package com.example.listapersonagens.data.remotedatasource

import com.example.listapersonagens.model.api.RickyAndMortyCharactersResult
import retrofit2.http.GET

interface RickyAndMortyService {

    @GET("character")
    suspend fun getCharacters(): RickyAndMortyCharactersResult

}