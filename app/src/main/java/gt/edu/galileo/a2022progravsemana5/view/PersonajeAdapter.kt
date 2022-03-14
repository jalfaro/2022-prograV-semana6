package gt.edu.galileo.a2022progravsemana5.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import gt.edu.galileo.a2022progravsemana5.R
import gt.edu.galileo.a2022progravsemana5.databinding.PersonajeItemBinding
import gt.edu.galileo.a2022progravsemana5.model.Personaje

class PersonajeAdapter(val arreglo: ArrayList<Personaje>, val clickPersonaje: PersonajeClick) :
    RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder>() {
    class PersonajeViewHolder(val view: PersonajeItemBinding, val click: PersonajeClick) : RecyclerView.ViewHolder(view.root) {
        fun bind(personaje: Personaje) {
            view.imgPersonaje.cargaImagen(personaje.image)
            view.contenido.setOnClickListener{
                click.onClick(personaje)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val personajeBinding = PersonajeItemBinding.inflate(inflater, parent, false)
        return PersonajeViewHolder(personajeBinding, clickPersonaje)
    }


    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        holder.view.personaje = arreglo[position]
        holder.bind(arreglo[position])
    }

    override fun getItemCount() = arreglo.size

    fun updateData(newList :List<Personaje>) {
        arreglo.clear();
        arreglo.addAll(newList);
        notifyDataSetChanged()
    }
}