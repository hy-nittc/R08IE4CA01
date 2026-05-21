import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleTest extends AnyFlatSpec with ChiselScalatestTester {
  "Operation" should "work" in {
    test(new ArithmeticOperation).withAnnotations(Seq(WriteVcdAnnotation))
     { dut =>
            println("Start test")
      for(a <- 0 until 10) {
        for(b <- 0 until 10){

            dut.io.aIn.poke(a)
            dut.io.bIn.poke(b)
            // dut.io.andOut.expect(false.B)
            // dut.io.orOut.expect(false.B)
            // dut.io.xorOut.expect(false.B)
            // dut.io.notOut.expect(true.B)
            // dut.io.nandOut.expect(true.B)
            // dut.io.norOut.expect(true.B)
            // dut.io.xnorOut.expect(true.B)
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"add${dut.io.addOut.peek()}," +
              s"sub${dut.io.subOut.peek()}," +
              s"mul${dut.io.mulOut.peek()}," +
              s"div${dut.io.divOut.peek()}," +
              s"neg${dut.io.negOut.peek()}," +
              s"mod${dut.io.modOut.peek()},")
            dut.clock.step()
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