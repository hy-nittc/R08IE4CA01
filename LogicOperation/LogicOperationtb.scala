import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleTest extends AnyFlatSpec with ChiselScalatestTester {
  "LogicOperation" should "work" in {
    test(new LogicOperation).withAnnotations(Seq(WriteVcdAnnotation))
     { dut =>
            println("Start test")
            
            dut.io.aIn.poke(false.B)
            dut.io.bIn.poke(false.B)
            dut.io.andOut.expect(false.B)
            dut.io.orOut.expect(false.B)
            dut.io.xorOut.expect(false.B)
            dut.io.notOut.expect(true.B)
            dut.io.nandOut.expect(true.B)
            dut.io.norOut.expect(true.B)
            dut.io.xnorOut.expect(true.B)
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"and${dut.io.andOut.peek()}," +
              s"or${dut.io.orOut.peek()}," +
              s"xor${dut.io.xorOut.peek()}," +
              s"not${dut.io.notOut.peek()}," +
              s"nand${dut.io.nandOut.peek()}," +
              s"nor${dut.io.norOut.peek()}," +
              s"xnor${dut.io.xnorOut.peek()}")

            dut.io.aIn.poke(false.B)
            dut.io.bIn.poke(true.B)
            dut.io.andOut.expect(false.B)
            dut.io.orOut.expect(true.B)
            dut.io.xorOut.expect(true.B)
            dut.io.notOut.expect(true.B)
            dut.io.nandOut.expect(true.B)
            dut.io.norOut.expect(false.B)
            dut.io.xnorOut.expect(false.B)
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"and${dut.io.andOut.peek()}," +
              s"or${dut.io.orOut.peek()}," +
              s"xor${dut.io.xorOut.peek()}," +
              s"not${dut.io.notOut.peek()}," +
              s"nand${dut.io.nandOut.peek()}," +
              s"nor${dut.io.norOut.peek()}," +
              s"xnor${dut.io.xnorOut.peek()}")


            dut.io.aIn.poke(true.B)
            dut.io.bIn.poke(false.B)
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"and${dut.io.andOut.peek()}," +
              s"or${dut.io.orOut.peek()}," +
              s"xor${dut.io.xorOut.peek()}," +
              s"not${dut.io.notOut.peek()}," +
              s"nand${dut.io.nandOut.peek()}," +
              s"nor${dut.io.norOut.peek()}," +
              s"xnor${dut.io.xnorOut.peek()}")

            dut.io.aIn.poke(true.B)
            dut.io.bIn.poke(true.B)
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"and${dut.io.andOut.peek()}," +
              s"or${dut.io.orOut.peek()}," +
              s"xor${dut.io.xorOut.peek()}," +
              s"not${dut.io.notOut.peek()}," +
              s"nand${dut.io.nandOut.peek()}," +
              s"nor${dut.io.norOut.peek()}," +
              s"xnor${dut.io.xnorOut.peek()}")
    }
  }
}

// class WaveTest extends AnyFlatSpec with ChiselScalatestTester {
//     "LogicOperation" should "pass" in {
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