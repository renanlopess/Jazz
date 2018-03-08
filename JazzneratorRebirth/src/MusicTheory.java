import Representation.ChordRepresentation;
import Representation.Key;
import jm.JMC;

public interface MusicTheory extends JMC{
	int[] majorScaleIntervals = new int[]{0, 2, 4, 5, 7, 9, 11, 12, 14, 16, 17, 19, 21, 23, 24};
	int[] minorScaleIntervals = new int[]{0, 2, 3, 5, 7, 8, 10, 12, 14, 15, 17, 19, 20, 22, 24};
	
	public static Chord buildChord(Key key, ChordRepresentation chordRepresentation){
		int[] chord_notes = new int[6];
		int[] intervals;
		
		if(key.getQuality().equals("major")){
			intervals = majorScaleIntervals;
		}else{
			intervals = minorScaleIntervals;
		}
		
		//Check if there are a bass note on this chord
		if(chordRepresentation.getBass_note() > 0){
			chord_notes[0] = key.getKey_note() + intervals[chordRepresentation.getBass_note()-1] - 12;
		}else{
			chord_notes[0] = 0;
		}

		//Apply the root, third and fifth of the chord
		chord_notes[1] = key.getKey_note() + intervals[chordRepresentation.getScale_degree()-1];
		chord_notes[2] = chord_notes[1] + intervals[2];
		chord_notes[3] = chord_notes[1] + intervals[4];
		
		//Modify and add notes accordingly with the complement of the chord	
		switch(chordRepresentation.getComplement()){
		case "M":
			//Do nothing
			break;
		case "m":
			chord_notes[2]--;
			break;
		case "aug":
			chord_notes[3]++;
			break;
		case "dim":
			chord_notes[2]--;
			chord_notes[3]--;
			break;
		case "7":
			chord_notes[4] = chord_notes[1] + 10;
			break;
		case "m7":
			chord_notes[2]--;
			chord_notes[4] = chord_notes[1] + 10;
			break;
		case "m7M":
			chord_notes[2]--;
			chord_notes[4] = chord_notes[1] + 11;
			break;
		case "7M":
			chord_notes[4] = chord_notes[1] + 11;
			break;
		case "6":
			chord_notes[4] = chord_notes[1] + 9;
			break;
		case "m6":
			chord_notes[2]--;
			chord_notes[4] = chord_notes[1] + 9;
			break;
		case "sus4":
			chord_notes[2] = chord_notes[1] + 5;
			break;
		case "7sus4":
			chord_notes[2] = chord_notes[1] + 5;
			chord_notes[4] = chord_notes[1] + 10;
			break;
		case "sus2":
			chord_notes[2] = chord_notes[1] + 2;
			break;
		case "7sus2":
			chord_notes[2] = chord_notes[1] + 2;
			chord_notes[4] = chord_notes[1] + 10;
			break;
		}
		
		//Check and ad added note
		if(chordRepresentation.getAdded_note() > 0){
			chord_notes[5] = chord_notes[1] + intervals[chordRepresentation.getAdded_note()-1];
		}else{
			chord_notes[5] = REST;
		}
		
		//Check and modify b5 note
		if(chordRepresentation.isB5() == true){
			chord_notes[3]--;
		}
		
		
		Chord chord = new Chord(chord_notes[0], chord_notes[1], chord_notes[2], 
				chord_notes[3], chord_notes[4], chord_notes[5]);
		
		return chord;
			
	}
	
}
