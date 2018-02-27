enum class Direction(private val value: String, private val left: String, private val right: String) {
	NORTH("N", "W", "E"),
	EAST("E", "N", "S"),
	SOUTH("S", "E", "W"),
	WEST("W", "S", "N");

	fun value() = value

	fun left() = directionToThe(left)

	fun right() = directionToThe(right)

	private fun directionToThe(direction: String) = values().firstOrNull { currentDirection ->
		currentDirection.value == direction
	}
}