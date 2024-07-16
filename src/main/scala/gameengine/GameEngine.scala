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
  private val firstPlayer: Player = createPlayerAndAssignGameBoard()
  private val cpuPlayer: Player = createPlayerAndAssignGameBoardForCpu()

  private var continuedPlaying: Boolean = true

  private var cpuQuestionList: List[String] = resources.listOfQuestions
  private var playerQuestionList: List[String] = resources.listOfQuestions

  /**
   * Create an object of player by assigning name, gameBoard and secret characters
   * @return player object
   */
  def createPlayerAndAssignGameBoard(): Player = {
    val player = new Player(name = "Player1", gameBoard = gameBoard.gameBoardForPlayer,
      selectRandomCharacter(resources.charactersList))
    player
  }
  /**
   * Create an object of player by assigning name, gameBoard and secret characters
   * @return player object
   */
  def createPlayerAndAssignGameBoardForCpu(): Player = {
    val player = new Player(name = "CPU", gameBoard = gameBoard.gameBoardForPlayer,
      selectRandomCharacter(resources.charactersList))
    player
  }

  /**
   * Starts the Game by calling all the necessary methods
   */
  def startTheGame():String = {
    println(resources.charactersList.head)
    var firstPlayerTurn: Boolean = true
    while (continuedPlaying) {
      if (endGame(firstPlayer.gameBoard)) {
        continuedPlaying = false
      }
      else{
        println(s"Player1's Secret Character:\n + ${printSecretCharacterForPlayer(firstPlayer.secretCharacter)}")
        showGameBoard(firstPlayer.gameBoard, firstPlayer.name)
        // print secret player and game board for the CPU
        println(s"CPU's Secret Character :\n +${printSecretCharacterForPlayer(cpuPlayer.secretCharacter)}")
        //showGameBoard(cpuPlayer.gameBoard, cpuPlayer.name)
        if (firstPlayerTurn) {
          firstPlayerTurnForTheGame()
          firstPlayerTurn = false
        }
        else{
          cpuTurnForTheGame()
          firstPlayerTurn = true
        }

      }

    }
    if(firstPlayer.gameBoard.head.name == firstPlayer.secretCharacter.name){
      s"Is this your character ${firstPlayer.gameBoard.head.name}?"
    }
    else{
      s"Is this your character ${firstPlayer.gameBoard.head.name}?\n"+
      s"You win"
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
  def filterQuestionsForPlayer(selectedQuestion: String): List[String] = {
    playerQuestionList = playerQuestionList.filterNot(_ == selectedQuestion)
    playerQuestionList
  }

  /**
   * Select random question from the question list and filters out
   * questionList which is returned so that there is no repeated questions
   *@return if
   *         * list is empty returns there are `no more questions`
   *         else returns the selected random question
   */
  def selectRandomQuestions(): String = {
    val questionsLength = random.nextInt(questionList.length)
    val question = questionList(questionsLength)
    questionList = questionList.filterNot(_ == question)
    if (questionList.isEmpty){
      continuedPlaying = false
      "no more questions"
    }
     else question
  }
  def showGameBoard(firstPlayerGameBoard: ListBuffer[Person], playerName: String): Unit = {
    println(s"***********$playerName's Game board ***********")
    println(f"|${"Name"}|${"Gender"}|${"Hair Colour"}|${"Hair Length"}|")
    for (row <- firstPlayerGameBoard) {
      println(row.productIterator.mkString("|"))
    }
    println("**************************************")
  }

  /***
   * Prints the secret Character of player in formatted order
   * @param secretCharacter the gameBoard assigned for player1
   */
  def  printSecretCharacterForPlayer(secretCharacter: Person): String = {
    // Create header for displaying the attribute
    val header = f"|${"Name"}%-10s | ${"Gender"}%-10s | ${"Hair Colour"}%-10s | ${"Wears Glasses"}%-10s |" +
      f"|${"Wears Hat"}%-15s ||${"Has Beard"}%-15s ||${"Eye Color"}%-15s |"
    // create a separator line
    val separator = "|" + "-" * 17 + "+" + "-" * 12 + "+" + "-" * 17 + "+" + "-" * 17 + "|" + "|" + "-" * 17 + "+" + "-" * 12 + "+" + "-" * 17 + "+" + "-" * 17 + "|"
    // create the values row
    val row = f"| ${secretCharacter.name}%-15s | ${secretCharacter.gender}%-10s | ${secretCharacter.hairColor}%-15s | ${secretCharacter.wearsGlasses}%-15s |" +
      f"${secretCharacter.wearsHat}%-15s${secretCharacter.hasBeard}%-15s${secretCharacter.eyeColor}%-15s"
    val output: String = header + "\n" + separator + "\n" + row
    output

  }

  /**
   * Filters out the list of character based upon the question and answer
   * @param characters The list of character for the gameBoard
   * @param question The answer to the question (true or false).
   * @param answer A list of characters that match the filter criteria.
   * @return
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
      case _ =>
    }
    characters
  }

  /**
   * matches the question asked by the player with the attributes present in the secret character of CPU
   * @param question this is the question selected by Player1
   * @return true if the question is true and false if the question is false
   */
  def matchPlayerQuestionToCpuCharacterAttribute(question: String, secretCharacter:Person): Boolean = {
    if (question.contains("hair")&&(question.contains(secretCharacter.hairColor.toLowerCase()))) true
    else if (question.contains("Is your person male?")&&(secretCharacter.gender.toLowerCase()=="male")) true
    else if (question.contains("Is your person female?")&&(secretCharacter.gender.toLowerCase()=="female")) true
    else if (question.contains(secretCharacter.wearsGlasses))true
    else if (question.contains("hat") && secretCharacter.wearsHat)true
    else if (question.contains("beard") && secretCharacter.hasBeard)true
    else if (question.contains(secretCharacter.eyeColor.toLowerCase))true
    else false
  }
  def firstPlayerTurnForTheGame():Unit ={
    println(s"${firstPlayer.name}'s Turn!!!!!'")
    println("Select the questions from below:")
    for ((question, index) <- playerQuestionList.zipWithIndex) {
      print(s"${index + 1}. $question \n")
    }
    val selectedQuestionIndex = readLine("Select your question:").toInt
    val selectedQuestion: String = playerQuestionList(selectedQuestionIndex - 1)
    println(s"Your selected Question is: $selectedQuestion")
    // filter out the selectedQuestionList
    filterQuestionsForPlayer(selectedQuestion)
     //if the cpu secret character has that attribute(female)
     //then it will be true and updates player board by removing males
    val cpuAnswer = matchPlayerQuestionToCpuCharacterAttribute(selectedQuestion.toLowerCase(), cpuPlayer.secretCharacter)
    println(cpuAnswer)
    filterCharacters(firstPlayer.gameBoard, selectedQuestion, cpuAnswer)

  }
  def cpuTurnForTheGame(): Unit = {
    println("****** CPU'S TURN********* ")
    val question = selectRandomQuestions()
    println(question)
    val answer: Boolean = readLine().toBoolean
    filterCharacters(firstPlayer.gameBoard, question, answer)
    println(firstPlayer.gameBoard.map(_.name))
  }

  /**
   * Checks if the length of the gameBoard is 1 means only one character left in the gameBoard
   * @param characters The game board of the player
   * @return returns true if the length of gameBoard == 1 else returns false
   */
  def endGame(characters: ListBuffer[Person]): Boolean = {
    characters.length == 1
  }
}
