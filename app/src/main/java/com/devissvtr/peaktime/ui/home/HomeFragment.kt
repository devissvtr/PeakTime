package com.devissvtr.peaktime.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.FragmentHomeBinding
import com.devissvtr.peaktime.ui.history.HistoryActivity
import com.devissvtr.peaktime.ui.login.LoginActivity
import com.devissvtr.peaktime.ui.note.NoteActivity
import com.devissvtr.peaktime.ui.notification.NotificationActivity
import com.devissvtr.peaktime.ui.schedule.ScheduleActivity
import com.devissvtr.peaktime.ui.visualization.VisualizationActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
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

        binding.btnNotification.setOnClickListener {
            val intent = Intent(requireContext(), NotificationActivity::class.java)
            startActivity(intent)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}