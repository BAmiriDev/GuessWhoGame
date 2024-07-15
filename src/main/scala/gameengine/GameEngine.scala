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

    if (questionList.length == 0) {
      "no more questions"
    } else {
      questions
    }


  }

  def filterCharacters(characters: ListBuffer[Person], question: String, answer: Boolean): ListBuffer[Person] = {
    question match {
      // if the answer is false removes male else removes female
      case "Is your character male" => characters.filterInPlace(_.gender == "Male" == answer)
      case "Is your character female?" => characters.filterInPlace(_.gender == "Female" == answer)
      case "Is your character's hair color brown?" => characters.filter(_.hairColor == "Brown" == answer)
      case "Is your character's hair color blonde?" => characters.filter(_.hairColor == "Blonde" == answer)
      case "Is your character's hair color black?" => characters.filter(_.hairColor == "Black" == answer)
      case "Is your character's hair color red?" => characters.filter(_.hairColor == "Red" == answer)
      case "Does your character wear glasses?" => characters.filter(_.wearsGlasses == answer)
      case "Does your character wear a hat?" => characters.filter(_.wearsHat == answer)
      case "Does your character have a beard?" => characters.filter(_.hasBeard == answer)
      case "Does your character have blue eyes?" => characters.filter(_.eyeColor == "Blue" == answer)
      case "Does your character have green eyes?" => characters.filter(_.eyeColor == "Green" == answer)
      case "Does your character have brown eyes?" => characters.filter(_.eyeColor == "Brown" == answer)
      case "Does your character have hazel eyes?" => characters.filter(_.eyeColor == "Hazel" == answer)
      case "Does your character have freckles?" => characters.filter(_.hasFreckles == answer)
      case "Does your character have earrings?" => characters.filter(_.hasEarrings == answer)
      case "Does your character wear a necklace?" => characters.filter(_.wearsNecklace == answer)
      case "Does your character have short hair?" => characters.filter(_.hairLength == "Short" == answer)
      case "Does your character have medium hair?" => characters.filter(_.hairLength == "Medium" == answer)
      case "Does your character have long hair?" => characters.filter(_.hairLength == "Long" == answer)
      case _ => characters
    }
    characters


  }

  def endGame(charcters: ListBuffer[Person]): Boolean = {
    charcters.length == 1
  }


}
