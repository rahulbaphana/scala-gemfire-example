package com.example.model

case class User(var id: Int, var name: String) {
  def this() = this(0, null)
}
