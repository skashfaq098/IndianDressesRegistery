package com.example.indiandressesstocks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.indiandressesstocks.model.ItemsObject;
import com.example.indiandressesstocks.rest.APIInterface;
import com.example.indiandressesstocks.rest.retrofitClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        APIInterface apiInterface;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.fab);
        TextView itemList=findViewById(R.id.textView);
        itemList.setText("Hello Worldscxv");
        apiInterface = retrofitClient.getClient().create(APIInterface.class);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<ItemsObject> call = apiInterface.getItem();
                call.enqueue(new Callback<ItemsObject>() {
                    @Override
                    public void onResponse(Call<ItemsObject> call, Response<ItemsObject> response) {

                        ItemsObject text = response.body();

//                        Log.d("TAG",response.code()+"");
//
//                        String displayResponse = "";
//
//                        ItemsObject result = new Gson().fromJson(String.valueOf(response.body()), ItemsObject.class);
//
//                        System.out.println(result+"itemObjectResult");
//                        Log.d("TAG",result+"itemObjectResult");
//                        itemList.setText((CharSequence) result.getValues().get(0));



                    }

                    @Override
                    public void onFailure(Call<ItemsObject> call, Throwable t) {
                        call.cancel();
                    }
                });

            }
        });
    }
}