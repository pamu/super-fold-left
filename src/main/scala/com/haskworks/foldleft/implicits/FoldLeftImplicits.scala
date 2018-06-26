package com.haskworks.foldleft.implicits

import com.haskworks.foldleft.actions.FoldLeftAction
import com.haskworks.foldleft.actions.FoldLeftAction.Done
import com.haskworks.foldleft.actions.FoldLeftAction
import com.haskworks.foldleft.actions.FoldLeftAction.{Continue, Done}

trait FoldLeftImplicits {


  implicit class ListOps[A](val seq: Seq[A]) {
    def tractableFoldLeft[B](empty: B)(f: (B, A) => FoldLeftAction[B]): B = {

      @scala.annotation.tailrec
      def loop(acc: B,
               f: (B, A) => FoldLeftAction[B],
               rest: Seq[A]): FoldLeftAction[B] = rest match {
        case Seq() => Done(acc)
        case Seq(x, xs@_*) => f(acc, x) match {
          case Continue(result) => loop(result, f, xs)
          case done: Done[B] => done
        }
      }

      loop(empty, f, seq).result
    }
  }

}
