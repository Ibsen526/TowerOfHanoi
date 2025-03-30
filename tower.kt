package toh.tower

import toh.window.Window

import java.awt.Color

class Tower(val towerHeight: Int, val maxTowerHeight: Int, val index: Int, val color: Color) {
	val tiles: ArrayDeque<Int> = ArrayDeque<Int>()
	val baseWidth: Int = 50
	val baseHeight: Int = 50
	
	init {
        for (i in towerHeight downTo 1) {
			tiles.addFirst(i)
		}
    }
	
	fun move(t: Tower) {
		if (tiles.size > 0) {
			val topTile = tiles.first()
			t.tiles.addFirst(topTile)
			tiles.removeFirst()
		}
	}
	
	fun display(window: Window, screenWidth: Int) {
		val nTiles = tiles.size
		for (i in tiles.indices) {
			val tileWidth = baseWidth * tiles[i]
			window.addRectangle(screenWidth / 4 * index - tileWidth / 2, 60 * maxTowerHeight - (20 + (nTiles - i) * 55), 
				tileWidth, baseHeight, color)
		}
	}
}