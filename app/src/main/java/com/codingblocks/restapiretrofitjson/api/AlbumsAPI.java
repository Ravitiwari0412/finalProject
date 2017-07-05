package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by buck on 7/3/2017.
 */

public interface AlbumsAPI {

    @GET("/Albums")
    Call<ArrayList<Album>> getAlbums();
}
