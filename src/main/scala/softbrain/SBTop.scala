package softbrain

/**
  * Created by t-vigan on 6/29/2016.
  */
import Chisel._
import Node._
import Common._
import Common.Util._

import SBConstants._


//IO design of softbrain
class SBIO(data_width: Int) extends Bundle{
  val core_cmd = Bits(width = data_width)
}

class SBTop extends Module{
  val io = new SBIO(data_width = 64)
}
