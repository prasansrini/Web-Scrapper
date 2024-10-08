package com.truecaller.network.repository

interface TrueCallerApiClient {
    suspend fun fetchTrueCallerInformation(): ApiOperation<String>
}