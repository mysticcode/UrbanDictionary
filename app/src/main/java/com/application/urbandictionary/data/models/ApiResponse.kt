package com.application.urbandictionary.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiResponse(
    val list: List<Definition>?
) : Parcelable