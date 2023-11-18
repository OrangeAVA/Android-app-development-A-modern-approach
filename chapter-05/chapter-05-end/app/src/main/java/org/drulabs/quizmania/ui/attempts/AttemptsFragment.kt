package org.drulabs.quizmania.ui.attempts

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.drulabs.quizmania.MainActivity
import org.drulabs.quizmania.R
import org.drulabs.quizmania.databinding.FragmentAttemptsBinding

@AndroidEntryPoint
class AttemptsFragment : Fragment() {

    private var _binding: FragmentAttemptsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val attemptsAdapter = AttemptAdapter(mutableListOf())

    private val attemptsViewModel: AttemptsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAttemptsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.rvAttemptList.adapter = attemptsAdapter
        attemptsViewModel.attempts.observe(viewLifecycleOwner) {
            attemptsAdapter.attempts = it.toMutableList()
        }

        (activity as? MainActivity?)?.supportActionBar?.title =
            getString(R.string.my_attempts)

        binding.btnSortDate.setOnClickListener {
            attemptsAdapter.attempts.sortBy { it.attemptedOn }
            attemptsAdapter.notifyDataSetChanged()
        }
        binding.btnSortScore.setOnClickListener {
            attemptsAdapter.attempts.sortBy { it.scorePercent }
            attemptsAdapter.notifyDataSetChanged()
        }
        binding.btnSortTitle.setOnClickListener {
            attemptsAdapter.attempts.sortBy { it.quizName }
            attemptsAdapter.notifyDataSetChanged()
        }

        return root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSortDate.setOnClickListener {
            attemptsAdapter.attempts.sortByDescending { it.attemptedOn }
            attemptsAdapter.notifyDataSetChanged()
        }
        binding.btnSortScore.setOnClickListener {
            attemptsAdapter.attempts.sortByDescending { it.scorePercent }
            attemptsAdapter.notifyDataSetChanged()
        }
        binding.btnSortTitle.setOnClickListener {
            attemptsAdapter.attempts.sortBy { it.quizName }
            attemptsAdapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}