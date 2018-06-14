package com.example.repository

import com.example.connection.GemfireConnection
import com.example.model.Position

object PositionsSpec extends App {
  new GemfireConnection {
      private val positionCache = PositionCache[Int](cache)
      positionCache.add(Position(1, "SAVING", "9952388706", "EQUITY", "CASH_EQUIVALANT", "92824", 4879, "444", 130134482.24950731d, "INR"))
      positionCache.add(Position(1, "SAVING_PLUS", "9952388707", "EQUITY_PLUS", "CASH_EQUIVALANT", "92824", 4879, "444", 130134482.24950731d, "INR"))
      positionCache.add(Position(2, "CURRENT", "8805342674", "EQUITY", "CASH_EQUIVALANT", "77189", 9387, "666", 362750915.00189805d, "USD"))
      positionCache.add(Position(3, "SAVING", "7076923837", "CASH", "CASH_EQUIVALANT", "40718", 9454, "333", 780128540.311229d, "CAD"))
      positionCache.add(Position(4, "SAVING_PLUS", "6334231406", "EQUITY", "CASH_EQUIVALANT", "10120", 2655, "222", 837344728.5878029d, "INR"))
      positionCache.add(Position(5, "CURRENT", "9928894277", "EQUITY", "INVESTMENT", "26510", 9439, "555", 6710203.8682593545d, "INR"))

      private val positions = positionCache.groupByAccountType()

      println(positions)

      cache.close()
    }
}
