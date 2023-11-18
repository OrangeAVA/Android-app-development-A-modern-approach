package org.drulabs.quizmania.ui.quizzes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.recyclerview.widget.RecyclerView
import org.drulabs.quizmania.databinding.ItemQuizBinding

class QuizAdapter(
    var quizzes: List<Quiz>,
    private val onQuizClicked: ((Quiz) -> Unit)? = null
) : RecyclerView.Adapter<QuizVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemQuizBinding.inflate(inflater, parent, false)
        return QuizVH(binding, onQuizClicked)
    }
    override fun getItemCount() = quizzes.size
    override fun onBindViewHolder(holder: QuizVH, position: Int) {
        holder.bind(quizzes[position])
    }
}

class QuizVH(
    private val itemQuizBinding: ItemQuizBinding,
    private val onQuizClickListener: ((Quiz) -> Unit)? = null
) : RecyclerView.ViewHolder(itemQuizBinding.root) {

    fun bind(item: Quiz) {
        itemQuizBinding.tvQuiz.text = item.displayName
        itemQuizBinding.root.setOnClickListener {
            onQuizClickListener?.invoke(item)
        }
        val o: DefaultLifecycleObserver
    }
}