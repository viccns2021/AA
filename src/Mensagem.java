import java.util.ArrayList;
import java.util.List;

public class Mensagem {

	String res;
	boolean achou = false;

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

	public Boolean subsetSumExponential(
			ArrayList<Integer> set,
			ArrayList<Integer> recursiveList,
			int sum,
			int bucket
	) {
		if (set.size() > 0 && !achou) {
			int actual = set.get(0);

			if (actual + bucket == sum) {
				set.add(actual);
				achou = true;
			} else if (bucket + actual < sum) {
				ArrayList<Integer> set1 = new ArrayList<>(set);
				ArrayList<Integer> set2 = new ArrayList<>(set);

				set1.add(actual);
				set.remove(0);

				subsetSumExponential(set, set1, sum, bucket + actual);
				subsetSumExponential(set, set2, sum, bucket);
			}
		}
		return false;
	}

	public boolean subsetSumDynamic(ArrayList<Integer> set, int size, int sum) {
	   boolean [][] subset = new boolean[set.size()+1][sum+1];

	   for (int i=0;i<=set.size();i++){
		   subset[i][0] = true;
	   }

		for (int i=1;i<=sum;i++){
			subset[0][i] = false;
		}

		for (int i=1;i<=set.size();i++){
			for(int j=1; j<=sum; j++){
				if (j<set.get(i-1) ) {
					subset[i][j] = subset[i-1][j];
				}
				if (j >= set.get(i-1)) {
					subset[i][j] =
							(subset[i-1][j] || subset[i-1][j-set.get(i-1)]);
				}
			}
		}

		return subset[size][sum];
	}

	Mensagem () {
	    	
	        int [] arr = new int [] {17, 25, 46, 94, 201, 400};
	        int value = arr.length;
	        int sum = 272;
	        
	        //this.sum = sr.inf;
	        //System.out.println(subsetSum(arr, value, this.sum));
	        this.res = subsetSum(arr, value, sum).toString();
		}
}
