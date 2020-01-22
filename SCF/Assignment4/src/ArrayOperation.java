/*
 * Design a class ArrOperation which should support following methods.
 *  Assume each method will receive an array of positive integers.
 *  
 *  
*/

public class ArrayOperation{
	
	/*
	 * @param arr is an array of positive numbers in which mirror sub array has to be found out
	 * @return returns the maximum length of mirror found in the given array
	 */
	public static int maxMirror(int[] arr) throws Exception{
		if(arr.length==0){
			throw new Exception("Empty Array");
		}
		int maxLength = 0;
		for(int i=0;i<arr.length;i++){
			for(int j=arr.length-1,length=0;j>i;j--){
				int left=i, right=j;
				while(left<=j && arr[left]==arr[right]){
					length++;
					left++;
					right--;
				}
				if(length>1 && maxLength<length){
					maxLength = length;
				}
			}
		}
		return maxLength;
	}
	
	/*
	 * @param arr is an array of positive integer in which no. of clumps are to be found
	 * @return returns total number of clumps
	 */
	public static int countClumps(int[] arr) throws Exception{
		if(arr.length==0){
			throw new Exception("Empty Array");
		}
		int countClumps = 0;
		
		Boolean newAppearence = true;
		for(int i=1;i<arr.length;i++){
			if(newAppearence){
				if(arr[i]==arr[i-1]){
					countClumps++;
					newAppearence=false;
				}
			}
			else{
				if(arr[i]!=arr[i-1]){
					newAppearence=true;
				}
			}
		}
		return countClumps;
	}
	
	/*
	 * @param arr is the array in which value of x and y are to be fixed
	 * @param X and @param Y are two positive integers present in array
	 * @return returns an array by fixing position of X and Y such that every X is followed by Y
	 */
	public static int[] fixXY(int arr[], int X, int Y) throws Exception{
		if(arr.length==0){
			throw new Exception("Empty Array");
		}
		else if(arr[arr.length-1]==X){
			throw new Exception("X present at last");
		}
		int countX=0, countY=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==X){
				if(i>0 && arr[i-1]==X){
					throw new Exception("Two X's are adjascent");
				}
				countX++;
			}
			else if(arr[i]==Y){
				countY++;
			}
		}
		if(countX!=countY){
			throw new Exception("X's and Y's are not equal in number");
		}
		int inputIndex = 0;
		int result[] = new int[arr.length];
		
		for(int i=0;i<arr.length;i++){
			if(arr[i]==X){
				result[i] = X;
				result[++i] = Y;
			}
			else{
				while(arr[inputIndex]==X || arr[inputIndex]==Y){
					inputIndex++;
				}
				result[i] = arr[inputIndex++];
			}
		}
		return result;
	}
	
	/*
	 * @param a is an array of positive integer whose split index has to be found out such that the splitted array have eqaul sum  
	 * @return returns split index and -1 in case array can't be splitted
	 */
	public static int splitArray(int arr[]) throws Exception{
		if(arr.length==0){
			throw new Exception("Empty Array");
		}
		int cumulativeArr[] = new int[arr.length];
		cumulativeArr[0] = arr[0];
		for(int i=1;i<arr.length;i++){
			cumulativeArr[i] = cumulativeArr[i-1]+arr[i];
		}
		int sum = cumulativeArr[arr.length-1];
		for(int i=0;i<arr.length;i++){
			if(cumulativeArr[i]==sum-cumulativeArr[i]){
				return i+1;
			}
		}
		return -1;
	}
}