import chisel3._

class RegisterVec extends Module {
    val io = IO(new Bundle {
        val aIn = Input(UInt(32.W))
        val indexIn = Input(UInt(5.W))
        val regVecOut = Output(UInt(32.W))
    })
  
    val regVec = Reg(Vec(32,UInt(32.W)))

    regVec(io.indexIn) := io.aIn
    io.regVecOut := regVec(io.indexIn)

}

object GenVerilog extends App {
  val s = getVerilogString(new RegisterVec())
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