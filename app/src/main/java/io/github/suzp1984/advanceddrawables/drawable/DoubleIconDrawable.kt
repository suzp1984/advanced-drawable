package io.github.suzp1984.advanceddrawables.drawable

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.Rect
import android.graphics.drawable.Drawable


class DoubleIconDrawable(val left : Drawable, val right : Drawable) : Drawable() {

    private var alphaValue : Int = 0xff

    override fun draw(canvas: Canvas?) {
        val rect : Rect = bounds
        val w = if (rect.height() < rect.width() / 2) rect.height() else rect.width() / 2
        val l = rect.left
        val t = rect.top
        val r = rect.right
        val b = rect.bottom

        val leftR = Rect()
        leftR.set(l, t + rect.height() / 2 - w / 2, l + w, t + rect.height() / 2 + w / 2)
        left.bounds = leftR

        val rightR = Rect()
        rightR.set(l + rect.width() - w, t + rect.height() / 2 - w / 2, r, t + rect.height() / 2 + w / 2)
        right.bounds = rightR

        left.draw(canvas)
        right.draw(canvas)
    }

    override fun setAlpha(alpha: Int) {
        left.alpha = alpha
        right.alpha = alpha
        alphaValue = alpha
    }

    override fun getAlpha(): Int {
        return alphaValue
    }

    override fun getOpacity(): Int {
        if (alphaValue < 255) {
            return PixelFormat.TRANSLUCENT
        } else {
            return PixelFormat.OPAQUE
        }
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        left.colorFilter = colorFilter
        right.colorFilter = colorFilter
    }
}