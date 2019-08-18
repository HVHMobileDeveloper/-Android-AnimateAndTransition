package com.example.animationsample.ui.main

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.animationsample.R
import com.example.animationsample.ui.fragment.FirstFragment
import com.example.animationsample.ui.fragment.SecondFragment

class ThreeActivity : AppCompatActivity() {

    private val firstFragment = FirstFragment.newInstance()
    private val secondFragment = SecondFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)
        initComponents()
    }

    private fun initComponents() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_parent, firstFragment)
            .commit()
    }

    private fun startFragment() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val changeTransform = TransitionInflater.from(this).inflateTransition(R.transition.change_image_transform)
            val explodeTransform = TransitionInflater.from(this).inflateTransition(R.transition.explode)

            // Animation khi thoat khoi Fragment 1
            firstFragment.sharedElementReturnTransition = changeTransform
            firstFragment.exitTransition = explodeTransform

            // Animation khi bat Fragment 2
            secondFragment.sharedElementEnterTransition = changeTransform
            secondFragment.enterTransition = explodeTransform

            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_parent, secondFragment)
                .addSharedElement(findViewById(R.id.img_profile), "transition_profile")
                .commit()
        }else{
            // Apply animation for different version
        }
    }
}
