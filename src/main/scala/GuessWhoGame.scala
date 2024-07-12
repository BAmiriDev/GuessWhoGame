import gameengine.GameEngine
import characters.Resources
import scala.util.Random

object GuessWhoGame extends App{
  // Select random players of Characters
  val gameEngine: GameEngine = new GameEngine
  val guessWhoGame: Resources = new Resources

  println(gameEngine.selectRandomCharacter(guessWhoGame.returnListOfCharacters()))
  println(gameEngine.selectRandomQuestions(guessWhoGame.returnListOfQuestions()))

  val questions: Resources = new Resources



  val question = "Is the character male?"
  val answer = false
  println(gameEngine.returnListOfFilteredCharacters(question, answer))


}
