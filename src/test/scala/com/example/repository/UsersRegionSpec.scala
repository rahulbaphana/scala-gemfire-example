package com.example.repository

import com.example.base.BaseUnitSpec
import com.example.connection.GemfireConnection
import com.example.model.User

class UsersRegionSpec extends BaseUnitSpec {

  "Customer cache" should "fetch values from /Users region in gemfire" in {
    new GemfireConnection {
      val customerCache = UserCache(cache)
      customerCache.add(User(1234, "Rahul Baphana"))
      customerCache.add(User(1235, "Shirish Padalkar"))
      customerCache.add(User(1236, "John Doe"))
      val customerFetched = customerCache.findAllWithNameContains("r")

      customerFetched.size() should be(1)
      cache.close()
    }
  }

  it should "add user to /Users" in {
    new GemfireConnection {
      val customerCache = UserCache(cache)
      customerCache.add(User(1234, "Rahul Baphana"))
      customerCache.add(User(1235, "Shirish Padalkar"))
      customerCache.add(User(1236, "John Doe"))
      val customerFetched = customerCache.get(1235)

      customerFetched should not be(null)

      customerFetched should be equals User(1235, "Shirish Padalkar")
      cache.close()
    }
  }
}
