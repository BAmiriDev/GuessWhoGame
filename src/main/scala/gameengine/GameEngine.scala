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

  // needs to be tested
  def createPlayerAndAssignGameBoard(): Player = {
    val player = new Player(name = "Player1", gameBoard = gameBoard.gameBoardForPlayer,
      selectRandomCharacter(resources.charactersList))
    player
  }

  def startTheGame() = {
    while (continuedPlaying) {
      if (endGame(firstPlayer.gameBoard)) {
        println("Congratulations, you won!")
        continuedPlaying = false
      } else {
        println(firstPlayer.secretCharacter)
        val question = selectRandomQuestions()
        if (question == "no more questions") {
          println("No more questions left. Ending the game.")
          continuedPlaying = false
        } else {
          println(question)
          val answer: Boolean = readLine().toBoolean
          filterCharacters(firstPlayer.gameBoard, question, answer)
          println(firstPlayer.gameBoard.map(_.name))
        }
      }
    }
    println(s"Is this your character ${firstPlayer.secretCharacter.name}?")
  }

  def selectRandomCharacter(characterList: List[Person]): Person = {
    val reply = characterList(random.nextInt(characterList.length))
    reply
  }

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

  def filterCharacters(characters: ListBuffer[Person], question: String, answer: Boolean): ListBuffer[Person] = {
    question match {
      case "Is your character male?" => characters.filterInPlace(_.gender == "Male" == answer)
      case "Is your character female?" => characters.filterInPlace(_.gender == "Female" == answer)
      case "Is your character's hair color brown?" => characters.filterInPlace(_.hairColor == "Brown" == answer)
      case "Is your character's hair color blonde?" => characters.filterInPlace(_.hairColor == "Blonde" == answer)
      case "Is your character's hair color black?" => characters.filterInPlace(_.hairColor == "Black" == answer)
      case "Is your character's hair color red?" => characters.filterInPlace(_.hairColor == "Red" == answer)
      case "Does your character wear glasses?" => characters.filterInPlace(_.wearsGlasses == answer)
      case "Does your character wear a hat?" => characters.filterInPlace(_.wearsHat == answer)
      case "Does your character have a beard?" => characters.filterInPlace(_.hasBeard == answer)
      case "Does your character have blue eyes?" => characters.filterInPlace(_.eyeColor == "Blue" == answer)
      case "Does your character have green eyes?" => characters.filterInPlace(_.eyeColor == "Green" == answer)
      case "Does your character have brown eyes?" => characters.filterInPlace(_.eyeColor == "Brown" == answer)
      case "Does your character have hazel eyes?" => characters.filterInPlace(_.eyeColor == "Hazel" == answer)
      case "Does your character have freckles?" => characters.filterInPlace(_.hasFreckles == answer)
      case "Does your character have earrings?" => characters.filterInPlace(_.hasEarrings == answer)
      case "Does your character wear a necklace?" => characters.filterInPlace(_.wearsNecklace == answer)
      case "Does your character have short hair?" => characters.filterInPlace(_.hairLength == "Short" == answer)
      case "Does your character have medium hair?" => characters.filterInPlace(_.hairLength == "Medium" == answer)
      case "Does your character have long hair?" => characters.filterInPlace(_.hairLength == "Long" == answer)
      case _ => characters
    }
    characters
  }

  def endGame(characters: ListBuffer[Person]): Boolean = {
    characters.length == 1
  }
}

