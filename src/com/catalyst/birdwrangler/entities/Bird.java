package com.catalyst.birdwrangler.entities;

public class Bird {

	int birdId;
	String birdNameCommon;
	
	public Bird(){
		
	}
	
	public Bird(int birdId, String birdNameCommon){
		this.birdId = birdId;
		this.birdNameCommon = birdNameCommon;
		
	}
	
	public Bird(String birdNameCommon){
		this.birdNameCommon = birdNameCommon;
		
	}

	public int getBirdId() {
		return birdId;
	}

	public void setBirdId(int birdId) {
		this.birdId = birdId;
	}

	public String getBirdNameCommon() {
		return birdNameCommon;
	}

	public void setBirdNameCommon(String birdNameCommon) {
		this.birdNameCommon = birdNameCommon;
	}

	
	
}
