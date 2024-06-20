package com.devissvtr.peaktime.ui.mode

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ModeViewModel(private val pref : SettingPreferences) : ViewModel() {
    fun getTheme(): LiveData<Boolean> {
        return pref.getThemeSetting().asLiveData()
    }

    fun saveTheme(isDarkModeActive : Boolean) {
        viewModelScope.launch {
            pref.saveThemeSetting(isDarkModeActive)
        }
    }
}