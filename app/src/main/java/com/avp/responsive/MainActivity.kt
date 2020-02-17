package com.avp.responsive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.avp.responsive.features.intro.IntroOneActivity
import com.avp.responsive.features.travelservice.IntergalacticTravelServiceActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClickListener()
    }

    private fun initClickListener() {
        btnTravelService.setOnClickListener {
            startActivity(Intent(this, IntergalacticTravelServiceActivity::class.java))
        }

        btnMoveToDimension.setOnClickListener {
            startActivity(Intent(this, IntroOneActivity::class.java))
        }
    }
}
