package com.example.repository

import com.example.model.Pojo
import org.apache.geode.cache.Region
import org.apache.geode.cache.client.ClientCache
import org.apache.geode.cache.query.{QueryService, SelectResults}
import scala.collection.JavaConverters._

case class PositionCache[T](clientCache: ClientCache) {
  val reg: Region[T, Pojo] = clientCache.getRegion("Positions")

  private val queryService: QueryService = clientCache.getQueryService()

  def groupByAccountType() = {
    val query = queryService.newQuery("select accountType, sum(p.balance) from /Positions p where p.accountKey=1 group by accountType")
    query.execute().asInstanceOf[SelectResults[Map[String, Double]]]
  }

  def getCount() = {
    val query = queryService.newQuery("select count(*) from /Positions p")
    query.execute().asInstanceOf[SelectResults[Map[String, Double]]]
  }

  def findAll() = {
    val query = queryService.newQuery("select * from /Positions")
    query.execute().asInstanceOf[SelectResults[Pojo]].asList().asScala
  }

  def addNewPositon = (position: Pojo) => {
    reg.put(position.hashCode().asInstanceOf[T], position)
  }

  def clear() = reg.clear()

  def get = (id: T) => reg.get(id)
}