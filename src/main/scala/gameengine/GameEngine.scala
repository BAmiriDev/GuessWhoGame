package gameengine

import characters.{GameBoard, Person, Player, Resources}

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random

class GameEngine {
  val resources = new Resources
  var questionList = resources.listOfQuestions
  val random = new Random()
  // Instantiate the game board
  val gameBoard = new GameBoard(resources.charactersList)
  // create firstPlayer
  val firstPlayer: Player = createPlayerAndAssignGameBoard()
  var continuedPlaying: Boolean = true

  def createPlayerAndAssignGameBoard(): Player = {
    val playerName = readLine("Enter your name")
    val player = new Player(name = playerName, gameBoard = gameBoard.gameBoardForPlayer1,
      selectRandomCharacter(resources.charactersList))
    player
  }

  def startTheGame() = {
    while (continuedPlaying) {
      if (endGame(firstPlayer.gameBoard) ) {
        println("Congraulations you won")
        continuedPlaying = false
      }
      println(firstPlayer.secretCharacter)
      val question = selectRandomQuestions()
      println(question)
      val answer: Boolean = readLine().toBoolean
      val remainingCharacters = filterCharacters(firstPlayer.gameBoard, question, answer)
      println(firstPlayer.gameBoard.map(_.name))
    }
    println(s"is this your charcter ${firstPlayer.secretCharacter.name}")

  }


  def selectRandomCharacter(characterList: List[Person]): Person = {
    val reply = characterList(random.nextInt(characterList.length))
    reply
  }

  def selectRandomQuestions(): String = {
    val questionsLength = random.nextInt(questionList.length)
    val questions = questionList(questionsLength)
    questionList = questionList.filterNot(_ == questions)

    if( questionList.length == 0) {
      "no more questions"
    } else{
      questions
    }




  }

  def filterCharacters(characters: ListBuffer[Person], question: String, answer: Boolean): Unit = {
    question match {
      case "Is your character male" => characters.filterInPlace(_.gender == "Male" == answer)
      case "Is your character female?" => characters.filterInPlace(_.gender == "Female" == answer)
      case "Is your character's hair color brown" => characters.filterInPlace(_.hairColour == "Brown" == answer)
      case "Is your character's hair color blonde?" => characters.filterInPlace(_.hairColour == "Blonde" == answer)
      case "Is your character's hair color black?" => characters.filterInPlace(_.hairColour == "Black" == answer)
      case "Is your character's hair color red" => characters.filterInPlace(_.hairColour == "Red" == answer)
      case "Does your character have long hair?" => characters.filterInPlace(_.hairLength == "Long" == answer)
      case _ =>
    }

  }

  def endGame(charcters: ListBuffer[Person]): Boolean = {
    charcters.length == 1
  }


}
