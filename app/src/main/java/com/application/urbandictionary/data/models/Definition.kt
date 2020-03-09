package com.application.urbandictionary.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Definition(
    val definition: String?,
    val permalink: String?,
    val thumbs_up: Int?,
    val sound_urls: List<String>?,
    val author: String?,
    val word: String?,
    val defid: Int,
    val current_vote: String?,
    val written_on: String?,
    val example: String?,
    val thumbs_down: Int?
) : Parcelable