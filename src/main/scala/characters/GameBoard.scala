package characters


import scala.collection.mutable.ListBuffer

class GameBoard(board: List[Person]) {
  // This is dynamic gameBoard
  val gameBoardForPlayer:ListBuffer[Person] = ListBuffer(board: _*)
  //val gameBoardForComputer:ListBuffer[Person] = ListBuffer(board: _*)
}
