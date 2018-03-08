package lab;

public class Segment {
	private String name;
	private boolean modulation;
	private int modulation_deegre;
	private int size;
	private int[][] intervals;
	
	Segment(String name, boolean modulation, int modulation_deegre, int size, int[][] interval){
		this.name = name;
		this.modulation = modulation;
		this.modulation_deegre = modulation_deegre;
		this.size = size;
		this.intervals = interval;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isModulation() {
		return modulation;
	}

	public void setModulation(boolean modulation) {
		this.modulation = modulation;
	}

	public int getModulation_deegre() {
		return modulation_deegre;
	}

	public void setModulation_deegre(int modulation_deegre) {
		this.modulation_deegre = modulation_deegre;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[][] getIntervals() {
		return intervals;
	}

	public void setIntervals(int[][] intervals) {
		this.intervals = intervals;
	}

}
