import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleTest extends AnyFlatSpec with ChiselScalatestTester {
    "SimpleTest" should "pass" in {
        test(new Decode).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
            for (opcode <- 0 to 15) {
                dut.io.opcodeIn.poke(opcode)
                dut.clock.step(1)
                println(s"opcode=${dut.io.opcodeIn.peekInt()},aluop=${dut.io.ctrlSignalsOut.peekInt().toString(16)}}")
            }
        }    
    }
}
