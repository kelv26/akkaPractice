package com.example

import akka.actor.testkit.typed.scaladsl.ScalaTestWithActorTestKit
import org.scalatest.wordspec.AnyWordSpecLike

class DeviceManagerSpec extends ScalaTestWithActorTestKit with AnyWordSpecLike{
//  "ignore requests for wrong groupId" in {
//    val probe = createTestProbe[DeviceManager.DeviceRegistered]()
//    val deviceManagerActor = spawn(DeviceManager())
//    deviceManagerActor ! DeviceManager.RequestTrackDevice("wrongGroup", "device1", probe.ref)
//    probe.expectNoMessage()
//  }

  "return same actor for same deviceId" in {
    val probe = createTestProbe[DeviceManager.DeviceRegistered]()
    val deviceManagerActor = spawn(DeviceManager())
    deviceManagerActor ! DeviceManager.RequestTrackDevice("group1", "device1", probe.ref)
    val response1 = probe.receiveMessage()
    deviceManagerActor ! DeviceManager.RequestTrackDevice("group1", "device1", probe.ref)
    val response2 = probe.receiveMessage()
    response1.device should ===(response2.device)
  }
}
