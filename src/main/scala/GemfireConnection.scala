
import java.io.Serializable

import org.apache.geode.cache.Region
import org.apache.geode.cache.client.{ClientCache, ClientCacheFactory}

case class Customer(id: Int, name: String) extends Serializable

object GemfireConnection extends App {
  val cache: ClientCache = new ClientCacheFactory().set("cache-xml-file", "xml/cache-xml-file.xml").create

  val reg: Region[Int, Customer] = cache.getRegion("Customers")
  private val customerToAdd = Customer(1234, "John Doe")
  reg.put(customerToAdd.id, customerToAdd)

  private val fetchedCustomer: Customer = reg.get(1234)

  println(fetchedCustomer)

  cache.close()

}
