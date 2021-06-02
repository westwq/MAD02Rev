package sg.edu.np.mad.mad02rev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);

        ArrayList<Post> data = db.getAllPosts();//new ArrayList<>();
//        for(int i=0; i<20; i++)
//        {
//            Post p = new Post();
//            p.handle = "Handle #"+i;
//            p.location = "Loc " + i;
//
//            data.add(p);
//        }

        RecyclerView rv = findViewById(R.id.rv);
        PostsAdapter adapter = new PostsAdapter(this, data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(layoutManager);
    }
}