package james.learning.colorchanger

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    var position1 = 0F
    var position2 = 0F
    private val MINIMUM_DISTANCE = 150F
    private val MINIMUM_NEGATIVE_DISTANCE = -150F
    lateinit var view: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view = findViewById(R.id.mainBackground)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    position1 = event.x
                }
                MotionEvent.ACTION_UP -> {
                    position2 = event.x
                    val swipeDiff = position1 - position2
                    if (swipeDiff > MINIMUM_DISTANCE) {
                        view.setBackgroundColor(Color.GREEN)
                    }
                    if (swipeDiff < MINIMUM_NEGATIVE_DISTANCE) {
                        view.setBackgroundColor(Color.WHITE)
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }
}