package com.haskworks.foldleft.actions

sealed trait FoldLeftAction[S] {
  val result: S
}

object FoldLeftAction {

  case class Continue[S](result: S) extends FoldLeftAction[S]
  case class Done[S](result: S) extends FoldLeftAction[S]

}