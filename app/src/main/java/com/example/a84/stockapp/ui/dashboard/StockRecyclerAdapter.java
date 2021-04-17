package com.example.a84.stockapp.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.a84.stockapp.R;

import java.util.ArrayList;

public class StockRecyclerAdapter extends RecyclerView.Adapter<StockRecyclerAdapter.ViewHolder> {

    private ArrayList<Stock> mLocalData;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView cp;
        private TextView symbol;
        private TextView ltd;
        private TextView price;
        private TextView open;
        private TextView high;
        private TextView low;
        private TextView volume;
        private TextView c;
        private TextView pc;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            cp = view.findViewById(R.id.cp);
            symbol = view.findViewById(R.id.symbol);
            price = view.findViewById(R.id.price);
            ltd = view.findViewById(R.id.ltd);
            open = view.findViewById(R.id.open);
            high = view.findViewById(R.id.high);
            low = view.findViewById(R.id.low);
            volume = view.findViewById(R.id.volume);
            c = view.findViewById(R.id.c);
            pc = view.findViewById(R.id.pc);

        }

        public TextView getltd() {
            return ltd;
        }

        public TextView getsymbol(){
            return symbol;
        }

        public TextView getcp(){
            return cp;
        }

        public TextView getprice(){
            return price;
        }

        public TextView getopen(){
            return open;
        }

        public TextView gethigh(){
            return high;
        }

        public TextView getlow(){
            return low;
        }

        public TextView getvolume(){
            return volume;
        }

        public TextView getc(){
            return c;
        }

        public TextView getpc(){
            return pc;
        }
    }

    public StockRecyclerAdapter(ArrayList<Stock> dataSet) {
        mLocalData = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_dashboard, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getltd().setText("Latest Trading Day: "+ mLocalData.get(position).getLatest_trading_day());
        viewHolder.getprice().setText("Price: $" + mLocalData.get(position).getPrice());
        viewHolder.getcp().setText("Change %: "+ mLocalData.get(position).getChange_percent());
        viewHolder.getsymbol().setText("Symbol: "+ mLocalData.get(position).getSymbol());
        viewHolder.getopen().setText("Open: $"+ mLocalData.get(position).getOpen());
        viewHolder.gethigh().setText("High: $"+ mLocalData.get(position).getHigh());
        viewHolder.getlow().setText("Low: $"+ mLocalData.get(position).getLow());
        viewHolder.getvolume().setText("Volume: "+ mLocalData.get(position).getVolume());
        viewHolder.getc().setText("Change: "+ mLocalData.get(position).getChange());
        viewHolder.getpc().setText("Prev. Close: $"+ mLocalData.get(position).getPrevious_close());
    }

    @Override
    public int getItemCount() {
        return mLocalData.size();
    }





}

