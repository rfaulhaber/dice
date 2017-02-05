import com.github.rfaulhaber.dice.Roll

object main {
  def main(args: Array[String]): Unit = {
    val pattern = """([0-9]+)?d([0-9]+)""".r

    if (args.length > 0) {
      val input = args(0)

      val response = input match {
        case pattern(amount, sides) if amount != null => Roll.newRoll(amount.toInt, sides.toInt)
        case pattern(_, sides) => Roll.newRoll(1, sides.toInt)
        case _ => "Invalid input"
      }

      response match {
        case s: String => println(s)
        case r: Roll => println(r.mkString)
      }
    }
  }
}
