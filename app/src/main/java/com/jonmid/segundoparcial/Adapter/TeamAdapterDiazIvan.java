package com.jonmid.segundoparcial.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.segundoparcial.Array.Images;
import com.jonmid.segundoparcial.Model.TeamModelDiazIvan;
import com.jonmid.segundoparcial.R;
import com.jonmid.segundoparcial.Views.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IVANCHO on 17/10/2017.
 */

public class TeamAdapterDiazIvan extends RecyclerView.Adapter<TeamAdapterDiazIvan.ViewHolder> {

    List<TeamModelDiazIvan> List = new ArrayList<>();
    Context context;

    public TeamAdapterDiazIvan(List<TeamModelDiazIvan> List, Context context) {
        this.List = List;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // Encargado de trabajar con el item.xml y sus componentes

        holder.name.setText(List.get(position).getName());
        holder.code.setText(List.get(position).getCode());
        //holder.crestUrl.setText(List.get(position).getCrestUrl());
        Picasso.with(context).load(Images.imageRandom()).into((holder.foto));


    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView code;
        //TextView crestUrl;
        ImageView foto;


        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);
            foto=(ImageView)item.findViewById(R.id.id_img_team);
            name = (TextView) item.findViewById(R.id.id_tv_name_team);
            code = (TextView) item.findViewById(R.id.id_tv_cod_team);


        }

        @Override
        public void onClick(View view) {

            Context contextItem = view.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name", List.get(getLayoutPosition()).getName());
            intent.putExtra("code", List.get(getLayoutPosition()).getCode());


            contextItem.startActivity(intent);
        }
    }

}
