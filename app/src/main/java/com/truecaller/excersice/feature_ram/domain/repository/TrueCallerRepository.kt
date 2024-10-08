package com.truecaller.excersice.feature_ram.domain.repository

import com.truecaller.network.repository.ApiOperation

interface TrueCallerRepository {

    suspend fun fetch15thCharacter(): ApiOperation<String>

    fun fetchEvery15thCharacter(): ApiOperation<List<String>>

    fun fetchWordCount(): ApiOperation<Map<String, Int>>
}