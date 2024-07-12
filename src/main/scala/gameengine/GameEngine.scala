package gameengine
import characters.{Person, Resources}

import scala.math.random
import scala.util.Random
class GameEngine {
  val random = new Random()

  def selectRandomCharacter(characterList: List[Person]) : Person ={

      val reply = characterList(random.nextInt(characterList.length))
      reply
  }


  def selectRandomQuestion(questions: List[String]): String  = {

    val questionair = questions(random.nextInt(questions.length))
   questionair
  }


}
