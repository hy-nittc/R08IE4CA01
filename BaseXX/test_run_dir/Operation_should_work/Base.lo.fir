FIRRTL version 1.2.0
circuit Base :
  module Base : @[Base.scala 4:7]
    input clock : Clock @[Base.scala 4:7]
    input reset : UInt<1> @[Base.scala 4:7]
    input io_opcode : UInt<4> @[Base.scala 5:14]
    output io_aluOp : UInt<3> @[Base.scala 5:14]

    node _T = eq(UInt<1>("h0"), io_opcode) @[Base.scala 12:21]
    node _T_1 = eq(UInt<1>("h1"), io_opcode) @[Base.scala 12:21]
    node _T_2 = eq(UInt<2>("h2"), io_opcode) @[Base.scala 12:21]
    node _T_3 = eq(UInt<2>("h3"), io_opcode) @[Base.scala 12:21]
    node _GEN_0 = mux(_T_3, UInt<2>("h3"), UInt<1>("h0")) @[Base.scala 11:12 12:21 23:16]
    node _GEN_1 = mux(_T_2, UInt<2>("h2"), _GEN_0) @[Base.scala 12:21 20:16]
    node _GEN_2 = mux(_T_1, UInt<1>("h1"), _GEN_1) @[Base.scala 12:21 17:16]
    node _GEN_3 = mux(_T, UInt<1>("h0"), _GEN_2) @[Base.scala 12:21 14:16]
    io_aluOp <= pad(_GEN_3, 3)
