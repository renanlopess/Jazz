import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Phrase;

public class JazzGuitarPattern03 extends Pattern implements JMC{
	
	public Measure buildMeasure(Chord[] chord){
		Phrase[] phrase = new Phrase[5];
		
		for(int i = 0; i < phrase.length; i++){
			phrase[i] = new Phrase(0);
		}
		
		switch(chord.length){
		case 1:
			if(chord[0].getBass_note() > 0){
				phrase[0].add(new Note(chord[0].getBass_note(), 5*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[0].getBass_note(), 7*EIGHTH_NOTE_TRIPLET));
			}else{
				phrase[0].add(new Note(chord[0].getRoot_note(), 5*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[0].getRoot_note(), 7*EIGHTH_NOTE_TRIPLET));
			}

			phrase[1].add(new Note(REST, 2*EIGHTH_NOTE_TRIPLET));
			phrase[1].add(new Note(chord[0].getFifth_note(), 4*EIGHTH_NOTE_TRIPLET));
			phrase[1].add(new Note(chord[0].getFifth_note(), 6*EIGHTH_NOTE_TRIPLET));
			
			phrase[2].add(new Note(REST, 2*EIGHTH_NOTE_TRIPLET));
			phrase[2].add(new Note(chord[0].getComplement_note(), 4*EIGHTH_NOTE_TRIPLET));
			phrase[2].add(new Note(chord[0].getComplement_note(), 6*EIGHTH_NOTE_TRIPLET));
			
			phrase[3].add(new Note(REST, 2*EIGHTH_NOTE_TRIPLET));
			phrase[3].add(new Note(chord[0].getAdded_note(), 4*EIGHTH_NOTE_TRIPLET));
			phrase[3].add(new Note(chord[0].getAdded_note(), 6*EIGHTH_NOTE_TRIPLET));
			
			phrase[4].add(new Note(REST, 2*EIGHTH_NOTE_TRIPLET));
			phrase[4].add(new Note(chord[0].getThird_note() + 12, 4*EIGHTH_NOTE_TRIPLET));
			phrase[4].add(new Note(chord[0].getThird_note() + 12, 6*EIGHTH_NOTE_TRIPLET));
			
			break;
		case 2:
			if(chord[0].getBass_note() > 0){
				phrase[0].add(new Note(chord[0].getBass_note(), 5*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[1].getBass_note(), 7*EIGHTH_NOTE_TRIPLET));
			}else{
				phrase[0].add(new Note(chord[0].getRoot_note(), 5*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[1].getRoot_note(), 7*EIGHTH_NOTE_TRIPLET));
			}

			phrase[1].add(new Note(REST, 2*EIGHTH_NOTE_TRIPLET));
			phrase[1].add(new Note(chord[0].getFifth_note(), 4*EIGHTH_NOTE_TRIPLET));
			phrase[1].add(new Note(chord[1].getFifth_note(), 6*EIGHTH_NOTE_TRIPLET));
			
			phrase[2].add(new Note(REST, 2*EIGHTH_NOTE_TRIPLET));
			phrase[2].add(new Note(chord[0].getComplement_note(), 4*EIGHTH_NOTE_TRIPLET));
			phrase[2].add(new Note(chord[1].getComplement_note(), 6*EIGHTH_NOTE_TRIPLET));
			
			phrase[3].add(new Note(REST, 2*EIGHTH_NOTE_TRIPLET));
			phrase[3].add(new Note(chord[0].getAdded_note(), 4*EIGHTH_NOTE_TRIPLET));
			phrase[3].add(new Note(chord[1].getAdded_note(), 6*EIGHTH_NOTE_TRIPLET));
			
			phrase[4].add(new Note(REST, 2*EIGHTH_NOTE_TRIPLET));
			phrase[4].add(new Note(chord[0].getThird_note() + 12, 4*EIGHTH_NOTE_TRIPLET));
			phrase[4].add(new Note(chord[1].getThird_note() + 12, 6*EIGHTH_NOTE_TRIPLET));
			
			break;
		case 4:
			if(chord[0].getBass_note() > 0){
				phrase[0].add(new Note(chord[0].getBass_note(), 2*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[1].getBass_note(), 2*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[2].getBass_note(), 2*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[3].getBass_note(), 2*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			}else{
				phrase[0].add(new Note(chord[0].getRoot_note(), 2*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[1].getRoot_note(), 2*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[2].getRoot_note(), 2*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[3].getRoot_note(), 2*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			}

			phrase[1].add(new Note(chord[0].getFifth_note(), 2*EIGHTH_NOTE_TRIPLET));
			phrase[1].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			phrase[1].add(new Note(chord[1].getFifth_note(), 2*EIGHTH_NOTE_TRIPLET));
			phrase[1].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			phrase[1].add(new Note(chord[2].getFifth_note(), 2*EIGHTH_NOTE_TRIPLET));
			phrase[1].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			phrase[1].add(new Note(chord[3].getFifth_note(), 2*EIGHTH_NOTE_TRIPLET));
			phrase[1].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			
			phrase[2].add(new Note(chord[0].getComplement_note(), 2*EIGHTH_NOTE_TRIPLET));
			phrase[2].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			phrase[2].add(new Note(chord[1].getComplement_note(), 2*EIGHTH_NOTE_TRIPLET));
			phrase[2].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			phrase[2].add(new Note(chord[2].getComplement_note(), 2*EIGHTH_NOTE_TRIPLET));
			phrase[2].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			phrase[2].add(new Note(chord[3].getComplement_note(), 2*EIGHTH_NOTE_TRIPLET));
			phrase[2].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			
			phrase[3].add(new Note(chord[0].getAdded_note(), 2*EIGHTH_NOTE_TRIPLET));
			phrase[3].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			phrase[3].add(new Note(chord[1].getAdded_note(), 2*EIGHTH_NOTE_TRIPLET));
			phrase[3].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			phrase[3].add(new Note(chord[2].getAdded_note(), 2*EIGHTH_NOTE_TRIPLET));
			phrase[3].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			phrase[3].add(new Note(chord[3].getAdded_note(), 2*EIGHTH_NOTE_TRIPLET));
			phrase[3].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			
			phrase[4].add(new Note(chord[0].getThird_note() + 12, 2*EIGHTH_NOTE_TRIPLET));
			phrase[4].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			phrase[4].add(new Note(chord[1].getThird_note() + 12, 2*EIGHTH_NOTE_TRIPLET));
			phrase[4].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			phrase[4].add(new Note(chord[2].getThird_note() + 12, 2*EIGHTH_NOTE_TRIPLET));
			phrase[4].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			phrase[4].add(new Note(chord[3].getThird_note() + 12, 2*EIGHTH_NOTE_TRIPLET));
			phrase[4].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			
			break;
		}
		
		Measure measure = new Measure();
		measure.setPhrase(phrase);
		
		return measure;

	}

}
