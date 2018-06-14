package com.example.connection

import org.apache.geode.cache.client.{ClientCache, ClientCacheFactory}

trait GemfireConnection {
  val cache: ClientCache = new ClientCacheFactory().set("cache-xml-file", "xml/cache-xml-file.xml")
                          .create()
}
