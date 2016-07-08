package Softbrain
{
  /**
    * Created by t-vigan on 6/29/2016.
    */

import Chisel._
import Node._
import Common._
import Common.Util._

import SBConstants._


//IO design of softbrain
class SbIo(data_width: Int) extends Bundle {

  val core_cmd = new ValidIO(new SbReq(data_width)).flip
  //valid and cmd as input
  val core_stall = new SbRep().asOutput()
}

//req to sb -- needs clone method as cannot use auto-constructor
class SbReq(data_width: Int) extends Bundle {
  val cmd = Bits(width = data_width)

  override def clone = {new SbReq(data_width).asInstanceOf[this.type]}
}

//rep from sb
class SbRep extends Bundle {
  val stall = Bool() //initially false

  override def clone = {new SbRep().asInstanceOf[this.type]}
}

//main class
class SoftbrainTop(implicit conf: SodorConfiguration) extends Module {

  //Top interface from core
  val io = new Bundle {
    val sbio = new SbIo(SB_CMD_WIDTH)
  }

  //Modules declaration

}

}