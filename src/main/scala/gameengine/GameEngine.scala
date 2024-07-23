package gameengine

import characters.{GameBoard, Person, Player, Resources}

import scala.Console.println
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random

class GameEngine {
  val resources = new Resources
  private var questionList: List[String] = resources.listOfQuestions
  private val random = new Random()
  // Instantiate the game board
  val gameBoard = new GameBoard(resources.charactersList)
  // create firstPlayer
  private val cpuPlayer: Player = createPlayerAndAssignGameBoard()
  private var continuedPlaying: Boolean = true

  /**
   * Create an object of player by assigning name, gameBoard and secret characters
   * @return player object
   */
  def createPlayerAndAssignGameBoard(): Player = {
    val player = new Player(name = "CPU", gameBoard = gameBoard.gameBoardForPlayer,
      selectRandomCharacter(resources.charactersList))
    player
  }

  /**
   * Starts the Game by calling all the necessary methods
   */
  def startTheGame(): String = {
    while (continuedPlaying) {
      if (endGame(cpuPlayer.gameBoard)) {
        println("Congratulations, you won!")
        continuedPlaying = false
      }
      else if (questionList.isEmpty) {
        println("No more questions left: I couldn't guess!")
        println("You Won")
        continuedPlaying = false
      }
      else {
        playerTurn()
      }
    }
    if (cpuPlayer.gameBoard.head.name == cpuPlayer.secretCharacter.name) {
      s"Is this your character ${cpuPlayer.gameBoard.head.name}?"
    }
    else {
      s"Is this your character ${cpuPlayer.gameBoard.head.name}?\n" +
        s"Congratulations, You win!!!!"
    }
  }
  /**
   * Select random character by from Character List from Resources class
   * @param characterList list of characters from resources class
   * @return randomCharacter of type Person
   */
  def selectRandomCharacter(characterList: List[Person]): Person = {
    val randomCharacter = characterList(random.nextInt(characterList.length))
    randomCharacter
  }

  /**
   * Select random question from the question list and filters out
   * questionList which is returned so that there is no repeated questions
   * @return if
   *         * list is empty returns there are `no more questions`
   *         else returns the selected random question
   */
  def selectRandomQuestions(): String = {
    val questionsLength = random.nextInt(questionList.length)
    val question = questionList(questionsLength)
    questionList = questionList.filterNot(_ == question)
    question
  }

  def playerTurn() ={
    println(printSecretCharacterForPlayer(cpuPlayer.secretCharacter))
    showGameBoard(cpuPlayer.gameBoard, "CPU")
    println(s" Your Turn!!!!!'")
    println("Select the questions from below:")
    for ((question, index) <- questionList.zipWithIndex) {
      println(s"${index + 1}. $question")
    }
    val selectedQuestionIndex = readLine("Select your question:").toInt
    val selectedQuestion: String = questionList(selectedQuestionIndex - 1)
    println(s"You selected : ${selectedQuestion}")
    // filter out the selectedQuestionList
    filterQuestionsForPlayer(selectedQuestion)
    val cpuAnswer = matchPlayerQuestionToCpuCharacterAttribute((selectedQuestion.toLowerCase))
    println(cpuAnswer)

  }

  /** *
   * Prints the secret Character of player in formatted order
   * @param secretCharacter the gameBoard assigned for player1
   */
  def printSecretCharacterForPlayer(secretCharacter: Person): String = {
    // Create header for displaying the attribute
    val header = f"|${"Name"}%-15s | ${"Gender"}%-10s | ${"Hair Colour"}%-15s | ${"Wears Glasses"}%-15s |" +
      f"|${"Wears Hat"}%-15s ||${"Has Beard"}%-15s ||${"Eye Color"}%-15s |"
    // create a separator line
    val separator = "|" + "-" * 17 + "+" + "-" * 12 + "+" + "-" * 17 + "+" + "-" * 17 + "|" + "|" + "-" * 17 + "+" + "-" * 12 + "+" + "-" * 17 + "+" + "-" * 17 + "|"
    // create the values row
    val row = f"| ${secretCharacter.name}%-15s | ${secretCharacter.gender}%-10s | ${secretCharacter.hairColor}%-15s | ${secretCharacter.wearsGlasses}%-15s |" +
      f"${secretCharacter.wearsHat}%-15s${secretCharacter.hasBeard}%-15s${secretCharacter.eyeColor}%-15s"
    val output: String = header + "\n" + separator + "\n" + row
    output

  }
  def filterQuestionsForPlayer(selectedQuestion: String): Unit = {
    questionList = questionList.filterNot(_ == selectedQuestion)
  }
  def matchPlayerQuestionToCpuCharacterAttribute(question: String): Boolean = {
    if (question.contains(cpuPlayer.secretCharacter.name.toLowerCase())) true
    else if (question.contains(cpuPlayer.secretCharacter.gender.toLowerCase())) true
    else false
  }

  /**
   * Filters out the list of character based upon the question and answer
   * @param characters The list of character for the gameBoard
   * @param question   The answer to the question (true or false).
   * @param answer     A list of characters that match the filter criteria.
   * @return the filtered gameBoard for the player
   */
  def filterCharacters(characters: ListBuffer[Person], question: String, answer: Boolean): ListBuffer[Person] = {
    question match {
      case "Is your person male?" => characters.filterInPlace(_.gender == "Male" == answer)
      case "Is your person female?" => characters.filterInPlace(_.gender == "Female" == answer)
      case "Does your person have blonde hair?" => characters.filterInPlace(_.hairColor == "Blonde" == answer)
      case "Does your person have brown hair?" => characters.filterInPlace(_.hairColor == "Brown" == answer)
      case "Does your person have black hair?" => characters.filterInPlace(_.hairColor == "Black" == answer)
      case "Does your person have red hair?" => characters.filterInPlace(_.hairColor == "Red" == answer)
      case "Does your person have grey hair?" => characters.filterInPlace(_.hairColor == "Grey" == answer)
      case "Does your person wear glasses?" => characters.filterInPlace(_.wearsGlasses == answer)
      case "Does your person wear a hat?" => characters.filterInPlace(_.wearsHat == answer)
      case "Does your person have a beard?" => characters.filterInPlace(_.hasBeard == answer)
      case "Does your person have blue eyes?" => characters.filterInPlace(_.eyeColor == "Blue" == answer)
      case "Does your person have green eyes?" => characters.filterInPlace(_.eyeColor == "Green" == answer)
      case "Does your person have brown eyes?" => characters.filterInPlace(_.eyeColor == "Brown" == answer)
      case "Does your person have hazel eyes?" => characters.filterInPlace(_.eyeColor == "Hazel" == answer)
      case _ => characters.clear() // If the question does not match any case, clear the list
    }
    characters
  }
  def showGameBoard(firstPlayerGameBoard: ListBuffer[Person], playerName: String): Unit = {
    println(s"***********$playerName's Game board ***********")
    for (row <- firstPlayerGameBoard) {
      print(row.name)
      print(" ")
    }
  }

  /**
   * Checks if the length of the gameBoard is 1 means only one character left in the gameBoard
   * @param characters The game board of the player
   * @return returns true if the length of gameBoard == 1 else returns false
   */
  def endGame(playerGameBoard: ListBuffer[Person]): Boolean = {
    playerGameBoard.length == 1
  }
}
