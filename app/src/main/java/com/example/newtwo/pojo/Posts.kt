package com.example.nestedrecyclerview.pojo

import com.example.nestedrecyclerview.pojo.home.HomeItem
import com.example.nestedrecyclerview.pojo.home.HomeItemType

data class Posts(val image:Int,val name:String,val post:Int){
    fun toHomeItem(): HomeItem<Any>{
        return HomeItem(this,HomeItemType.TYPE_POST)
    }
}
