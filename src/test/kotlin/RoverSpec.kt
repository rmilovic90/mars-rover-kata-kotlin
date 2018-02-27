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
	}
})

class Rover {
	private var direction = "N"

	fun execute(commands: String): String {
		commands.forEach {
			direction = rotateRight()
		}

		return "0:0:$direction"
	}

	private fun rotateRight() = when (direction) {
		"N" -> "E"
		"E" -> "S"
		"S" -> "W"
		else -> "N"
	}
}