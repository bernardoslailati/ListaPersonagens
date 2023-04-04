package com.example.listapersonagens.model.mapper

import com.example.listapersonagens.model.domain.Character
import com.example.listapersonagens.model.api.DisneyCharacter
import com.example.listapersonagens.model.api.RickyAndMortyCharacter

@JvmName("toDisneyDomain")
fun List<DisneyCharacter>.toDomain(): List<Character> {
    return this.map {
        Character(
            name = it.name,
            imageUrl = it.imageUrl
        )
    }
}

@JvmName("toRickyAndMortyDomain")
fun List<RickyAndMortyCharacter>.toDomain(): List<Character> {
    return this.map {
        Character(
            name = it.name,
            imageUrl = it.image
        )
    }
}