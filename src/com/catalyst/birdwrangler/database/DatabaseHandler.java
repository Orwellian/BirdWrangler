package com.catalyst.birdwrangler.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.catalyst.birdwrangler.entities.*;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static DatabaseHandler INSTANCE;
	private static final String DATABASE_NAME = "BwDB";
	private static final int DATABASE_VERSION = 1;

	private static final String BIRD_TABLE = "bird";
	private static final String BIRD_ID = "birdId";
	private static final String BIRD_NAME = "birdName";

	private static final String RECORD_TABLE = "record";
	private static final String RECORD_ID = "recordId";
	private static final String RECORD_DATE = "recordDate";
	private static final String RECORD_LAT = "recordLat";
	private static final String RECORD_LONG = "recordLong";
	private static final String RECORD_URI = "recordUri";
	private static final String RECORD_BEHAVIOR = "recordActivity";
	private static final String RECORD_NOTES = "recordNotes";

	private static final String BIRD_CREATE = "create table bird (birdId integer primary key autoincrement, birdName text)";

	private static final String RECORD_CREATE = "create table record (recordId integer primary key autoincrement, recordDate integer, recordLat real, recordLong real,"
			+ " recordUri text, recordActivity text, recordNotes text, birdId integer, foreign key (birdId) references bird (birdId))";

	private Cursor cursor;

	private DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public static DatabaseHandler getInstance(Context context) {
		if (INSTANCE == null) {
			INSTANCE = new DatabaseHandler(context);
		}
		return INSTANCE;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try {
			db.execSQL(BIRD_CREATE);
			db.execSQL(RECORD_CREATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// log the version upgrade
		Log.w("TaskDBAdapter", "Upgrading from version " + oldVersion + " to "
				+ newVersion + ", which will destroy all old data");
		// Drop older tables if existing
		db.execSQL("DROP TABLE IF EXISTS " + BIRD_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + RECORD_TABLE);

		// Create tables again
		onCreate(db);
	}

	/**
	 * Adds a new bird to the database
	 */
	public boolean addBird(Bird bird) {
		boolean isWritten = false;
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(BIRD_NAME, bird.getBirdNameCommon());

		try {
			db.insert(BIRD_TABLE, null, values);
			db.close();
			isWritten = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isWritten;
	}

	/**
	 * 
	 * @return a list of Bird objects
	 */
	public List<Bird> getAllBirds() {
		List<Bird> birdList = new ArrayList<Bird>();
		SQLiteDatabase db = this.getReadableDatabase();

		// Select everything from bird table
		Cursor cursor = db
				.query(BIRD_TABLE, null, null, null, null, null, null);
		// looping through all rows and adding to list
		if (cursor != null && cursor.moveToFirst()) {
			do {
				Bird bird = new Bird();
				bird.setBirdId(cursor.getInt(0));
				bird.setBirdNameCommon(cursor.getString(1));

				// Adding bird to list
				birdList.add(bird);
			} while (cursor.moveToNext());
		}
		db.close();
		// return bird list
		return birdList;
	}
	
	public List<Record> getAllRecords(){
		List<Record> recordList = new ArrayList<Record>();
		SQLiteDatabase db = this.getReadableDatabase();

		// Select everything from record table
		Cursor cursor = db
				.query(RECORD_TABLE, null, null, null, null, null, null);
		// looping through all rows and adding to list
		if (cursor != null && cursor.moveToFirst()) {
			
			do {
				Record record = new Record();
				record.setRecordId(cursor.getInt(0));
				record.setRecordDate(cursor.getLong(1));
				record.setRecordLat(cursor.getDouble(2));
				record.setRecordLong(cursor.getDouble(3));
				record.setPhotoUri(cursor.getString(4));
				record.setRecordBehavior(cursor.getString(5));
				record.setRecordNotes(cursor.getString(6));
				record.setBirdId(cursor.getInt(7));

				// Adding record to list
				recordList.add(record);
			} while (cursor.moveToNext());
		}
		db.close();
		// return record list
		return recordList;
	}

	/**
	 * Adds a new observation to the database
	 */
	public boolean addRecord(Record record) {
		boolean isWritten = false;
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(RECORD_DATE, record.getRecordDate());
		values.put(RECORD_LAT, record.getRecordLat());
		values.put(RECORD_LONG, record.getRecordLong());
		values.put(RECORD_URI, record.getPhotoUri());
		values.put(RECORD_BEHAVIOR, record.getRecordBehavior());
		values.put(RECORD_NOTES, record.getRecordNotes());
		values.put(BIRD_ID, record.getBirdId());
		try {
			db.insert(RECORD_TABLE, null, values);
			db.close();
			isWritten = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isWritten;
	}

	/**
	 * 
	 * @param birdName
	 * @return the primary key (birdId) of the named bird
	 */
	public int getBirdIdByBirdName(String birdName) {
		int birdId;
		SQLiteDatabase db = this.getReadableDatabase();
		cursor = db.query(BIRD_TABLE, new String[] { BIRD_ID }, BIRD_NAME
				+ " = ?", new String[] { birdName }, null, null, null);
		if (cursor != null && cursor.moveToFirst()) {
			birdId = cursor.getInt(0);
		} else {
			birdId = 0;
		}
		db.close();
		return birdId;
	}
}
