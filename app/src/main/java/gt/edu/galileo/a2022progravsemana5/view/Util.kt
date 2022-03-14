package gt.edu.galileo.a2022progravsemana5.view

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.cargaImagen (url: String) {
    Glide.with(context).load(url).into(this)
}