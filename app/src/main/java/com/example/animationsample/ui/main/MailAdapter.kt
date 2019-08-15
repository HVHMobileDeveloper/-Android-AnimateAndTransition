package com.example.animationsample.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.animationsample.R
import com.example.animationsample.data.Mail
import com.example.animationsample.data.Picture
import com.example.animationsample.utils.DataGenerator
import kotlinx.android.synthetic.main.item_mail.view.item_mail_author
import kotlinx.android.synthetic.main.item_mail.view.item_mail_avatar
import kotlinx.android.synthetic.main.item_mail.view.item_mail_background
import kotlinx.android.synthetic.main.item_mail.view.item_mail_description
import kotlinx.android.synthetic.main.item_mail.view.item_mail_photo_recyclerview
import kotlinx.android.synthetic.main.item_mail.view.item_mail_title

class MailAdapter(@NonNull private val onItemEmailClicked: (mail: Mail, rootView: View, imageView: View) -> Unit) :
    RecyclerView.Adapter<MailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_mail, parent, false)
    )

    override fun getItemCount(): Int = DataGenerator.MAILS.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(DataGenerator.MAILS[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(mail: Mail) {
            itemView.run {
                item_mail_author.text = mail.author
                item_mail_title.text = mail.title
                item_mail_description.text = mail.description
                setAuthorAvatar(item_mail_avatar, mail.authorAvatar)
                setPictures(item_mail_photo_recyclerview, mail.picture)

                setOnClickListener { onItemEmailClicked(mail, item_mail_background, item_mail_avatar) }
            }
        }

        private fun setAuthorAvatar(imageView: AppCompatImageView, url: String) {
            Glide.with(imageView)
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .error(R.drawable.ic_launcher_background)
                .into(imageView)
        }

        private fun setPictures(rv: RecyclerView, pictures: List<Picture>) {
            if (!pictures.isNullOrEmpty())
                rv.adapter = ImageAdapter(pictures)
        }
    }
}
