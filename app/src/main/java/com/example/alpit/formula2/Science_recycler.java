package com.example.alpit.formula2;

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

/**
 * Created by Alpit on 17-03-2017.
 */

public class Science_recycler extends RecyclerView.Adapter<Science_recycler.ScienceView> {

    String[] title;
    Drawable[] picture;
    String[] des;

    public Science_recycler(Context context) {
        Resources r = context.getResources();
        title = r.getStringArray(R.array.sci_name);
        des = r.getStringArray(R.array.sci_descript);
        TypedArray t = r.obtainTypedArray(R.array.sci_image);
        picture = new Drawable[t.length()];
        for (int i = 0; i < picture.length; i++) {
            picture[i] = t.getDrawable(i);
        }
        t.recycle();
    }


    @Override
    public ScienceView onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_cardview, parent, false);
        ScienceView scienceView = new ScienceView(view);
        return scienceView;
    }

    @Override
    public void onBindViewHolder(ScienceView holder, int position) {
        holder.tx_sci.setText(title[position]);
        holder.img_sci.setImageDrawable(picture[position]);
        holder.tx_scides.setText(des[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class ScienceView extends RecyclerView.ViewHolder {
        public TextView tx_sci, tx_scides;
        public ImageView img_sci;

        public ScienceView(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Einstine.class));
                    } else if (getAdapterPosition() == 1) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Newton.class));
                    } else if (getAdapterPosition() == 2) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), galelio.class));
                    } else if (getAdapterPosition() == 3) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), cdarwin.class));
                    } else if (getAdapterPosition() == 4) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Ntesla.class));
                    } else if (getAdapterPosition() == 5) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Curie.class));
                    } else if (getAdapterPosition() == 6) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Pasture.class));
                    } else if (getAdapterPosition() == 7) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Farady.class));
                    } else if (getAdapterPosition() == 8) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Bohr.class));
                    } else if (getAdapterPosition() == 9) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Raman.class));
                    }
                }
            });
            tx_sci = (TextView) itemView.findViewById(R.id.phy_text);
            img_sci = (ImageView) itemView.findViewById(R.id.phy_image1);
            tx_scides = (TextView) itemView.findViewById(R.id.phy_des);
        }
    }
}



