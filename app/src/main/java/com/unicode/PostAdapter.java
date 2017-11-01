package com.unicode;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hello on 27-10-2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private List<Post> postList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, position, nationality, jerseyNumber;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            position =  view.findViewById(R.id.position);
            nationality = view.findViewById(R.id.nationality);
            jerseyNumber = view.findViewById(R.id.jersey_number);
        }
    }


    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.position.setText(post.getPosition());
        holder.name.setText(post.getName());
        holder.nationality.setText(post.getNationality());
        holder.jerseyNumber.setText(Integer.toString(post.getJerseyNumber()));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
