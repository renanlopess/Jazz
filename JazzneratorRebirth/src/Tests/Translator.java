package Tests;

public interface Translator {
	
	public static String toRomanAlgarism(int num){
		String result = "";
		
		if(num < 10){
			for(int i = 1; i <= num; i++){
				result = result + "I";
				if(i == 4){
					result = "IV";	
				}else if(i == 5){
					result = "V";
				}else if(num == 9){
					result = "IX";
				}
			}
			
		}else if(num < 100){
			int decimal = (Integer)(num/10);
			int singular = num - (decimal*10);
			String string_1 = "";
			String string_2 = "";
			for(int i = 1; i <= decimal; i++){
				string_1 = string_1 + "X";
			}
			for(int i = 1; i <= singular; i++){
				string_2 = string_2 + "I";
				if(i == 4){
					string_2 = "IV";
				}else if(i == 5){
					string_2 = "V";
				}else if(num == 9){
					string_2 = "IX";
				}
			}
			result = string_1 + string_2;
		}
		
		return result;
	}
	
	public static String toNote(int num){
		int a = num/12;
		int b = 12*a;
		int c = num-b;
		String[] notes = new String[]{"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
		
		return notes[c];
	}

}
