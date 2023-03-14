package com.mariana.adv160420017week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }

        var number1 = (0..100).random()
        var number2 = (0..100).random()

        first.text = number1.toString()
        second.text = number2.toString()

        var result = number1 + number2

        btnSubmit.setOnClickListener {
            val playersResult = txtAnswer.text.toString().toInt()

            var playerScore = 0
            if (playersResult == result){
                playerScore = 100
            }
            val action = GameFragmentDirections.actionResultFragment(playerScore.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }
}