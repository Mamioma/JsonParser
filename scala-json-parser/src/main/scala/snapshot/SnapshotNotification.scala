package snapshot

case class SnapshotNotification(orgId: String,
                                dataSetId: String,
                                trackingId: String,
                                sandboxId: String,
                                sandboxName: String,
                                snapshot: Option[Snapshot])
