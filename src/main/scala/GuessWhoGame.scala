import characters.Resources
import gameengine.GameEngine

object GuessWhoGame extends App{
  // Select random players of Characters
  val gameEngine: GameEngine = new GameEngine
  println(gameEngine.startTheGame())


}
