import Representation.Key;
import Representation.MeasureRepresentation;
import Representation.PartRepresentation;
import Representation.SongRepresentation;
import jm.music.data.Part;
import jm.music.tools.Mod;

public class BassPlayer  extends Instrumentalist{

	public BassPlayer(SongRepresentation song, Pattern pattern[]){
		setPattern(pattern);
		
		/*If the parts are added as a vector they will play in parallel.
		In order to the parts to play in sequence, you have to first create
		a part, then the next one and use the mod.append() to link then.
		*/
		setPart(buildPart(song.getKey(), song.getParts()[0]));
		for(int i = 1; i < song.getPartOrder().length; i++){
			Mod.append(getPart(), buildPart(song.getKey(), song.getParts()[song.getPartOrder()[i]]));
		}
	}
	
	private Part buildPart(Key key, PartRepresentation partRepresentation){
		// Create part with bass guitar sound(33) that plays on channel one(2);
		Part part1 = new Part(BASS, 2);
			
		/*As the parts, if the phrases are added as a vector they will play in parallel.
		In order to the phrases to play in sequence, you have to first create a phrase, 
		then the next one and use the mod.append() to link then.
		*/
		part1.addPhraseList(buildPhrase(key, partRepresentation.getModulation_value(),
				partRepresentation.getMeasures()[0], 0).getPhrase());
		for(int i = 1; i < partRepresentation.getMeasures().length; i++){
		
			Part part2 = new Part(BASS, 2);
			
			part2.addPhraseList(buildPhrase(key, partRepresentation.getModulation_value(),
				partRepresentation.getMeasures()[i], i).getPhrase());
			
			Mod.append(part1, part2);
		}
	
		//Applying the modulation indicated in the piece
		Mod.transpose(part1, partRepresentation.getModulation_value());
		
		return part1;
	}
	
	private Measure buildPhrase(Key key, int modulation_degree, 
			MeasureRepresentation measureRepresentation, int pattern_count){
		
		Measure measure = new Measure();
		Chord[] chords = new Chord[measureRepresentation.getChords().length];
		
		/*Consults the 'MusicTheory' interface to build the chord indicated in the
		song representation.
		*/
		for(int i = 0; i < chords.length; i++){
			chords[i] = MusicTheory.buildChord(key, measureRepresentation.getChords()[i]);
		}
		
		//Cycling the patterns
		while(pattern_count > getPattern().length-1){
			pattern_count = pattern_count - getPattern().length;
		}
		
		measure = getPattern()[pattern_count].buildMeasure(chords);
		
		return measure;
	}
	
	
}
