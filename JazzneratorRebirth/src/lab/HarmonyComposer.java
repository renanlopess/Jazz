package lab;

import java.util.ArrayList;

import Utils.Randomizer;

public class HarmonyComposer {
	
	public void ComposePart(int[] variety){
		
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
