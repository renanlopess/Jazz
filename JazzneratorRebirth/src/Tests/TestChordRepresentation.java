package Tests;

import Representation.ChordRepresentation;

public class TestChordRepresentation implements Translator{

	public TestChordRepresentation(){
		System.out.println("------------------------");
		System.out.println("Testing ChordRepresentation class ...");
		ChordRepresentation representation = new ChordRepresentation(0, 2, "7sus4", true, 13, 5, 2);
		String chordName = "";
		
		chordName = "" + Translator.toRomanAlgarism(representation.getScale_degree());
		
		chordName = chordName + representation.getComplement();
		
		if(representation.isB5() == true){
			chordName = chordName + "b5";
		}
		
		if(representation.getAdded_note() > 0){
			chordName = chordName + new String( "+" + representation.getAdded_note());
		}
		
		if(representation.getBass_note() > 0){
			chordName = chordName + "/" +  Translator.toRomanAlgarism(representation.getBass_note());
		}
		
		if(representation.getInversion() > 0){
			chordName = chordName + " " + representation.getInversion() + "rd inversion";
		}
		
		System.out.println(chordName);
		System.out.println("------------------------");
	}
}
