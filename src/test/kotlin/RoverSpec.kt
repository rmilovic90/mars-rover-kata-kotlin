import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object RoverSpec : Spek({
	describe("a rover") {
		it("should rotate right") {
			val rover = Rover()
			rover.execute() shouldEqual "0:0:E"
		}
	}
})

class Rover {
	fun execute() = "0:0:E"
}