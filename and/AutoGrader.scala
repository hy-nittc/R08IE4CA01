import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class AutoGrader extends AnyFlatSpec with ChiselScalatestTester {
  "Test" should "Work" in {
  test(new And).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>

      var score = 0

      def check(a: Int, b: Int, expected: Int, pts: Int): Unit = {
        dut.io.aIn.poke(a.U)
        dut.io.bIn.poke(b.U)
        dut.clock.step()

        try {
          dut.io.andOut.expect(expected.U)
          score += pts
        } catch {
          case _: Throwable =>
        }
      }

      for (a <- 0 to 1; b <- 0 to 1) {
        val expected = a & b
        check(a, b, expected, 25)
      }

      println(s"TOTAL_SCORE=$score")
    }
  }
}