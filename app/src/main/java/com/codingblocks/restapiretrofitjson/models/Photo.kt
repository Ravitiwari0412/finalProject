package com.codingblocks.restapiretrofitjson.models

/**
 * Created by buck on 7/3/2017.
 */
data class Photo(
           var albumId : Int,
           var id : Int,
           var title : String,
           var url:String,
           var thumbnailUrl: String
)