package com.example.listapersonagens.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.listapersonagens.R
import com.example.listapersonagens.databinding.FragmentCharactersBinding
import com.example.listapersonagens.model.domain.CharacterType.DISNEY
import com.example.listapersonagens.model.domain.CharacterType.RICKY_AND_MORTY
import com.example.listapersonagens.model.mapper.toDomain
import com.example.listapersonagens.network.service.DisneyService
import com.example.listapersonagens.network.service.RickyAndMortyService
import com.example.listapersonagens.ui.utils.adapter.CharactersAdapter
import com.example.listapersonagens.ui.utils.extension.gone
import com.example.listapersonagens.ui.utils.extension.visible
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CharactersFragment : Fragment() {
    
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!
    
    private val retrofitDisney: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.disneyapi.dev/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val disneyService: DisneyService = retrofitDisney.create(DisneyService::class.java)
    
    private val retrofitRickyAndMorty: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val rickyAndMortyService: RickyAndMortyService =
        retrofitRickyAndMorty.create(RickyAndMortyService::class.java)
    
    private val charactersAdapter = CharactersAdapter()
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }
    
    private fun setupView() {
        with(binding) {
            rvCharacters.adapter = charactersAdapter
            
            rgCharacterType.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbCharacterTypeDisney -> {
                        CoroutineScope(Dispatchers.IO).launch(Dispatchers.Main) {
                            pbLoadingCharacters.visible()
                            tvCharactersTypeTitle.text = DISNEY.title
                            llCharactersTypeHeader.background = AppCompatResources.getDrawable(
                                requireContext(),
                                DISNEY.colorRes
                            )
                            Glide.with(binding.root)
                                .load(DISNEY.imageUrl)
                                .error(R.drawable.ic_launcher_background)
                                .into(ivCharactersTypeImage)
                            
                            val disneyCharacters = disneyService.getCharacters()
                            charactersAdapter.submitList(disneyCharacters.data.toDomain())
                            pbLoadingCharacters.gone()
                        }
                    }
                    R.id.rbCharacterTypeRickyAndMorty -> {
                        CoroutineScope(Dispatchers.IO).launch(Dispatchers.Main) {
                            pbLoadingCharacters.visible()
                            tvCharactersTypeTitle.text = RICKY_AND_MORTY.title
                            llCharactersTypeHeader.background = AppCompatResources.getDrawable(
                                requireContext(),
                                RICKY_AND_MORTY.colorRes
                            )
                            Glide.with(binding.root)
                                .load(RICKY_AND_MORTY.imageUrl)
                                .error(R.drawable.ic_launcher_background)
                                .into(ivCharactersTypeImage)
                            
                            val rickyAndMortyCharacters = rickyAndMortyService.getCharacters()
                            charactersAdapter.submitList(
                                rickyAndMortyCharacters.results.toDomain()
                            )
                            pbLoadingCharacters.gone()
                        }
                    }
                }
            }
        }
    }
}
