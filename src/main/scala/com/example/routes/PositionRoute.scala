package com.example.routes

import akka.http.scaladsl.server.Directives._
import com.example.connection.GemfireConnection
import com.example.model.Pojo
import com.example.repository.PositionCache
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport

class PositionRoute(var positionCache: PositionCache[Pojo] = null) extends PlayJsonSupport {

  new GemfireConnection {
    positionCache = PositionCache[Pojo](cache)
  }

  val route =
    path("positions") {
      get {
        complete(positionCache.findAll())
      }
    }
}
