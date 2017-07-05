package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by buck on 7/3/2017.
 */

public interface PhotosAPI {


    @GET("/photos")
    Call<ArrayList<Photo>> getphotos();

    @GET("/albums/{id}/photos")
    Call<ArrayList<Photo>> getphotosByAlbumId(
            @Path("id") int albumId
    );
}
