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
 * Created by Alpit on 19-03-2017.
 */

public class chem_recyccler extends RecyclerView.Adapter<chem_recyccler.chem_holder> {

    String[] title;
    Drawable[] picture;
    String[] des;

    public chem_recyccler(Context context) {
        Resources r = context.getResources();
        title = r.getStringArray(R.array.Chemarr);
        des = r.getStringArray(R.array.Chemarr_des);
        TypedArray t = r.obtainTypedArray(R.array.chem_image);
        picture = new Drawable[t.length()];
        for (int i = 0; i < picture.length; i++) {
            picture[i] = t.getDrawable(i);
        }
        t.recycle();
    }

    @Override
    public chem_recyccler.chem_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_cardview, parent, false);
        chem_holder chem_holder = new chem_holder(view);
        return chem_holder;
    }

    @Override
    public void onBindViewHolder(chem_recyccler.chem_holder holder, int position) {
        holder.tx_sci.setText(title[position]);
        holder.img_sci.setImageDrawable(picture[position]);
        holder.tx_scides.setText(des[position]);

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class chem_holder extends RecyclerView.ViewHolder {
        private TextView tx_sci, tx_scides;
        private ImageView img_sci;

        public chem_holder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Basic_activity.class));
                    }
                }
            });

            tx_sci = (TextView) itemView.findViewById(R.id.phy_text);
            img_sci = (ImageView) itemView.findViewById(R.id.phy_image1);
            tx_scides = (TextView) itemView.findViewById(R.id.phy_des);
        }

    }

}
