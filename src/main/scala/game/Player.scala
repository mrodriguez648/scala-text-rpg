package main.scala.game

import scala.util.Random

class Player (name:String, maxHP:Int,
              curHP:Int, atk:Int,
              armr:Int, exp:Int) extends Creature (name, maxHP, curHP, atk, armr, exp)
{
  def gainXP(expGain:Int): Unit =
  {
    this.xp = this.xp + expGain
  }
  def attack(defender:Creature): Unit =
  {
    if(this.atk > defender.armr)
    {
      println("Attack successful! You deal " + this.atk.toString + " damage.")
      defender.setHP_=(defender.getHP - this.atk)
    }
    else
    {
      val defChance = Random.nextDouble() * defender.armr
      val atkChance = Random.nextDouble() * this.atk
      if(atkChance > defChance)
      {
        println("Attack successful! You deal " + this.atk.toString + " damage.")
        defender.setHP_=(defender.getHP - this.atk)
      }
      else
      {
        println("Your opponent's armor proves resilient. No damage.")
      }
    }
  }

  // Player character has no special attack
  override def specialAtk(defender: Creature): Unit = this.attack(defender)

  def getXPStatus: String =
  {
    this.name + " currently has " + this.xp.toString + " XP."
  }

}
