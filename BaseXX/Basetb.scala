import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleTest extends AnyFlatSpec with ChiselScalatestTester {
  "Operation" should "work" in {
    test(new Base).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
      println("Start test")
      for(a <- 0 until 4) {
        dut.io.opcode.poke(a)
        println(s"opcode=${dut.io.opcode.peek()},aluOp=${dut.io.aluOp.peek()}")
        dut.clock.step()
      }
    }
  }
}

