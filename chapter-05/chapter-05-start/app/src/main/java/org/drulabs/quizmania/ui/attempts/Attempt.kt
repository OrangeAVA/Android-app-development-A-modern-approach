package org.drulabs.quizmania.ui.attempts

import java.time.LocalDate
import kotlin.math.roundToInt

data class Attempt(
    val attemptId: Int,
    val quizId: Int,
    val quizName: String,
    val attemptedOn: LocalDate,
    val questionsCount: Int,
    val correctAnswerCount: Int,
    val incorrectAnswerCount: Int,
    val maxScore: Int,
    val userScore: Int
) {
    val attemptedQuestionCount
        get() = (correctAnswerCount + incorrectAnswerCount)
    val scorePercent: Double
        get() = (100.0 * (userScore * 100.0 / maxScore).roundToInt()) / 100.0
    val skipCount
        get() = (questionsCount - correctAnswerCount - incorrectAnswerCount)
}
