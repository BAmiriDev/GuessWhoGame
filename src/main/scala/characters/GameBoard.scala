package characters


import scala.collection.mutable.ListBuffer

class GameBoard(board: List[Person]) {
  val gameBoardForPlayer:ListBuffer[Person] = ListBuffer(board: _*)
}
