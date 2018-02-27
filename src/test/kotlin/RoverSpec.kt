import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object RoverSpec : Spek({
	describe("a rover") {
		val rover = Rover()

		listOf(
			listOf("R", "0:0:E")
		).forEach { test ->
			it("should rotate right (comands: ${test[0]}, expected position: ${test[1]})") {
				rover.execute(test[0]) shouldEqual test[1]
			}
		}
	}
})

class Rover {
	fun execute(commands: String) = "0:0:E"
}