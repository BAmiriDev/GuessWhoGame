import characters.Resources
import gameengine.GameEngine

object GuessWhoGame extends App{
  // Select random players of Characters
  val gameEngine: GameEngine = new GameEngine
  val guessWhoGame: Resources = new Resources

  println("Create game and assign Board " + gameEngine.createPlayerAndAssignGameBoard() )

  println(gameEngine.selectRandomCharacter(guessWhoGame.charactersList))
  println(gameEngine.selectRandomQuestions(guessWhoGame.listOfQuestions))

  val question = "Is the character male?"
  val answer = false
  println(gameEngine.returnListOfFilteredCharacters(question, answer))



}
