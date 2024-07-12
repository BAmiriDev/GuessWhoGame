package gameengine
import characters.Person

import scala.math.random
import scala.util.Random
class GameEngine {
  val random = new Random()
  def selectRandomCharacter(characterList: List[Person]) : Person ={
      val reply = characterList(random.nextInt(characterList.length))
      reply
  }
  def selectRandomQuestions(questionsList: List[String]) : String ={
    val question = questionsList(random.nextInt(questionsList.length))
    question
  }


}
