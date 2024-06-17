package com.devissvtr.peaktime.ui.mode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory

class ModelFactory(private val pref: SettingPreferences) : NewInstanceFactory()  {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ModeViewModel::class.java)){
            return ModeViewModel(pref) as T
        }
        throw IllegalArgumentException("unknown viewmodel class: " + modelClass.name)
    }


}