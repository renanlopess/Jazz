package Tests;

import Representation.Key;

public class TestKey {

	public TestKey(){
		System.out.println("------------------------");
		System.out.println("Testing Key class ...");
		Key key = new Key(60, "minor");
		System.out.println("Pitch: " + key.getKey_note());
		System.out.println("Quality: " + key.getQuality());
		System.out.println("------------------------");
	}
	
}
