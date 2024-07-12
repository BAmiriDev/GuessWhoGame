import gameengine.GameEngine
import characters.Resources

object GuessWhoGame extends App{
  // Select random players of Characters
  val gameEngine: GameEngine = new GameEngine
  val guessWhoGame: Resources = new Resources

  println(gameEngine.selectRandomCharacter(guessWhoGame.returnListOfCharacters()))
  println(gameEngine.selectRandomQuestions(guessWhoGame.returnListOfQuestions()))

}
