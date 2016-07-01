//**************************************************************************
// RISCV Processor 
//--------------------------------------------------------------------------

package Sodor
{

import Chisel._
import Node._
import Common._

class CoreIo(implicit conf: SodorConfiguration) extends Bundle 
{
  val host = new HTIFIO()
  val imem = new MemPortIo(conf.xprlen)
  val dmem = new MemPortIo(conf.xprlen)
}

class Core(resetSignal: Bool = null)(implicit conf: SodorConfiguration) extends Module(_reset = resetSignal)
{
   val io = new CoreIo()

   val frontend = Module(new FrontEnd())
   val cpath  = Module(new CtlPath())
   val dpath  = Module(new DatPath())

   frontend.io.imem <> io.imem                //connection to actual imem
   frontend.io.cpu <> cpath.io.imem           //frontendcpuio type
   frontend.io.cpu <> dpath.io.imem           //fronedncpuio type

   cpath.io.ctl  <> dpath.io.ctl
   cpath.io.dat  <> dpath.io.dat
   
   
   cpath.io.dmem <> io.dmem
   dpath.io.dmem <> io.dmem
   
   dpath.io.host <> io.host
}

}
