package com.example.desafio.android.ionay.silva.comic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.desafio.android.ionay.silva.characterlist.navigation.CharacterNavigationImpl.Extras
import com.example.desafio.android.ionay.silva.databinding.ActivityComicCharacterBinding
import com.example.desafio.android.ionay.silva.util.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComicCharacterActivity : AppCompatActivity() {

    private var id: Int = 0
    private val viewModel: ComicCharacterViewModel by viewModel()
    private lateinit var binding: ActivityComicCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicCharacterBinding.inflate(layoutInflater)
        id = intent.getIntExtra(Extras.CHARACTER_ID.name, 0)
        setContentView(binding.root)
        setupObservables()
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModel.getComicsCharacter(id)
    }

    private fun setupObservables() {
        viewModel.loadingLiveData.observe(this, {
        })

        viewModel.mComicCharactersData.observe(this, Observer {
            binding.progressCircular.visibility = View.GONE
            binding.characterComicPrice.text = it.prices.get(0).price.toString()
            binding.characterImage.loadImage(it.thumbnail.path, it.thumbnail.extension)
            binding.characterDescription.text = it.description
            binding.characterTitle.text = it.title
        })

    }


}