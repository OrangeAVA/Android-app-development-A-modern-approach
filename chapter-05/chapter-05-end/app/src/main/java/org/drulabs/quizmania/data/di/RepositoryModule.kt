package org.drulabs.quizmania.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import org.drulabs.quizmania.data.AttemptsRepository
import org.drulabs.quizmania.data.AttemptsRepositoryImpl
import org.drulabs.quizmania.data.QuizzesRepository
import org.drulabs.quizmania.data.QuizzesRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAttemptsRepository(
        attemptsRepositoryImpl: AttemptsRepositoryImpl
    ): AttemptsRepository

    @Binds
    abstract fun bindQuizzesRepository(
        quizzesRepositoryImpl: QuizzesRepositoryImpl
    ): QuizzesRepository
}
