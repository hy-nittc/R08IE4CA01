import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleTest extends AnyFlatSpec with ChiselScalatestTester {
  "Operation" should "work" in {
    test(new RegisterVec) { dut =>
      println("Start Write")
      for(a <- 0 until 10) {

            dut.io.aIn.poke(a)
            dut.io.indexIn.poke(a)
            dut.clock.step()
            println(s"a=${dut.io.aIn.peek()},index=${dut.io.indexIn.peek()}," +
              s"regVec${dut.io.regVecOut.peek()},"
              )

      }        
      println("Start Read")
      for(a <- 0 until 10) {

            dut.io.indexIn.poke(a)
            dut.clock.step()
            println(s"a=${dut.io.aIn.peek()},index=${dut.io.indexIn.peek()}," +
              s"regVec${dut.io.regVecOut.peek()},"
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