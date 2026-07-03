import chisel3._
import chisel3.util._
import javax.swing.InputMap

class Delay extends Module {
  val io = IO(new Bundle {
    val aIn = Input(UInt(4.W))
    val aOut = Output(UInt(4.W))
    val bOut = Output(UInt(4.W))
  })

  val a = RegNext(io.aIn)
  val b = RegNext(RegNext(io.aIn))

  // val a = Reg(UInt(4.W))
  // a := io.aIn

  io.aOut := a
  io.bOut := b
}

object GenVerilog extends App {
  val s = getVerilogString(new Delay())
  println(s)
}
