package org.drulabs.quizmania.ui.attempts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date
import java.util.TimeZone

private val _dateFormat = SimpleDateFormat.getDateInstance().apply {
    timeZone = TimeZone.getDefault()
}

class AttemptsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Attempts Fragment"
    }
    val text: LiveData<String> = _text

    private val _attempts = MutableLiveData<List<Attempt>>().apply {
        value = listOf(
            Attempt(
                attemptId = 1,
                quizId = 1,
                quizName = "Trigonometry",
                attemptedOn = LocalDate.parse("2023-12-23")!!,
                questionsCount = 20,
                correctAnswerCount = 15,
                incorrectAnswerCount = 3,
                maxScore = 200,
                userScore = 150
            ),
            Attempt(
                attemptId = 2,
                quizId = 1,
                quizName = "Trigonometry",
                attemptedOn = LocalDate.parse("2023-12-26")!!,
                questionsCount = 20,
                correctAnswerCount = 18,
                incorrectAnswerCount = 2,
                maxScore = 200,
                userScore = 180
            ),
            Attempt(
                attemptId = 3,
                quizId = 5,
                quizName = "Universe",
                attemptedOn = LocalDate.parse("2023-12-25")!!,
                questionsCount = 10,
                correctAnswerCount = 7,
                incorrectAnswerCount = 2,
                maxScore = 100,
                userScore = 70
            ),
            Attempt(
                attemptId = 4,
                quizId = 9,
                quizName = "Science and Technology",
                attemptedOn = LocalDate.parse("2023-12-28")!!,
                questionsCount = 30,
                correctAnswerCount = 22,
                incorrectAnswerCount = 5,
                maxScore = 300,
                userScore = 220
            )
        )
    }

    val attempts: LiveData<List<Attempt>> = _attempts
}