import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleTest extends AnyFlatSpec with ChiselScalatestTester {
    "SimpleTest" should "pass" in {
        test(new Alu) { dut =>
            for (a <- 0 to 10) {
                for(b <- 0 to 10) {
                    for(fn <- 0 to 3) {
                        dut.io.a.poke(a)
                        dut.io.b.poke(b)
                        dut.io.fn.poke(fn)
                        dut.clock.step(1)
                        println(s"a=${dut.io.a.peekInt()},b=${dut.io.b.peekInt()},fn=${dut.io.fn.peekInt()},y=${dut.io.y.peekInt()}")
                    }
                }
            }
        }    
    }
}

class WaveSpec extends AnyFlatSpec with ChiselScalatestTester {
    "WaveSpec" should "pass" in {
        test(new Alu).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
            for (a <- 0 to 10) {
                for(b <- 0 to 10) {
                    for(fn <- 0 to 3) {
                        dut.io.a.poke(a)
                        dut.io.b.poke(b)
                        dut.io.fn.poke(fn)
                        dut.clock.step(1)
                    }
                }
            }
        }
    }
}

