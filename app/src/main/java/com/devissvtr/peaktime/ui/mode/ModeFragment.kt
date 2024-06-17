package com.devissvtr.peaktime.ui.mode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.devissvtr.peaktime.databinding.FragmentModeBinding
import com.google.android.material.switchmaterial.SwitchMaterial

class ModeFragment : Fragment() {

    private var _binding: FragmentModeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val modeViewModel =
            ViewModelProvider(this)[ModeViewModel::class.java]

        _binding = FragmentModeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val switchTheme: SwitchMaterial = binding.switchTheme
        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switchTheme.isChecked = true
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switchTheme.isChecked = false
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}