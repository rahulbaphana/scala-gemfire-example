package com.example.base

import org.scalatest._

abstract class BaseUnitSpec extends FlatSpec with Matchers with
  OptionValues with Inside with Inspectors
