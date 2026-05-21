import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleTest extends AnyFlatSpec with ChiselScalatestTester {
  "Operation" should "work" in {
    test(new Comparator) { dut =>
            println("Start test")
      for(a <- 0 until 4) {
        for(b <- 0 until 4){

            dut.io.aIn.poke(a)
            dut.io.bIn.poke(b)
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"eq${dut.io.eq.peek()}," +
              s"neq${dut.io.neq.peek()}," +
              s"inv${dut.io.inv.peek()}," +
              s"gt${dut.io.gt.peek()}," +
              s"gteq${dut.io.gteq.peek()}," +
              s"lt${dut.io.lt.peek()}," +
              s"lteq${dut.io.lteq.peek()}," +
              s"neq${dut.io.neq.peek()}," +
              s"")

        }
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