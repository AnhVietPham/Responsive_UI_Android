package com.avp.responsive.features.travelservice

import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.avp.responsive.R
import kotlinx.android.synthetic.main.activity_intergalactic_travel_service.*

class IntergalacticTravelServiceActivity : AppCompatActivity() {

    private val constraintSetOne = ConstraintSet()
    private val constraintSetTwo = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intergalactic_travel_service)
        constraintSetOne.clone(constraintParent)
        constraintSetTwo.clone(this, R.layout.activity_main)

        departButton.setOnClickListener {
            val layoutparams =  rocketIcon.layoutParams as ConstraintLayout.LayoutParams
            val startAngle = layoutparams.circleAngle
            val endAngle = startAngle + (if (switch1.isChecked) 360 else 180)

            val anim = ValueAnimator.ofFloat(startAngle, endAngle)
            anim.addUpdateListener {
                val animatedValue = it.animatedValue as Float
                val layoutParams = rocketIcon.layoutParams as ConstraintLayout.LayoutParams

                layoutParams.circleAngle = animatedValue
                rocketIcon.layoutParams = layoutParams
                rocketIcon.rotation = (animatedValue % 360 - 270)
            }
            anim.duration = if (switch1.isChecked) 2000 else 1000

            //6
            anim.interpolator = LinearInterpolator() as TimeInterpolator?
            anim.start()
        }
    }
}
