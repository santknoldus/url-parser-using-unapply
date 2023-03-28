package com.knoldus.urlparser

object URLParser {

  def apply(url: String) = s"$url"

  //unapply method to deconstruct object
  def unapply(url: String): Option[(String, String, String)] = {
    if (url.indexOf("://") == -1 || url.indexOf("/", url.indexOf("://") + 3) == -1) {
      return None
    }
    val protocol = url.substring(0, url.indexOf("://"))
    val domain = url.substring(url.indexOf("://") + 3, url.indexOf("/", url.indexOf("://") + 3))
    val path = url.substring(url.indexOf("/", url.indexOf("://") + 3) + 1)
    Some(protocol, domain, path)
  }
}