import chisel3._

class WireAndReg extends Module {
    val io = IO(new Bundle {
        val aIn = Input(UInt(8.W))
        val wireOut = Output(UInt(8.W))
        val regOut = Output(UInt(8.W))
        val regnextOut = Output(UInt(8.W))
    })

    val wire = Wire(UInt(8.W))
    val reg = Reg(UInt(8.W))
    // val reg = RegInit (0.U(8.W))

    // A register can also be connected to its input at the definition:
    val nextreg = RegNext (io.aIn,0.U)

    wire := io.aIn
    reg := io.aIn

    io.wireOut := wire
    io.regOut := reg
    io.regnextOut := nextreg

}

object GenVerilog extends App {
  val s = getVerilogString(new WireAndReg())
  println(s)
}

/**
 * An object extending App to generate the Verilog code.
 */
//- start generate_string
// object GenVerilog extends App {
//   val s = getVerilogString(new CALab0())
//   println(s)
// }

//- start generate
// object GenVerilog extends App {
//   emitVerilog(new CALab0())
// }
//- end

//- start generate_options
// object GenVerilog extends App {
//   emitVerilog(new CALab0(), Array("--target-dir", "generated"))
// }
//- end