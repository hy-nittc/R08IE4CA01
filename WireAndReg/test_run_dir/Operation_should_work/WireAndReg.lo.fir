FIRRTL version 1.2.0
circuit WireAndReg :
  module WireAndReg :
    input clock : Clock
    input reset : UInt<1>
    input io_aIn : UInt<8> @[WireAndReg.scala 4:16]
    output io_wireOut : UInt<8> @[WireAndReg.scala 4:16]
    output io_regOut : UInt<8> @[WireAndReg.scala 4:16]
    output io_regnextOut : UInt<8> @[WireAndReg.scala 4:16]

    reg reg : UInt<8>, clock with :
      reset => (UInt<1>("h0"), reg) @[WireAndReg.scala 12:18]
    reg nextreg : UInt<8>, clock with :
      reset => (UInt<1>("h0"), nextreg) @[WireAndReg.scala 16:27]
    node wire = io_aIn @[WireAndReg.scala 11:20 18:10]
    io_wireOut <= wire @[WireAndReg.scala 21:16]
    io_regOut <= reg @[WireAndReg.scala 22:15]
    io_regnextOut <= nextreg @[WireAndReg.scala 23:19]
    reg <= io_aIn @[WireAndReg.scala 19:9]
    nextreg <= mux(reset, UInt<1>("h0"), io_aIn) @[WireAndReg.scala 16:{27,27,27}]
