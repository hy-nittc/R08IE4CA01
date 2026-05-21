import chisel3._
import chisel3.util.experimental.loadMemoryFromFile

class IMem(AddrWidth: UInt=10.U) extends Module{
    val io = IO(new Bundle {
        val addrIn = Input(UInt(10.W))
        val instrOut = Output(UInt(16.W))
    })

    val mem = Mem (Math.pow(2, AddrWidth.litValue.toDouble).toInt , UInt (8.W))
    loadMemoryFromFile(mem, "code.hex.txt")

    io.instrOut := mem(io.addrIn)

}