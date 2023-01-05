package com.example.indiandressesstocks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.indiandressesstocks.adapters.ItemListAdapter;
import com.example.indiandressesstocks.model.ItemsObject;
import com.example.indiandressesstocks.rest.APIInterface;
import com.example.indiandressesstocks.rest.retrofitClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ItemsObject> itemList;
    private ItemListAdapter itemListAdapter;
    private RecyclerView itemListRv;
    private ProgressBar loadingPB;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemList = new ArrayList<>();

        // initializing our views.
        itemListRv = findViewById(R.id.idRvItemlist);
        loadingPB = findViewById(R.id.idPBLoading);

        // calling a method to load our API.
        getDataFromAPI();
//        FloatingActionButton fab = findViewById(R.id.fab);
//        TextView itemList=findViewById(R.id.textView);
//        itemList.setText("Hello Worldscxv");
        apiInterface = retrofitClient.getClient().create(APIInterface.class);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Call<ItemsObject> call = apiInterface.getItem();
//                call.enqueue(new Callback<ItemsObject>() {
//                    @Override
//                    public void onResponse(Call<ItemsObject> call, Response<ItemsObject> response) {
//
//                        ItemsObject text = response.body();

//                        Log.d("TAG",response.code()+"");
//
//                        String displayResponse = "";
//
//                        ItemsObject result = new Gson().fromJson(String.valueOf(response.body()), ItemsObject.class);
//
//                        System.out.println(result+"itemObjectResult");
//                        Log.d("TAG",result+"itemObjectResult");
//                        itemList.setText((CharSequence) result.getValues().get(0));
//
//
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ItemsObject> call, Throwable t) {
//                        call.cancel();
//                    }
//                });
//
//            }
//        });
    }

    private void getDataFromAPI() {
        apiInterface = retrofitClient.getClient().create(APIInterface.class);
        Call<JsonObject> call = apiInterface.getItem();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                loadingPB.setVisibility(View.GONE);
                try {
                    System.out.println(response.body().getAsJsonArray("values")+"ResponseFromSheet");
                    JSONObject obj = new JSONObject(String.valueOf(response.body()));
                    JSONArray entryArray = obj.getJSONArray("values");
                    for(int i=0; i<entryArray.length(); i++){

                        JSONObject entryObj = entryArray.getJSONObject(i);
                        String itemName = entryObj.getJSONObject("gsx$ItemName").getString("$t");
                        String itemPrice = entryObj.getJSONObject("gsx$Price").getString("$t");
                        String itemQty = entryObj.getJSONObject("gsx$Qty").getString("$t");

                        itemList.add(new ItemsObject(itemName, itemPrice, itemQty));

                        // passing array list to our adapter class.
                        itemListAdapter = new ItemListAdapter(itemList, MainActivity.this);

                        // setting layout manager to our recycler view.
                        itemListRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                        // setting adapter to our recycler view.
                        itemListRv.setAdapter(itemListAdapter);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                call.cancel();
            }

        });
    }
}