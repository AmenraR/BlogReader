package android.alaride.blogreader;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.BlockingDeque;

public class BlogPostTask extends AsyncTask<Activity, Void, JSONObject>{
    private Activity activity;

    @Override
    protected JSONObject doInBackground(Activity... activities) {
        activity = activities[0];

        JSONObject jsonObject = null;

        //catches the errors in the Url statement and displaying them in the catch
        try {
            URL blogFeedUrl = new URL("http://blog.teamtreehouse.com/api/get_recent_summary/?count=10");

            HttpURLConnection connection = (HttpURLConnection)blogFeedUrl.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                Log.i("BlogPostTask", "Successful Connection " + responseCode);
                jsonObject = BlogPostParser.get().parse(connection.getInputStream());
            }

        }
        catch(MalformedURLException error){
            Log.e("BlogPostTask", "Malformed URL: " + error);
        }
        catch(IOException error){
            Log.e("BlogPostTask", "IO Exception" + error);
        }
        return jsonObject;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        BlogPostParser.get().readFeed(jsonObject);
        ListView listView = (ListView)activity.findViewById(R.id.ListView);

        //adapts the information in order to have it displayed into the listView

        BlogPostAdapter adapter = new BlogPostAdapter(activity, BlogPostParser.get().posts);
        listView.setAdapter(adapter);
        //tells the listView to use the previously created adapter
    }
}
