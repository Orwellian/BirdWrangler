package com.catalyst.birdwrangler.entities;

public class Record {
	
	int recordId;
	long recordDate;
	double recordLat;
	double recordLong;
	String photoUri;
	String recordBehavior;
	String recordNotes;
	int birdId;
	
	public Record(){
		
	}
	
	public Record(int recordId, long recordDate, double recordLat, double recordLong, String photoUri, String recordBehavior, String recordNotes, int birdId) {
		this.recordId = recordId;
		this.recordDate = recordDate;
		this.recordLat = recordLat;
		this.recordLong = recordLong;
		this.photoUri = photoUri;
		this.recordBehavior = recordBehavior;
		this.recordNotes = recordNotes;
		this.birdId = birdId;
	}
	
	public Record(long recordDate, double recordLat, double recordLong, String photoUri, String recordBehavior, String recordNotes, int birdId){
		this.recordDate = recordDate;
		this.recordLat = recordLat;
		this.recordLong = recordLong;
		this.photoUri = photoUri;
		this.recordBehavior = recordBehavior;
		this.recordNotes = recordNotes;
		this.birdId = birdId;
	}

	public String getPhotoUri() {
		return photoUri;
	}

	public void setPhotoUri(String photoUri) {
		this.photoUri = photoUri;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public long getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(long recordDate) {
		this.recordDate = recordDate;
	}

	public double getRecordLat() {
		return recordLat;
	}

	public void setRecordLat(double recordLat) {
		this.recordLat = recordLat;
	}

	public double getRecordLong() {
		return recordLong;
	}

	public void setRecordLong(double recordLong) {
		this.recordLong = recordLong;
	}

	public String getRecordBehavior() {
		return recordBehavior;
	}

	public void setRecordBehavior(String recordBehavior) {
		this.recordBehavior = recordBehavior;
	}

	public String getRecordNotes() {
		return recordNotes;
	}

	public void setRecordNotes(String recordNotes) {
		this.recordNotes = recordNotes;
	}

	public int getBirdId() {
		return birdId;
	}

	public void setBirdId(int birdId) {
		this.birdId = birdId;
	}

}
