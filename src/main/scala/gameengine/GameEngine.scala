package gameengine
import characters.{Person, Resources}

import scala.math.random
import scala.util.Random

class GameEngine {

  val guesWhoGame1 = new Resources


  val random = new Random()
  def selectRandomCharacter(characterList: List[Person]) : Person ={
      val reply = characterList(random.nextInt(characterList.length))
      reply
  }
  def selectRandomQuestions(questionsList: List[String]) : String ={
    val question = questionsList(random.nextInt(questionsList.length))
    question
  }

  def filterCharacters(characters: List[Person], question: String, answer: Boolean): List[Person] = {
    val filteredCharacters = question match {
      case "Does the character have short hair?" => characters.filter(_.hairLength == "Short" == answer)
      case "Is the character male?" => characters.filter(_.gender == "Male" == answer)
      case "Does the character have black hair?" => characters.filter(_.hairColour == "Black" == answer)
      case _ => characters
    }
    filteredCharacters
  }

  def returnListOfFilteredCharacters(question: String, answer: Boolean): List[Person] = {
    filterCharacters(guesWhoGame1.returnListOfCharacters,question, answer)
  }



}
