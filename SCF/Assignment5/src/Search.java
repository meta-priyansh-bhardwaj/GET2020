/*
 * Design a class “Search” to search for an element in an array using 
 * following strategy
 * Linear Search
 * Binary Search
 * Each of the above methods will receive an array and an element to be search
 * in array as input. It will return the index where this element occurs 
 * in array. Assume array to be sorted for Binary search.
 * @author Priyansh
 */
public class Search {
	/*
	 * @param arr is the integer array in which search has to be carried out
	 * 
	 * @param element is the element to be searched
	 * 
	 * @return returns index of the key if it is present in the array else
	 * returns -1
	 */
	public static int LinearSearch(int arr[], int element) throws Exception {
		if (arr.length == 0) {
			throw new Exception("Empty Array");
		}
		LinearSearchUtil(arr, 0, element);
		return -1;
	}
	
	/*
	 * @param index is the start index of array
	 * 
	 * @param element is the element to be searched
	 */
	private static int LinearSearchUtil(int arr[], int index, int element){
		if(index>=arr.length){
			return -1;
		}
		else if(arr[index]==element){
			return index;
		}
		return LinearSearchUtil(arr, index+1, element);
	}

	/*
	 * @param arr is the integer array in which search has to be carried out
	 * @param element is the element to be searched
	 * @return returns index of the key if it is present in the array else
	 * returns -1
	 */
	public static int BinarySearch(int arr[], int element) throws Exception{
		if(arr.length==0){
			throw new Exception("Empty Array");
		}
		return BinarySearchUtil(arr, element, 0, arr.length);
	}

	/**
	 * 
	 * @param arr is the integer array in which search has to be carried out
	 * @param element is the element to be searched
	 * @param low is the index of subarray to be searched
	 * @param high is the index of subarray to be searched
	 * @return returns index of the key if it is present in the array else
	 */
	private static int BinarySearchUtil(int arr[], int element, int low,
			int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high);
		if (arr[mid] == element) {
			return mid;
		} else if (arr[mid] > element) {
			return BinarySearchUtil(arr, element, low, mid - 1);
		} else {
			return BinarySearchUtil(arr, element, mid + 1, high);
		}
	}
};