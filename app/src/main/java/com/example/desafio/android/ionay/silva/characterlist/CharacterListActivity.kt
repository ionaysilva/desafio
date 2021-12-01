package com.example.desafio.android.ionay.silva.characterlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio.android.ionay.silva.databinding.CharactherListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListActivity : AppCompatActivity() {

    private val viewModel: CharacterListViewModel by viewModel()
    private lateinit var binding: CharactherListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CharactherListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObservables()
    }

    private fun setupObservables() {
        viewModel.mCharactersData.observe(this, Observer {
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
        viewModel.getCharacters()
    }


}