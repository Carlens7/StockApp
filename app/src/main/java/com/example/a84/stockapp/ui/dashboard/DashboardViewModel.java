package com.example.a84.stockapp.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.a84.stockapp.R;

import java.util.ArrayList;

public class DashboardViewModel extends ViewModel {
    private final String[] stocks = {"IBM"};
    private ArrayList<Stock> theStocks;
    RecyclerView example;
    StockRecyclerAdapter exampleAdapter;


    private MutableLiveData<String> mText;




    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }


}