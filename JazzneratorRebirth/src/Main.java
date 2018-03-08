import Representation.ChordRepresentation;
import Representation.Key;
import Representation.MeasureRepresentation;
import Representation.SongRepresentation;
import jm.JMC;
import jm.music.data.Score;
import jm.util.Play;
import Representation.PartRepresentation;

public class Main implements JMC{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SongRepresentation blueBossa =  new SongRepresentation("Blue Bossa");
		Key key = new Key(48, "minor");
		ChordRepresentation cm7 = new ChordRepresentation(0, 8, "m7", false, 0, 0, 0);
		ChordRepresentation fm6 = new ChordRepresentation(0, 4, "m6", false, 0, 0, 0);
		ChordRepresentation dm7b5 = new ChordRepresentation(0, 2, "m7", true, 0, 0, 0);
		ChordRepresentation g7 = new ChordRepresentation(0, 5, "7", false, 0, 0, 0);
		ChordRepresentation cm6 = new ChordRepresentation(0, 1, "m6", false, 0, 0, 0);
		ChordRepresentation cm6_ = new ChordRepresentation(0, 8, "m6", false, 0, 0, 0);
		ChordRepresentation dm7 = new ChordRepresentation(0, 2, "m7", false, 0, 0, 0);
		ChordRepresentation c7m = new ChordRepresentation(0, 1, "7M", false, 0, 0, 0);
		
		MeasureRepresentation measure1_1 = new MeasureRepresentation(cm7);	
		MeasureRepresentation measure1_2 = new MeasureRepresentation(fm6);
		MeasureRepresentation measure2_1 = new MeasureRepresentation(dm7b5);	
		MeasureRepresentation measure2_2 = new MeasureRepresentation(g7);
		MeasureRepresentation measure2_3 = new MeasureRepresentation(cm6);
		MeasureRepresentation measure3_3 = new MeasureRepresentation(cm6_);
		MeasureRepresentation measure3_4 = new MeasureRepresentation(dm7b5, g7);
		MeasureRepresentation measure4_1 = new MeasureRepresentation(dm7);
		MeasureRepresentation measure4_2 = new MeasureRepresentation(g7);
		MeasureRepresentation measure4_3 = new MeasureRepresentation(c7m);
		
		PartRepresentation a1 = new PartRepresentation("a", 1, 0, new MeasureRepresentation[]{measure1_1, measure1_1
				, measure1_2, measure1_2});
		PartRepresentation b1 = new PartRepresentation("b", 1, 0, new MeasureRepresentation[]{measure2_1, measure2_2
				, measure2_3, measure2_3});
		PartRepresentation b2 = new PartRepresentation("b", 2, 0, new MeasureRepresentation[]{measure2_1, measure2_2
				, measure3_3, measure3_4});
		PartRepresentation c1 = new PartRepresentation("c", 1, 1, new MeasureRepresentation[]{measure4_1, measure4_2
				, measure4_3, measure4_3});
		PartRepresentation[] parts = new PartRepresentation[]{a1, b1, b2, c1};
		
		blueBossa.setKey(key);
		blueBossa.setParts(parts);
		blueBossa.setPartOrder(new int[]{0, 1, 3, 2, 0, 1, 3, 2});
		
		GuitarPlayer guitarPlayer = new GuitarPlayer(blueBossa, new Pattern[]{new JazzGuitarPattern01(),
				new JazzGuitarPattern02()});
		BassPlayer bassPlayer = new BassPlayer(blueBossa, new Pattern[]{new JazzBassPattern01(),
				new JazzBassPattern02()});
		
		Score song = new Score();
		song.addPart(guitarPlayer.getPart());
		song.addPart(bassPlayer.getPart());
		song.setTempo(120);
		Play.midi(song);
		
		//new TestChord();
		
	}

}
