package com.knoldus.urlparser

import org.scalatest.funsuite.AnyFunSuite

class URLParserTest extends AnyFunSuite {
  test("extracting url") {
    val url = new URLParser("https://www.mywebsite.com/home/about")
    val result: String = url match {
      case URLParser(protocol, domain, path) => s"Protocol: $protocol\nDomain: $domain\nPath: $path"
      case _ => "URL not found"
    }
    assert(result === ("Protocol: https\nDomain: www.mywebsite.com\nPath: home/about"))
  }

  test("extracting empty url") {
    val url = new URLParser(" ")
    val result: String = url match {
      case URLParser(protocol, domain, path) => s"Protocol: $protocol\nDomain: $domain\nPath: $path"
      case _ => "URL not found"
    }
    assert(result == "URL not found")
  }
}
