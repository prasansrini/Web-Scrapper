package com.truecaller.excersice.feature_ram.presentation.components

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.truecaller.excersice.feature_ram.domain.use_case.TrueCallerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "TrueCallerViewModel"

@HiltViewModel
class TrueCallerViewModel @Inject constructor(
    private val trueCallerUseCases: TrueCallerUseCases
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

    fun fetchEvery15thCharacter(
        apiCallback: (List<String>) -> Unit
    ) {
        viewModelScope.launch {
            trueCallerUseCases.getEvery15ThCharacter.invoke().onSuccess {
                val resultList: List<String> =
                    it.filterIndexed { index, _ -> (index + 1) % 15 == 0 }
                apiCallback(resultList)
            }.onFailure {
                Log.e(TAG, "Error in fetching character from TrueCaller API!")
            }
        }
    }

    fun fetchWordCount(
        apiCallback: (Map<String, Int>) -> Unit
    ) {
        viewModelScope.launch {
            trueCallerUseCases.getWordCounter.invoke().onSuccess {
                apiCallback(it)
            }.onFailure {
                Log.e(TAG, "Error in fetching character from TrueCaller API!")
            }
        }
    }
}