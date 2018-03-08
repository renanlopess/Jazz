package Representation;

public class ChordRepresentation {
	private int modulation_value;
	private int scale_degree;
	private String complement;// options: M, m, aug, dim, 7, m7, m7M, 7M, 6, m6, sus4, 7sus4, sus2, 7sus2.
	private int added_note;// options: 9, 11, 13 or zero for none.
	private boolean b5; // If the chord holds a b5 instead of a 5.
	private int bass_note; // 0 if the bass note is the root of the chord, then 1 if is the I of the scale, 2 if II ... 
	private int inversion; // 1 for first, 2 for second and 0 if it's on root position.
	
	/* Example:
		In a song on a key of C, a Dm7b5+13 would have scale_degree = 2,
		complement = m7, added_note = 13, b5 = true, bass_note = 0 and inversion = 0.	
	*/
	
	public ChordRepresentation(int modulation_value, int scale_degree, String complement, 
			boolean b5, int added_note, int bass_note, int inversion){
		//Checking if the arguments are valid
		if(scale_degree < 1){
			
			throw new IllegalArgumentException(
                    "The scale deegre was out of range.");
			
		}else if(complement.equals("M") == false
			&& complement.equals("m") == false
			&& complement.equals("aug") == false
			&& complement.equals("dim") == false
			&& complement.equals("7") == false
			&& complement.equals("m7") == false
			&& complement.equals("m7M") == false
			&& complement.equals("7M") == false
			&& complement.equals("6") == false
			&& complement.equals("m6") == false
			&& complement.equals("sus4") == false
			&& complement.equals("7sus4") == false
			&& complement.equals("sus2") == false
			&& complement.equals("7sus2") == false){
			
			throw new IllegalArgumentException(
                    "It was not possible to identify the interval quality.");
			
		}else if(bass_note < 0 || bass_note > 7){
			
			throw new IllegalArgumentException(
                    "The bass note was out of range.");
			
		}else if(inversion < 0 || inversion > 2){

			throw new IllegalArgumentException(
                    "The inversion was out of range.");
		
		}else{
			this.modulation_value = modulation_value;
			this.scale_degree = scale_degree;
			this.complement = complement;
			this.b5 = b5;
			this.added_note = added_note;
			this.bass_note = bass_note;
			this.inversion = inversion;
		}
	}

	public int getScale_degree() {
		return scale_degree;
	}

	public void setScale_degree(int scale_degree) {
		this.scale_degree = scale_degree;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public int getAdded_note() {
		return added_note;
	}

	public void setAdded_note(int added_note) {
		this.added_note = added_note;
	}

	public boolean isB5() {
		return b5;
	}

	public void setB5(boolean b5) {
		this.b5 = b5;
	}

	public int getBass_note() {
		return bass_note;
	}

	public void setBass_note(int bass_note) {
		this.bass_note = bass_note;
	}

	public int getInversion() {
		return inversion;
	}

	public void setInversion(int inversion) {
		this.inversion = inversion;
	}

	public int getModulation_value() {
		return modulation_value;
	}

	public void setModulation_value(int modulation_value) {
		this.modulation_value = modulation_value;
	}
	
}
