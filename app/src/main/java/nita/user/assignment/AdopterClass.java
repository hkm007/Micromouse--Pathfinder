package nita.user.assignment;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.ceryle.fitgridview.FitGridAdapter;

public class AdopterClass extends RecyclerView.Adapter<AdopterClass.ViewHolder> {
    private ArrayList<AdopterItems> items;
    private Context context;

    public AdopterClass(ArrayList<AdopterItems> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final int x=position%6,y=position-(x*6);
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Log.v("tag","x="+x+"   y="+y);
            }
        });
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {


            }
        }.start();


        if (x==0&&y==0)
        {

            holder.tv.setBackgroundColor(Color.BLUE);
        }
        else if (x==0&&y==1)
        {

            holder.tv.setBackgroundColor(Color.BLUE);
        }
        else if (x==1&&y==1)
        {

            holder.tv.setBackgroundColor(Color.BLUE);
        }
        else if (x==1&&y==2)
        {

            holder.tv.setBackgroundColor(Color.BLUE);
        }
        else if (x==1&&y==3)
        {

            holder.tv.setBackgroundColor(Color.BLUE);
        }
        else if (x==2&&y==3)
        {

            holder.tv.setBackgroundColor(Color.BLUE);
        }
        else if (x==3&&y==3)
        {

            holder.tv.setBackgroundColor(Color.BLUE);
        }
        else if (x==3&&y==4)
        {

            holder.tv.setBackgroundColor(Color.BLUE);
        }
        else if (x==4&&y==4)
        {

            holder.tv.setBackgroundColor(Color.BLUE);
        }
        else if (x==5&&y==4)
        {

            holder.tv.setBackgroundColor(Color.BLUE);
        }
        else if (x==5&&y==5)
        {

            holder.tv.setBackgroundColor(Color.BLUE);
        }
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.text);
        }
    }
}
