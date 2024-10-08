package com.truecaller.excersice.feature_ram.data.repository

import android.util.Log
import com.truecaller.excersice.feature_ram.domain.repository.TrueCallerRepository
import com.truecaller.network.repository.ApiOperation
import com.truecaller.network.repository.TrueCallerApiClient
import javax.inject.Inject

private const val TAG = "TrueCallerRepositoryImp"

class TrueCallerRepositoryImpl @Inject constructor(
    private val client: TrueCallerApiClient
) : TrueCallerRepository {

    override suspend fun fetch15thCharacter(): ApiOperation<String> {
        return client.fetchTrueCallerInformation()
    }

    override fun fetchEvery15thCharacter(): ApiOperation<List<String>> {
        TODO("Not yet implemented")
    }

    override fun fetchWordCount(): ApiOperation<Map<String, Int>> {
        TODO("Not yet implemented")
    }
}