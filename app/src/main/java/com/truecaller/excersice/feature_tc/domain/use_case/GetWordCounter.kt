package com.truecaller.excersice.feature_tc.domain.use_case

import com.truecaller.excersice.feature_tc.domain.repository.TrueCallerRepository
import com.truecaller.network.repository.ApiOperation

class GetWordCounter(
    private val repository: TrueCallerRepository
) {
    suspend operator fun invoke(): ApiOperation<Map<String, Int>> {
        return repository.fetchWordCount()
    }
}
