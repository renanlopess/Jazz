import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.music.tools.Mod;

public class JazzBassPattern01 extends Pattern implements JMC{
	
	JazzBassPattern01(){
		
	}
	
	public Measure buildMeasure(Chord[] chord){
		Phrase[] phrase = new Phrase[1];
		
		for(int i = 0; i < phrase.length; i++){
			phrase[i] = new Phrase(0);
		}
		
		switch(chord.length){
		case 1:
			if(chord[0].getBass_note() > 0){
				phrase[0].add(new Note(chord[0].getBass_note(), 5*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[0].getBass_note() + 7, 5*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			}else{
				phrase[0].add(new Note(chord[0].getRoot_note(), 5*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[0].getFifth_note(), 5*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			}

			break;
		case 2:
			if(chord[0].getBass_note() > 0){
				phrase[0].add(new Note(chord[0].getBass_note(), 5*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[1].getBass_note(), 5*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			}else{
				phrase[0].add(new Note(chord[0].getRoot_note(), 5*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(chord[1].getRoot_note(), 5*EIGHTH_NOTE_TRIPLET));
				phrase[0].add(new Note(REST, EIGHTH_NOTE_TRIPLET));
			}
			
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

			break;
		}
		
		Mod.transpose(phrase[0], -12);
		Measure measure = new Measure();
		measure.setPhrase(phrase);
		
		return measure;

	}
}
