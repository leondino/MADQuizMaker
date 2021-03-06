package com.example.quizmake.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.quizmake.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(activity as AppCompatActivity).get(QuizViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCreateQuestion.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_createQuizFragment2)
        }
        btnStartQuiz.setOnClickListener{
            if(viewModel.isQuestionCreated())
                findNavController().navigate(R.id.action_homeFragment_to_quizFragment2)
            else
                Toast.makeText(context, "Please create a question before starting the quiz.", Toast.LENGTH_SHORT).show()
        }
    }

}
