import chisel3._

class Counter extends Module {
    val io = IO(new Bundle {
      val countOut = Output(UInt(8.W))
    })

    val count = RegInit(UInt(8.W), 0.U)
    count := count + 1.U
    io.countOut := count

}

object GenVerilog extends App {
  val s = getVerilogString(new Counter())
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