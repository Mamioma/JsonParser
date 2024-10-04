package jsonParser

object MarshallableImplicits {

  implicit class Unmarshallable(unMarshallMe: String) {
    def toMap: Map[String,Any] = JsonUtils.toMap(unMarshallMe)
    def toMapOf[V]()(implicit m: Manifest[V]): Map[String,V] = JsonUtils.toMap[V](unMarshallMe)
    def fromJson[T]()(implicit m: Manifest[T]): T =  JsonUtils.fromJson[T](unMarshallMe)
  }

  implicit class Marshallable[T](marshallMe: T) {
    def toJson: String = JsonUtils.toJson(marshallMe)
  }

}
