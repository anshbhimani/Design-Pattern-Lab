import java.util.ArrayList;
import java.util.List;

interface MathProcessing
{
	public void performMathOperation(String type,Integer[] data);
}
		
class AdvancedMathProcessing{
	public void calculateAvarage(List<Integer> ls)
	{
		int result = 0;
		for(int i = 0 ; i < ls.size() ; i++){
			result += ls.get(i);
		}
		
		System.out.println("Your Average of array is: "+(result /= ls.size()));
	}
	
	public void sortData(List<Integer> ls)
	{

		System.out.println("List Before Sorting");
		System.out.println("-----------------------------------------------");
		printList(ls);
		
		for(int i = 0 ; i < ls.size() ; i++){
			for(int j = 0; j <= i ; j++){
				if(ls.get(i) < ls.get(j)){
					
					int temp = ls.get(i);
					ls.set(i, ls.get(j));
					ls.set(j, temp);
					
				}
			}
		}
		
		System.out.println("\nList After Sorting");
		System.out.println("-----------------------------------------------");
		printList(ls);
		
	}
	
	public void searchData(List<Integer> ls,int value)
	{
		boolean IsFounded = false;
		for(int i = 0 ; i <= ls.size() ; i++){
			if(value == ls.get(i)){
				IsFounded = true;
				break;
			}
		}
		
		if(IsFounded){			
			System.out.println("Element Founded!!");
		}else{
			System.out.println("Element Not Found!!");
		}
	}
	
	public void replace(List<Integer> ls,int key,int value)
	{
		for(int i = 0 ; i < ls.size() ; i++){
			if(key == ls.get(i)){
				ls.set(i, value);
			}
		}
	}
	
	private void printList(List<Integer> ls){ 
		for(int i = 0 ; i < ls.size() ; i++){
			System.out.println("Element "+(i+1)+") = "+ls.get(i));
		}
	}
}

class MathDataAdapter implements MathProcessing {

	private AdvancedMathProcessing amp = new AdvancedMathProcessing();
	@Override
	public void performMathOperation(String type, Integer[] data) {
		
		if(type.equalsIgnoreCase("average")){
			amp.calculateAvarage(ArrayToListConverter(data));
		}
		else if(type.equalsIgnoreCase("plus")){
			int result = 0;
			for(int i = 0 ; i < data.length ; i++){
				result += data[i];
			}
			System.out.println("Total Addition is: "+result);
		}
		else if(type.equalsIgnoreCase("multiply")){
			long result = 1;
			for(int i = 0 ; i < data.length ; i++){
				result *= data[i];
			}
			System.out.println("Total Multiplicatio is: "+result);
		}
		else if(type.equalsIgnoreCase("search")){
			amp.searchData(ArrayToListConverter(data), 42);
		}
		else if(type.equalsIgnoreCase("sort")){
			amp.sortData(ArrayToListConverter(data));
		}
		else if(type.equalsIgnoreCase("replace")){
			amp.replace(ArrayToListConverter(data), 32,43);
		}
	}
	
	private List<Integer> ArrayToListConverter(Integer[] arr){
		List<Integer> ls = new ArrayList<Integer>();
		for(int i = 0 ; i < arr.length ; i++ ){
			ls.add(arr[i]);
		}
		return ls;
		
	}
}

public class AdapterPatern {

	public static void main(String[] args) {

		MathDataAdapter mda = new MathDataAdapter();
		Integer[] arr = {23,6,26,4,26,12,86,22,54};
		
		mda.performMathOperation("sort", arr);
		mda.performMathOperation("plus", arr);
		mda.performMathOperation("multiply", arr);
		
	}

}
