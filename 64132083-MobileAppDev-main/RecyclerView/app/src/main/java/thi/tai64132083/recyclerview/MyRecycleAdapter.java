package thi.tai64132083.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<SanPham> list;
    ClickLisenner lisenner;

    public MyRecycleAdapter(Context context, List<SanPham> list, ClickLisenner lisenner) {
        this.context = context;
        this.list = list;
        this.lisenner = lisenner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.img.setImageResource(list.get(position).getImg());
        holder.tv_name.setText(list.get(position).getName());
        holder.tv_gia.setText(list.get(position).getGia());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lisenner.click(list.get(position).getImg(),list.get(position).getName(),list.get(position).getGia());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
