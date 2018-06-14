package com.example.model

import java.util.Date

case class User(id: Int, name: String) {
  def this() = this(0, null)
}

case class Position(accountKey: Int,
                     accountType: String,
                     accountNumber: String,
                     assetClassL1: String,
                     assetClassL2: String,
                     securityId: String,
                     quantity: Int,
                     accountGroupId: String,
                     balance: Double,
                     currency: String,
                     date: Date = new Date()) {
  def this() = this(0, null, null, null, null, null, 0, null, 0.0d, null)
}