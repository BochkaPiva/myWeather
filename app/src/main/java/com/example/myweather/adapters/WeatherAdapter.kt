package com.example.myweather.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myweather.Model.Data.MainData
import com.example.myweather.databinding.ListItemBinding

class WeatherAdapter: ListAdapter<MainData, WeatherAdapter.Holder>(ItemComparator()) {
//        class Holder(view: View) : RecyclerView.ViewHolder(view){
//                val binding = ListItemBinding.bind(view)
//                fun bind(item: DayData) = with(binding){
//                        tvDate.text = item.date
//
//                }
//        }
class Holder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: MainData) = with(binding){
                tvDate.text = item.now_dt
                tvCondition.text = item.fact.condition
                tvTemp.text = item.fact.temp.toString()
                tvTemp.text = item.fact.icon

        }
        companion object{
                fun create(parent: ViewGroup): Holder{
                        return Holder(ListItemBinding
                                .inflate(LayoutInflater.from(parent.context), parent, false))
                }
        }
}
        class ItemComparator : DiffUtil.ItemCallback<MainData>(){
                override fun areItemsTheSame(oldItem: MainData, newItem: MainData): Boolean {
                        return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: MainData, newItem: MainData): Boolean {
                        return oldItem == newItem
                }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
                return Holder.create(parent)
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
                holder.bind(getItem(position))
        }

}