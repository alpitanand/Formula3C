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
 * Created by Alpit on 22-01-2017.
 */

public class Physics_recycler extends RecyclerView.Adapter<Physics_recycler.phy_holder>{

   private String phy_title[];
    private String phy_des[];
   private Drawable phy_image[];
    public Physics_recycler(Context context)
    {
        Resources phy= context.getResources();
        phy_title=phy.getStringArray(R.array.phy_name);
        phy_des=phy.getStringArray(R.array.phy_descript);
        TypedArray t1=phy.obtainTypedArray(R.array.image);
        phy_image=new Drawable[t1.length()];
        for(int i=0;i<phy_image.length;i++)
        {
            phy_image[i]=t1.getDrawable(i);
        }
    t1.recycle();
    }

    public Physics_recycler.phy_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_cardview,parent,false);
        phy_holder phyholder=new phy_holder(view);
        return phyholder;
    }

    @Override
    public void onBindViewHolder(phy_holder holder, int position) {
        holder.tx_phy.setText(phy_title[position]);
        holder.phy_img.setImageDrawable(phy_image[position]);
        holder.tx_phydes.setText(phy_des[position]);
    }

    @Override
    public int getItemCount() {
        return phy_title.length;
    }

public class phy_holder extends RecyclerView.ViewHolder{
public TextView tx_phy,tx_phydes;
    public ImageView phy_img;
    public phy_holder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getAdapterPosition()==0)
                {itemView.getContext().startActivity(new Intent(itemView.getContext(),Kinematics.class));
                }
                if(getAdapterPosition()==1)
                {itemView.getContext().startActivity(new Intent(itemView.getContext(),Gravitation.class));
                }
                if(getAdapterPosition()==2)
                {itemView.getContext().startActivity(new Intent(itemView.getContext(),Mechanics.class));
                }
                if(getAdapterPosition()==3)
                {itemView.getContext().startActivity(new Intent(itemView.getContext(),Hydrodynamics.class));
                }
                if(getAdapterPosition()==4)
                {itemView.getContext().startActivity(new Intent(itemView.getContext(),Shm.class));
                }
                if(getAdapterPosition()==5)
                {itemView.getContext().startActivity(new Intent(itemView.getContext(),Waves.class));
                }
                if(getAdapterPosition()==6)
                {itemView.getContext().startActivity(new Intent(itemView.getContext(),Interference.class));
                }
                if(getAdapterPosition()==7)
                {itemView.getContext().startActivity(new Intent(itemView.getContext(),Electromagneticwaves.class));
                }
                if(getAdapterPosition()==8)
                {itemView.getContext().startActivity(new Intent(itemView.getContext(),Modernphysics.class));
                }
                if(getAdapterPosition()==9)
                {itemView.getContext().startActivity(new Intent(itemView.getContext(),Thermalexpansion.class));
                }
                if(getAdapterPosition()==10)
                {itemView.getContext().startActivity(new Intent(itemView.getContext(),Thermodynamics.class));
                }

            }
        });
        tx_phy=(TextView)itemView.findViewById(R.id.phy_text);
        phy_img=(ImageView)itemView.findViewById(R.id.phy_image1);
        tx_phydes=(TextView)itemView.findViewById(R.id.phy_des);
    }
}
}
