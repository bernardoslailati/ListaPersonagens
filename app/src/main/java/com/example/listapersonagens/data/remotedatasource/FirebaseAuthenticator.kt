package com.example.listapersonagens.data.remotedatasource

import com.example.listapersonagens.model.domain.User

/**
 * Principio utilizado:
 * Dependency Inversion Principle (DIP), extrai a lógica de autenticar
 * o login do usuário para uma Interface -> UserAuthenticator
 * dessa forma torna mais fácil para que possa ser reutilizado
 * em outras possíveis classes sem depender diretamente da sua implementação.
 * Isso facilita a alteração da implementação sem precisar alterar
 * o código em outros lugares.
 *
 * Antes:
 * object FirebaseAuthenticator : UserAuthenticator {

private val registeredUsers = listOf(
User("teste1@gmail.com", "123"),
User("teste2@gmail.com", "456")
)

override fun login(email: String, password: String): Boolean =
registeredUsers.any { it.email == email && it.password == password }

}
Depois:
 */

class FirebaseAuthenticator : UserAuthenticator {

    private val registeredUsers = listOf(
        User("teste1@gmail.com", "123"), User("teste2@gmail.com", "456")
    )

    override fun login(email: String, password: String): Boolean =
        registeredUsers.any { it.email == email && it.password == password }

}