package org.drulabs.quizmania.ui.attempts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AttemptsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Attempts Fragment"
    }
    val text: LiveData<String> = _text
}