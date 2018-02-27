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
		).forEach { testData ->
			it("should rotate right (comands: ${testData[0]}, expected position: ${testData[1]})") {
				rover.execute(testData[0]) shouldEqual testData[1]
			}
		}

		listOf(
			listOf("L", "0:0:W"),
			listOf("LL", "0:0:S"),
			listOf("LLL", "0:0:E"),
			listOf("LLLL", "0:0:N")
		).forEach { testData ->
			it("should rotate left (comands: ${testData[0]}, expected position: ${testData[1]})") {
				rover.execute(testData[0]) shouldEqual testData[1]
			}
		}
	}
})

class Rover {
	private var direction = "N"
	private var eDirection = Direction.NORTH

	fun execute(commands: String): String {
		commands.forEach { command ->
			if (command == 'L') {
				eDirection = eDirection.left()!!
				direction = eDirection.value()
			}
			if (command == 'R') {
				eDirection = eDirection.right()!!
				direction = eDirection.value()
			}
		}

		return "0:0:$direction"
	}
}

enum class Direction(private val value: String, private val left: String, private val right: String) {
	NORTH("N", "W", "E"),
	EAST("E", "N", "S"),
	SOUTH("S", "E", "W"),
	WEST("W", "S", "N");

	fun value() = value

	fun left() = values().firstOrNull { direction ->
		direction.value == this.left
	}

	fun right() = values().firstOrNull { direction ->
		direction.value == this.right
	}
}