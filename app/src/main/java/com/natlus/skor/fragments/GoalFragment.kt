package com.natlus.skor.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.natlus.skor.R
import com.natlus.skor.databinding.FragmentGoalBinding
import com.natlus.skor.models.GoalScorer


/**
 * A simple [Fragment] subclass.
 */
class GoalFragment : Fragment() {
    private lateinit var binding: FragmentGoalBinding
    private lateinit var goalScorer: GoalScorer
    private val args: GoalFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_goal, container, false)
        binding.buttonSave.setOnClickListener {
            val name = binding.inputName.text.toString()
            val minute = binding.inputMinute.text.toString().toInt()
            onSaveClicked(name, minute)
        }
        binding.buttonCancel.setOnClickListener {
            onCancelClicked()
        }
        return binding.root
    }

    fun onSaveClicked(name: String, minute: Int) {
        val requestKey: String = args.requestKey
        goalScorer = GoalScorer(name = name, minute = minute)
        val result: Bundle = bundleOf("data" to goalScorer, "key" to requestKey)
        setFragmentResult("scorer", result = result)
        findNavController().navigateUp()
    }

    fun onCancelClicked() {
        findNavController().navigateUp()
    }
}