package io.github.suzp1984.advanceddrawables.drawable

import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.Log

class CircleDrawable : Drawable() {

    private var backgroundPaint: Paint = Paint()
    private var txtPaint: Paint = Paint()
    private var text: String = ""
    private val TAG : String = "CircleDrawable"

    init {
        backgroundPaint.color = Color.rgb(255, 0, 0)

        txtPaint.typeface = Typeface.DEFAULT
        txtPaint.color = Color.rgb(0, 0, 0)
    }

    override fun draw(canvas: Canvas?) {
        if (canvas == null) {
            return
        }

        val rect : Rect = bounds
        canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2.0f, backgroundPaint)

        txtPaint.textSize = adjustTextSize()

        val txtRect : Rect = Rect()
        txtPaint.getTextBounds(text, 0, text.length, txtRect)
        val txtWidth = txtPaint.measureText(text)
        canvas.drawText(text, rect.exactCenterX() - txtWidth / 2, rect.exactCenterY() + txtRect.height() / 2, txtPaint)
    }

    override fun setAlpha(alpha: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOpacity(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return PixelFormat.UNKNOWN
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun setText(t : String) {
        text = t
    }

    private fun adjustTextSize() : Float {
        val rect = bounds
        val txtRect = Rect()

        val min : Int = if (rect.width() < rect.height()) rect.width() else rect.height()

        var txtSize = rect.width().toFloat()
        Log.e(TAG, "rect width = " + rect.width())

        while (true) {
            txtPaint.textSize = txtSize
            txtPaint.getTextBounds(text, 0, text.length, txtRect)
            val w = txtPaint.measureText(text)

            val maxSize : Float = if (w > txtRect.height()) w else txtRect.height().toFloat()

            Log.e(TAG, "text size = " + txtSize)
            if (maxSize < (min * 8.0f / 10.0f)) {
                break
            }

            txtSize -= 0.5f
        }

        return txtSize
    }
}