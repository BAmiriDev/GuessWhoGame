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
  "GameEngine.printSecretCharacterForPlayer" should {
    "" +
      "return the formatted secret attribute attribute" when {
      "creating the player for the game" in {
        val header = f"|${"Name"}%-15s | ${"Gender"}%-10s | ${"Hair Colour"}%-15s | ${"Wears Glasses"}%-15s |" +
          f"|${"Wears Hat"}%-15s ||${"Has Beard"}%-15s ||${"Eye Color"}%-15s |"
        val separator = "|" + "-" * 17 + "+" + "-" * 12 + "+" + "-" * 17 + "+" + "-" * 17 + "|" + "|" + "-" * 17 +
          "+" + "-" * 12 + "+" + "-" * 17 + "+" + "-" * 17 + "|"
        val row = f"| ${testCharacter.name}%-15s | ${testCharacter.gender}%-10s | ${testCharacter.hairColor}%-15s | ${testCharacter.wearsGlasses}%-15s |" +
          f"${testCharacter.wearsHat}%-15s${testCharacter.hasBeard}%-15s${testCharacter.eyeColor}%-15s"
        val testOutput: String = header + "\n" + separator + "\n" + row
        assert(gameEngine.printSecretCharacterForPlayer(testCharacter) ==testOutput)
      }
    }
  }

}
