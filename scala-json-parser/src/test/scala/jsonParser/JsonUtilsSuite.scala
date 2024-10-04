package jsonParser

import org.scalatest.FunSuite
import jsonParser.MarshallableImplicits._
import snapshot.SnapshotNotification

class JsonUtilsSuite extends FunSuite {

  test("test serialize and deserialize a snapshot message") {
    val json =
      """{
        |  "orgId" : "myOrgId",
        |  "dataSetId" : "myDataSetId",
        |  "trackingId" : "myTrackingId",
        |  "sandboxId" : "mySandboxId",
        |  "sandboxName" : "mySandboxName",
        |  "snapshot" : {
        |    "id" : 1,
        |    "trackingId" : "myTrackingId",
        |    "commitId" : "myCommitId",
        |    "committedAtMillis" : 1234,
        |    "operation" : "myOperation",
        |    "reason" : "myReason",
        |    "userAgent" : "myUserAgent",
        |    "apiKey" : "myApiKey",
        |    "stats" : { },
        |    "isDelayed" : null,
        |    "tags" : { }
        |  }
        |}""".stripMargin
    val result = json.fromJson[SnapshotNotification]
    verifyResult(result)
    val serialized = result.toJson
    assert(serialized === json)
  }

  private def verifyResult(result: SnapshotNotification): Unit = {
    assert(result.orgId === "myOrgId")
    assert(result.dataSetId === "myDataSetId")
    assert(result.trackingId === "myTrackingId")
    assert(result.sandboxId === "mySandboxId")
    assert(result.sandboxName === "mySandboxName")
    assert(result.snapshot.get.id === 1)
    assert(result.snapshot.get.trackingId === "myTrackingId")
    assert(result.snapshot.get.commitId === Some("myCommitId"))
    assert(result.snapshot.get.committedAtMillis === 1234)
    assert(result.snapshot.get.operation === "myOperation")
    assert(result.snapshot.get.reason === Some("myReason"))
    assert(result.snapshot.get.userAgent === "myUserAgent")
    assert(result.snapshot.get.apiKey === "myApiKey")
    assert(result.snapshot.get.stats === Map.empty)
    assert(result.snapshot.get.isDelayed === None)
    assert(result.snapshot.get.tags === Map.empty)
  }
}
