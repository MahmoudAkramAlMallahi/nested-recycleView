package com.example.nestedrecyclerview.pojo.home

data class HomeItem<T>(
    val item:T,
    val type: HomeItemType,
)
