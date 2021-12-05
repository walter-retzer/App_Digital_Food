package com.wdretzer.digitalfoods

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DadosPratos(val imagem: Int, val nome: String, val descricao: String): Parcelable
