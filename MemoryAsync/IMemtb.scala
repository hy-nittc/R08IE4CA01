//> using scala "2.13.14"
//> using dep "edu.berkeley.cs::chisel3:3.6.1"
//> using plugin "edu.berkeley.cs:::chisel3-plugin:3.6.1"
//> using dep "edu.berkeley.cs::chiseltest:6.0.0"
//> using options "-unchecked", "-deprecation", "-language:reflectiveCalls", "-feature", "-Xfatal-warnings", "-Ywarn-unused", "-Ymacro-annotations"

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class WaveSpec extends AnyFlatSpec with ChiselScalatestTester {
    "WaveSpec" should "pass" in {
        test(new IMem).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
            for (a <- 0 to 255) {
                dut.io.addrIn.poke(a)
                println(s"addr=${dut.io.addrIn.peekInt()},instr=${dut.io.instrOut.peekInt().toString(16)}}")
                dut.clock.step(1)
                println(s"addr=${dut.io.addrIn.peekInt()},instr=${dut.io.instrOut.peekInt().toString(16)}}")
                println("----------") 
            }
       }
    }
}
