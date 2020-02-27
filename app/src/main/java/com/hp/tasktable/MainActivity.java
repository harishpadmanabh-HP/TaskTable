package com.hp.tasktable;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hp.tasktable.Adapter.MyAdapter;
import com.hp.tasktable.Model.ResponseModel;
import com.hp.tasktable.Network.ReftrofitConfg;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ResponseModel responseModel;
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        try {

            new ReftrofitConfg().getApi().apiCall().enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    responseModel = response.body();
                    LinearLayoutManager verticalLayoutmanager
                            = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

                    rv.setLayoutManager(verticalLayoutmanager);
                    rv.setAdapter(new MyAdapter(responseModel, MainActivity.this));


                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(MainActivity.this, ""+t, Toast.LENGTH_SHORT).show();

                }
            });

        }catch (Exception e)
        {
            Log.e("EXCEPTION" , String.valueOf(e));
            Toast.makeText(MainActivity.this, "" + e, Toast.LENGTH_SHORT).show();

        }
    }

    private void initView() {
        rv = findViewById(R.id.rv);
    }
}
