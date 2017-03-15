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
 * Created by Alpit on 05-03-2017.
 */

public class Unit_recycler extends RecyclerView.Adapter<Unit_recycler.unit_holder> {
    private String unit_title[];
    private Drawable[] unit_image;
    private String unit_description[];

    public Unit_recycler(Context context) {
        Resources unit = context.getResources();
        unit_title = unit.getStringArray(R.array.unit_name);
        unit_description = unit.getStringArray(R.array.unit_descrip);
        TypedArray t2 = unit.obtainTypedArray(R.array.unit_icon);
        unit_image = new Drawable[t2.length()];
        for (int i = 0; i < unit_image.length; i++) {
            unit_image[i] = t2.getDrawable(i);
        }
        t2.recycle();
    }

    @Override
    public Unit_recycler.unit_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_cardview, parent, false);
        unit_holder unitholder = new unit_holder(view);
        return unitholder;
    }

    @Override
    public void onBindViewHolder(Unit_recycler.unit_holder holder, int position) {
        holder.uniticon.setImageDrawable(unit_image[position]);
        holder.unitname.setText(unit_title[position]);
        holder.unitdes.setText(unit_description[position]);

    }

    @Override
    public int getItemCount() {
        return unit_title.length;
    }

    public class unit_holder extends RecyclerView.ViewHolder {
        public TextView unitname, unitdes;
        public ImageView uniticon;

        public unit_holder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Triangle.class));
                    }
                    if (getAdapterPosition() == 5) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), Change.class));
                    }
                }
            });
            unitname = (TextView) itemView.findViewById(R.id.phy_text);
            unitdes = (TextView) itemView.findViewById(R.id.phy_des);
            uniticon = (ImageView) itemView.findViewById(R.id.phy_image1);
        }
    }

}
