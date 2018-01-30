package main.scala.game

import scala.io.StdIn
import scala.util.Random

object Main
{
  def gameLoop(player: Player): Boolean =
  {
    println()
    var endGame = false
    val enemy = new Orc("Orc",12,12,7,6,10)
    println("You encounter an " + enemy.getName + ".")
    while(!enemy.isDead && !player.isDead && !endGame)
    {
      println("What will you do?")
      println("Enter 1 to attack. Enter 2 to check combat status. Enter 0 to quit.")
      val choice = StdIn.readLine()
      if (choice != "0")
      {
        if (choice == "1")
        {
          println("You attempt to attack your enemy.")
          player.attack(enemy)
        }
        else if (choice == "2")
        {
          println("You analyze the current battle situation.")
          println(enemy.getStatus)
          println(player.getStatus)
          println(player.getXPStatus)
        }
        if(!enemy.isDead)
        {
          println(enemy.getName + " attempts to attack you.")
          // Calculate if enemy should perform special attack
          if((enemy.getHP < (enemy.maxHP * .25).toInt) && (Random.nextDouble() > .5))
          {
            enemy.specialAtk(player)
          }
          else
          {
            enemy.attack(player)
          }
        }
      }
      else { endGame = true }
    }
    if(!player.isDead && enemy.isDead)
    {
      println("You have slain " + enemy.getName + "!")
      println("You have gained " + enemy.getXP.toString + " XP.")
      player.gainXP(enemy.getXP)
      println(player.getXPStatus)
      println("Onwards to the next battle!")
      true
    }
    else if(player.isDead)
    {
      println("You have been slain! Please restart the game.")
      false
    }
    else { false }
  }

  def main(args: Array[String]): Unit =
  {
    println("Scala Program for Assignment 1: Text-based RPG.")
    println("Enter a character name or type 0 to quit.")
    val choice = StdIn.readLine()
    if (choice != "0")
    {
      val player = new Player(choice,20,20,10,10,0)
      println("Prepare for your adventure, " + player.getName + ".")
      while(gameLoop(player)) {}
    }
    println("Exiting game.")
  }
}
