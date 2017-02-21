package com.example.alpit.formula2;

/**
 * Created by Alpit on 16-01-2017.
 */

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    String[] tittle;
    Drawable[] picture;

    public RecyclerAdapter(Context context) {
        Resources re = context.getResources();
        tittle = re.getStringArray(R.array.Title_array);
        TypedArray t = re.obtainTypedArray(R.array.Title_image);
        picture = new Drawable[t.length()];
        for (int i = 0; i < picture.length; i++) {
            picture[i] = t.getDrawable(i);
        }
        t.recycle();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tx_title.setText(tittle[position]);
        holder.im_img.setImageDrawable(picture[position]);


    }

    @Override
    public int getItemCount() {
        return tittle.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tx_title;
        public ImageView im_img;

        public MyViewHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition() == 1) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Physics.class));
                    }
                }
            });
            tx_title = (TextView) itemView.findViewById(R.id.title);
            im_img=(ImageView)itemView.findViewById(R.id.image);
        }
    }

}