import chisel3._

class LogicOperation extends Module {
    val io = IO(new Bundle {
        val aIn = Input(UInt(1.W))
        val bIn = Input(UInt(1.W))
        val andOut = Output(UInt(1.W))
        val orOut = Output(UInt(1.W))
        val xorOut = Output(UInt(1.W))
        val notOut = Output(UInt(1.W))
        val nandOut = Output(UInt(1.W))
        val norOut = Output(UInt(1.W))
        val xnorOut = Output(UInt(1.W))
    })

    io.andOut := io.aIn & io.bIn
    io.orOut := io.aIn | io.bIn
    io.xorOut := io.aIn ^ io.bIn
    io.notOut := ~io.aIn
    io.nandOut := ~(io.aIn & io.bIn)
    io.norOut := ~(io.aIn | io.bIn)
    io.xnorOut := ~(io.aIn ^ io.bIn)

}

object GenVerilog extends App {
  val s = getVerilogString(new LogicOperation())
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

