package com.example.repository

import com.example.connection.GemfireConnection
import com.example.model.Pojo

object PositionsSpec extends App {
  new GemfireConnection {
    private val positionCache = PositionCache[Int](cache)

    positionCache.clear()

    (1l to 100000l).map(accKey => positionCache.addNewPositon(Pojo(accKey)))

    val startTime = System.currentTimeMillis()
    private val allPositions = positionCache.findAll()
    val timeRequired = System.currentTimeMillis() - startTime

    println(s"difference: $timeRequired millis")

    println(s"count: ${positionCache.getCount()}")

    cache.close()
  }
}
