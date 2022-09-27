package com.example.nestedrecyclerview.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.pojo.Posts
import com.example.nestedrecyclerview.pojo.home.HomeItem
import com.example.nestedrecyclerview.pojo.home.HomeItemType
import com.example.newtwo.R
import com.example.newtwo.databinding.ItemListStorieBinding
import com.example.newtwo.databinding.ItemPostBinding
import com.example.newtwo.databinding.ItemTextBinding

class PostAdapter(val list: List<HomeItem<Any>>):RecyclerView.Adapter<PostAdapter.BaseHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        when(viewType){
            STORIE_VIEW_HOLDER ->{
                val view=
                    LayoutInflater.from(parent.context).inflate(R.layout.item_list_storie,parent,false)
                return StorieHolder(view)
            }
            TEXT_VIEW_HOLDER ->{
                val view=
                    LayoutInflater.from(parent.context).inflate(R.layout.item_text,parent,false)
                return TextHolder(view)
            }
            POST_VIEW_HOLDER ->{
                val view=
                    LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
                return PostHolder(view)
            }
            else -> throw Exception("not OnCreateViewHolder PostAdapter")
        }
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        when(holder){
            is StorieHolder ->{
                val stories=list[position].item as List<Int>
                val adapterStorie=StorieAdapter(stories)
                holder.binding.itemListStorieRv.adapter=adapterStorie
            }
            is TextHolder ->{
            }
            is PostHolder->{
                bindPost(holder,position)
            }
        }
    }

    private fun bindPost(holder:PostHolder,position:Int){
        val post=list[position].item as Posts
        holder.binding.itemPostIvPerson.setImageResource(post.image)
        holder.binding.itemPostTvName.text=post.name
        holder.binding.itemPostIvPost.setImageResource(post.post)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(list[position].type){
            HomeItemType.TYPE_STORIES-> STORIE_VIEW_HOLDER
            HomeItemType.TYPE_NEW_POST-> TEXT_VIEW_HOLDER
            HomeItemType.TYPE_POST-> POST_VIEW_HOLDER
        }
    }

    companion object{
        const val STORIE_VIEW_HOLDER=0
        const val TEXT_VIEW_HOLDER=2
        const val POST_VIEW_HOLDER=3
    }

    open class BaseHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    class StorieHolder(itemView: View):BaseHolder(itemView){
        val binding= ItemListStorieBinding.bind(itemView)
    }
    class TextHolder(itemView: View):BaseHolder(itemView){
        val binding= ItemTextBinding.bind(itemView)
    }
    class PostHolder(itemView: View):BaseHolder(itemView){
        val binding= ItemPostBinding.bind(itemView)
    }
}
