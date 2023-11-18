package org.drulabs.quizmania.ui.quizzes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizzesViewModel : ViewModel() {

    private val _quizzes = MutableLiveData<List<Quiz>>().apply {
        value = listOf(
            Quiz(1, "Chemistry", false),
            Quiz(2, "Politics", false),
            Quiz(3, "Current Affairs", true),
            Quiz(4, "Technology", false)
        )
    }

    val quizzes: LiveData<List<Quiz>> = _quizzes
}