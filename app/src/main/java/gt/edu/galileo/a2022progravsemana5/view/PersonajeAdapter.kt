package gt.edu.galileo.a2022progravsemana5.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import gt.edu.galileo.a2022progravsemana5.R
import gt.edu.galileo.a2022progravsemana5.model.Personaje

class PersonajeAdapter(val arreglo: ArrayList<Personaje>, val clickPersonaje: PersonajeClick) :
    RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder>() {
    class PersonajeViewHolder(val view: View, val click: PersonajeClick) : RecyclerView.ViewHolder(view) {
        val id = view.findViewById<TextView>(R.id.txt_id)
        val nombre = view.findViewById<TextView>(R.id.txt_nombre)
        val especie = view.findViewById<TextView>(R.id.txt_especie)
        val contenido = view.findViewById<LinearLayout>(R.id.contenido)
        fun bind(personaje: Personaje) {
            nombre.text = personaje.name
            especie.text = personaje.species
            id.text = personaje.id.toString()
            contenido.setOnClickListener{
                click.onClick(personaje)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PersonajeViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.personaje_item, parent, false),
        clickPersonaje
    )


    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        holder.bind(arreglo[position])
    }

    override fun getItemCount() = arreglo.size

    fun updateData(newList :List<Personaje>) {
        arreglo.clear();
        arreglo.addAll(newList);
        notifyDataSetChanged()
    }
}