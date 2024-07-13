package gameengine
import characters.{GameBoard, Person, Player, Resources}

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random

class GameEngine {

  val guesWhoGame1 = new Resources
  val random = new Random()
  // Instantiate the game board
  val gameBoard = new GameBoard(guesWhoGame1.charactersList)

  def createPlayerAndAssignGameBoard(): String = {
    val playerName = readLine("Enter your name")
    val player = new Player(name = playerName, gameBoard = gameBoard.gameBoardForPlayer1)
    player.name
  }

  def selectRandomCharacter(characterList: List[Person]) : Person ={
      val reply = characterList(random.nextInt(characterList.length))
      reply
  }
  def selectRandomQuestions(questionsList: List[String]) : String ={
    val question = questionsList(random.nextInt(questionsList.length))
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

  def returnListOfFilteredCharacters(question: String, answer: Boolean): ListBuffer[Person] = {
    filterCharacters(gameBoard.gameBoardForPlayer1,question, answer)
  }




}
