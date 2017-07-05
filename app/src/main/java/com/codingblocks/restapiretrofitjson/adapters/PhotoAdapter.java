package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Photo;
import com.codingblocks.restapiretrofitjson.models.Post;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

/**
 * Created by buck on 7/3/2017.
 */

public class PhotoAdapter
        extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    public static final String TAG = "photo";

    private Context context;
    private ArrayList<Photo> photos;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public PhotoAdapter(Context context, ArrayList<Photo> posts) {
        this.context = context;
        this.photos = posts;
    }

    public void updatePhotos(ArrayList<Photo> posts) {
       this.photos=posts;
        notifyDataSetChanged();
    }

    @Override
    public PhotoAdapter.PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_photos, parent, false);

        return new PhotoAdapter.PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotoAdapter.PhotoViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: HEllo World");
        final Photo thisPost = photos.get(position);

      holder.tvPhotoTitle.setText(thisPost.getTitle());

        Picasso.with(context).load(thisPost.getThumbnailUrl()).into(holder.thumbnail);
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(thisPost.getId(), view);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {

        TextView tvPhotoTitle;
        ImageView thumbnail;
        View thisView;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            thisView = itemView;
           tvPhotoTitle=(TextView)itemView.findViewById(R.id.tvphototitle);
            thumbnail=(ImageView)itemView.findViewById(R.id.imageView);
        }
    }
}
