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

  // Create Player and Assign Game Board
  def createPlayerAndAssignGameBoard(): Player = {
    val player = new Player(name = "Player1", gameBoard = gameBoard.gameBoardForPlayer,
      selectRandomCharacter(resources.charactersList))
    player
  }

  // Start the Game
  def startTheGame() = {
    while (continuedPlaying) {
      if (endGame(firstPlayer.gameBoard)) {
        println("Congratulations, you won!")
        continuedPlaying = false
      }
      println(firstPlayer.secretCharacter)
      val question = selectRandomQuestions()
      println(question)
      val answer: Boolean = readLine().toBoolean
      filterCharacters(firstPlayer.gameBoard, question, answer)
      println(firstPlayer.gameBoard.map(_.name))
    }
    println(s"Is this your character ${firstPlayer.secretCharacter.name}?")
  }

  // Select Random Character
  def selectRandomCharacter(characterList: List[Person]): Person = {
    val reply = characterList(random.nextInt(characterList.length))
    reply
  }

  // Select Random Questions
  def selectRandomQuestions(): String = {
    val questionsLength = random.nextInt(questionList.length)
    val question = questionList(questionsLength)
    questionList = questionList.filterNot(_ == question)

    if (questionList.isEmpty) {
      "no more questions"
    } else {
      question
    }
  }

  // Filter Characters
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
      case "Does your person have freckles?" => characters.filterInPlace(_.hasFreckles == answer)
      case "Does your person have earrings?" => characters.filterInPlace(_.hasEarrings == answer)
      case "Does your person wear a necklace?" => characters.filterInPlace(_.wearsNecklace == answer)
      case "Does your person have short hair?" => characters.filterInPlace(_.hairLength == "Short" == answer)
      case "Does your person have medium hair?" => characters.filterInPlace(_.hairLength == "Medium" == answer)
      case "Does your person have long hair?" => characters.filterInPlace(_.hairLength == "Long" == answer)
      case _ => characters
    }
    characters
  }

  // End Game
  def endGame(characters: ListBuffer[Person]): Boolean = {
    characters.length == 1
  }
}
