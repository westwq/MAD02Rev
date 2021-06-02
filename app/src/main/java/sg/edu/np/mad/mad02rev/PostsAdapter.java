package sg.edu.np.mad.mad02rev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostViewHolder>{
    ArrayList<Post> data;
    Context context;

    public PostsAdapter(Context c, ArrayList<Post> d){
        data = d;
        context = c;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.vh_post, parent, false);

        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post p = data.get(position);

        holder.txtHandle.setText(p.handle);
        holder.txtLocation.setText(p.location);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
