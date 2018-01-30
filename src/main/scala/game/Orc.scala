package main.scala.game

import scala.util.Random

class Orc(name:String, maxHP:Int,
          curHP:Int, atk:Int,
          armr:Int, exp:Int) extends Creature (name, maxHP, curHP, atk, armr, exp)
{
  def attack(defender:Creature): Unit =
  {
    if(this.atk > defender.armr)
    {
      println("Attack successful! You lose " + this.atk.toString + " health.")
      defender.setHP_=(defender.getHP - this.atk)
    }
    else
    {
      val defChance = Random.nextDouble() * defender.armr
      val atkChance = Random.nextDouble() * this.atk
      if(atkChance > defChance)
      {
        println("Attack successful! You lose " + this.atk.toString + " health.")
        defender.setHP_=(defender.getHP - this.atk)
      }
      else
      {
        println("Your opponent's attack is futile against you. No damage taken.")
      }
    }
  }
  def specialAtk(defender:Creature): Unit =
  {
    println(this.name + " uses its special attack!")
    println("Your armor is completely ignored.")
    println("Attack successful! You lose " + this.atk.toString + " health.")
    defender.setHP_=(defender.getHP - this.atk)
  }
}
