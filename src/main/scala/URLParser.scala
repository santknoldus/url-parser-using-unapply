package com.knoldus.urlparser

class URLParser(val urlString: String)

object URLParser {

  def apply(url: String) = new URLParser(url)

  //unapply method to deconstruct object
  def unapply(parser: URLParser): Option[(String, String, String)] = {
    val url = parser.urlString
    if (url.indexOf("://") == -1 || url.indexOf("/", url.indexOf("://") + 3) == -1) {
      return None
    }
    val protocol = url.substring(0, url.indexOf("://"))
    val domain = url.substring(url.indexOf("://") + 3, url.indexOf("/", url.indexOf("://") + 3))
    val path = url.substring(url.indexOf("/", url.indexOf("://") + 3) + 1)
    Some(protocol, domain, path)
  }
}

object Extractor extends App {

  private val extractor = URLParser("https://www.mywebsite.com/home")

  extractor match {
    case URLParser(protocol, domain, path) => println(s"Protocol: $protocol\nDomain: $domain\nPath: $path")
    case _ => println("URL not found")
  }
}