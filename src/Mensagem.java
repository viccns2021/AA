import java.util.ArrayList;
import java.util.List;

public class Mensagem{

	String res;

	    public static List<Integer> subsetSum(int arr[], int size, int sum) {
	    	
	    	
	    	
	        ArrayList<Integer> subset = new ArrayList<>();
	        for(int i = size-1; i >= 0; i--) {
	            if(sum < arr[i]) {
	                arr[i] = -1;
	            } else {
	                sum -= arr[i];
	            }
	        }

	        for(int j=0; j<size;j++){
	            if(arr[j] != -1){
	                subset.add(arr[j]);
	            }
	        }

	        return subset;
	    }

	     Mensagem () {
	    	
	        int [] arr = new int [] {17, 25, 46, 94, 201, 400};
	        int value = arr.length;
	        int sum = 272;
	        
	        //this.sum = sr.inf;
	        //System.out.println(subsetSum(arr, value, this.sum));
	        this.res = subsetSum(arr, value, sum).toString();
	        
	     	}}