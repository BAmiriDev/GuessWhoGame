package characters

class Resources {
  //create a list of characters

  val charactersList:List[Person] = List(
      Person("Alex", "Male", "Brown", wearsGlasses = true, wearsHat = false, hasBeard = false, "Blue", hasFreckles = false, hasEarrings = false, wearsNecklace = false, "Short"),
      Person("Beth", "Female", "Blonde", wearsGlasses = false, wearsHat = true, hasBeard = false, "Green", hasFreckles = false, hasEarrings = true, wearsNecklace = false, "Long"),
      Person("Chris", "Male", "Black", wearsGlasses = false, wearsHat = false, hasBeard = true, "Brown", hasFreckles = false, hasEarrings = false, wearsNecklace = false, "Short"),
      Person("Dana", "Female", "Red", wearsGlasses = true, wearsHat = false, hasBeard = false, "Hazel", hasFreckles = true, hasEarrings = false, wearsNecklace = true, "Long"),
      Person("Eli", "Male", "Blonde", wearsGlasses = false, wearsHat = true, hasBeard = false, "Blue", hasFreckles = false, hasEarrings = false, wearsNecklace = false, "Short"),
      Person("Fiona", "Female", "Brown", wearsGlasses = false, wearsHat = false, hasBeard = false, "Brown", hasFreckles = false, hasEarrings = true, wearsNecklace = true, "Medium"),
      Person("George", "Male", "Grey", wearsGlasses = true, wearsHat = false, hasBeard = true, "Green", hasFreckles = false, hasEarrings = false, wearsNecklace = false, "Short"),
      Person("Hannah", "Female", "Black", wearsGlasses = false, wearsHat = true, hasBeard = false, "Brown", hasFreckles = true, hasEarrings = false, wearsNecklace = true, "Long"),
      Person("Ian", "Male", "Red", wearsGlasses = true, wearsHat = false, hasBeard = false, "Blue", hasFreckles = false, hasEarrings = false, wearsNecklace = false, "Short"),
      Person("Jane", "Female", "Grey", wearsGlasses = true, wearsHat = false, hasBeard = false, "Hazel", hasFreckles = false, hasEarrings = true, wearsNecklace = false, "Medium"),
      Person("Kyle", "Male", "Brown", wearsGlasses = false, wearsHat = true, hasBeard = true, "Green", hasFreckles = false, hasEarrings = false, wearsNecklace = false, "Short"),
      Person("Laura", "Female", "Blonde", wearsGlasses = false, wearsHat = false, hasBeard = false, "Blue", hasFreckles = false, hasEarrings = false, wearsNecklace = true, "Long"),
      Person("Mike", "Male", "Black", wearsGlasses = false, wearsHat = true, hasBeard = false, "Brown", hasFreckles = true, hasEarrings = false, wearsNecklace = false, "Short"),
      Person("Nina", "Female", "Red", wearsGlasses = true, wearsHat = false, hasBeard = false, "Green", hasFreckles = false, hasEarrings = true, wearsNecklace = false, "Medium"),
      Person("Oscar", "Male", "Grey", wearsGlasses = false, wearsHat = true, hasBeard = true, "Blue", hasFreckles = false, hasEarrings = false, wearsNecklace = false, "Short"),
      Person("Paula", "Female", "Brown", wearsGlasses = true, wearsHat = false, hasBeard = false, "Brown", hasFreckles = true, hasEarrings = false, wearsNecklace = true, "Medium")
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
  "Does your person have freckles?",
  "Does your person have earrings?",
  "Does your person wear a necklace?",
  "Does your person have short hair?",
  "Does your person have medium hair?",
  "Does your person have long hair?")
}
