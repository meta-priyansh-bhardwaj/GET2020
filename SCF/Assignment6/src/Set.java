/**
 * Implement the immutable class intSet using an array to represent a set of
 * integers in the range 1-1000. It should support public methods like -
 * 
 * isMember(int x) - check whether x is a member of the set and return a boolean
 * value
 * 
 * size() - return the size of the set
 * 
 * isSubSet(intSet s) - check whether s is a subset of the set
 * 
 * getComplement() - return the complement set, you can assume that 1..1000 is
 * the universal set
 * 
 * union(intSet s1, intSet s2) - return the union of s1 and s2
 * 
 * You may use private helper methods.
 * 
 * 
 * @author Priyansh
 *
 */
public class Set {
	private static final int CAPACITY = 1001, LOWERBOUND = 1,
			UPPERBOUND = 1000;
	private final Boolean[] set;
	private int size;

	/**
	 * Default Contructor
	 */
	public Set() {
		size = 0;
		set = new Boolean[CAPACITY];
		for (int i = 0; i < CAPACITY; i++) {
			set[i] = false;
		}
	}

	/**
	 * Constructor to initialize the set 
	 * @param arr
	 * @throws Exception
	 */
	public Set(int[] arr) throws Exception {
		this();
		for (int a : arr) {
			if (a < LOWERBOUND || a > UPPERBOUND) {
				throw new Exception("Value out of range");
			}
			if (!set[a]) {
				size++;
				set[a] = true;
			}
		}
	}
	
	/**
	 * To check if given element is the member of the set
	 * @param x element to be checked in set
	 * @return true if element is present on set else return false
	 */
	public Boolean isMember(int x) throws Exception {
		if (x < LOWERBOUND || x > UPPERBOUND) {
			throw new Exception("Value is out of range");
		}
		return set[x];
	}
	
	/**
	 * TO get size of the set
	 * @return size of the set
	 */
	public int size() {
		return size;
	}
	
	/**
	 * To check if given set is subset of the set
	 * @param SET s is the object to check the subset 
	 * @return true if it is a subset else false
	 */
	public Boolean isSubSet(Set s) throws Exception {
		for (int i = LOWERBOUND; i <= UPPERBOUND; i++) {
			if (s.isMember(i) && !this.isMember(i)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * To get complement of the set
	 * @return Complement of a set
	 */
	public Set getComplement() throws Exception {
		int size = CAPACITY - this.size;
		int[] complementArr = new int[size];
		for (int i = LOWERBOUND, iterator = 0; i <= UPPERBOUND
				&& iterator < size; i++) {
			if (!this.isMember(i)) {
				complementArr[iterator++] = i;
			}
		}
		return new Set(complementArr);
	}
	
	/**
	 * To get union of two sets
	 * @param s is a set of some number
	 * @return return union of this and s
	 */
	public Set union(Set s) throws Exception {
		int size = s.size() + this.size();
		int arr[] = new int[size];
		for (int i = LOWERBOUND, iterator = 0; i <= UPPERBOUND; i++) {
			if (s.isMember(i)) {
				arr[iterator++] = i;
			}
			if (this.isMember(i)) {
				arr[iterator++] = i;
			}
		}
		return new Set(arr);
	}
	
	/**
	 * To check if given set is equal to the set
	 * @param s if another Set
	 * @return true if they are equal or false otherwise
	 */
	public Boolean equals(Set s) {
		for (int i = LOWERBOUND; i < UPPERBOUND; i++) {
			if (this.set[i] != s.set[i]) {
				return false;
			}
		}
		return true;
	}
}
