package toh

import toh.window.Window
import toh.tower.Tower

import java.awt.Color

val START_TOWER_HEIGHT: Int = 5; // Adjust the height of the initial tower
val WAIT_AFTER_MOVE: Long = 300; // How long does the program wait after a move in milliseconds

fun moveTile(window: Window, i: Int, a: Tower, b: Tower, c: Tower) { // Recursively moves all tiles 
	if (i > 0) {
		moveTile(window, i - 1, a, c, b)
		a.move(c) // Moves upmost tile from a to c
		displayTowers(window, a, b, c)
		moveTile(window, i - 1, b, a, c)
	}
}

fun displayTowers(window: Window, a: Tower, b: Tower, c: Tower) {
	window.resetCanvas()
	val windowWidth = window.getSize().width
	a.display(window, windowWidth)
	b.display(window, windowWidth)
	c.display(window, windowWidth)
	Thread.sleep(WAIT_AFTER_MOVE)
}

fun main() {
    val window = Window("Towers of Hanoi")
    window.isVisible = true

	val a: Tower = Tower(START_TOWER_HEIGHT, START_TOWER_HEIGHT, 1, Color.BLUE)
	val b: Tower = Tower(0, START_TOWER_HEIGHT, 2, Color.GREEN)
	val c: Tower = Tower(0, START_TOWER_HEIGHT, 3, Color.RED) // Target tower

	displayTowers(window, a, b, c)
	moveTile(window, START_TOWER_HEIGHT, a, b, c)

	println("Finished")
}