package james.learning.colorchanger

import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private var position1 = 0F
    private var position2 = 0F
    private lateinit var view: ConstraintLayout
    private var colorPosition = 0
    private lateinit var text: TextView

    companion object {
        private const val MINIMUM_DISTANCE = 150F
        private const val MINIMUM_NEGATIVE_DISTANCE = -150F
        private val COLOURS = arrayOf(Color.WHITE, Color.DKGRAY, Color.MAGENTA, Color.YELLOW, Color.BLUE, Color.GREEN, Color.RED, Color.CYAN, Color.LTGRAY)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view = findViewById(R.id.mainBackground)
        text = findViewById(R.id.currentPositionNumber)
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
                        colorPosition += 1
                    }
                    if (swipeDiff < MINIMUM_NEGATIVE_DISTANCE) {
                        colorPosition -= 1
                    }
                    if (colorPosition >= COLOURS.size || colorPosition <= 0)
                        colorPosition = 0
                    view.setBackgroundColor(COLOURS[colorPosition])
                    text.text = (colorPosition + 1).toString()
                }
            }
        }
        return super.onTouchEvent(event)
    }
}