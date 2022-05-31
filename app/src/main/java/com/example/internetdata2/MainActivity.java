package com.example.internetdata2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
       Call<List<Item>> call = apiInterface.getListOfItems();
       call.enqueue(new Callback<List<Item>>() {
           @Override
           public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
               List<Item> Items =response.body();
               ItemsAdapter adapter = new ItemsAdapter(Items) ;
               recyclerView.setAdapter(adapter);

           }

           @Override
           public void onFailure(Call<List<Item>> call, Throwable t) {

           }
       });

    }
}