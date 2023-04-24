package com.example.listapersonagens.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listapersonagens.model.domain.repository.CharactersListRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val charactersListRepository: CharactersListRepository) : ViewModel() {

    private val _userLogin: MutableLiveData<Boolean> = MutableLiveData()
    val userLogin: LiveData<Boolean> get() = _userLogin

    fun getLogin(email: String, password: String) {
        viewModelScope.launch {
            val usersLogin = charactersListRepository.getUserLogin(email, password)
            _userLogin.postValue(usersLogin)
        }
    }
}