package com.example.brizz.budayabandung.KategoriActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brizz.budayabandung.DescriptionActivity.DescriptionActivity;
import com.example.brizz.budayabandung.Holder.BudayaViewHolder;
import com.example.brizz.budayabandung.Model.Budaya;
import com.example.brizz.budayabandung.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class AlatMusikActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView recyclerView;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
        setSupportActionBar(toolbar);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("alat_musik");

        recyclerView = findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Budaya, BudayaViewHolder>
                firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Budaya, BudayaViewHolder>(

                Budaya.class,
                R.layout.budaya_item,
                BudayaViewHolder.class,
                mDatabase

        ) {
            @Override
            protected void populateViewHolder(BudayaViewHolder viewHolder, final Budaya model, int position) {

                viewHolder.setTitle(model.getTitle());
                viewHolder.setImage(getApplicationContext(), model.getImage());

                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getBaseContext(), DescriptionActivity.class);
                        intent.putExtra("send_image", model.getImage());
                        intent.putExtra("send_title", model.getTitle());
                        intent.putExtra("send_desc", model.getDesc());
                        startActivity(intent);
                    }
                });
            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
