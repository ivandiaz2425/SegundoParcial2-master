package com.jonmid.segundoparcial.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.segundoparcial.Array.Images;
import com.jonmid.segundoparcial.R;
import com.jonmid.segundoparcial.TeamActivity;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView Name;
    private TextView Code;
    private ImageView Images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Name = (TextView)findViewById(R.id.id_tv_namedetail);
        Code =(TextView)findViewById(R.id.id_tv_codedetail);


        Bundle bundle= getIntent().getExtras();


        Name.setText(bundle.getString("name"));
        Code.setText(bundle.getString("code"));

        Images = (ImageView)findViewById(R.id.id_img_item_detail);

        Picasso.with(this).load(com.jonmid.segundoparcial.Array.Images.imageRandom()).into((Images));

    }

    public void regresar(View v){
        Intent intent= new Intent(this, TeamActivity.class);
        startActivity(intent);

    }
}
