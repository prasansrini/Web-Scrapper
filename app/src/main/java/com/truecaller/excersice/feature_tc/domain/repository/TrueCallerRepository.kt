package com.truecaller.excersice.feature_tc.domain.repository

import com.truecaller.network.repository.ApiOperation

interface TrueCallerRepository {

    suspend fun fetch15thCharacter(): ApiOperation<String>

    suspend fun fetchEvery15thCharacter(): ApiOperation<List<String>>

    suspend fun fetchWordCount(): ApiOperation<Map<String, Int>>
}