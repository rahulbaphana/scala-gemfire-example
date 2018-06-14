package com.example.repository

import java.util

import com.example.connection.GemfireConnection
import com.example.model.User
import org.apache.geode.cache.Region
import org.apache.geode.cache.client.ClientCache
import org.apache.geode.cache.query.{QueryService, SelectResults}

case class CustomerCache(clientCache: ClientCache) extends GemfireConnection {
  val reg: Region[Int, User] = clientCache.getRegion("Users")

  private val queryService: QueryService = clientCache.getQueryService()

  def findAllWithNameContains(c: String): util.List[User] = {
    val params: Array[AnyRef] = Array(c)
    val query = queryService.newQuery("select * from /Users us where us.name.contains($1)")
    query.execute(params).asInstanceOf[SelectResults[User]].asList()
  }

  def add = (customer: User) => reg.put(customer.id, customer)

  def get = (id: Int) => reg.get(id)
}
