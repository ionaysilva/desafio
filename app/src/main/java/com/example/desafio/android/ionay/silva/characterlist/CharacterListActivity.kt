package com.example.desafio.android.ionay.silva.characterlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio.android.ionay.silva.R
import com.example.desafio.android.ionay.silva.databinding.CharactherListBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListActivity : AppCompatActivity() {

    private val viewModel: CharacterListViewModel by viewModel()
    private lateinit var binding: CharactherListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CharactherListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObservables()
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModel.getCharacters()
    }

    private fun setupObservables() {
        viewModel.loadingLiveData.observe(this, Observer {
            showLoading()
        })
        viewModel.mCharactersData.observe(this, Observer {
            stopLoading()
            it.data.results.let {
                it
                binding.charactersRecyclerview.setHasFixedSize(true)
                val characterListAdapter = CharacterListAdapter(
                    it,
                    onItemClick = {
                        viewModel.openDetailCharacter(this, it)
                    }
                )
                binding.charactersRecyclerview.adapter = characterListAdapter
                binding.charactersRecyclerview.layoutManager = LinearLayoutManager(this)
            }

        })

        viewModel.errorLiveData.observe(this, {
            showError()
        })
    }

    private fun showLoading() {
        binding.myScreen.visibility = View.GONE
        binding.myProgress.visibility = View.VISIBLE
    }

    private fun stopLoading(){
        binding.myScreen.visibility = View.VISIBLE
        binding.myProgress.visibility = View.GONE
    }

    private fun showError(){
        Snackbar.make(binding.root, R.string.error_message, Snackbar.LENGTH_INDEFINITE)
            .setAction(R.string.try_again) { viewModel.getCharacters() }
            .show()
    }


}