package characters

case class Person(
                   name: String,
                   gender: Gender,
                   hairColor: HairColour,
                   wearsGlasses: PersonWithGlasses,
                   wearsHat: PersonWithHat,
                   hasBeard: PersonWithBeard,
                   eyeColor: EyeColour,
                 )


