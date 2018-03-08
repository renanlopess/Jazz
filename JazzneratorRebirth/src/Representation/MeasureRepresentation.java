package Representation;

public class MeasureRepresentation {
	private ChordRepresentation[] chords;
	
	// In this program, a single measure may hold only one, two or four chords 
	
	public MeasureRepresentation(ChordRepresentation chord_1){
		chords = new ChordRepresentation[]{chord_1};
	}
	
	public MeasureRepresentation(ChordRepresentation chord_1, ChordRepresentation chord_2){
		chords = new ChordRepresentation[]{chord_1, chord_2};
	}
	
	public MeasureRepresentation(ChordRepresentation chord_1, ChordRepresentation chord_2, 
			ChordRepresentation chord_3, ChordRepresentation chord_4){
		chords = new ChordRepresentation[]{chord_1, chord_2, chord_3, chord_4};
	}

	public ChordRepresentation[] getChords() {
		return chords;
	}

	public void setChords(ChordRepresentation[] chords) {
		this.chords = chords;
	}
}
