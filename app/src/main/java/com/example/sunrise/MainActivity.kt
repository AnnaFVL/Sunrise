package com.example.sunrise

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    private var grassCount: Int = 0         // счетчик, сколько раз нажали на траву


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sunImageView: ImageView = findViewById(R.id.sun)
        val sunRiseAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.sun_rise)
        sunImageView.startAnimation(sunRiseAnimation)

        val nightSky: ImageView = findViewById(R.id.sky_night)
        val nightSkyAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.sky_anim)
        nightSky.startAnimation(nightSkyAnimation)

        val nightGrass: ImageView = findViewById(R.id.grass_night)
        val nightGrassAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.grass_anim)
        nightGrass.startAnimation(nightGrassAnimation)

        nightGrass.setOnClickListener{
            //Toast.makeText(this,"Grass", Toast.LENGTH_LONG).show()
            grassCount++
            flowerAnimationShow()
        }

        nightSky.setOnClickListener{
            //Toast.makeText(this,"Sky", Toast.LENGTH_LONG).show()
            skyAnimationShow()
        }
    }

    fun skyAnimationShow() {
        val cloud1: ImageView = findViewById(R.id.cloud1)
        val cloud2: ImageView = findViewById(R.id.cloud2)

        val cloud1Animation: Animation = AnimationUtils.loadAnimation(this, R.anim.cloud_anim)
        val cloud2Animation: Animation = AnimationUtils.loadAnimation(this, R.anim.cloud_anim)

        cloud1.startAnimation(cloud1Animation)

        Timer().schedule(2000) {
            cloud2.startAnimation(cloud2Animation)
        }
    }

    fun flowerAnimationShow() {

        val flower1: ImageView = findViewById(R.id.flower1)
        val flower2: ImageView = findViewById(R.id.flower2)
        val flower3: ImageView = findViewById(R.id.flower3)
        val flower1blue: ImageView = findViewById(R.id.flower1blue)
        val flower2blue: ImageView = findViewById(R.id.flower2blue)
        val flower3blue: ImageView = findViewById(R.id.flower3blue)


        val flower1GrowsAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.flower_anim)
        val flower2GrowsAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.flower_anim)
        val flower3GrowsAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.flower_anim)

        val flower1BlueAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.color_to_blue_anim)
        val flower2BlueAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.color_to_blue_anim)
        val flower3BlueAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.color_to_blue_anim)

        val flower1RedAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.color_to_red_anim)
        val flower2RedAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.color_to_red_anim)
        val flower3RedAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.color_to_red_anim)

        if (grassCount == 1) {
            flower1.startAnimation(flower1GrowsAnimation)
            flower2.startAnimation(flower2GrowsAnimation)
            flower3.startAnimation(flower3GrowsAnimation)

            flower1blue.startAnimation(flower1GrowsAnimation)
            flower2blue.startAnimation(flower1GrowsAnimation)
            flower3blue.startAnimation(flower1GrowsAnimation)
        }
        else if (grassCount % 2 == 0) {

            flower1.startAnimation(flower1BlueAnimation)
            flower2.startAnimation(flower2BlueAnimation)
            flower3.startAnimation(flower3BlueAnimation)
        }
        else {

            flower1.startAnimation(flower1RedAnimation)
            flower2.startAnimation(flower2RedAnimation)
            flower3.startAnimation(flower3RedAnimation)
        }
    }
}

