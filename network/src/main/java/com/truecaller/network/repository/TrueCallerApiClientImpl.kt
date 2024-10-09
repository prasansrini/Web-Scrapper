package com.truecaller.network.repository

import android.util.Log
import com.truecaller.network.util.Constants.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get

private const val TAG = "TrueCallerApiClientImpl"

class TrueCallerApiClientImpl : TrueCallerApiClient {
    private val client = HttpClient(OkHttp) {
        defaultRequest { url(BASE_URL) }
    }

    private var characterCache: String? = null

    override suspend fun fetchTrueCallerInformation(): ApiOperation<String> {
        characterCache?.let {
            Log.d(TAG, "Fetching from the cache...")
            return ApiOperation.Success(it)
        }

        return safeApiCall {
            client.get("/blog/life-at-truecaller/life-as-an-android-engineer").body<String>()
                .also { data ->
                    characterCache = data
                }
        }
    }

    override suspend fun fetchTrueCallerList(): ApiOperation<List<String>> {
        characterCache?.let { it ->
            Log.d(TAG, "Fetching from the cache...")
            return ApiOperation.Success(it.splitToSequence("").filter { it.isNotEmpty() }.toList())
        }

        return safeApiCall {
            client.get("/blog/life-at-truecaller/life-as-an-android-engineer").body<String>()
                .splitToSequence("").filter { it.isNotEmpty() }.toList().also { data ->
                    characterCache = data.joinToString(prefix = "", postfix = "", separator = "")
                }
        }
    }

    override suspend fun fetchWordCount(): ApiOperation<Map<String, Int>> {
        characterCache?.let {
            Log.d(TAG, "Fetching from the cache...")

            return ApiOperation.Success(extractResultMap(it))
        }

        return safeApiCall {
            extractResultMap(client.get("/blog/life-at-truecaller/life-as-an-android-engineer")
                .body<String>().also { data ->
                    characterCache = data
                })
        }
    }

    private fun extractResultMap(inputString: String): Map<String, Int> {
        val words = inputString.split(Regex("\\s+"))

        val output = mutableMapOf<String, Int>()

        for (word in words) {
            if (word.isNotBlank()) {
                output[word] = output.getOrDefault(word, 0) + 1
            }
        }

        return output
    }

    private inline fun <T> safeApiCall(apiCall: () -> T): ApiOperation<T> {
        return try {
            ApiOperation.Success(data = apiCall())
        } catch (e: Exception) {
            ApiOperation.Failure(e)
        }
    }
}

sealed interface ApiOperation<T> {
    data class Success<T>(val data: T) : ApiOperation<T>
    data class Failure<T>(val exception: Exception) : ApiOperation<T>

    fun onSuccess(block: (T) -> Unit): ApiOperation<T> {
        if (this is Success) block(data)
        return this
    }

    fun onFailure(block: (Exception) -> Unit): ApiOperation<T> {
        if (this is Failure) block(exception)
        return this
    }
}
