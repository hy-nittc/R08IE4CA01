import chisel3._

class RegFile extends Module {
      val io = IO(new Bundle {
      val rs1 = Input(UInt(5.W))   // 読み出しレジスタ1
      val rs2 = Input(UInt(5.W))   // 読み出しレジスタ2
      val rd  = Input(UInt(5.W))   // 書き込み先
      val wen = Input(Bool())      // 書き込み有効
      val wd  = Input(UInt(32.W))  // 書き込みデータ
      val rd1 = Output(UInt(32.W)) // 読み出しデータ1
      val rd2 = Output(UInt(32.W)) // 読み出しデータ2
    })

  // 32本の32bitレジスタ
  val regs = RegInit(VecInit(Seq.fill(32)(0.U(32.W))))

  // ===== 書き込み =====
  when(io.wen && io.rd =/= 0.U) {
    regs(io.rd) := io.wd
  }

  // ===== 読み出し =====
  io.rd1 := Mux(io.rs1 === 0.U, 0.U, regs(io.rs1))
  io.rd2 := Mux(io.rs2 === 0.U, 0.U, regs(io.rs2))

}

object GenVerilog extends App {
  val s = getVerilogString(new RegFile())
  println(s)
}

/**
 * An object extending App to generate the Verilog code.
 */
//- start generate_string
// object GenVerilog extends App {
//   val s = getVerilogString(new RegFile())
//   println(s)
// }

//- start generate
// object GenVerilog extends App {
//   emitVerilog(new RegFile())
// }
//- end

//- start generate_options
// object GenVerilog extends App {
//   emitVerilog(new RegFile(), Array("--target-dir", "generated"))
// }
//- end