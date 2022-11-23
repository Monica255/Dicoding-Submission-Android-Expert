package com.example.favorite.news

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coredata.ui.NewsAdapter
import com.example.favorite.databinding.ActivityFavoriteBinding
import com.example.favorite.di.DaggerFavoriteComponent
import com.example.favorite.viewmodel.ViewModelFactory
import com.example.randomnews.di.FavoriteDependencies
import com.example.randomnews.ui.detail.DetailActivity
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject


class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFavoriteBinding
    @Inject
    lateinit var fac:ViewModelFactory
    private val viewModel: FavoriteViewModel by viewModels { fac }
    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        binding=ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()

        val newsAdapter = NewsAdapter()
        newsAdapter.onItemClick = { data ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, data)
            startActivity(intent)
        }

        with(binding.rvNews) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = newsAdapter
        }


        viewModel.favNews.observe(this) { news ->
            if (news != null&& news.isNotEmpty()) {
                newsAdapter.setData(news)
                binding.tvEmpty.visibility=View.GONE
                binding.rvNews.visibility=View.VISIBLE
            }else{
                binding.tvEmpty.visibility=View.VISIBLE
                binding.rvNews.visibility=View.GONE
            }
        }

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
}