import characters.{Person, Resources}
import gameengine.GameEngine

import scala.collection.mutable.ListBuffer

object GuessWhoGame extends App{
  // Select random players of Characters
  val gameEngine: GameEngine = new GameEngine
  val guessWhoGame: Resources = new Resources
  val player1 = gameEngine.firstPlayer



//  println("Create game and assign Board " +gameEngine.firstPlayer.secretCharacter)
   gameEngine.startTheGame()
//  println(gameEngine.selectRandomCharacter(guessWhoGame.charactersList))
//  println(gameEngine.selectRandomQuestions(guessWhoGame.listOfQuestions))
//
//  val question = "Is the character male?"
//  val answer = false
//  println(gameEngine.returnListOfFilteredCharacters(question, answer))

//  gameEngine.gameLoop()
//  println(gameEngine.filterCharacters(characters = player1.gameBoard, "Does the character have short hair?", false))



}
