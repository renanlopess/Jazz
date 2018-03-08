

public class NoteRepresentation {
	private int note_of_the_chord;
	private double duration;
	
	NoteRepresentation(int note_of_the_chord, double duration){
		this.note_of_the_chord = note_of_the_chord;
		this.duration = duration;
	}

	public int getNote_of_the_chord() {
		return note_of_the_chord;
	}

	public void setNote_of_the_chord(int note_of_the_chord) {
		this.note_of_the_chord = note_of_the_chord;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
}
