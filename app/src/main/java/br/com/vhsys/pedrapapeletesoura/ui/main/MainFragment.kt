package br.com.vhsys.pedrapapeletesoura.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.vhsys.pedrapapeletesoura.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var buttonPaper: Button? = null
    private var buttonRock: Button? = null
    private var buttonScissor: Button? = null

    private var textComputerMove: TextView? = null
    private var textPlayerMove: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonPaper = view.findViewById<Button>(R.id.button_paper)
        buttonRock = view.findViewById<Button>(R.id.button_rock)
        buttonScissor = view.findViewById<Button>(R.id.button_scissor)

        textComputerMove = view.findViewById<TextView>(R.id.text_computer_move)
        textPlayerMove = view.findViewById<TextView>(R.id.text_player_move)

        viewModel.liveDataComputerMove.observe(viewLifecycleOwner) { move ->
            textComputerMove?.text = move
        }

        buttonScissor?.setOnClickListener {
            viewModel.move(MainViewModel.SCISSOR_MOVE)
        }
        buttonPaper?.setOnClickListener {
            viewModel.move(MainViewModel.PAPER_MOVE)

        }
        buttonRock?.setOnClickListener {
            viewModel.move(MainViewModel.ROCK_MOVE)
        }
    }

}