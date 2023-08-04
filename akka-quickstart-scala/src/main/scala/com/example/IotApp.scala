package com.example

import akka.actor.typed.ActorSystem

object IotApp {
  def main(args: Array[String]): Unit = {
    ActorSystem[Nothing](IOTSupervisor(), "iot-system")
  }
}
