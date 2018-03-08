

import Representation.ChordRepresentation;
import Representation.Key;
import Tests.Translator;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;

public class TestChord implements MusicTheory{

	public TestChord(){
		System.out.println("------------------------");
		System.out.println("Testing Chord class ...");
		ChordRepresentation representation = new ChordRepresentation(0, 1, "7M", false, 0, 0, 0);
		Key key = new Key(60, "major");
		Chord chord = MusicTheory.buildChord(key, representation);
		Phrase[] phrase = new Phrase[5];
		for(int i = 0; i < phrase.length; i++){
			phrase[i] = new Phrase(0.0);
		}
		phrase[0].add(new Note(chord.getRoot_note(), 4));
		phrase[1].add(new Note(chord.getThird_note(), 4));
		phrase[2].add(new Note(chord.getFifth_note(), 4));
		phrase[3].add(new Note(chord.getComplement_note(), 4));
		phrase[4].add(new Note(chord.getAdded_note(), 4));
		
		Part part = new Part();
		
		part.addPhraseList(phrase);
		
		Score score = new Score();
		
		score.add(part);
		Play.midi(score);
		
		System.out.println(chord.getBass_note());
		System.out.println(chord.getRoot_note());
		System.out.println(chord.getThird_note());
		System.out.println(chord.getFifth_note());
		System.out.println(chord.getComplement_note());
		System.out.println(chord.getAdded_note());
		System.out.println("------------------------");
	}
	
	
}
