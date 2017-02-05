package com.github.rfaulhaber.dice

import scala.util.Random

case class Roll(each: List[Int]) {
  def sum: Int = this.each.sum

  def max: Int = this.each.max

  def min: Int = this.each.min

  def mkString: String =
    "Sum: " + this.sum +
      "\nRolls: " + (this.each mkString ", ") +
      "\nMin: " + this.min +
      "\nMax: " + this.max
}

object Roll {
  def newRoll(amount: Int, sides: Int): Roll = {
    if (amount == 1) Roll(rand(1, sides) :: Nil)
    else Roll(rand(1, sides) :: newRoll(amount - 1, sides).each)
  }

  private def rand(min: Int, max: Int): Int = {
    min + Random.nextInt((max - min) + 1)
  }
}