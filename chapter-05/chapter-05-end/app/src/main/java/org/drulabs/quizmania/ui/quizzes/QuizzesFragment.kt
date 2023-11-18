package org.drulabs.quizmania.ui.quizzes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.drulabs.quizmania.databinding.FragmentQuizzesBinding

@AndroidEntryPoint
class QuizzesFragment : Fragment() {

    private var _binding: FragmentQuizzesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val quizzesViewModel: QuizzesViewModel by viewModels()

    private var quizAdapter: QuizAdapter = QuizAdapter(listOf()) {
        Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizzesBinding.inflate(inflater, container, false)

        binding.rvQuizList.adapter = quizAdapter
        quizzesViewModel.quizzes.observe(viewLifecycleOwner) {
            quizAdapter.quizzes = it.toMutableList()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}