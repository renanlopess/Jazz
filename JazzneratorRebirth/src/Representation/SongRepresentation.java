package Representation;

public class SongRepresentation {
	private String title;
	private Key key;
	private PartRepresentation[] parts;
	private int[] partOrder;
	
	public SongRepresentation(String title){
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public PartRepresentation[] getParts() {
		return parts;
	}

	public void setParts(PartRepresentation[] parts) {
		this.parts = parts;
	}

	public int[] getPartOrder() {
		return partOrder;
	}

	public void setPartOrder(int[] partOrder) {
		this.partOrder = partOrder;
	}
}
