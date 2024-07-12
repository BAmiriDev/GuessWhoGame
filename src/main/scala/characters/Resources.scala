package characters

class Resources {
  //create a list of characters
  val firstCharacter: Person = Person(name = "David", gender = "Male", hairColour = "Black", hairLength = "Short")
  val secondCharacter: Person = Person(name = "Sam", gender = "Male", hairColour = "Grey", hairLength = "Short")
  val thirdCharacter: Person = Person(name = "Victoria", gender = "Female", hairColour = "Purple", hairLength = "Long")
  val fourthCharacter: Person = Person(name = "Charlotte", gender = "Female", hairColour = "Yellow", hairLength = "Long")

  val charactersList: List[Person] = List(firstCharacter, secondCharacter, thirdCharacter, fourthCharacter)

  def returnListOfQuestions(): List[String] = {
    val listOfQuestions: List[String] = List(
      "What is your character's name?",
      "Is your character male or female?",
      "Is your character's hair color brown/blonde/black/red/etc.?",
      "Does your character have long hair?")
    listOfQuestions
  }

  def returnListOfCharacters(): List[Person] = {
    charactersList
  }

}
