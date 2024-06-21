package com.devissvtr.peaktime.ui.visualization

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityVisualizationBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.MPPointF

class VisualizationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVisualizationBinding
    private val taskValues = ArrayList<PieEntry>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVisualizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        dataListing()
    }

    private fun dataListing() {
        taskValues.add(PieEntry(2f, "Completed Tasks"))
        taskValues.add(PieEntry(1f, "In Progress Tasks"))
        setChart()
    }

    private fun setChart() {
        val pieDataSetter: PieDataSet

        if (binding.pieChart.data != null && binding.pieChart.data.dataSetCount > 0) {
            pieDataSetter = binding.pieChart.data.getDataSetByIndex(0) as PieDataSet
            pieDataSetter.values = taskValues
            binding.pieChart.data.notifyDataChanged()
            binding.pieChart.notifyDataSetChanged()
        } else {
            pieDataSetter = PieDataSet(taskValues, "")
            pieDataSetter.setColors(*ColorTemplate.VORDIPLOM_COLORS)
            pieDataSetter.setDrawValues(false)
            pieDataSetter.sliceSpace = 3f
            pieDataSetter.iconsOffset = MPPointF(10f, 10f)
            pieDataSetter.selectionShift = 10f

            val dataSets = ArrayList<IPieDataSet>()
            dataSets.add(pieDataSetter)

            val data = PieData(pieDataSetter)
            binding.pieChart.data = data
            binding.pieChart.invalidate()
            binding.pieChart.description.isEnabled = false

            binding.pieChart.animateY(1400, Easing.EaseInOutQuad)
            binding.pieChart.setEntryLabelColor(Color.BLACK)
            binding.pieChart.holeRadius = 13f

            binding.pieChart.setTransparentCircleColor(Color.BLUE)
            binding.pieChart.setTransparentCircleAlpha(110)
            binding.pieChart.transparentCircleRadius = 17f

            binding.pieChart.isDrawHoleEnabled = false
        }
    }
}