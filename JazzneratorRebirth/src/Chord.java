

public class Chord {
	private int bass_note;
	private int root_note; // I
	private int third_note; // normally III or VI in sus4 and II in sus2.
	private int fifth_note; // V
	private int complement_note; // normally bVII, VII, VI or none.
	private int added_note; // normally IX, XI, XIII or none.
	
	Chord(int bass_note, int root_note, int third_note, int fifth_note, int complement_note, int added_note){
		this.bass_note = bass_note;
		this.root_note = root_note;
		this.third_note = third_note;
		this.fifth_note = fifth_note;
		this.complement_note = complement_note;
		this.added_note = added_note;
		
	}

	public int getBass_note() {
		return bass_note;
	}

	public void setBass_note(int bass_note) {
		this.bass_note = bass_note;
	}

	public int getRoot_note() {
		return root_note;
	}

	public void setRoot_note(int root_note) {
		this.root_note = root_note;
	}

	public int getThird_note() {
		return third_note;
	}

	public void setThird_note(int third_note) {
		this.third_note = third_note;
	}

	public int getFifth_note() {
		return fifth_note;
	}

	public void setFfith_note(int fifth_note) {
		this.fifth_note = fifth_note;
	}

	public int getComplement_note() {
		return complement_note;
	}

	public void setComplement_note(int complement_note) {
		this.complement_note = complement_note;
	}

	public int getAdded_note() {
		return added_note;
	}

	public void setAdded_note(int added_note) {
		this.added_note = added_note;
	}
	
}
