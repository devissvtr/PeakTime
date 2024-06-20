package com.devissvtr.peaktime.ui.mode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.devissvtr.peaktime.databinding.FragmentModeBinding
import com.google.android.material.switchmaterial.SwitchMaterial

class ModeFragment : Fragment() {

    private var _binding: FragmentModeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentModeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val switchTheme: SwitchMaterial = binding.switchTheme

        val pref = SettingPreferences.getInstance(requireActivity().applicationContext.dataStore)
        val modeViewModel = ViewModelProvider(this, ModelFactory(pref)).get(
            ModeViewModel::class.java
        )

        modeViewModel.getTheme().observe(this) { DarkMode: Boolean ->
            if (DarkMode){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switchTheme.isChecked = true
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switchTheme.isChecked = false
            }
        }

        switchTheme.setOnCheckedChangeListener{_: CompoundButton?, isChecked: Boolean ->
            modeViewModel.saveTheme((isChecked))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}