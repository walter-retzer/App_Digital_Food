package com.wdretzer.digitalfoods
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dados(val imagem: Int, val nome: String): Parcelable
