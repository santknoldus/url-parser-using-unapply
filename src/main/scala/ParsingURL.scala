package com.knoldus.urlparser

object ParsingURL extends App {

  private val extractor = URLParser("https://www.mywebsite.com/home")

  extractor match {
    case URLParser(protocol, domain, path) => println(s"Protocol: $protocol\nDomain: $domain\nPath: $path")
    case _ => println("URL not found")
  }
}