package com.hp.tasktable.Network;

import com.hp.tasktable.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apis {
    @GET("tracking/viewreport.php")
    Call<ResponseModel> apiCall();
}
