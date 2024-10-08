package com.truecaller.excersice.feature_ram.presentation.components

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.truecaller.excersice.feature_ram.domain.use_case.TruecallerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "TrueCallerViewModel"

@HiltViewModel
class TrueCallerViewModel @Inject constructor(
    private val trueCallerUseCases: TruecallerUseCases
) : ViewModel() {

    fun fetch15thCharacter(
        apiCallback: (String) -> Unit
    ) {
        viewModelScope.launch {
            trueCallerUseCases.get15ThCharacter.invoke().onSuccess {
                apiCallback(it[14].toString())
            }.onFailure {
                Log.e(TAG, "Error in fetching character from TrueCaller API!")
            }
        }
    }
}