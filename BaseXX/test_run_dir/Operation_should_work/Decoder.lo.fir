FIRRTL version 1.2.0
circuit Decoder :
  module Decoder :
    input clock : Clock
    input reset : UInt<1>
    input io_opcode : UInt<4> @[Decode.scala 5:14]
    output io_aluOp : UInt<3> @[Decode.scala 5:14]
    output io_regWrite : UInt<1> @[Decode.scala 5:14]
    output io_memRead : UInt<1> @[Decode.scala 5:14]
    output io_memWrite : UInt<1> @[Decode.scala 5:14]

    node _T = eq(UInt<1>("h0"), io_opcode) @[Decode.scala 20:21]
    node _T_1 = eq(UInt<1>("h1"), io_opcode) @[Decode.scala 20:21]
    node _T_2 = eq(UInt<2>("h2"), io_opcode) @[Decode.scala 20:21]
    node _T_3 = eq(UInt<2>("h3"), io_opcode) @[Decode.scala 20:21]
    node _GEN_0 = mux(_T_3, UInt<1>("h0"), UInt<1>("h0")) @[Decode.scala 15:12 20:21 38:16]
    node _GEN_1 = mux(_T_3, UInt<1>("h1"), UInt<1>("h0")) @[Decode.scala 18:15 20:21 39:19]
    node _GEN_2 = mux(_T_2, UInt<1>("h0"), _GEN_0) @[Decode.scala 20:21 32:16]
    node _GEN_3 = mux(_T_2, UInt<1>("h1"), UInt<1>("h0")) @[Decode.scala 16:15 20:21 33:19]
    node _GEN_4 = mux(_T_2, UInt<1>("h0"), _GEN_1) @[Decode.scala 18:15 20:21]
    node _GEN_5 = mux(_T_1, UInt<1>("h1"), _GEN_2) @[Decode.scala 20:21 27:16]
    node _GEN_6 = mux(_T_1, UInt<1>("h1"), _GEN_3) @[Decode.scala 20:21 28:19]
    node _GEN_7 = mux(_T_1, UInt<1>("h0"), _GEN_3) @[Decode.scala 17:14 20:21]
    node _GEN_8 = mux(_T_1, UInt<1>("h0"), _GEN_4) @[Decode.scala 18:15 20:21]
    node _GEN_9 = mux(_T, UInt<1>("h0"), _GEN_5) @[Decode.scala 20:21 22:16]
    node _GEN_10 = mux(_T, UInt<1>("h1"), _GEN_6) @[Decode.scala 20:21 23:19]
    node _GEN_11 = mux(_T, UInt<1>("h0"), _GEN_7) @[Decode.scala 17:14 20:21]
    node _GEN_12 = mux(_T, UInt<1>("h0"), _GEN_8) @[Decode.scala 18:15 20:21]
    io_aluOp <= pad(_GEN_9, 3)
    io_regWrite <= _GEN_10
    io_memRead <= _GEN_11
    io_memWrite <= _GEN_12
