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
	private static final int capacity = 1001, lowerBound = 1,
			upperBound = 1000;
	private final Boolean[] set;
	private int size;

	public Set() {
		size = 0;
		set = new Boolean[capacity];
		for (int i = 0; i < capacity; i++) {
			set[i] = false;
		}
	}

	public Set(int[] arr) throws Exception {
		this();
		for (int a : arr) {
			if (a < lowerBound || a > upperBound) {
				throw new Exception("Value out of range");
			}
			if (!set[a]) {
				size++;
				set[a] = true;
			}
		}
	}
	
	/**
	 * @param x element to be checked in set
	 * @return true if element is present on set else return false
	 */
	public Boolean isMember(int x) throws Exception {
		if (x < lowerBound || x > upperBound) {
			throw new Exception("Value is out of range");
		}
		return set[x];
	}
	
	/**
	 * @return size of the set
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @param SET s is the object to check the subset 
	 * @return true if it is a subset else false
	 */
	public Boolean isSubSet(Set s) throws Exception {
		for (int i = lowerBound; i <= upperBound; i++) {
			if (s.isMember(i) && !this.isMember(i)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @return Complement of a set
	 */
	public Set getComplement() throws Exception {
		int size = capacity - this.size;
		int[] complementArr = new int[size];
		for (int i = lowerBound, iterator = 0; i <= upperBound
				&& iterator < size; i++) {
			if (!this.isMember(i)) {
				complementArr[iterator++] = i;
			}
		}
		return new Set(complementArr);
	}
	
	/**
	 * @param s is a set of some number
	 * @return return union of this and s
	 */
	public Set union(Set s) throws Exception {
		int size = s.size() + this.size();
		int arr[] = new int[size];
		for (int i = lowerBound, iterator = 0; i <= upperBound; i++) {
			if (s.isMember(i)) {
				arr[iterator++] = i;
			}
			if (this.isMember(i)) {
				arr[iterator++] = i;
			}
		}
		return new Set(arr);
	}
	
	public Boolean equals(Set s) {
		for (int i = lowerBound; i < upperBound; i++) {
			if (this.set[i] != s.set[i]) {
				return false;
			}
		}
		return true;
	}
}
