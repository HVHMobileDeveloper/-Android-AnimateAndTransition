package com.example.animationsample.ui.main

import android.os.Build
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Explode
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.example.animationsample.R
import com.example.animationsample.R.layout
import com.example.animationsample.data.Mail
import com.example.animationsample.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.rc_contacts

class MainActivity : AppCompatActivity() {

    private val mailAdapter by lazy {
        MailAdapter { mail, rootView, imageView -> onEmailClicked(mail, rootView, imageView) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            with(window) {
                requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
                sharedElementEnterTransition = Explode()
                sharedElementExitTransition = ChangeBounds()
            }
        }

        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        initComponents()
    }

    private fun initComponents() {
        rc_contacts?.apply {
            adapter = mailAdapter
        }
    }

    private fun onEmailClicked(mail: Mail, root: View, imageView: View) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                Pair(root, getString(R.string.transition_root)),
                Pair(imageView, getString(R.string.transition_image))
            )

            startActivity(DetailActivity.getDetailIntent(this, mail), options.toBundle())
        }
    }
}
