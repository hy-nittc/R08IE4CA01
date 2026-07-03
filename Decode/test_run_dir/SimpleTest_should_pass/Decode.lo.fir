FIRRTL version 1.2.0
circuit Decode :
  module Decode :
    input clock : Clock
    input reset : UInt<1>
    input io_opcodeIn : UInt<4> @[decode.scala 58:16]
    output io_ctrlSignalsOut : UInt<4> @[decode.scala 58:16]

    node _io_ctrlSignalsOut_T = eq(io_opcodeIn, UInt<1>("h0")) @[decode.scala 64:22]
    node _io_ctrlSignalsOut_T_1 = eq(io_opcodeIn, UInt<4>("h8")) @[decode.scala 65:22]
    node _io_ctrlSignalsOut_T_2 = eq(io_opcodeIn, UInt<4>("hc")) @[decode.scala 66:22]
    node _io_ctrlSignalsOut_T_3 = eq(io_opcodeIn, UInt<6>("h22")) @[decode.scala 67:22]
    node _io_ctrlSignalsOut_T_4 = eq(io_opcodeIn, UInt<6>("h24")) @[decode.scala 68:22]
    node _io_ctrlSignalsOut_T_5 = mux(_io_ctrlSignalsOut_T_4, UInt<3>("h4"), UInt<1>("h0")) @[src/main/scala/chisel3/util/Mux.scala 141:16]
    node _io_ctrlSignalsOut_T_6 = mux(_io_ctrlSignalsOut_T_3, UInt<2>("h3"), _io_ctrlSignalsOut_T_5) @[src/main/scala/chisel3/util/Mux.scala 141:16]
    node _io_ctrlSignalsOut_T_7 = mux(_io_ctrlSignalsOut_T_2, UInt<2>("h2"), _io_ctrlSignalsOut_T_6) @[src/main/scala/chisel3/util/Mux.scala 141:16]
    node _io_ctrlSignalsOut_T_8 = mux(_io_ctrlSignalsOut_T_1, UInt<2>("h3"), _io_ctrlSignalsOut_T_7) @[src/main/scala/chisel3/util/Mux.scala 141:16]
    node _io_ctrlSignalsOut_T_9 = mux(_io_ctrlSignalsOut_T, UInt<1>("h0"), _io_ctrlSignalsOut_T_8) @[src/main/scala/chisel3/util/Mux.scala 141:16]
    io_ctrlSignalsOut <= pad(_io_ctrlSignalsOut_T_9, 4) @[decode.scala 63:23]
