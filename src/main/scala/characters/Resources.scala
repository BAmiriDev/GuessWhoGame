package characters

class Resources {
  //create a list of characters

  val charactersList:List[Person] = List(
      Person("Alex", gender = Male, "Brown", PersonWithGlasses(true) , PersonWithHat(false), PersonWithBeard(false), "Blue"),
      Person("Beth", "Female", "Blonde", wearsGlasses = false, wearsHat = true, hasBeard = false, "Green"),
      Person("Chris", "Male", "Black", wearsGlasses = false, wearsHat = false, hasBeard = true, "Brown"),
      Person("Dana", "Female", "Red", wearsGlasses = true, wearsHat = false, hasBeard = false, "Hazel"),
      Person("Eli", "Male", "Blonde", wearsGlasses = false, wearsHat = true, hasBeard = false, "Blue"),
      Person("Fiona", "Female", "Brown", wearsGlasses = false, wearsHat = false, hasBeard = false, "Brown"),
      Person("George", "Male", "Grey", wearsGlasses = true, wearsHat = false, hasBeard = true, "Green"),
      Person("Hannah", "Female", "Black", wearsGlasses = false, wearsHat = true, hasBeard = false, "Brown"),
      Person("Ian", "Male", "Red", wearsGlasses = true, wearsHat = false, hasBeard = false, "Blue"),
      Person("Jane", "Female", "Grey", wearsGlasses = true, wearsHat = false, hasBeard = false, "Hazel"),
      Person("Kyle", "Male", "Brown", wearsGlasses = false, wearsHat = true, hasBeard = true, "Green"),
      Person("Laura", "Female", "Blonde", wearsGlasses = false, wearsHat = false, hasBeard = false, "Blue"),
      Person("Mike", "Male", "Black", wearsGlasses = false, wearsHat = true, hasBeard = false, "Brown"),
      Person("Nina", "Female", "Red", wearsGlasses = true, wearsHat = false, hasBeard = false, "Green"),
      Person("Oscar", "Male", "Grey", wearsGlasses = false, wearsHat = true, hasBeard = true, "Blue"),
      Person("Paula", "Female", "Brown", wearsGlasses = true, wearsHat = false, hasBeard = false, "Brown")
  )

  // Questions list
  val listOfQuestions: List[String] = List(
    "Is your person male?",
  "Is your person female?",
  "Does your person have blonde hair?",
  "Does your person have brown hair?",
  "Does your person have black hair?",
  "Does your person have red hair?",
  "Does your person have grey hair?",
  "Does your person wear glasses?",
  "Does your person wear a hat?",
  "Does your person have a beard?",
  "Does your person have blue eyes?",
  "Does your person have green eyes?",
  "Does your person have brown eyes?",
  "Does your person have hazel eyes?",
  )
}
