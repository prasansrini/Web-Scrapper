package com.truecaller.excersice.feature_tc.domain.use_case

import com.truecaller.excersice.feature_tc.domain.repository.TrueCallerRepository
import com.truecaller.network.repository.ApiOperation

class GetEvery15ThCharacterUseCase(
    private val repository: TrueCallerRepository
) {
    suspend operator fun invoke(): ApiOperation<List<String>> {
        return repository.fetchEvery15thCharacter()
    }
}
