package com.example.listapersonagens.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listapersonagens.model.domain.Character
import com.example.listapersonagens.model.domain.repository.CharactersListRepository
import com.example.listapersonagens.model.mapper.toDomain
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val charactersListRepository: CharactersListRepository
) : ViewModel() {

    private val _character: MutableLiveData<List<Character>> = MutableLiveData()
    val character: LiveData<List<Character>> get() = _character

    fun getCharactersDisney() {
        viewModelScope.launch {
            val disneyCharacters = charactersListRepository.getCharactersDisney()
            _character.postValue(
                disneyCharacters.data.toDomain()
            )
        }
    }

    fun getCharactersRickAndMorty() {
        viewModelScope.launch {
            val rickyAndMortyCharacters = charactersListRepository.getCharactersRickAndMorty()
            _character.postValue(
                rickyAndMortyCharacters.results.toDomain()
            )

        }
    }
}