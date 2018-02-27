class Rover {
	private var direction = Direction.NORTH

	fun execute(commands: String): String {
		commands.forEach { command ->
			if (command == 'L') {
				direction = direction.left()!!
			}
			if (command == 'R') {
				direction = direction.right()!!
			}
		}

		return "0:0:${direction.value()}"
	}
}