package com.example.nestedrecyclerview.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newtwo.R
import com.example.newtwo.databinding.ItemStorieBinding

class StorieAdapter(val image:List<Int>):RecyclerView.Adapter<StorieAdapter.BaseHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        when(viewType){
            ADD_STORIE_HOLDER->{
                val view=LayoutInflater.from(parent.context).inflate(R.layout.item_storie,parent,false)
                return AddStorieHolder(view)
            }
            NORMAIL_STORIE_HOLDER->{
                val view=LayoutInflater.from(parent.context).inflate(R.layout.item_storie,parent,false)
                return NormailStorieHolder(view)
            }
            else -> throw Exception("not OnCreateViewHolder StorieAdapter")
        }
    }
    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        when(holder){
            is AddStorieHolder->{
                holder.binding.itemAddStorieIv.setImageResource(R.drawable.ic_add)
            }
            is NormailStorieHolder->{
                holder.binding.itemAddStorieIv.setImageResource(R.drawable.ic_person)
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return when(position){
            0->ADD_STORIE_HOLDER
            else-> NORMAIL_STORIE_HOLDER

        }
    }
    override fun getItemCount()=image.size

    companion object{
        private const val ADD_STORIE_HOLDER=1
        private const val NORMAIL_STORIE_HOLDER=2
    }


    open class BaseHolder(itemView:View): RecyclerView.ViewHolder(itemView)
    class AddStorieHolder(itemView: View):BaseHolder(itemView){
        val binding= ItemStorieBinding.bind(itemView)
    }
    class NormailStorieHolder(itemView: View):BaseHolder(itemView){
        val binding=ItemStorieBinding.bind(itemView)
    }

}