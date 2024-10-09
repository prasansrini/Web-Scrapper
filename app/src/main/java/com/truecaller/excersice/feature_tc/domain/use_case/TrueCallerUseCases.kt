package com.truecaller.excersice.feature_tc.domain.use_case

data class TrueCallerUseCases(
    val get15ThCharacter: Get15ThCharacterUseCase,
    val getEvery15ThCharacter: GetEvery15ThCharacterUseCase,
    val getWordCounter: GetWordCounter
)