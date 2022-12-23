package com.example.coredata.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coredata.R
import com.example.coredata.databinding.ItemNewsBinding
import com.example.coredata.domain.News

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ListViewHolder>() {

    private var listData = ArrayList<News>()
    var onItemClick: ((News) -> Unit)? = null

    fun setData(newListData: List<News>?) {
        val oldListData = listData
        if (newListData == null || newListData == oldListData) return
        if(listData.isEmpty()) {
            listData.addAll(newListData)
            notifyItemRangeInserted(0,newListData.size)
            return
        }
        if (newListData.size <oldListData.size){
            val removedData=oldListData.minus(newListData)
            removedData.forEach {
                val i=oldListData.indexOf(it)
                listData.remove(it)
                notifyItemRemoved(i)
            }
            return
        }

        if(newListData.size==oldListData.size){
            val difData=newListData.minus(oldListData.toSet())
            difData.forEach {
                val i=newListData.indexOf(it)
                listData[i] = it
                notifyItemChanged(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemNewsBinding.bind(itemView)
        fun bind(data: News) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.imgUrl)
                    .into(ivItemImage)
                tvItemTitle.text = data.title
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}