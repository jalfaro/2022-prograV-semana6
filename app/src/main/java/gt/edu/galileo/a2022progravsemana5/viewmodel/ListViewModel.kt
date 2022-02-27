package gt.edu.galileo.a2022progravsemana5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gt.edu.galileo.a2022progravsemana5.model.Personaje

class ListViewModel: ViewModel() {
    var personajes = MutableLiveData<List<Personaje>>()
    fun refresh() {
        personajes.value = loadData()
    }
    fun loadData(): List<Personaje> = listOf(
            Personaje(1,"Rick Sanchez", "Humano", "Male", ""),
            Personaje(2,"Morty", "Humano", "Male", ""),
            Personaje(3,"Julio", "Humano", "Male", ""),
            Personaje(4, "Amber", "Humano", "Female",""))

}