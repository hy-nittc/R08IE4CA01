//> using scala "2.13.14"
//> using dep "edu.berkeley.cs::chisel3:3.6.1"
//> using plugin "edu.berkeley.cs:::chisel3-plugin:3.6.1"
// using dep "edu.berkeley.cs::chiseltest:6.0.0"
// using dep "org.scala-sbt::compiler-bridge:1.10.3"
//> using options "-unchecked", "-deprecation", "-language:reflectiveCalls", "-feature", "-Xcheckinit", "-Xfatal-warnings", "-Ywarn-dead-code", "-Ywarn-unused", "-Ymacro-annotations"

import chisel3._
import chisel3.util._

class Alu extends Module {
    val io = IO(new Bundle {
        val a = Input(UInt(16.W))
        val b = Input(UInt(16.W))
        val fn = Input(UInt(2.W))
        val y = Output(UInt(16.W))
    })

    // default value is needed
    io.y := 0.U

    // The ALU selection
    switch(io.fn){
        is(0.U){io.y:=io.a + io.b}
        is(1.U){io.y:=io.a - io.b}
        is(2.U){io.y:=io.a | io.b}
        is(3.U){io.y:=io.a & io.b}
    }
}

object printVerilogCode extends App {
    val s = getVerilogString(new Alu())
    println(s)
}