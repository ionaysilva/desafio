package com.example.desafio.android.ionay.silva.characterdetail

import Results
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio.android.ionay.silva.characterlist.navigation.CharacterNavigationImpl
import com.example.desafio.android.ionay.silva.databinding.ActivityDetailCharacterBinding
import com.example.desafio.android.ionay.silva.util.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailActivity : AppCompatActivity() {

    private val viewModel: CharacterDetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailCharacterBinding
    private var result: Results? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        result = intent.getParcelableExtra(CharacterNavigationImpl.Extras.CHARACTER.name)
        setupView()
    }

    private fun setupView() {
        result?.let{ result ->
            binding.characterImage.loadImage(result.thumbnail.path, result.thumbnail.extension)
            binding.characterTitle.text = result.name
            binding.characterDescription.text = result.description

            binding.goToComic.setOnClickListener {
                viewModel.openComicActivity(this, result.id)
            }
        }

    }
}