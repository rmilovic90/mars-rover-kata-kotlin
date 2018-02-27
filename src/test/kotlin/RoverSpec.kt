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