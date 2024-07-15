package gameengine

import characters.{GameBoard, Person, Player, Resources}
import org.scalatest.wordspec.AnyWordSpec

class GameEngineSpec extends AnyWordSpec {
  val resources: Resources = new Resources
  val gameBoard: GameBoard = new GameBoard(resources.charactersList)
  val testCharacter: Person = resources.charactersList(1)
  val gameEngine = new GameEngine()
  "GameEngine.createPlayerAndAssignGameBoard" should {
    "" +
      "return the player object" when {
      "creating the player for the game" in {
        val testPlayer = gameEngine.createPlayerAndAssignGameBoard()
        assert(testPlayer.name == "Player1")
        assert(testPlayer.gameBoard.equals(gameBoard.gameBoardForPlayer))
        assert(testPlayer.secretCharacter.isInstanceOf[Person])
      }
    }
  }
}
