package snapshot

case class Snapshot (
   id: Long,
   trackingId: String,
   commitId: Option[String],
   committedAtMillis: Long,
   operation: String,
   reason: Option[String],
   userAgent: String,
   apiKey: String,
   stats: Map[String, Long],
   isDelayed: Option[Boolean],
   tags: Map[String, String]
)