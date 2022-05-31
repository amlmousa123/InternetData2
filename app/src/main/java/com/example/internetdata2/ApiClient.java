package com.example.internetdata2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String Base_URL = "http://560057.youcanlearnit.net/services/json/";
       private static Retrofit retrofit = null ;

       public static Retrofit getClient() {

           if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(Base_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
           }

           return retrofit ;

       }
}
