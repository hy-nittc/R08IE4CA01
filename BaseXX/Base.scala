import chisel3._
import chisel3.util._

class Base extends Module {
  val io = IO(new Bundle {
    val opcode = Input(UInt(4.W))
    val aluOp = Output(UInt(3.W))
  })

  // デフォルト値
  io.aluOp := 0.U
  switch(io.opcode) {
    is("b0000".U) {        // ADD
      io.aluOp := 0.U
    }
    is("b0001".U) {        // SUB
      io.aluOp := 1.U
    }
    is("b0010".U) {        // LOAD
      io.aluOp := 2.U
    }
    is("b0011".U) {        // STORE
      io.aluOp := 3.U
    }
  }
}

object GenVerilog extends App {
  val s = getVerilogString(new Base())
  println(s)
}
