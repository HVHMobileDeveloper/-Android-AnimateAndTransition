package com.example.animationsample.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.animationsample.R
import com.example.animationsample.R.layout
import com.example.animationsample.data.Mail
import com.example.animationsample.ui.main.ImageAdapter
import kotlinx.android.synthetic.main.activity_detail.activity_detail_author
import kotlinx.android.synthetic.main.activity_detail.activity_detail_avatar
import kotlinx.android.synthetic.main.activity_detail.activity_detail_description
import kotlinx.android.synthetic.main.activity_detail.activity_detail_rv
import kotlinx.android.synthetic.main.activity_detail.activity_detail_title

class DetailActivity : AppCompatActivity() {

    private val mail by lazy { intent.getParcelableExtra<Mail>(EXTRA_MAIL) ?: Mail() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_detail)
        initComponents()
    }

    private fun initComponents() {
        activity_detail_title?.text = mail.title
        activity_detail_author?.text = mail.author
        activity_detail_description?.text = mail.description

        Glide.with(activity_detail_avatar)
            .load(mail.authorAvatar)
            .apply(RequestOptions.circleCropTransform())
            .error(R.drawable.ic_launcher_background)
            .into(activity_detail_avatar)

        activity_detail_rv?.apply {
            adapter = ImageAdapter(mail.picture)
        }
    }

    companion object {

        private const val EXTRA_MAIL = "EXTRA_MAIL"

        fun getDetailIntent(context: Context, mail: Mail): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            val bundle = Bundle().apply {
                putParcelable(EXTRA_MAIL, mail)
            }
            intent.putExtras(bundle)
            return intent
        }
    }
}
