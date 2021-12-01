package com.example.desafio.android.ionay.silva.characterlist

import Results
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio.android.ionay.silva.databinding.ItemCharacterBinding
import com.example.desafio.android.ionay.silva.util.loadImage

class CharacterListAdapter(
    private val results: List<Results>,
    private val onItemClick: ((result: Results) -> Unit)
) : RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterListAdapter.CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: CharacterListAdapter.CharacterViewHolder, position: Int) {
        holder.bindView(results[position])
    }

    override fun getItemCount(): Int {
        return results.count()
    }


    inner class CharacterViewHolder(
        private val binding: ItemCharacterBinding,
        private val onItemClick: (result: Results) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(result: Results) {

            binding.characterImage.loadImage(result.thumbnail.path, result.thumbnail.extension)
            binding.characterText.text = result.name

            itemView.setOnClickListener {
                onItemClick.invoke(result)
            }
        }
    }

}