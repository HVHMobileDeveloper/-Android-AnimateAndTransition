package com.example.animationsample.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Picture(val url: String) : Parcelable
