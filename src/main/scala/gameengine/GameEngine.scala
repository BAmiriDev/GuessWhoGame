package gameengine
import characters.Person

import scala.math.random
import scala.util.Random
class GameEngine {

  def selectRandomCharacter(characterList: List[Person]) : Person ={
      val random = new Random()
      val reply = characterList(random.nextInt(characterList.length))
      reply
  }


}
