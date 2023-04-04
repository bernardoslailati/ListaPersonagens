package com.example.listapersonagens.model.domain

import androidx.annotation.ColorRes
import com.example.listapersonagens.R

enum class CharacterType(
    val title: String,
    val imageUrl: String,
    @ColorRes val colorRes: Int,
) {
    DISNEY(
        title = "Disney",
        imageUrl = "https://icon-library.com/images/disney-icon-png/disney-icon-png-20.jpg",
        colorRes = R.color.red_disney
    ),
    RICKY_AND_MORTY(
        title = "Ricky And Morty",
        imageUrl = "https://logosmarcas.net/wp-content/uploads/2022/01/Rick-And-Morty-Logo.png",
        colorRes = R.color.blue_ricky_and_morty
    )
}