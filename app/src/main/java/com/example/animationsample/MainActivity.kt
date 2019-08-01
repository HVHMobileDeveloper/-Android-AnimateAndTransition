package com.example.animationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var sceneRoot: ViewGroup
    private lateinit var aScene: Scene
    private lateinit var anotherScene: Scene
    private lateinit var transition: Transition
    private var isStart = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
    }

    private fun initComponents() {
        btn_go?.setOnClickListener(this)
        sceneRoot = findViewById(R.id.scene_root)
        aScene = Scene.getSceneForLayout(sceneRoot, R.layout.a_scene, this)
        anotherScene = Scene.getSceneForLayout(sceneRoot, R.layout.another_scene, this)
        transition = Fade(Fade.IN)
        transition.duration = 1000
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_go -> startTransition()
        }
    }

    private fun startTransition() {
        if (isStart) {
            TransitionManager.go(anotherScene, transition)
            isStart = !isStart
        } else {
            TransitionManager.go(aScene, transition)
            isStart = !isStart
        }
    }
}
