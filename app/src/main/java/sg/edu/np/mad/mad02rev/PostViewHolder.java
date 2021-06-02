package sg.edu.np.mad.mad02rev;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder{
    TextView txtHandle;
    TextView txtLocation;
    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        txtHandle = itemView.findViewById(R.id.handle);
        txtLocation = itemView.findViewById(R.id.location);
    }
}
