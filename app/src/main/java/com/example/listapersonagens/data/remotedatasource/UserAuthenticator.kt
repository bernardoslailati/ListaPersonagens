package com.example.listapersonagens.data.remotedatasource

interface UserAuthenticator {
    fun login(email: String, password: String): Boolean
}