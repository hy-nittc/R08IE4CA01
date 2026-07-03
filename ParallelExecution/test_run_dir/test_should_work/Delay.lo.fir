FIRRTL version 1.2.0
circuit Delay :
  module Delay : @[Delay.scala 5:7]
    input clock : Clock @[Delay.scala 5:7]
    input reset : UInt<1> @[Delay.scala 5:7]
    input io_aIn : UInt<4> @[Delay.scala 6:14]
    output io_aOut : UInt<4> @[Delay.scala 6:14]
    output io_bOut : UInt<4> @[Delay.scala 6:14]

    reg a : UInt<4>, clock with :
      reset => (UInt<1>("h0"), a) @[Delay.scala 12:18]
    reg b_REG : UInt<4>, clock with :
      reset => (UInt<1>("h0"), b_REG) @[Delay.scala 13:26]
    reg b : UInt<4>, clock with :
      reset => (UInt<1>("h0"), b) @[Delay.scala 13:18]
    io_aOut <= a @[Delay.scala 18:11]
    io_bOut <= b @[Delay.scala 19:11]
    a <= io_aIn @[Delay.scala 12:18]
    b_REG <= io_aIn @[Delay.scala 13:26]
    b <= b_REG @[Delay.scala 13:18]
