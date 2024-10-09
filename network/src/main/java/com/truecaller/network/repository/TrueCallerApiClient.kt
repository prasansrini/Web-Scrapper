package com.truecaller.network.repository

interface TrueCallerApiClient {
    suspend fun fetchTrueCallerInformation(): ApiOperation<String>

    suspend fun fetchTrueCallerList(): ApiOperation<List<String>>

    suspend fun fetchWordCount(): ApiOperation<Map<String, Int>>
}