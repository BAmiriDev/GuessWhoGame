import gameengine.GameEngine
import person.GuessWhoGame

object StartGame extends App{

  val gameEngine: GameEngine = new GameEngine
  val guessWhoGame: GuessWhoGame = new GuessWhoGame
  println(gameEngine.selectRandomCharacter(guessWhoGame.returnListOfCharacters()))

}
