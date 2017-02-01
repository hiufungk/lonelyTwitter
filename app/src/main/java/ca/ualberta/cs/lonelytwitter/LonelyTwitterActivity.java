package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This class is the main view class of the project. <br> In this class, the user interaction and file manipulation is performed.
 * All files are in the form of "json" files that are stored in Emulator's accessible from Android Device monitor
 * <pre>
 *     pre-formatted text: <br>
 *         File Explorer -> data ->data -> ca.ualberta.cs.lonelytwitter ->files ->file.sav
 * </pre>
 * <code> begin <br>
 * some pseudo code <br>
 * end.</code>
 The file name is indicated in the &nbsp &nbsp &nbsp FILENAME constant.
 <ul>
 	<li>item1</li>
 	<li>item2</li>
 	<li>item3</li>
 </ul>
 <ol>
 	<li>item1</li>
 	<li>item2</li>
 	<li>item3</li>
 </ol>

 @author hiufungk
 @version 1.0
 @see Tweet
 @since 0.5
 */
public class LonelyTwitterActivity extends Activity {

	/**
	* the file that all the tweets are saved here. The format of the file is JSON.
	* @see #loadFromFile
	* @see #saveInFile()
	* */
	private static final String FILENAME = "file.sav";
	private enum TweetListOrdering {DATE_ASCENDING, DATE_DESCENDING, TEXT_ASCENDING, TEXT_DESCENDING};
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	/** Called when the activity is first created.
	 * set OnclickListener for saveButton and clearButton*/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		try {
			Tweet tweet = new NormalTweet("first tweet");
			tweet.setMessage("asadgfh");
			ImportantTweet importantTweet = new ImportantTweet("very important");
			importantTweet.getDate();
			NormalTweet normalTweet = new NormalTweet("im normal");

			ArrayList<Tweet> arrayList = new ArrayList<Tweet>();
			arrayList.add(tweet);
			arrayList.add((Tweet) importantTweet); //can always up cast, will have data lost if cast back to importantTweet after cast to Tweet
			arrayList.add(normalTweet);

		} catch (TweetTooLongException e) {
			e.printStackTrace();
		}

		/** add text to tweetlist and update adapter
		* @throws TweetTooLongException if the text is too long.
		 * */
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				text = trimExtraSpaces(text);
				Tweet tweet = null;
				try {
					tweet = new NormalTweet(text);
				} catch (TweetTooLongException e) {
					e.printStackTrace();
				}
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});

		/**
		 * remove file
		 * clear and update adapter*/
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				deleteFile(FILENAME);
				tweetList.clear();
				adapter.notifyDataSetChanged(); //update UI
			}

		});
	}

	/**
	*load from file and create adapter for tweet list
	 *  */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Trims extra spaces using regular expression.
	 * @param inputString string that needs to be cleared of extra spaces.
	 * @return  resulting string
	 * */
	private String trimExtraSpaces(String inputString){
		inputString = inputString.replaceAll("\\s+", " ");
		return inputString;
	}

	/**
	 * This method sorts the tweet list and refreshes the adapter.
	 * @param ordering ordering to be used
	 * */
	private void sortTweetListItems(TweetListOrdering ordering){
		// TODO: 1/31/17 not implemented yet
	}

	/**
	 * Loads tweets from specified fiel.
	 * @throws TweetTooLongException if the text is too long.
	 * @exception FileNotFoundException if the file is not created first.
	 * */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			//Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			//2017-01-24 18:19
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Save tweets to a specified file in JSON format.
	 * @throws FileNotFoundException if file folder doesnt exist*/
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);//mode_private overwrite the whole file, look up MODE_APPEND to not overwrite?
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO: Handle the Exception properly later
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}