package com.hp.tasktable.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReftrofitConfg {
    public Apis getApi()
    {
        //build retrofit object
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://hradmin.aryupay.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //connect api class with this builder

        Apis apis=retrofit.create(Apis.class);
        return apis;
    }
}
