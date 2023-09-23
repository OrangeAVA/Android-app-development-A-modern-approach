package org.drulabs.quizmania.ui.quizzes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.drulabs.quizmania.databinding.FragmentQuizzesBinding

class QuizzesFragment : Fragment() {

    private var _binding: FragmentQuizzesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val quizzesViewModel =
            ViewModelProvider(this).get(QuizzesViewModel::class.java)

        _binding = FragmentQuizzesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        quizzesViewModel.text.observe(viewLifecycleOwner) {
            binding.textQuizzes.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}