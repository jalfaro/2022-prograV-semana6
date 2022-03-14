package gt.edu.galileo.a2022progravsemana5.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import gt.edu.galileo.a2022progravsemana5.R
import gt.edu.galileo.a2022progravsemana5.databinding.FragmentDetailBinding
import gt.edu.galileo.a2022progravsemana5.model.Personaje

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
        binding.btnIrAWeb.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://rickandmortyapi.com/"));
            startActivity(intent)
        }
        val personaje = arguments?.getParcelable<Personaje>("personaje")
        binding.especiePersonaje.text = personaje?.species
        binding.nombrePersonaje.text = personaje?.name
        binding.sexoPersonaje.text = personaje?.gender
        return binding.root
    }
}