package toh.canvasPanel

import javax.swing.*
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics

class Rect (x: Int, y: Int, w: Int, h: Int, c: Color) {
    var X: Int = x
    var Y: Int = y
    var Width: Int = w
    var Height: Int = h
    var Color: Color = c
}

class CanvasPanel : JPanel() {
    val rects: MutableList<Rect> = mutableListOf()

    init {
        preferredSize = Dimension(1200, 400)
        background = Color.WHITE
    }

    fun addRectangle(x: Int, y: Int, w: Int, h: Int, c: Color) {
        rects.add(Rect(x, y, w, h, c))
        repaint()
    }

    fun resetCanvas() {
        rects.clear()
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        for (rect in rects) {
            g.color = rect.Color
            g.fillRect(rect.X, rect.Y, rect.Width, rect.Height)
        }
    }
}