package com.haskworks.foldleft.actions

sealed trait FoldLeftActions[+S, E]

object FoldLeftActions {
  
  case class Continue[+S](result: S) extends FoldLeftActions[S, Nothing]
  case class Done[+S](result: S) extends FoldLeftActions[S, Nothing]
  case class Error[+S](result: S, error: Throwable) extends FoldLeftActions[S, Nothing]


}