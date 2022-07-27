package com.example.phonecomparator.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.phonecomparator.R
import com.example.phonecomparator.databinding.SmartThingItemBinding
import com.example.phonecomparator.model.RawSmart
import com.example.phonecomparator.model.ResultSmart

class SearchRecyclerAdapter(private val resultSearchingList: List<ResultSmart>, private val openDetailFragment: (String) -> Unit): RecyclerView.Adapter<SearchRecyclerAdapter.SearchSmartViewHolder>() {

    inner class SearchSmartViewHolder(private val binding: SmartThingItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(resultSmartItem: ResultSmart){

            if (resultSmartItem.brand != null){
                binding.tvBrand.text = resultSmartItem.brand.raw
            }
            if (resultSmartItem.model != null){
                binding.tvModel.text = resultSmartItem.model.raw
            }
            if (resultSmartItem.version != null){
                binding.tvVersion.text = resultSmartItem.version.raw
            }

            binding.tvScore.text = resultSmartItem._meta.score.toString()

            if (resultSmartItem.image_front != null){
                Glide.with(binding.ivFrontImage)
                    .load(resultSmartItem.image_front.raw)
                    .error(R.drawable.sad_phone)
                    .into(binding.ivFrontImage)
            }


            binding.root.setOnClickListener {
                //Start a new activity
                openDetailFragment(resultSmartItem._meta.id)
                //"Search item id: " -> resultSmartItem._meta.id
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSmartViewHolder {
        return SearchSmartViewHolder(SmartThingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SearchSmartViewHolder, position: Int) {
        holder.bind(resultSearchingList[position])
    }

    override fun getItemCount() = resultSearchingList.size

}