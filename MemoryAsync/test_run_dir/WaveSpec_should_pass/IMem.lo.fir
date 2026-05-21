FIRRTL version 1.1.0
circuit IMem :
  module IMem :
    input clock : Clock
    input reset : UInt<1>
    input io_addrIn : UInt<10>
    output io_instrOut : UInt<16>

    mem mem : @[IMem.scala 10:19]
      data-type => UInt<8>
      depth => 1024
      read-latency => 0
      write-latency => 1
      reader => io_instrOut_MPORT
      read-under-write => undefined
    io_instrOut <= pad(mem.io_instrOut_MPORT.data, 16) @[IMem.scala 13:17]
    mem.io_instrOut_MPORT.addr <= io_addrIn @[IMem.scala 13:23]
    mem.io_instrOut_MPORT.en <= UInt<1>("h1") @[IMem.scala 13:23]
    mem.io_instrOut_MPORT.clk <= clock @[IMem.scala 13:23]
