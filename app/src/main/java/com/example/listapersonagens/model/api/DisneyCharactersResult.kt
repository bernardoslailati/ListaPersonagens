package com.example.listapersonagens.model.api

data class DisneyCharactersResult(
    val data: List<DisneyCharacter>
)

data class DisneyCharacter(
    val name: String,
    val imageUrl: String
)
