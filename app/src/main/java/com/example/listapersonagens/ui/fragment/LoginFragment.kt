package com.example.listapersonagens.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.listapersonagens.R
import com.example.listapersonagens.databinding.FragmentLoginBinding
import com.example.listapersonagens.ui.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModel()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    /**
     * Principio utilizado:
     * Single Responsibility Principle (SRP), separei a responsabilidade de autenticação para a viewModel,
     * dessa forma ela fica responsável por lidar com a lógica de autenticação e expor para o liveData deixando apto para
     * ser observado pela view, assim insenta completamente a view de lidar diretamente com essa autenticação.
     *
     * Antes:
     *  val isLoggedIn = FirebaseAuthenticator.login(tietEmail.text.toString(), tietPassword.text.toString())
    if (isLoggedIn)
    findNavController().navigate(R.id.action_loginFragment_to_charactersFragment)
    else
    Toast.makeText(requireContext(), "Usuário não encontrado.", Toast.LENGTH_SHORT).show()

     * Depois:
     */
    private fun setupView() {
        with(binding) {
            btnLogin.setOnClickListener {
                loginViewModel.getLogin(tietEmail.text.toString(), tietPassword.text.toString())

            }
        }

        loginViewModel.userLogin.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(R.id.action_loginFragment_to_charactersFragment)
            } else {
                Toast.makeText(requireContext(), "Credenciais inválidas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}