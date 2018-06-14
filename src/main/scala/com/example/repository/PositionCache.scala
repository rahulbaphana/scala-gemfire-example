package com.example.repository

import java.util

import com.example.model.{AccountTypeGroup, Position}
import org.apache.geode.cache.Region
import org.apache.geode.cache.client.ClientCache
import org.apache.geode.cache.query.{QueryService, SelectResults}

case class PositionCache[T](clientCache: ClientCache) {
  val reg: Region[T, Position] = clientCache.getRegion("Positions")

  private val queryService: QueryService = clientCache.getQueryService()

  def groupByAccountType() = {
    val query = queryService.newQuery("select accountType, sum(p.balance) from /Positions p where p.accountKey=1 group by accountType")
    query.execute().asInstanceOf[SelectResults[Map[String, Double]]]
  }

  def add = (position: Position) => reg.put(position.hashCode().asInstanceOf[T], position)

  def get = (id: T) => reg.get(id)
}