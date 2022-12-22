package com.example.randomnews.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.coredata.domain.News
import com.example.randomnews.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private var _binding:ActivityDetailBinding?=null
    private val binding get() = _binding!!
    private val viewModel:DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding=ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setToolbar()

        val detailTourism = intent.getParcelableExtra<News>(EXTRA_DATA)
        showData(detailTourism)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun showData(data: News?) {
        data?.let {
            Glide.with(this)
                .load(it.imgUrl)
                .into(binding.imgNews)
            binding.tvTitle.text=it.title
            binding.tvDate.text=it.date
            binding.tvContent.text=it.content

            var state=data.isFavorite
            binding.cbFav.isChecked=state
            binding.cbFav.setOnClickListener {
                state=!state
                viewModel.setFavoriteTourism(data,state)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    companion object{
        const val EXTRA_DATA="extra_data"
    }
}