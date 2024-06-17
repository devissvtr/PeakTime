package com.devissvtr.peaktime.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.devissvtr.peaktime.MainActivity
import com.devissvtr.peaktime.databinding.ContentMainBinding
import com.devissvtr.peaktime.databinding.FragmentHomeBinding
import com.devissvtr.peaktime.ui.history.HistoryActivity
import com.devissvtr.peaktime.ui.note.NoteActivity
import com.devissvtr.peaktime.ui.schedule.ScheduleActivity
import com.devissvtr.peaktime.ui.visualization.VisualizationActivity

//import com.devissvtr.peaktime.databinding.FragmentGalleryBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnSchedule.setOnClickListener {
            val intent = Intent(requireContext(), ScheduleActivity::class.java)
            startActivity(intent)
        }

        binding.btnNotes.setOnClickListener {
            val intent = Intent(requireContext(), NoteActivity::class.java)
            startActivity(intent)
        }

        binding.btnHistory.setOnClickListener {
            val intent = Intent(requireContext(), HistoryActivity::class.java)
            startActivity(intent)
        }

        binding.btnVisualization.setOnClickListener {
            val intent = Intent(requireContext(), VisualizationActivity::class.java)
            startActivity(intent)
        }

//        val textView: TextView = binding.textGallery
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}