package io.github.suzp1984.advanceddrawables

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import io.github.suzp1984.advanceddrawables.drawable.CircleDrawable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image : ImageView = findViewById(R.id.image) as ImageView

        val circle : CircleDrawable = CircleDrawable()
        circle.setText("8")
        circle.alpha = 255
        image.setImageDrawable(circle)
    }
}
