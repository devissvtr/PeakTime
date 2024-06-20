//package com.devissvtr.peaktime.ui.logout
//
//import android.content.Intent
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.lifecycleScope
//import androidx.navigation.fragment.findNavController
//import com.devissvtr.peaktime.R
//import com.devissvtr.peaktime.databinding.FragmentLogoutBinding
//import com.devissvtr.peaktime.ui.authentication.AuthViewModel
//import com.devissvtr.peaktime.ui.login.LoginActivity
//import kotlinx.coroutines.launch
//
//class LogoutFragment : Fragment() {
//    private var _binding : FragmentLogoutBinding? = null
//    private val binding get() = _binding!!
//    private val authViewModel: AuthViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentLogoutBinding.inflate(inflater, container, false)
//        return binding.root
//
//    }
//    private fun logout() {
//        startActivity(Intent(this, LoginActivity::class.java))
//        finish()
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        lifecycleScope.launch {
//            authViewModel.logout()
//
//            findNavController().navigate(LoginActivity::class.java)
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}