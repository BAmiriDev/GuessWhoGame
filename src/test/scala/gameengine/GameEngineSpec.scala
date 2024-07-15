package gameengine

import characters.{GameBoard, Person, Player, Resources}
import org.scalatest.wordspec.AnyWordSpec

class GameEngineSpec extends AnyWordSpec {
  val resources = new Resources
  val gameBoard = new GameBoard(resources.charactersList)
  val testCharacter: Person = resources.charactersList.head // Ensure the character exists
  val gameEngine = new GameEngine()

  "GameEngine.createPlayerAndAssignGameBoard" should {
    "return the player object" when {
      "creating the player for the game" in {
        val testPlayer = gameEngine.createPlayerAndAssignGameBoard()
        assert(testPlayer.name == "Player1")
        assert(testPlayer.gameBoard == gameBoard.gameBoardForPlayer)
        assert(testPlayer.secretCharacter.isInstanceOf[Person])
      }
    }
  }
}
