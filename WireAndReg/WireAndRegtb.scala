import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleTest extends AnyFlatSpec with ChiselScalatestTester {
  "Operation" should "work" in {
    test(new WireAndReg).withAnnotations(Seq(WriteVcdAnnotation))
     { dut =>
            println("Start test")
            dut.io.aIn.poke(10)
            println(s"a=${dut.io.aIn.peek()}," +
              s"wireOut${dut.io.wireOut.peek()}," +
              s"regOut${dut.io.regOut.peek()}," +
              s"nextregOut${dut.io.regnextOut.peek()},"
              )

            dut.clock.step()
            dut.io.aIn.poke(20)
            println(s"a=${dut.io.aIn.peek()}," +
              s"wireOut${dut.io.wireOut.peek()}," +
              s"regOut${dut.io.regOut.peek()}," +
              s"nextregOut${dut.io.regnextOut.peek()},"
              )

            dut.io.aIn.poke(30)
            dut.clock.step()
            println(s"a=${dut.io.aIn.peek()}," +
              s"wireOut${dut.io.wireOut.peek()}," +
              s"regOut${dut.io.regOut.peek()}," +
              s"nextregOut${dut.io.regnextOut.peek()},"
              )

    }
  }
}

// class WaveTest extends AnyFlatSpec with ChiselScalatestTester {
//     "ArithmeticOperation" should "pass" in {
//         test(new LogicOperation).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
//             println("Start test")
            
//             dut.io.aIn.poke(false.B)
//             dut.io.bIn.poke(false.B)
//             dut.clock.step()
//             dut.io.aIn.poke(false.B)
//             dut.io.bIn.poke(true.B)
//             dut.clock.step()
//             dut.io.aIn.poke(true.B)
//             dut.io.bIn.poke(false.B)
//             dut.clock.step()
//             dut.io.aIn.poke(true.B)
//             dut.io.bIn.poke(true.B)
//             dut.clock.step()

//         }
//     }
// }