package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

/**
 * Created by buck on 7/3/2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.albumViewHolder> {
    private Context context;
    private ArrayList<Album>albums;

    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    public void updateAlbums( ArrayList<Album>albums){
        this.albums=albums;
        notifyDataSetChanged();

    }

    @Override
    public albumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_albums, parent, false);

        return new albumViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(AlbumAdapter.albumViewHolder holder, int position) {

        final Album thisAlbum=albums.get(position);
        holder.tvtitle.setText(thisAlbum.getTitle());
        holder.thisview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.onItemClick(thisAlbum.getId(),v);
                }
            }
        });
    }





    @Override
    public int getItemCount() {
        return albums.size();
    }

    class albumViewHolder extends RecyclerView.ViewHolder{
        TextView tvtitle;
        View thisview;
        public albumViewHolder(View itemView) {
            super(itemView);
            thisview=itemView;
            tvtitle=(TextView)itemView.findViewById(R.id.tvalbums);
        }
    }
}
