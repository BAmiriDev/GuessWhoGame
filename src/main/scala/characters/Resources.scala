package characters

class Resources {
  //create a list of characters
  val firstCharacter: Person = Person(name = "David", gender = "Male", hairColour = "Black", hairLength = "Short")
  val secondCharacter: Person = Person(name = "Sam", gender = "Male", hairColour = "Grey", hairLength = "Short")
  val thirdCharacter: Person = Person(name = "Victoria", gender = "Female", hairColour = "Purple", hairLength = "Long")
  val fourthCharacter: Person = Person(name = "Charlotte", gender = "Female", hairColour = "Yellow", hairLength = "Long")

  val charactersList: List[Person] = List(firstCharacter, secondCharacter, thirdCharacter, fourthCharacter)
  // Questions list
  val listOfQuestions: List[String] = List(
      "Is your character male",
      "Is your character female?",
      "Is your character's hair color brown?",
      "Is your character's hair color blonde?",
      "Is your character's hair color black?",
      "Is your character's hair color red",
      "Does your character have long hair?")
}
