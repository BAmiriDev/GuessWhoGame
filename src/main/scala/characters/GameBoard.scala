package characters

import scala.collection.mutable.ListBuffer

class GameBoard(board: List[Person]) {
  // This is dynamic gameBoard
  val gameBoardForPlayer1:ListBuffer[Person] = ListBuffer(board: _*)

}
