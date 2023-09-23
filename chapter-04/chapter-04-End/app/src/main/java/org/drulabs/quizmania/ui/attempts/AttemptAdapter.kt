package org.drulabs.quizmania.ui.attempts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import org.drulabs.quizmania.R
import org.drulabs.quizmania.databinding.ItemAttemptBinding
import org.drulabs.quizmania.databinding.ItemAttemptTintBinding

class AttemptAdapter(
    var attempts: MutableList<Attempt>
) : RecyclerView.Adapter<AttemptVH>() {

    companion object {
        const val TYPE_EVEN = 0
        const val TYPE_ODD = 1
    }

    override fun getItemViewType(position: Int) =
        if (position % 2 == 0) TYPE_EVEN else TYPE_ODD

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttemptVH {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_EVEN -> {
                val binding = ItemAttemptBinding.inflate(inflater, parent, false)
                AttemptRegularVH(binding)
            }

            else -> {
                val binding = ItemAttemptTintBinding.inflate(inflater, parent, false)
                AttemptTintVH(binding)
            }
        }
    }

    override fun getItemCount() = attempts.size

    override fun onBindViewHolder(holder: AttemptVH, position: Int) {
        holder.bind(attempts[position])
    }
}


abstract class AttemptVH(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(attempt: Attempt)
}

class AttemptRegularVH(private val binding: ItemAttemptBinding) : AttemptVH(binding) {

    override fun bind(attempt: Attempt) {
        binding.attemptQuizTitle.text = attempt.quizName
        binding.attemptDate.text =
            binding.root.context.getString(R.string.attempted_on, attempt.attemptedOn)
        val attemptResult = binding.root.context.getString(R.string.attempt_result)
        val attemptResultDisplay = String.format(
            attemptResult,
            attempt.attemptedQuestionCount,
            attempt.questionsCount,
            attempt.correctAnswerCount,
            attempt.skipCount,
            attempt.incorrectAnswerCount
        )
        binding.attemptResult.text = attemptResultDisplay
        val attemptScore = binding.root.context.getString(R.string.attempt_score)
        val attemptScoreDisplay = String.format(
            attemptScore,
            attempt.userScore,
            attempt.maxScore,
            attempt.scorePercent
        )
        binding.attemptScore.text = attemptScoreDisplay
    }
}

class AttemptTintVH(private val binding: ItemAttemptTintBinding) : AttemptVH(binding) {

    override fun bind(attempt: Attempt) {
        binding.attemptQuizTitle.text = attempt.quizName
        binding.attemptDate.text =
            binding.root.context.getString(R.string.attempted_on, attempt.attemptedOn)
        val attemptResult = binding.root.context.getString(R.string.attempt_result)
        val attemptResultDisplay = String.format(
            attemptResult,
            attempt.attemptedQuestionCount,
            attempt.questionsCount,
            attempt.correctAnswerCount,
            attempt.skipCount,
            attempt.incorrectAnswerCount
        )
        binding.attemptResult.text = attemptResultDisplay
        val attemptScore = binding.root.context.getString(R.string.attempt_score)
        val attemptScoreDisplay = String.format(
            attemptScore,
            attempt.userScore,
            attempt.maxScore,
            attempt.scorePercent
        )
        binding.attemptScore.text = attemptScoreDisplay
    }
}