package com.example.model

import java.time.LocalDate
import java.util.Random

import play.api.libs.json.{Json, OFormat, OWrites, Reads}

object RandomDataGenerator {
  val ACCOUNT_TYPE_ARRAY: Array[String] = Array("SAVING", "SAVING_PLUS", "CURRENT")
  val ASSET_CLASS_ARRAY: Array[String] = Array("CASH", "EQUITY")
  val ASSET_CLASS_LTWO_ARRAY: Array[String] = Array("CASH_EQUIVALANT", "INVESTMENT")
  val ACCOUNT_GROUP_ARRAY: Array[String] = Array("111", "222", "333", "444", "555", "666")
  val CURRENCY_ARRAY: Array[String] = Array("USD", "CAD", "INR")

  private val random = new scala.util.Random

  def generateRandomLong: Long = random.nextLong()

  def generateRandomDouble = random.nextDouble

  def getRandomElement(array: Array[String]): String = array(random.nextInt(array.length))

  def generateRandomDate: LocalDate = {
    val random = new Random
    val minDay = LocalDate.of(1950, 1, 1).toEpochDay.toInt
    val maxDay = LocalDate.of(2018, 1, 1).toEpochDay.toInt
    val randomDay = minDay + random.nextInt(maxDay - minDay)
    LocalDate.ofEpochDay(randomDay)
  }
}

case class Pojo(accountKey: Long,
                accountType: String = RandomDataGenerator.getRandomElement(RandomDataGenerator.ACCOUNT_TYPE_ARRAY),
                accountNumber: Long = RandomDataGenerator.generateRandomLong,
                assetClassL1: String = RandomDataGenerator.getRandomElement(RandomDataGenerator.ASSET_CLASS_ARRAY),
                assetClassL2: String = RandomDataGenerator.getRandomElement(RandomDataGenerator.ASSET_CLASS_LTWO_ARRAY),
                accountGroupId: String = RandomDataGenerator.getRandomElement(RandomDataGenerator.ACCOUNT_GROUP_ARRAY),
                balance: Double = RandomDataGenerator.generateRandomDouble,
                currency: String = RandomDataGenerator.getRandomElement(RandomDataGenerator.CURRENCY_ARRAY),
                date: LocalDate = RandomDataGenerator.generateRandomDate
                   ) extends Serializable {

  def this() = this(0l, "", 0l, "", "", "", 0d, "")


  override def toString: String = accountKey + "," + "\'" + accountType + "\'" + "," + accountNumber + "," + "\'" + assetClassL1 + "\'" + "," + "\'" + assetClassL2 + "\'" + "," + "\'" + accountGroupId + "\'" + "," + balance + "," + "\'" + currency + "\'" + "," + "\'" + date + "\'"


}

object Pojo {
  implicit val jsonFormatRead: Reads[Pojo] = Json.reads[Pojo]
  implicit val jsonFormatWrite: OWrites[Pojo] = Json.writes[Pojo]
  implicit val jsonFormat: OFormat[Pojo] = Json.format[Pojo]
}
