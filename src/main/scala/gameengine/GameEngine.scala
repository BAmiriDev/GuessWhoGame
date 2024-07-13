package gameengine
import characters.{GameBoard, Person, Player, Resources}

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random

class GameEngine {
  val resources = new Resources
  val questionList = resources.listOfQuestions
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

  def startTheGame() ={

    while(continuedPlaying){
      if(firstPlayer.gameBoard.length==1) continuedPlaying = false
      val question = selectRandomQuestions()
      println(question)
      val answer: Boolean = readLine().toBoolean
      println(firstPlayer.secretCharacter)
      val firstPlayer.gameBoard = filterCharacters(firstPlayer.gameBoard, question, answer)
      println(firstPlayer.gameBoard)


    }
  }

  def selectRandomCharacter(characterList: List[Person]) : Person ={
      val reply = characterList(random.nextInt(characterList.length))
      reply
  }
  def selectRandomQuestions() : String ={
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



  def endGame(charcters: ListBuffer[Person]): Boolean = {
    charcters.length == 1
  }








}
