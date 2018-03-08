package lab;

import java.util.ArrayList;

import Utils.Randomizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Segment II_V_I = new Segment("|II|V|I", false, 0, 3, new int[][]{{2},{5},{1}});
		Segment II_VpI = new Segment("|II|V-I", false, 0, 2, new int[][]{{2},{5, 1}});
		Segment IIpV_I = new Segment("|II-V|I", false, 0, 2, new int[][]{{2, 5},{1}});
		Segment II_V = new Segment("|II|V", false, 0, 2, new int[][]{{2},{5}});
		Segment IIpV = new Segment("|II-V", false, 0, 1, new int[][]{{2, 5}});
		Segment V_I = new Segment("|V|I", false, 0, 2, new int[][]{{5},{1}});
		Segment VpI = new Segment("|V-I", false, 0, 1, new int[][]{{5,1}});
		Segment I = new Segment("|I", false, 0, 1, new int[][]{{1}});
		Segment IV = new Segment("|IV", false, 0, 1, new int[][]{{4}});
		Segment mhalf = new Segment("(M+0,5)", true, 1, 0, null);
		Segment mwhole = new Segment("(M+1)", true, 2, 0, null);
		Segment m3rd = new Segment("(M+3rd)", true, 3, 0, null);
		Segment mp5 = new Segment("(M+p5)", true, 7, 0, null);
		Segment mRoot = new Segment("(MROOT)", true, 0, 0, null);
		
		ArrayList<Segment> segments = new ArrayList<Segment>();
		segments.add(II_V_I);
		segments.add(II_VpI);
		segments.add(IIpV_I);
		segments.add(II_V);
		segments.add(IIpV);
		segments.add(V_I);
		segments.add(VpI);
		segments.add(I);
		segments.add(IV);
		segments.add(mhalf);
		segments.add(mwhole);
		segments.add(m3rd);
		segments.add(mp5);
		segments.add(mRoot);
		
		ArrayList<Segment> part = new ArrayList<Segment>();
		part = buildPart(segments, 4);
		for(int i = 0; i<part.size(); i++){
			System.out.print(part.get(i).getName());
		}
		System.out.println("\n" + getVarietyValue(part));
		
		part = buildPart(part, segments, 8);
		for(int i = 0; i<part.size(); i++){
			System.out.print(part.get(i).getName());
		}
		System.out.println("\n" + getVarietyValue(part));
		
	}
	public static ArrayList<Segment> buildPart(ArrayList<Segment> otherParts, ArrayList<Segment> segments, int variety){
		ArrayList<Segment> result = new ArrayList<Segment>();
		//Choose a sub
		result.add(new Segment("(MROOT)", true, 0, 0, null));
		
		int maxSize = 4;
		int currentSize = 0;
		
		
		ArrayList<Segment> filteredSegments = new ArrayList<Segment>();
		currentSize = 0;
		while(currentSize < maxSize){
			filteredSegments = new ArrayList<Segment>(segments);
			//Filter by size
			for(int i = 0; i < filteredSegments.size(); i++){
				if(filteredSegments.get(i).getSize() + currentSize > maxSize){
					filteredSegments.remove(i);
					i--;
				}
			}
			
			ArrayList<Segment> for_global_simulation = new ArrayList<Segment>();
			for_global_simulation.addAll(otherParts);
			for_global_simulation.addAll(result);
			//Avoid going lower than variety number
			for(int i = 0; i < filteredSegments.size(); i++){
				if(simulateVariety(for_global_simulation, filteredSegments.get(i))
						+((maxSize - (currentSize + filteredSegments.get(i).getSize()))*2)
					 	< variety){
					filteredSegments.remove(i);
					i--;
				}
			}
			
			//Avoid going over variety number
			if(getVarietyValue(for_global_simulation) == variety){
				for(int i = 0; i < filteredSegments.size(); i++){
					if(filteredSegments.get(i).isModulation()){
						filteredSegments.remove(filteredSegments.get(i));
						i--;
					}
				}
			}
			
			for(int i = 0; i < filteredSegments.size(); i++){
				if(simulateVariety(for_global_simulation, filteredSegments.get(i)) > variety){
					filteredSegments.remove(i);
					i--;
				}
			}
			
			
			result.add(filteredSegments.get(Randomizer.run(0, filteredSegments.size()-1)));
			
			//Avoiding consecutive modulations
			if(result.get(result.size()-1).isModulation() && result.get(result.size()-2).isModulation()){
				result.remove(result.size()-2);
			}
			
			currentSize = currentSize + result.get(result.size()-1).getSize();
		}
		
		return result;
	}
	
	public static ArrayList<Segment> buildPart(ArrayList<Segment> segments, int variety){
		ArrayList<Segment> result = new ArrayList<Segment>();
		//Choose a sub
		result.add(new Segment("(MROOT)", true, 0, 0, null));
		
		int maxSize = 4;
		int currentSize = 0;
		
		
		ArrayList<Segment> filteredSegments = new ArrayList<Segment>();
		currentSize = 0;
		while(currentSize < maxSize){
			filteredSegments = new ArrayList<Segment>(segments);
			//Filter by size
			for(int i = 0; i < filteredSegments.size(); i++){
				if(filteredSegments.get(i).getSize() + currentSize > maxSize){
					filteredSegments.remove(i);
					i--;
				}
			}
			
			
			//Avoid going lower than variety number
			for(int i = 0; i < filteredSegments.size(); i++){
				if(simulateVariety(result, filteredSegments.get(i))
						+((maxSize - (currentSize + filteredSegments.get(i).getSize()))*2)
					 	< variety){
					filteredSegments.remove(i);
					i--;
				}
			}
			
			//Avoid going over variety number
			if(getVarietyValue(result) == variety){
				for(int i = 0; i < filteredSegments.size(); i++){
					if(filteredSegments.get(i).isModulation()){
						filteredSegments.remove(filteredSegments.get(i));
						i--;
					}
				}
			}
			
			for(int i = 0; i < filteredSegments.size(); i++){
				if(simulateVariety(result, filteredSegments.get(i)) > variety){
					filteredSegments.remove(i);
					i--;
				}
			}
			
			
			result.add(filteredSegments.get(Randomizer.run(0, filteredSegments.size()-1)));
			
			//Avoiding consecutive modulations
			if(result.get(result.size()-1).isModulation() && result.get(result.size()-2).isModulation()){
				result.remove(result.size()-2);
			}
			
			currentSize = currentSize + result.get(result.size()-1).getSize();
		}
		
		return result;
	}
	
	public static int simulateVariety(ArrayList<Segment> segments, Segment segment){
		ArrayList<Segment> simulation = new ArrayList<Segment>();
		simulation.addAll(segments);
		simulation.add(segment);
		return getVarietyValue(simulation);
	}
	
	public static int getVarietyValue(ArrayList<Segment> segments){
		int modulation_value = 0;
		int current_id = 0;
		ArrayList<Integer> current_segment_ids = new ArrayList<Integer>();
		for(int i = 0; i < segments.size(); i++){
			if(segments.get(i).isModulation()){
				modulation_value = segments.get(i).getModulation_deegre();
			}else{
				for(int ii = 0; ii < segments.get(i).getIntervals().length; ii++){
					for(int iii = 0; iii < segments.get(i).getIntervals()[ii].length; iii++){
						current_id = segments.get(i).getIntervals()[ii][iii] + (modulation_value*10);
						if(current_segment_ids.contains(current_id) == false){
							current_segment_ids.add(current_id);
						}
					}	
				}
			}
		}
		
		return current_segment_ids.size();
	}

}
