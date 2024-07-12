package characters

class Resources {
  //create a list of characters
  val firstCharacter: Person = Person(name = "David", gender = "Male", hairColour = "Black", hairLength = "Short")
  val secondCharacter: Person = Person(name = "Sam", gender = "Male", hairColour = "Grey", hairLength = "Short")
  val thirdCharacter: Person = Person(name = "Victoria", gender = "Female", hairColour = "Purple", hairLength = "Long")
  val fourthCharacter: Person = Person(name = "Charlotte", gender = "Female", hairColour = "Yellow", hairLength = "Long")

  val charactersList: List[Person] = List(firstCharacter, secondCharacter, thirdCharacter, fourthCharacter)

  def returnMapOfQuestions(): List[String] ={
    val listOfQuestions:List[String] = List("")
  }
  def returnListOfCharacters(): List[Person] ={
    charactersList
  }

}
