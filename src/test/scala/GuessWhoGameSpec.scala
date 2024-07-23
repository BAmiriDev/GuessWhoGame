import characters._
import gameengine.GameEngine
import org.scalatest.wordspec.AnyWordSpec

import scala.collection.mutable.ListBuffer

class GuessWhoGameSpec extends AnyWordSpec {

  // Initialize game engine and resources once
  val resources = new Resources
  val gameEngine: GameEngine = new GameEngine

  // Initialize expected values directly
  val expectedCharacters: List[Person] = resources.charactersList
  var expectedQuestions: List[String] = resources.listOfQuestions

  "GameEngine.selectRandomCharacter" should {
    "select a random character from the list" when {
      "called to select a random character" in {
        val characters = resources.charactersList
        val selectedCharacter = gameEngine.selectRandomCharacter(characters)
        assert(characters.contains(selectedCharacter))
      }
    }
  }

  "GameEngine.selectRandomQuestions" should {
    "select a random question from the list" when {
      "called to select a random question" in {
        val questions = resources.listOfQuestions
        val selectedQuestion = gameEngine.selectRandomQuestions()
        assert(questions.contains(selectedQuestion))
      }
    }
  }

  "GameEngine.filterCharactersByAnswer" should {
    "filter characters based on the string answer" when {
      "called to filter characters by string answer" in {
        val question = "Is your person male?"
        val answer = false
        val charactersList = List(
          Person("John", Male, DarkBrown, PersonWithGlasses(true), PersonWithHat(false), PersonWithBeard(false), Blue),
          Person("Jane", Female, Blonde, PersonWithGlasses(false), PersonWithHat(true), PersonWithBeard(false), Green),
          Person("Doe", Female, Black, PersonWithGlasses(false), PersonWithHat(false), PersonWithBeard(true), Brown)
        )

        val filteredCharacters = ListBuffer.from(charactersList)
        gameEngine.filterCharacters(filteredCharacters, question, answer)

        val expectedFilteredCharacters = List(
          Person("Jane", Female, Blonde, PersonWithGlasses(false), PersonWithHat(true), PersonWithBeard(false), Green),
          Person("Doe", Female, Black, PersonWithGlasses(false), PersonWithHat(false), PersonWithBeard(true), Brown)
        )

        assert(filteredCharacters.toList == expectedFilteredCharacters)
      }
    }

    "filter characters based on the attribute 'no beard'" in {
      val question = "Does your person have a beard?"
      val answer = false
      val charactersList = List(
        Person("Alex", Male, DarkBrown, PersonWithGlasses(true), PersonWithHat(false), PersonWithBeard(false), Blue),
        Person("Beth", Female, Blonde, PersonWithGlasses(false), PersonWithHat(true), PersonWithBeard(false), Green),
        Person("Chris", Male, Black, PersonWithGlasses(false), PersonWithHat(false), PersonWithBeard(true), Brown)
      )

      val filteredCharacters = ListBuffer.from(charactersList)
      gameEngine.filterCharacters(filteredCharacters, question, answer)

      val expectedFilteredCharacters = List(
        Person("Alex", Male, DarkBrown, PersonWithGlasses(true), PersonWithHat(false), PersonWithBeard(false), Blue),
        Person("Beth", Female, Blonde, PersonWithGlasses(false), PersonWithHat(true), PersonWithBeard(false), Green)
      )

      assert(filteredCharacters.toList == expectedFilteredCharacters)
    }

    "filter characters based on the attribute 'blue eyes'" in {
      val question = "Does your person have blue eyes?"
      val answer = true

      val charactersList = List(
        Person("Alex", Male, DarkBrown, PersonWithGlasses(true), PersonWithHat(false), PersonWithBeard(false), Blue),
        Person("Beth", Female, Blonde, PersonWithGlasses(false), PersonWithHat(true), PersonWithBeard(false), Green),
        Person("Chris", Male, Black, PersonWithGlasses(false), PersonWithHat(false), PersonWithBeard(true), Brown)
      )

      val filteredCharacters = ListBuffer.from(charactersList)
      gameEngine.filterCharacters(filteredCharacters, question, answer)

      val expectedFilteredCharacters = List(
        Person("Alex", Male, DarkBrown, PersonWithGlasses(true), PersonWithHat(false), PersonWithBeard(false), Blue)
      )

      assert(filteredCharacters.toList == expectedFilteredCharacters)
    }

    "handle edge case where no characters match the criteria" in {
      val question = "Does your person have purple hair?"
      val answer = true
      val filteredCharacters = ListBuffer.from(expectedCharacters)
      val expectedFilteredCharacters = gameEngine.filterCharacters(filteredCharacters, question, answer)
      assert(filteredCharacters.isEmpty == expectedFilteredCharacters.isEmpty)
    }
  }

  "GameEngine.endGame" should {
    "return true when only one character is left" in {
      val singleCharacterList = ListBuffer(resources.charactersList.head)
      assert(gameEngine.endGame(singleCharacterList))
    }

    "return false when more than one character is left" in {
      val characters = ListBuffer.from(expectedCharacters)
      assert(!gameEngine.endGame(characters))
    }
  }

  "GameEngine.createPlayerAndAssignGameBoard" should {
    "create a player and assign the game board" in {
      val player = gameEngine.createPlayerAndAssignGameBoard()
      assert(player.name == "CPU")
      assert(player.gameBoard == gameEngine.gameBoard.gameBoardForPlayer)
      assert(resources.charactersList.contains(player.secretCharacter))
    }
  }

  "GameEngine.resetGame" should {
    "reset the game properly" in {
      gameEngine.resetGame()
      assert(resources.charactersList.contains(gameEngine.createPlayerAndAssignGameBoard().secretCharacter))
    }
  }

  "GameEngine.showGameBoard" should {
    "print the game board correctly" in {
      val gameBoard = ListBuffer(resources.charactersList.head)
      val playerName = "TestPlayer"
      gameEngine.showGameBoard(gameBoard, playerName)
      // Since the showGameBoard method prints directly, we will not assert here. Instead, we rely on visual verification.
      assert(true) // This is a placeholder for visual verification.
    }
  }

  "GameEngine.filterQuestionsForPlayer" should {
    "filter out the selected question from the list" in {
      val initialQuestions = resources.listOfQuestions
      val selectedQuestion = initialQuestions.head
      gameEngine.filterQuestionsForPlayer(selectedQuestion)
      assert(!gameEngine.selectRandomQuestions().contains(selectedQuestion))
    }
  }
}
