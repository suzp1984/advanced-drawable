package io.github.suzp1984.advanceddrawables

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import io.github.suzp1984.advanceddrawables.drawable.CircleDrawable
import io.github.suzp1984.advanceddrawables.drawable.DoubleIconDrawable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image : ImageView = findViewById(R.id.image) as ImageView

//        val circle : CircleDrawable = CircleDrawable()
//        circle.setText("8")
//        image.setImageDrawable(circle)
        val l = CircleDrawable()
        l.setText("1")

        val r = CircleDrawable()
        r.setText("2")

        val lDouble = DoubleIconDrawable(l, r)

        val lr = CircleDrawable()
        lr.setText("3")

        val rr = CircleDrawable()
        rr.setText("4")
        val rDouble = DoubleIconDrawable(lr, rr)

        val double : DoubleIconDrawable = DoubleIconDrawable(lDouble, rDouble)

        image.setImageDrawable(double)
    }
}
