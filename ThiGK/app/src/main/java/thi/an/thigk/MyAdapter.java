package thi.an.thigk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<QuocGia> data;

    public MyAdapter(List<QuocGia> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QuocGia qg = data.get(position);
        holder.txtTitle.setText(qg.getName());
        holder.txtSubTitle.setText(qg.getPop());
        holder.imageView.setImageResource(qg.imageResId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtSubTitle;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtSubTitle = itemView.findViewById(R.id.txtSubTitle);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
