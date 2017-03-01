package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        TextView text = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String tweetMessage = intent.getStringExtra("message");
        //Log.d("mytag", tweetMessage);
        text.setText(tweetMessage);

    }
}
