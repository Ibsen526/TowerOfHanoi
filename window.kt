package toh.window

import toh.canvasPanel.CanvasPanel

import javax.swing.JFrame
import java.awt.Color

class Window(title: String) : JFrame() {
    var canvasPanel: CanvasPanel = CanvasPanel()

    init {
        setTitle(title)

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(1200, 400)
        setLocationRelativeTo(null)

        add(canvasPanel)
        pack()
    }

    fun addRectangle(x: Int, y: Int, w: Int, h: Int, c: Color) {
        canvasPanel.addRectangle(x, y, w, h, c)
    }

    fun resetCanvas() {
        canvasPanel.resetCanvas()
    }
}