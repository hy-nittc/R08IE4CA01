import chisel3._

class Comparator extends Module {
  val io = IO(new Bundle {
      val aIn = Input(UInt(8.W))
      val bIn = Input(UInt(8.W))
      val eq = Output(UInt(8.W))
      val neq = Output(UInt(8.W))
      val gt = Output(UInt(8.W))
      val gteq = Output(UInt(8.W))
      val lt = Output(UInt(8.W))
      val lteq = Output(UInt(8.W))
      val inv = Output(UInt(8.W))
  })

  io.eq := io.aIn === io.bIn
  io.neq := io.aIn =/= io.bIn
  io.gt := io.aIn > io.bIn
  io.gteq := io.aIn >= io.bIn
  io.lt := io.aIn < io.bIn
  io.lteq := io.aIn <= io.bIn
  io.inv := !(io.aIn === io.bIn)
  
}

object GenVerilog extends App {
  val s = getVerilogString(new Comparator())
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