import chisel3._
import chisel3.util._


// declaration of the states
object State extends ChiselEnum {
  val green, yellow, red = Value
}

  // declaration of state register with initial value green.
import State._


class FSM extends Module {
  val io = IO(new Bundle {
      val clearIn = Input(Bool())
      val stateOut = Output(State())
  })

  val stateReg = RegInit(green)
  io.stateOut := stateReg

  // Next state logic
  when (io.clearIn){
      stateReg := green
  }.otherwise {
    switch(stateReg) {
      is(green){
        stateReg := yellow
      }
      is(yellow){
        stateReg := red
      }
      is(red){
        stateReg := green
      }
    }
  }

}

object GenVerilog extends App {
  val s = getVerilogString(new FSM())
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