package com.natlus.skor.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.natlus.skor.R
import com.natlus.skor.databinding.FragmentScoreBinding
import com.natlus.skor.models.GoalScorer

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {
    val HOME_REQUEST_KEY = "home"
    val AWAY_REQUEST_KEY = "away"
    val SCORER_KEY = "scorer"

    lateinit var homeGoalScorerList: ArrayList<GoalScorer>
    lateinit var awayGoalScorerList: ArrayList<GoalScorer>

    private lateinit var binding: FragmentScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeGoalScorerList = arrayListOf()
        awayGoalScorerList = arrayListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false)
        binding.fragment = this
        setFragmentResultListener(SCORER_KEY) { requestKey, bundle ->
            val goalScorer: GoalScorer = bundle.getParcelable("data")!!
            if (bundle.getString("key").equals(HOME_REQUEST_KEY)) {
                homeGoalScorerList.add(goalScorer)
            } else {
                awayGoalScorerList.add(goalScorer)
            }
        }
        binding.buttonAddHome.setOnClickListener {
            onAddHomeClick()
        }
        binding.buttonAddAway.setOnClickListener {
            onAddAwayClick()
        }
        return binding.root
    }

    private fun onAddHomeClick() {
        val action = ScoreFragmentDirections.goalScorerAction(HOME_REQUEST_KEY)
        findNavController().navigate(action)
    }

    private fun onAddAwayClick() {
        val action = ScoreFragmentDirections.goalScorerAction(AWAY_REQUEST_KEY)
        findNavController().navigate(action)
    }

    fun getHomeScorer(): String {
        val result = StringBuilder()
        for (goal in homeGoalScorerList) {
            result.append(goal.name).append(" ").append(goal.minute).append("\" ")
        }
        return result.toString()
    }

    fun getAwayScorer(): String {
        val result = StringBuilder()
        for (goal in awayGoalScorerList) {
            result.append(goal.name).append(" ").append(goal.minute).append("\" ")
        }
        return result.toString()
    }
}