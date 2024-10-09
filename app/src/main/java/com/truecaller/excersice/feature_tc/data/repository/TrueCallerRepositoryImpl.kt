package com.truecaller.excersice.feature_tc.data.repository

import com.truecaller.excersice.feature_tc.domain.repository.TrueCallerRepository
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

    override suspend fun fetchEvery15thCharacter(): ApiOperation<List<String>> {
        return client.fetchTrueCallerList()
    }

    override suspend fun fetchWordCount(): ApiOperation<Map<String, Int>> {
        return client.fetchWordCount()
    }
}