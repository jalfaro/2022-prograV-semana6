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
        Personaje(1,"Rick Sanchez", "Humano", "Male", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
        Personaje(2,"Morty Smith", "Humano", "Male", "https://rickandmortyapi.com/api/character/avatar/2.jpeg"),
        Personaje(5,"Jerry Smith", "Humano", "Male", "https://rickandmortyapi.com/api/character/avatar/5.jpeg"),
        Personaje(4, "Summer Smith", "Humano", "Female","https://rickandmortyapi.com/api/character/avatar/3.jpeg"))
}