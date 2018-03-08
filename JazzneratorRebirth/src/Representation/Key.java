package Representation;

public class Key {
	private int key_note;
	private String quality;
	
	public Key(int key_note, String quality){
		//Checking if the arguments are valid
		if(key_note < 12){
			throw new IllegalArgumentException(
					"Key note can not be so low, its pitch got to be over 11(minimum 12).");
			
		}else if(quality.equals("major") == false && quality.equals("minor") == false){
			throw new IllegalArgumentException(
                    "Quality must be either 'major' or 'minor'.");
			
		}else{
			this.key_note = key_note;
			this.quality = quality;
		}
		
	}

	public int getKey_note() {
		return key_note;
	}

	public void setKey_note(int key_note) {
		this.key_note = key_note;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	
	
}
