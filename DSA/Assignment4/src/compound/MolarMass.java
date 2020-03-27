package compound;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to calculate MolarMass
 *
 */
public class MolarMass {
	private static Map<Character, Integer> atomicMasses;

	/**
	 * Storing atomic masses of basic atoms
	 */
	static {
		atomicMasses = new HashMap<Character, Integer>();
		atomicMasses.put('C', 12);
		atomicMasses.put('O', 16);
		atomicMasses.put('H', 1);
	}

	/**
	 * Function to calculate molar mass of compound
	 * @param compound a string of compound of only C, H and O
	 * @return
	 * @throws Exception if compound is null or invalid
	 */
	public static int calculateMolarMass(String compound) throws Exception {
		if (compound == null) {
			throw new Exception("Null compound!");
		}
		int molarMass = 0;
		for (int i = 0; i < compound.length(); i++) {
			Integer atomicMass = 0;
			if (compound.charAt(i) == '(') {
				i++;
				int openedBrackets = 0;
				StringBuilder molecule = new StringBuilder();
				while (i < compound.length() && !(compound.charAt(i) == ')' && openedBrackets == 0)) {
					if(compound.charAt(i) == '(') {
						openedBrackets++;
					} else if(compound.charAt(i) == ')') {
						openedBrackets--;
					}
					molecule.append(compound.charAt(i++));
				}
				if(i == compound.length()) {
					throw new Exception("Invalid compound!");
				}
				atomicMass = calculateMolarMass(molecule.toString());
			} else {
				atomicMass = atomicMasses.get(compound.charAt(i));
				if(atomicMass == null) {
					throw new Exception("Invalid compound!");
				}
			}
			int moleculeCount = 1;
			StringBuilder countString = new StringBuilder();
			
			while(i+1 < compound.length() && Character.isDigit(compound.charAt(i+1))) {
				countString.append(compound.charAt(++i));
			}
			if(countString.length() > 0) {
				moleculeCount = Integer.parseInt(countString.toString());
			}
			
			molarMass += atomicMass * moleculeCount;
		}
		return molarMass;
	}
}
