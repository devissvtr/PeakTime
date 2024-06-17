package com.devissvtr.peaktime.ui.language

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.devissvtr.peaktime.databinding.FragmentHomeBinding
import com.devissvtr.peaktime.databinding.FragmentLanguangeBinding

class LanguageFragment : Fragment() {

    private var _binding: FragmentLanguangeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val languageViewModel =
            ViewModelProvider(this).get(LanguageViewModel::class.java)

        _binding = FragmentLanguangeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        languageViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}