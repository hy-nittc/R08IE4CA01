FIRRTL version 1.2.0
circuit FSM :
  module FSM :
    input clock : Clock
    input reset : UInt<1>
    input io_clearIn : UInt<1> @[CALab10.scala 15:14]
    output io_stateOut : UInt<2> @[CALab10.scala 15:14]

    reg stateReg : UInt<2>, clock with :
      reset => (UInt<1>("h0"), stateReg) @[CALab10.scala 20:25]
    node _T = asUInt(UInt<1>("h0")) @[CALab10.scala 27:22]
    node _T_1 = asUInt(stateReg) @[CALab10.scala 27:22]
    node _T_2 = eq(_T, _T_1) @[CALab10.scala 27:22]
    node _T_3 = asUInt(UInt<1>("h1")) @[CALab10.scala 27:22]
    node _T_4 = asUInt(stateReg) @[CALab10.scala 27:22]
    node _T_5 = eq(_T_3, _T_4) @[CALab10.scala 27:22]
    node _T_6 = asUInt(UInt<2>("h2")) @[CALab10.scala 27:22]
    node _T_7 = asUInt(stateReg) @[CALab10.scala 27:22]
    node _T_8 = eq(_T_6, _T_7) @[CALab10.scala 27:22]
    node _GEN_0 = mux(_T_8, UInt<1>("h0"), stateReg) @[CALab10.scala 27:22 35:18 20:25]
    node _GEN_1 = mux(_T_5, UInt<2>("h2"), _GEN_0) @[CALab10.scala 27:22 32:18]
    node _GEN_2 = mux(_T_2, UInt<1>("h1"), _GEN_1) @[CALab10.scala 27:22 29:18]
    node _GEN_3 = mux(io_clearIn, UInt<1>("h0"), _GEN_2) @[CALab10.scala 24:20 25:16]
    io_stateOut <= stateReg @[CALab10.scala 21:15]
    stateReg <= mux(reset, UInt<1>("h0"), _GEN_3) @[CALab10.scala 20:{25,25}]
