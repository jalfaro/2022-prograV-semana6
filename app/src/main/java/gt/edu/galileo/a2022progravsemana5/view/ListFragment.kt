package gt.edu.galileo.a2022progravsemana5.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import gt.edu.galileo.a2022progravsemana5.R
import gt.edu.galileo.a2022progravsemana5.databinding.FragmentListBinding
import gt.edu.galileo.a2022progravsemana5.model.Personaje
import gt.edu.galileo.a2022progravsemana5.viewmodel.ListViewModel


class ListFragment : Fragment(), PersonajeClick {
    private lateinit var binding: FragmentListBinding
    private lateinit var model: ListViewModel
    val adapter = PersonajeAdapter(arrayListOf(), this);
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        model = ViewModelProvider(this).get(ListViewModel::class.java)
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.listado.layoutManager = LinearLayoutManager(context)
        binding.listado.adapter = adapter
        model.personajes.observe(viewLifecycleOwner,{
            adapter.updateData(it)
            if (binding.swipeLayout.isRefreshing) {
                binding.swipeLayout.isRefreshing = false
            }
        } )
        binding.swipeLayout.setOnRefreshListener {
            model.refresh()
        }
        model.refresh();
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onClick(personaje: Personaje) {
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(personaje)
        binding.root.findNavController().navigate(action);
    }
}