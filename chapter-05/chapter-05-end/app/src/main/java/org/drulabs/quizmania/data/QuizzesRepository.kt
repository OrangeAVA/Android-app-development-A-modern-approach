package org.drulabs.quizmania.data

import org.drulabs.quizmania.ui.quizzes.Quiz
import javax.inject.Inject

interface QuizzesRepository {
    suspend fun getQuizzes(): List<Quiz>
}

class QuizzesRepositoryImpl @Inject constructor() : QuizzesRepository {

    private val _quizList = listOf(
        Quiz(1, "Chemistry", false),
        Quiz(2, "Politics", false),
        Quiz(3, "Current Affairs", true),
        Quiz(4, "Technology", false)
    )

    override suspend fun getQuizzes(): List<Quiz> {
        return _quizList
    }

}
