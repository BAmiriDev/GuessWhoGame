package characters

import characters._

class Resources {
  // Create a list of characters
  val charactersList: List[Person] = List(
    Person("Alex", Female, DarkBrown, PersonWithGlasses(true), PersonWithHat(false), PersonWithBeard(false), Blue),
    Person("Beth", Female, Blonde, PersonWithGlasses(false), PersonWithHat(true), PersonWithBeard(false), Green),
    Person("Chris", Male, Black, PersonWithGlasses(false), PersonWithHat(false), PersonWithBeard(true), Brown),
    Person("Dana", Female, Red, PersonWithGlasses(true), PersonWithHat(false), PersonWithBeard(false), Hazel),
    Person("Eli", Male, Blonde, PersonWithGlasses(false), PersonWithHat(true), PersonWithBeard(false), Blue),
    Person("Fiona", Female, DarkBrown, PersonWithGlasses(false), PersonWithHat(false), PersonWithBeard(false), Brown),
    Person("George", Male, Grey, PersonWithGlasses(true), PersonWithHat(false), PersonWithBeard(true), Green),
    Person("Hannah", Female, Black, PersonWithGlasses(false), PersonWithHat(true), PersonWithBeard(false), Brown),
    Person("Ian", Male, Red, PersonWithGlasses(true), PersonWithHat(false), PersonWithBeard(false), Blue),
    Person("Jane", Female, Grey, PersonWithGlasses(true), PersonWithHat(false), PersonWithBeard(false), Hazel),
    Person("Kyle", Male, DarkBrown, PersonWithGlasses(false), PersonWithHat(true), PersonWithBeard(true), Green),
    Person("Laura", Female, Blonde, PersonWithGlasses(false), PersonWithHat(false), PersonWithBeard(false), Blue),
    Person("Mike", Male, Black, PersonWithGlasses(false), PersonWithHat(true), PersonWithBeard(false), Brown),
    Person("Nina", Female, Red, PersonWithGlasses(true), PersonWithHat(false), PersonWithBeard(false), Green),
    Person("Oscar", Male, Grey, PersonWithGlasses(false), PersonWithHat(true), PersonWithBeard(true), Blue),
    Person("Paula", Female, DarkBrown, PersonWithGlasses(true), PersonWithHat(false), PersonWithBeard(false), Brown)
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
    "Does your person have hazel eyes?"
  )
}
