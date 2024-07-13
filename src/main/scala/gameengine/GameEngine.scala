package gameengine

import characters.{GameBoard, Person, Player, Resources}

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random

class GameEngine {
  val resources = new Resources
  val questionList = resources.listOfQuestions
  val random = new Random()
  // instantiate the game board
  val gameBoard = new GameBoard(resources.charactersList)
  // create firstPlayer
  val firstPlayer: Player = createPlayerAndAssignGameBoard()
  var continuedPlaying: Boolean = true

  def createPlayerAndAssignGameBoard(): Player = {
    val playerName = readLine("Enter your name: ")
    val player = new Player(name = playerName, gameBoard = gameBoard.gameBoardForPlayer1,
      selectRandomCharacter(resources.charactersList))
    player
  }

  def startTheGame() = {
    var changingGameBoard = firstPlayer.gameBoard
    while (continuedPlaying) {
      if (firstPlayer.gameBoard.length == 1) continuedPlaying = false
      else {
        println("Your secret Character is" + firstPlayer.secretCharacter.toString)
        val question:String = "Does the character have short hair?"
        println(question)
        val playerAnswer: Boolean = readLine().toBoolean
        changingGameBoard = filterCharacters(changingGameBoard, question, playerAnswer)
        println(changingGameBoard.map(_.name))
      }
    }
  }

  def selectRandomCharacter(characterList: List[Person]): Person = {
    val reply = characterList(random.nextInt(characterList.length))
    reply
  }

  def selectRandomQuestions(): String = {
    val question = questionList(random.nextInt(questionList.length))
    question
  }

  def filterCharacters(characters: ListBuffer[Person], question: String, answer: Boolean): ListBuffer[Person] = {
    val filteredCharacters = question match {
      case "Does the character have short hair?" => characters.filter(_.hairLength == "Short" == answer)
      case "Is the character male?" => characters.filter(_.gender == "Male" == answer)
      case "Does the character have black hair?" => characters.filter(_.hairColour == "Black" == answer)
      case _ => characters
    }
    filteredCharacters
  }

  //  def returnListOfFilteredCharacters(question: String, answer: Boolean): ListBuffer[Person] = {
  //    filterCharacters(gameBoard.gameBoardForPlayer1,question, answer)
  //  }


  //end game


}
