package com.example.newtwo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.pojo.Posts
import com.example.nestedrecyclerview.pojo.home.HomeItem
import com.example.nestedrecyclerview.pojo.home.HomeItemType
import com.example.nestedrecyclerview.ui.adapters.PostAdapter
import com.example.newtwo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val storieList= listOf(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background)
        val postList= mutableListOf<Posts>()

        postList.add(Posts(R.drawable.ic_person,"Mahmoud",R.drawable.ic_launcher_background))
        postList.add(Posts(R.drawable.ic_person,"Akram",R.drawable.ic_launcher_background))
        postList.add(Posts(R.drawable.ic_person,"Ali",R.drawable.ic_launcher_background))
        postList.add(Posts(R.drawable.ic_person,"Ahmed",R.drawable.ic_launcher_background))


        val itemList= mutableListOf<HomeItem<Any>>()
        itemList.add(HomeItem(storieList, HomeItemType.TYPE_STORIES))
        itemList.add(HomeItem("Update your status",HomeItemType.TYPE_NEW_POST))
        itemList.addAll(postList.map{it.toHomeItem()})
        val adapter= PostAdapter(itemList)
        findViewById<RecyclerView>(R.id.main_rv).adapter=adapter
    }
}