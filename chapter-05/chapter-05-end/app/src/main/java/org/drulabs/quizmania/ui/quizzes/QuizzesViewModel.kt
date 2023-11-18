package org.drulabs.quizmania.ui.quizzes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.drulabs.quizmania.data.QuizzesRepository
import javax.inject.Inject

@HiltViewModel
class QuizzesViewModel @Inject constructor(
    private val quizzesRepository: QuizzesRepository
) : ViewModel() {

    private val _quizzes = MutableLiveData<List<Quiz>>()

    val quizzes: LiveData<List<Quiz>> = _quizzes


    init {
        viewModelScope.launch {
            if (isActive) {
                _quizzes.value = quizzesRepository.getQuizzes()
            }
        }
    }
}