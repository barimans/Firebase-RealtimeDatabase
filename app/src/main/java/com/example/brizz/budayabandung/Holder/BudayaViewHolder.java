package com.example.brizz.budayabandung.Holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brizz.budayabandung.R;
import com.squareup.picasso.Picasso;

/**
 * Created by brizz on 11/16/17.
 */

public class BudayaViewHolder extends RecyclerView.ViewHolder{

    TextView post_title, post_desc;
    ImageView post_image;
    Context context;

    public BudayaViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        post_title = itemView.findViewById(R.id.post_title);
        post_desc = itemView.findViewById(R.id.post_desc);
        post_image = itemView.findViewById(R.id.post_image);

    }
    public void setTitle(String title){
        post_title.setText(title);
    }

    public void setDesc(String desc){
        post_desc.setText(desc);
    }

    public void setImage(Context context, String image){
        Picasso.with(context).load(image).into(post_image);
    }
}
