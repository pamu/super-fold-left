package com.haskworks.foldleft

package object implicits {

  implicit class ListOps[+A](val list: List[A]) {
    def superFoldLeft: List[A] = list
  }
}
