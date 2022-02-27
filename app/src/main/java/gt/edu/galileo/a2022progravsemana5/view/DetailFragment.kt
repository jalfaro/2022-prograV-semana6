package gt.edu.galileo.a2022progravsemana5.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import gt.edu.galileo.a2022progravsemana5.R
import gt.edu.galileo.a2022progravsemana5.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.container.setOnClickListener{
            it.findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }
        binding.especiePersonaje.text = arguments?.getString("especie", "")
        binding.nombrePersonaje.text = arguments?.getString("nombre", "")
        binding.sexoPersonaje.text = arguments?.getString("sexo", "")
        return binding.root
    }
}