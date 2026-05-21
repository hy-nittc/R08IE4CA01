import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleTest extends AnyFlatSpec with ChiselScalatestTester {
  "Operation" should "work" in {
    test(new RegFile) { dut =>
      println("Start test")
      dut.io.wen.poke(true.B)
      for(a <- 0 until 32) {
        dut.io.rd.poke(a)
        dut.io.wd.poke(a+10)
        dut.clock.step()
      }
      dut.io.wen.poke(false.B)
      for(a <- 0 until 32) {
          dut.io.rs1.poke(a)
          dut.io.rs2.poke(31 - a)
          dut.clock.step()
          println(s"rs1=${dut.io.rs1.peek()},rs2=${dut.io.rs2.peek()},wd${dut.io.wd.peek()}," +
            s"rd1=${dut.io.rd1.peek()},}" +
            s"rd1=${dut.io.rd2.peek()},}"
            )

      }
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