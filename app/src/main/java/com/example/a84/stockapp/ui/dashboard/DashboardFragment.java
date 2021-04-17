package com.example.a84.stockapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.Manifest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.zip.Inflater;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.a84.stockapp.R;

public class DashboardFragment extends Fragment {
    private final String[] stocks = {"IBM"};
    private ArrayList<Stock> theStocks;
    RecyclerView example;
    StockRecyclerAdapter exampleAdapter;

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        theStocks = new ArrayList<Stock>();
        example = example.findViewById(R.id.navigation_dashboard);

        for(String s : stocks) {
            String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol={{REPLACE_KEY}}&apikey=I5I6LW85PQXIBU2U".replace("{{REPLACE_KEY}}", s);
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            GsonRequest<GlobalQuote> req = new GsonRequest<GlobalQuote>(url, GlobalQuote.class, null, new Response.Listener<GlobalQuote>() {
                @Override
                public void onResponse(GlobalQuote response) {

                    System.out.println("Successful Response");
                    System.out.println(response.getGlobalQuote().getSymbol());
                    theStocks.add(response.getGlobalQuote());

                    if(theStocks.size() == stocks.length){
                        doView();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println("That didn't work!");
                }
            });

        }

        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }



        });
        return root;
    }

    private void doView(){
        exampleAdapter = new StockRecyclerAdapter(theStocks);
        example.setAdapter(exampleAdapter);
        example.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}