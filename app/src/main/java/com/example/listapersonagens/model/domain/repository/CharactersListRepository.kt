package com.example.listapersonagens.model.domain.repository

import com.example.listapersonagens.model.api.DisneyCharactersResult
import com.example.listapersonagens.model.api.RickyAndMortyCharactersResult

interface CharactersListRepository {

    suspend fun getUserLogin(email: String, password: String): Boolean
    suspend fun getCharactersDisney(): DisneyCharactersResult
    suspend fun getCharactersRickAndMorty() : RickyAndMortyCharactersResult
}