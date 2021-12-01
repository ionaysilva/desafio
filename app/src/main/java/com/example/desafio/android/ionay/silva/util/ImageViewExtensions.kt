package com.example.desafio.android.ionay.silva.util

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.desafio.android.ionay.silva.R

fun AppCompatImageView.loadImage(path: String, extension: String) {

    if (!path.isNullOrBlank()) {
        Glide.with(this)
            .load("${path}.${extension}")
            .error(R.drawable.ic_baseline_broken_image_24)
            .into(this)
    } else {
        this.setImageResource(R.drawable.ic_baseline_broken_image_24)
    }



}