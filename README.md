# IE4CA
The Computer Architecture class conducted in the Department of Computer Science and Electronic Engineering, National Institute of Technology , Tokuyama College. 

## Learning Objectives
Understanding

- Hardware description language
- Fundamentals of RTL design
- Basics of computer architecture


## Prerequisites

- Homebrew
- OpenJDK
- SBT
- Surfer
- Verilator


## Install

### Homebrew

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

echo >> /Users/hideakiyanagisawa/.zprofile
echo 'eval "$(/opt/homebrew/bin/brew shellenv zsh)"' >> /Users/hideakiyanagisawa/.zprofile
eval "$(/opt/homebrew/bin/brew shellenv zsh)"
```

### OpenJDK

```bash
brew install openjdk
sudo ln -sfn /opt/homebrew/opt/openjdk/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk
echo 'export PATH="/opt/homebrew/opt/openjdk/bin:$PATH"' >> ~/.zshrc
echo 'export CPPFLAGS="-I/opt/homebrew/opt/openjdk/include"' >> ~/.zshrc
```

### SBT

```bash
brew install sbt  
```

### Surfer

```bash
brew install surfer  
```

### Verilator

```bash
brew install verilator  
```

### Rosetta

```bash
sudo softwareupdate --install-rosetta
```

## Optional

### Lima

```bash
brew install lima  
cd workingdirectory    
git clone https://github.com/hy-nittc/IE4CA.git  
brew install lima  
lima start chisel.yaml  
limactl list  
limactl shell chisel  
```


## Digital Circuit Design

## Hardware Description Language

Chisel. Hardware Construction Language.


## Project Structure

```bash
.
├── build.sbt
└── src
    ├── main
    │   └── scala
    │       └── Main.scala
    └── test
        └── scala
            └── MainTest.scala
```

### build.sbt

chisel 6.5.0

```scala
scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  // "-Xfatal-warnings",
  "-language:reflectiveCalls",
)

scalaVersion := "2.13.14"
val chiselVersion = "6.5.0"
addCompilerPlugin("org.chipsalliance" % "chisel-plugin" % chiselVersion cross CrossVersion.full)
libraryDependencies += "org.chipsalliance" %% "chisel" % chiselVersion
libraryDependencies += "edu.berkeley.cs" %% "chiseltest" % "6.0.0"
libraryDependencies += "edu.berkeley.cs" % "ip-contributions" % "0.5.1"
```

3.6.1


```scala
scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  // "-Xfatal-warnings",
  "-language:reflectiveCalls",
)

scalaVersion := "2.13.14"
val chiselVersion = "3.6.1"
addCompilerPlugin("edu.berkeley.cs" %% "chisel3-plugin" % chiselVersion cross CrossVersion.full)
libraryDependencies += "edu.berkeley.cs" %% "chisel3" % chiselVersion
libraryDependencies += "edu.berkeley.cs" %% "chiseltest" % "0.6.2"
```

### And.scala

Hardware Description.

```scala
import chisel3._

class And extends Module {
    val io = IO(new Bundle {
        val aIn = Input(UInt(1.W))
        val bIn = Input(UInt(1.W))
        val andOut = Output(UInt(1.W))
    })

    io.andOut := io.aIn & io.bIn
}

object GenVerilog extends App {
  val s = getVerilogString(new And())
  println(s)
}

// generate .v verilog file
// object GenVerilog extends App {
//   emitVerilog(new And(), Array("--target-dir", "generated"))
// }
```

### AndTest.scala

Test Bench Code.

```scala
import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class WaveTest extends AnyFlatSpec with ChiselScalatestTester {
  "WaveForm" should "work" in {
    test(new And).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
//    test(new And) { dut =>
            println("Start test")
            
            dut.io.aIn.poke(false.B)
            dut.io.bIn.poke(false.B)
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"and${dut.io.andOut.peek()},")

            dut.io.aIn.poke(false.B)
            dut.io.bIn.poke(true.B)
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"and${dut.io.andOut.peek()},")

            dut.io.aIn.poke(true.B)
            dut.io.bIn.poke(false.B)
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"and${dut.io.andOut.peek()},")

            dut.io.aIn.poke(true.B)
            dut.io.bIn.poke(true.B)
            println(s"a=${dut.io.aIn.peek()},b=${dut.io.bIn.peek()}," +
              s"and${dut.io.andOut.peek()},")
    }
  }
}

```


### Verilog HDL Generation

```bash
sbt run
```

### Simulation

```bash
sbt test
```

### Wave Form

```bash
surfer &
```

## Submission
[GitHub Classroom](https://classroom.github.com)


## References

