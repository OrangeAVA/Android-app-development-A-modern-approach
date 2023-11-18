package org.drulabs.quizmania.ui.attempts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.drulabs.quizmania.data.AttemptsRepository
import javax.inject.Inject

@HiltViewModel
class AttemptsViewModel @Inject constructor(
    private val attemptsRepository: AttemptsRepository
) : ViewModel() {

    private val _attempts = MutableLiveData<List<Attempt>>()

    init {
        viewModelScope.launch {
            if (isActive) {
                _attempts.value = attemptsRepository.getUserAttempts()
            }
        }
    }

    val attempts: LiveData<List<Attempt>> = _attempts
}
