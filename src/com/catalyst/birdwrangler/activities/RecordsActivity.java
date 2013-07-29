package com.catalyst.birdwrangler.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.catalyst.birdwrangler.R;
import com.catalyst.birdwrangler.database.DatabaseHandler;
import com.catalyst.birdwrangler.entities.Bird;
import com.catalyst.birdwrangler.entities.Record;
import com.catalyst.birdwrangler.utilities.OnDialogDoneListener;
import com.catalyst.birdwrangler.utilities.Utilities;

public class RecordsActivity extends Activity implements OnDialogDoneListener {

	static String[] recordDates;
	static String[] birdNames;
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<String> dates = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_records);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.records, menu);
		return true;
	}

	@Override
	public void onDialogDone(String tag, boolean cancelled, CharSequence message) {
		// TODO Auto-generated method stub

	}

	public void sortByBird(View v) {
		List<Bird> birds = DatabaseHandler.getInstance(this).getAllBirds();

		birdNames = getBirdNames(birds);

		ListView listView = (ListView) findViewById(R.id.ListView01);
		listView.setAdapter(new BaseAdapter() {

			public int getCount() {
				return birdNames.length;
			}

			public Object getItem(int position) {
				return birdNames[position];
			}

			public long getItemId(int position) {
				return position;
			}

			public View getView(int position, View convertView, ViewGroup parent) {
				LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				View view = inflater.inflate(R.layout.listrow, null);
				TextView textView = (TextView) view
						.findViewById(R.id.TextView01);
				textView.setText(birdNames[position]);
				return view;
			}
		});
	}

	private String[] getBirdNames(List<Bird> birds) {

		for (int i = 0; i < birds.size(); i++) {
			Bird bird = birds.get(i);
			names.add(bird.getBirdNameCommon());
		}

		String[] birdNames = new String[names.size()];
		birdNames = names.toArray(birdNames);

		return birdNames;
	}
	
	private String[] getRecordDates(List<Record> records){
		for (int i = 0; i < records.size(); i++) {
			Record record = records.get(i);
			long rawDate = record.getRecordDate();
			Utilities utils = new Utilities();
			String date = utils.formatMillis(rawDate);
			dates.add(date);
		}
		return recordDates;
	}

}
