package com.example.brizz.budayabandung.AddActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.brizz.budayabandung.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AddDataActivity extends AppCompatActivity {

    private ImageButton imageUpload;
    private EditText etKat, etTitle, etDesc;
    private Button btnAdd;

    private static final int GALLERY_REQUEST = 2;

    private Uri imageUri = null;

    private StorageReference mStorage;
    private DatabaseReference mDbAm, mDbSn, mDbMk, mDbPk, mDbTb;

    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        imageUpload = findViewById(R.id.iv_upload);
        etKat = findViewById(R.id.et_kat);
        etTitle = findViewById(R.id.et_title);
        etDesc = findViewById(R.id.et_desc);
        btnAdd = findViewById(R.id.btn_add);

        mStorage = FirebaseStorage.getInstance().getReference();
        mDbAm = FirebaseDatabase.getInstance().getReference().child("alat_musik");
        mDbSn = FirebaseDatabase.getInstance().getReference().child("seni_tradisi");
        mDbMk = FirebaseDatabase.getInstance().getReference().child("makanan");
        mDbPk = FirebaseDatabase.getInstance().getReference().child("pakaian");
        mDbTb = FirebaseDatabase.getInstance().getReference().child("tema_bandung");

        mProgress = new ProgressDialog(this);

        imageUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST);

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addData();
            }
        });
    }

    private void addData(){

        mProgress.setMessage("Uploading ...");
        mProgress.show();

        final String kat_val = etKat.getText().toString().trim();
        final String title_val = etTitle.getText().toString().trim();
        final String desc_val = etDesc.getText().toString().trim();

        if (kat_val.equalsIgnoreCase("alat musik")){

            if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val) && imageUri != null){

                StorageReference filePath = mStorage.child("Alat_Musik").child(imageUri.getLastPathSegment());

                filePath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();

                        DatabaseReference newPost = mDbAm.push();

                        newPost.child("title").setValue(title_val);
                        newPost.child("desc").setValue(desc_val);
                        newPost.child("image").setValue(downloadUrl.toString());

                        mProgress.dismiss();
                    }
                });
            }
        }

        if (kat_val.equalsIgnoreCase("seni tradisional")){

            if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val) && imageUri != null){

                StorageReference filePath = mStorage.child("Seni_Tradisi").child(imageUri.getLastPathSegment());

                filePath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();

                        DatabaseReference newPost = mDbSn.push();

                        newPost.child("title").setValue(title_val);
                        newPost.child("desc").setValue(desc_val);
                        newPost.child("image").setValue(downloadUrl.toString());

                        mProgress.dismiss();
                    }
                });
            }
        }

        if (kat_val.equalsIgnoreCase("makanan")){

            if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val) && imageUri != null){

                StorageReference filePath = mStorage.child("Makanan").child(imageUri.getLastPathSegment());

                filePath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();

                        DatabaseReference newPost = mDbMk.push();

                        newPost.child("title").setValue(title_val);
                        newPost.child("desc").setValue(desc_val);
                        newPost.child("image").setValue(downloadUrl.toString());

                        mProgress.dismiss();
                    }
                });
            }
        }

        if (kat_val.equalsIgnoreCase("pakaian")){

            if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val) && imageUri != null){

                StorageReference filePath = mStorage.child("Pakaian_Adat").child(imageUri.getLastPathSegment());

                filePath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();

                        DatabaseReference newPost = mDbPk.push();

                        newPost.child("title").setValue(title_val);
                        newPost.child("desc").setValue(desc_val);
                        newPost.child("image").setValue(downloadUrl.toString());

                        mProgress.dismiss();
                    }
                });
            }
        }

        if (kat_val.equalsIgnoreCase("tema")){

            if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val) && imageUri != null){

                StorageReference filePath = mStorage.child("Tema_Bandung").child(imageUri.getLastPathSegment());

                filePath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();

                        DatabaseReference newPost = mDbTb.push();

                        newPost.child("title").setValue(title_val);
                        newPost.child("desc").setValue(desc_val);
                        newPost.child("image").setValue(downloadUrl.toString());

                        mProgress.dismiss();
                    }
                });
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){
            imageUri = data.getData();
            imageUpload.setImageURI(imageUri);
        }
    }
}
