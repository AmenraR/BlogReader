package android.alaride.blogreader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;


public class BlogActivity extends Activity {

    protected ProgressBar progressBar;
    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        /*String[] arrayStrings = new String[]{
                "Blog Post 1",
                "Blog Post 2",
                "Blog Post 3",
                "Blog Post 4"
        };*/

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        listView = (ListView)findViewById(R.id.ListView);

        //when listview is empty, the progress bar will show, if it isnt, it will disappear.
        listView.setEmptyView(progressBar);

        new BlogPostTask().execute(this);
    }


}
