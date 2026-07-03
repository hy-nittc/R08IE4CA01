import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleTest extends AnyFlatSpec with ChiselScalatestTester {
  "test" should "work" in {
    test(new Delay).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
      println("Start test")
      for(a <- 1 until 4) {
          set(a)
      }

      def set (  a: Int): Unit = {
        dut.io.aIn.poke(a.U)
        println(s"aIn=${dut.io.aIn.peek()},aOut=${dut.io.aOut.peek()},bOut=${dut.io.bOut.peek()}")
        dut.clock.step(1)
        println(s"aIn=${dut.io.aIn.peek()},aOut=${dut.io.aOut.peek()},bOut=${dut.io.bOut.peek()}")
        dut.clock.step(1)
      }
    }
  }
}

