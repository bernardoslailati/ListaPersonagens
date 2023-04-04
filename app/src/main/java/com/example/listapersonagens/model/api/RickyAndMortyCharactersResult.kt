package com.example.listapersonagens.model.api

data class RickyAndMortyCharacters(
    val results: List<RickyAndMortyCharacter>
)

data class RickyAndMortyCharacter (
    val name: String,
    val image: String
)
