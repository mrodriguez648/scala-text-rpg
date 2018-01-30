package main.scala.game

abstract class Creature(val name:String, var maxHP:Int, var curHP:Int,
                        val atk:Int, val armr: Int, var xp:Int)
{
  def isDead: Boolean =
  {
    if(this.curHP <= 0) { true }
    else { false }
  }

  def getXP: Int = { this.xp }
  def getName: String = { this.name }
  def setHP_=(hp:Int): Unit = { this.curHP = hp }
  def getHP: Int = { this.curHP }
  def getMaxHP: Int = { this.maxHP }


  def attack(defender:Creature): Unit

  def specialAtk(defender:Creature): Unit

  def getStatus: String  =
  {
    this.name + " has " + this.curHP.toString + "/" + this.maxHP.toString + " health."
  }
}