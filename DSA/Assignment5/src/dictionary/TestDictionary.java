package dictionary;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

/**
 * Class to test dictionary
 *
 */
class TestDictionary {

	@Test
	void testDictionary1() {
		try {
			FileReader file = new FileReader("files/data.json");
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(file);
			Dictionary dictionary = new DictionaryImplementaton(json);
			
			assertTrue("twenty".contentEquals(dictionary.get("20")));
			assertTrue("thirty".contentEquals(dictionary.get("30")));
			assertTrue("fourty".contentEquals(dictionary.get("40")));
			assertTrue("fifty".contentEquals(dictionary.get("50")));
			assertTrue("sixty".contentEquals(dictionary.get("60")));
			assertTrue("seventy".contentEquals(dictionary.get("70")));
			assertTrue("eighty".contentEquals(dictionary.get("80")));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testDictionary2() {
		try {
			FileReader file = new FileReader("files/data.json");
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(file);
			Dictionary dictionary = new DictionaryImplementaton(json);
			
			List<Pair> expectedOrder = new ArrayList<Pair>();
			expectedOrder.add(new Pair("20", "twenty"));
			expectedOrder.add(new Pair("30", "thirty"));
			expectedOrder.add(new Pair("40", "fourty"));
			expectedOrder.add(new Pair("50", "fifty"));
			expectedOrder.add(new Pair("60", "sixty"));
			expectedOrder.add(new Pair("70", "seventy"));
			expectedOrder.add(new Pair("80", "eighty"));
			
			List<Pair> resultingOrder = dictionary.getAllPairs();
			
			assertTrue(expectedOrder.equals(resultingOrder));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	@Test
	void testDictionary3() {
		try {
			FileReader file = new FileReader("files/data.json");
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(file);
			Dictionary dictionary = new DictionaryImplementaton(json);
			
			List<Pair> expectedOrder = new ArrayList<Pair>();
			expectedOrder.add(new Pair("30", "thirty"));
			expectedOrder.add(new Pair("40", "fourty"));
			expectedOrder.add(new Pair("50", "fifty"));
			expectedOrder.add(new Pair("60", "sixty"));
			expectedOrder.add(new Pair("70", "seventy"));
			
			List<Pair> resultingOrder = dictionary.getPairsInRange("30", "70");
			
			assertTrue(expectedOrder.equals(resultingOrder));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	@Test
	void testDictionary4() {
		try {
			FileReader file = new FileReader("files/data.json");
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(file);
			Dictionary dictionary = new DictionaryImplementaton(json);
			
			assertTrue(dictionary.delete("20"));
			assertFalse(dictionary.delete("20"));
			assertTrue(dictionary.delete("50"));
			
			List<Pair> expectedOrder = new ArrayList<Pair>();
			expectedOrder.add(new Pair("30", "thirty"));
			expectedOrder.add(new Pair("40", "fourty"));
			expectedOrder.add(new Pair("60", "sixty"));
			expectedOrder.add(new Pair("70", "seventy"));
			expectedOrder.add(new Pair("80", "eighty"));

			List<Pair> resultingOrder = dictionary.getAllPairs();
			
			assertTrue(expectedOrder.equals(resultingOrder));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	@Test
	void testDictionary5() {
		try {
			FileReader file = new FileReader("files/data.json");
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(file);
			Dictionary dictionary = new DictionaryImplementaton(json);
			
			assertTrue(dictionary.delete("20"));
			assertTrue(dictionary.delete("50"));

			assertEquals(null, dictionary.get("20"));
			assertEquals(null, dictionary.get("50"));
			assertEquals("seventy", dictionary.get("70"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
}
