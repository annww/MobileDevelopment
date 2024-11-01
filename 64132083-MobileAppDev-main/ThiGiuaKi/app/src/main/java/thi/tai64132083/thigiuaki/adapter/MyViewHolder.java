package thi.tai64132083.thigiuaki.adapter;



import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import thi.tai64132083.thigiuaki.R;


public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView tv_name;
    TextView tv_gia;

    public MyViewHolder(View view) {
        super(view);
        this.img = view.findViewById(R.id.img);
        this.tv_name = view.findViewById(R.id.tv_name);
        this.tv_gia = view.findViewById(R.id.tv_gia);
    }
}
