package com.example.portalapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Portal (
    var portalTitle: String,
    var portalURL: String
) : Parcelable

//data class Portal (
//    var portalTitle: String,
//    var portalURL: String
//)
