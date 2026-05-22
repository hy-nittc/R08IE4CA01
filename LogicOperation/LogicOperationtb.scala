import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleTest extends AnyFlatSpec with ChiselScalatestTester {
  "LogicOperation" should "work" in {
    test(new LogicOperation).withAnnotations(Seq(WriteVcdAnnotation))
     { dut =>
            println("Start test")
            
            dut.io.aIn.poke(0.U)
            dut.io.bIn.poke(0.U)
            dut.clock.step()         
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"and${dut.io.andOut.peek()}," +
              s"or${dut.io.orOut.peek()}," +
              s"xor${dut.io.xorOut.peek()}," +
              s"not${dut.io.notOut.peek()}," +
              s"nand${dut.io.nandOut.peek()}," +
              s"nor${dut.io.norOut.peek()}," +
              s"xnor${dut.io.xnorOut.peek()}")

            dut.io.aIn.poke(1.U)
            dut.io.bIn.poke(0.U)
            dut.clock.step()
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"and${dut.io.andOut.peek()}," +
              s"or${dut.io.orOut.peek()}," +
              s"xor${dut.io.xorOut.peek()}," +
              s"not${dut.io.notOut.peek()}," +
              s"nand${dut.io.nandOut.peek()}," +
              s"nor${dut.io.norOut.peek()}," +
              s"xnor${dut.io.xnorOut.peek()}")

            dut.io.aIn.poke(0.U)
            dut.io.bIn.poke(1.U)
            dut.clock.step()         

            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"and${dut.io.andOut.peek()}," +
              s"or${dut.io.orOut.peek()}," +
              s"xor${dut.io.xorOut.peek()}," +
              s"not${dut.io.notOut.peek()}," +
              s"nand${dut.io.nandOut.peek()}," +
              s"nor${dut.io.norOut.peek()}," +
              s"xnor${dut.io.xnorOut.peek()}")

            dut.io.aIn.poke(1.U)
            dut.io.bIn.poke(1.U)
            dut.clock.step()         
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"and${dut.io.andOut.peek()}," +
              s"or${dut.io.orOut.peek()}," +
              s"xor${dut.io.xorOut.peek()}," +
              s"not${dut.io.notOut.peek()}," +
              s"nand${dut.io.nandOut.peek()}," +
              s"nor${dut.io.norOut.peek()}," +
              s"xnor${dut.io.xnorOut.peek()}")
            dut.clock.step()         
    }
  }
}
