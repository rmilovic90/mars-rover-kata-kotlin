import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object RoverSpec : Spek({
	describe("a rover") {
		lateinit var rover: Rover

		beforeEachTest {
			rover = Rover()
		}

		listOf(
			listOf("R", "0:0:E"),
			listOf("RR", "0:0:S"),
			listOf("RRR", "0:0:W"),
			listOf("RRRR", "0:0:N")
		).forEach { test ->
			it("should rotate right (comands: ${test[0]}, expected position: ${test[1]})") {
				rover.execute(test[0]) shouldEqual test[1]
			}
		}

		listOf(
			listOf("L", "0:0:W"),
			listOf("LL", "0:0:S"),
			listOf("LLL", "0:0:E"),
			listOf("LLLL", "0:0:N")
		).forEach { test ->
			it("should rotate left (comands: ${test[0]}, expected position: ${test[1]})") {
				rover.execute(test[0]) shouldEqual test[1]
			}
		}
	}
})

class Rover {
	private var direction = "N"
	private var eDirection = Direction.NORTH

	fun execute(commands: String): String {
		commands.forEach {
			if (it == 'L') {
				direction = rotateLeft()
			}
			if (it == 'R') {
				eDirection = eDirection.right()!!
				direction = eDirection.value()
			}
		}

		return "0:0:$direction"
	}

	private fun rotateLeft() = when (direction) {
		"N" -> "W"
		"W" -> "S"
		"S" -> "E"
		else -> "N"
	}
}

enum class Direction(private val value: String, private val left: String, private val right: String) {
	NORTH("N", "W", "E"),
	EAST("E", "N", "S"),
	SOUTH("S", "E", "W"),
	WEST("W", "S", "N");

	fun value() = value

	fun right() = values().firstOrNull { direction ->
		direction.value == this.right
	}
}