package com.truecaller.excersice.feature_tc.di

import com.truecaller.excersice.feature_tc.data.repository.TrueCallerRepositoryImpl
import com.truecaller.excersice.feature_tc.domain.repository.TrueCallerRepository
import com.truecaller.excersice.feature_tc.domain.use_case.Get15ThCharacterUseCase
import com.truecaller.excersice.feature_tc.domain.use_case.GetEvery15ThCharacterUseCase
import com.truecaller.excersice.feature_tc.domain.use_case.GetWordCounter
import com.truecaller.excersice.feature_tc.domain.use_case.TrueCallerUseCases
import com.truecaller.network.repository.TrueCallerApiClient
import com.truecaller.network.repository.TrueCallerApiClientImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun getKtorClientInstance(): TrueCallerApiClient {
        return TrueCallerApiClientImpl()
    }

    @Provides
    @Singleton
    fun providesUseCases(repository: TrueCallerRepository): TrueCallerUseCases {
        return TrueCallerUseCases(
            get15ThCharacter = Get15ThCharacterUseCase(repository),
            getEvery15ThCharacter = GetEvery15ThCharacterUseCase(repository),
            getWordCounter = GetWordCounter(repository)
        )
    }

    @Provides
    @Singleton
    fun providesRepository(client: TrueCallerApiClient): TrueCallerRepository {
        return TrueCallerRepositoryImpl(client)
    }
}