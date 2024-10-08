package com.truecaller.excersice.feature_ram.domain.use_case

import com.truecaller.excersice.feature_ram.domain.repository.TrueCallerRepository
import com.truecaller.network.repository.ApiOperation

class Get15ThCharacterUseCase(
    private val repository: TrueCallerRepository
) {
    suspend operator fun invoke(): ApiOperation<String> {
        return repository.fetch15thCharacter()
    }
}
