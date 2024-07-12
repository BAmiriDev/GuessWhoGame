import gameengine.GameEngine
import characters.Resources
import scala.util.Random

object GuessWhoGame extends App{
  // Select random players of Characters
  val gameEngine: GameEngine = new GameEngine
  val guessWhoGame: Resources = new Resources
  println(gameEngine.selectRandomCharacter(guessWhoGame.returnListOfCharacters()))

  val questions: Resources = new Resources



  println(gameEngine.selectRandomQuestion(guessWhoGame.returnListOfQuestions()))

}
