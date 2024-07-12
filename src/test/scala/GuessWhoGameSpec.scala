import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec



class GuessWhoGameSpec extends AnyWordSpec{

  "A Character" when {
    "created" should {
      "have the correct attributes" in {
        // Test character instantiation
      }
    }
  }
  "A character is selected"when{
    "game is started"should{
      "random character is slected"in{
        // Test charcters for random selection
      }
    }
  }
  "A question is asked"when{
    "characters are selected based of question"should{
      "characters are removed if not selected" in{
        // characters are filtered out based on questions
      }
    }
  }

}
