package com.truecaller.excersice.feature_ram.domain.use_case

data class TrueCallerUseCases(
    val get15ThCharacter: Get15ThCharacterUseCase,
    val getEvery15ThCharacter: GetEvery15ThCharacterUseCase,
    val getWordCounter: GetWordCounter
)