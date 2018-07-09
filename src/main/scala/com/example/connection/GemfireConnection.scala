package com.example.connection

import org.apache.geode.cache.client.{ClientCache, ClientCacheFactory}

trait GemfireConnection {
  var cache: ClientCache = new ClientCacheFactory().set("cache-xml-file", "xml/cache-xml-file.xml")
    .create()
}
