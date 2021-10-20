package com.developer.guideapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developer.guideapp.databinding.ListItemBinding

class ListAdapter(private val list: ArrayList<GuideModel>, private val click:(GuideModel)->Unit) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

     class ViewHolder(private val view: ListItemBinding, clickPosition:(Int)->Unit) : RecyclerView.ViewHolder(view.root) {
        init {
            view.root.setOnClickListener{
                clickPosition(bindingAdapterPosition)
            }
        }

        fun bind(guideModel: GuideModel) {
            view.image.load(guideModel.image)
            view.description.text = guideModel.longDisc
            view.title.text = guideModel.name
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding){
             click(list[it])
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
