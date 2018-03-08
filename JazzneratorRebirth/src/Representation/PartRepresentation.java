package Representation;

public class PartRepresentation {
	private String id_letter;
	private int variation;
	private int modulation_value;
	private MeasureRepresentation[] measures;
	
	/* Example:
	 	The song Blue Bossa has 4 parts
	 	A1: i7 | i7 | iv6 | iv6 ||
	 	B1: ii7b5 | V7 | i6 | i6 ||
	 	B2: ii7b5 | V7 | i6 | ii7b5 - V7 ||
	 	C1: modulates up by 1 half-tone ii7 | V7 | I7M | I7M||
	 	
	 	The C1 part would be part_letter = "C", variation = 1, 
	 	and modulation_degree = 1(because this part raises the tone by 1 half-tone).
	 */
	
	public PartRepresentation(String part_letter, int variation, int modulation_degree, MeasureRepresentation[] parses){
		this.id_letter = part_letter;
		this.variation = variation;
		this.modulation_value = modulation_degree;
		this.measures = parses;
	}

	public String getId_letter() {
		return id_letter;
	}

	public void setId_letter(String id_letter) {
		this.id_letter = id_letter;
	}

	public int getVariation() {
		return variation;
	}

	public void setVariation(int variation) {
		this.variation = variation;
	}

	public int getModulation_value() {
		return modulation_value;
	}

	public void setModulation_value(int modulation_value) {
		this.modulation_value = modulation_value;
	}

	public MeasureRepresentation[] getMeasures() {
		return measures;
	}

	public void setMeasures(MeasureRepresentation[] measures) {
		this.measures = measures;
	}
	
	
}
