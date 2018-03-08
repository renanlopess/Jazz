import jm.JMC;
import jm.music.data.Part;

public class Instrumentalist implements JMC, MusicTheory{
	private Part part;
	private Pattern pattern[];
	
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	public Pattern[] getPattern() {
		return pattern;
	}
	public void setPattern(Pattern pattern[]) {
		this.pattern = pattern;
	}
}
