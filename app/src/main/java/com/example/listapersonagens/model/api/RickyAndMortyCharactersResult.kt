package com.example.listapersonagens.model.api

data class RickyAndMortyCharactersResult(
    val results: List<RickyAndMortyCharacter>
)

data class RickyAndMortyCharacter (
    val name: String,
    val image: String
)
