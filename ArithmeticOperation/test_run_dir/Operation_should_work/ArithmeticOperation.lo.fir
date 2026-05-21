FIRRTL version 1.2.0
circuit ArithmeticOperation :
  module ArithmeticOperation :
    input clock : Clock
    input reset : UInt<1>
    input io_aIn : UInt<8> @[ArithmeticOperation.scala 4:16]
    input io_bIn : UInt<8> @[ArithmeticOperation.scala 4:16]
    output io_addOut : UInt<8> @[ArithmeticOperation.scala 4:16]
    output io_subOut : UInt<8> @[ArithmeticOperation.scala 4:16]
    output io_mulOut : UInt<8> @[ArithmeticOperation.scala 4:16]
    output io_divOut : UInt<8> @[ArithmeticOperation.scala 4:16]
    output io_negOut : UInt<8> @[ArithmeticOperation.scala 4:16]
    output io_modOut : UInt<8> @[ArithmeticOperation.scala 4:16]

    node _io_addOut_T = add(io_aIn, io_bIn) @[ArithmeticOperation.scala 15:25]
    node _io_addOut_T_1 = tail(_io_addOut_T, 1) @[ArithmeticOperation.scala 15:25]
    node _io_subOut_T = sub(io_aIn, io_bIn) @[ArithmeticOperation.scala 16:25]
    node _io_subOut_T_1 = tail(_io_subOut_T, 1) @[ArithmeticOperation.scala 16:25]
    node _io_mulOut_T = mul(io_aIn, io_bIn) @[ArithmeticOperation.scala 17:25]
    node _io_divOut_T = div(io_aIn, io_bIn) @[ArithmeticOperation.scala 18:25]
    node _io_negOut_T = sub(UInt<1>("h0"), io_aIn) @[ArithmeticOperation.scala 19:18]
    node _io_negOut_T_1 = tail(_io_negOut_T, 1) @[ArithmeticOperation.scala 19:18]
    node _io_modOut_T = rem(io_aIn, io_bIn) @[ArithmeticOperation.scala 20:25]
    io_addOut <= _io_addOut_T_1 @[ArithmeticOperation.scala 15:15]
    io_subOut <= _io_subOut_T_1 @[ArithmeticOperation.scala 16:15]
    io_mulOut <= bits(_io_mulOut_T, 7, 0) @[ArithmeticOperation.scala 17:15]
    io_divOut <= _io_divOut_T @[ArithmeticOperation.scala 18:15]
    io_negOut <= _io_negOut_T_1 @[ArithmeticOperation.scala 19:15]
    io_modOut <= _io_modOut_T @[ArithmeticOperation.scala 20:15]
