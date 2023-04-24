package com.example.listapersonagens.di

import com.example.listapersonagens.core.BaseUrlDisney
import com.example.listapersonagens.core.BaseUrlRickAndMorty
import com.example.listapersonagens.data.remotedatasource.DisneyService
import com.example.listapersonagens.data.remotedatasource.FirebaseAuthenticator
import com.example.listapersonagens.data.remotedatasource.RickyAndMortyService
import com.example.listapersonagens.data.remotedatasource.UserAuthenticator
import com.example.listapersonagens.data.repository.CharactersListRepositoryImpl
import com.example.listapersonagens.model.domain.repository.CharactersListRepository
import com.example.listapersonagens.ui.viewmodel.CharactersViewModel
import com.example.listapersonagens.ui.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<UserAuthenticator> {
        FirebaseAuthenticator()
    }
    single<RickyAndMortyService> {
        get<Retrofit>(named("rickandmorty")).create(RickyAndMortyService::class.java)
    }
    single<DisneyService> {
        get<Retrofit>(named("disney")).create(DisneyService::class.java)
    }

    single<CharactersListRepository> {
        CharactersListRepositoryImpl(get(), get(), get())
    }
    single<Retrofit>(named("disney")) {
        Retrofit.Builder().baseUrl(BaseUrlDisney).addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<Retrofit>(named("rickandmorty")) {
        Retrofit.Builder().baseUrl(BaseUrlRickAndMorty)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    viewModel{LoginViewModel(get())}
    viewModel{CharactersViewModel(get())}
}