package com.example.listapersonagens.data.remotedatasource

import com.example.listapersonagens.model.api.DisneyCharactersResult
import retrofit2.http.GET

interface DisneyService {
    @GET("characters")
    suspend fun getCharacters(): DisneyCharactersResult

}