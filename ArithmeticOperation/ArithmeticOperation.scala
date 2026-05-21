import chisel3._

class ArithmeticOperation extends Module {
    val io = IO(new Bundle {
        val aIn = Input(UInt(8.W))
        val bIn = Input(UInt(8.W))
        val addOut = Output(UInt(8.W))
        val subOut = Output(UInt(8.W))
        val mulOut = Output(UInt(8.W))
        val divOut = Output(UInt(8.W))
        val negOut = Output(UInt(8.W))
        val modOut = Output(UInt(8.W))
    })

    io.addOut := io.aIn + io.bIn
    io.subOut := io.aIn - io.bIn
    io.mulOut := io.aIn * io.bIn
    io.divOut := io.aIn / io.bIn
    io.negOut := -io.aIn
    io.modOut := io.aIn % io.bIn

}

object GenVerilog extends App {
  val s = getVerilogString(new ArithmeticOperation())
  println(s)
}

// following does not produce a Verilog file
// chisel3.stage.ChiselStage.emitVerilog(new Hello())

/**
 * An object extending App to generate the Verilog code.
 */

//- start generate_string
// object HelloString extends App {
//   val s = getVerilogString(new Hello())
//   println(s)
// }

//- start generate
// object Hello extends App {
//   emitVerilog(new Hello())
// }
//- end

//- start generate_options
// object HelloOption extends App {
//   emitVerilog(new Hello(), Array("--target-dir", "generated"))
// }
//- end

