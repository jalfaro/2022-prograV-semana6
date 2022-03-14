package gt.edu.galileo.a2022progravsemana5.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Personaje(
    val id: Int,
    val name: String,
    val species: String,
    val gender: String,
    val image: String): Parcelable
