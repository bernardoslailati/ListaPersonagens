package com.example.listapersonagens.data.repository

import com.example.listapersonagens.data.remotedatasource.DisneyService
import com.example.listapersonagens.data.remotedatasource.RickyAndMortyService
import com.example.listapersonagens.data.remotedatasource.UserAuthenticator
import com.example.listapersonagens.model.api.DisneyCharactersResult
import com.example.listapersonagens.model.api.RickyAndMortyCharactersResult
import com.example.listapersonagens.model.domain.repository.CharactersListRepository


class CharactersListRepositoryImpl(
    private val userAuthenticator: UserAuthenticator,
    private val rickyAndMortyService: RickyAndMortyService,
    private val disneyService: DisneyService
) : CharactersListRepository {

    override suspend fun getUserLogin(email: String, password: String): Boolean {
        return userAuthenticator.login(email, password)
    }


    override suspend fun getCharactersDisney() : DisneyCharactersResult {
        return disneyService.getCharacters()
    }

    override suspend fun getCharactersRickAndMorty() : RickyAndMortyCharactersResult {
        return rickyAndMortyService.getCharacters()
    }
}