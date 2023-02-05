// --== CS400 Project One File Header ==--
// Name: Bill Lee
// CSL Username: billl
// Email: blee266@wisc.edu
// Lecture #: 002
// Notes to Grader: <any optional extra notes to your grader>
/*
 * This class tests the functionality of the HashtableMap class' methods
 */
public class HashtableMapTests <KeyType, ValueType> {
	/*
	 * This method tests the put method and the get method of the HashtableMap class.
	 * 
	 * @returns true when the test passes, false otherwise.
	 */
	public static boolean test1()  { 
		try {
			HashtableMap Tester1 = new HashtableMap();

			Tester1.put("first", 1);
			Tester1.put("second", 2);
			Tester1.put("third", 3);
			Tester1.put("fourth", 4);
			if(!(Tester1.get("first").equals(1))) {
				return false;
			}
			if(!(Tester1.get("third").equals(3))) {
				return false;
			}
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	/*
	 * This method tests the size method of the HashtableMap class.
	 * 
	 * @returns true when the test passes, false otherwise.
	 */
	public static boolean test2() {
		try {
			HashtableMap Tester1 = new HashtableMap();

			Tester1.put("first", 1);
			Tester1.put("second", 2);
			Tester1.put("third", 3);
			Tester1.put("fourth", 4);
			if(!(Tester1.size() == 4)) {
				return false;
			}
			Tester1.remove("second");
			if(!(Tester1.size() == 3)) {
				return false;
			}
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	/*
	 * This method tests the clear method of the HashtableMap class.
	 * 
	 * @returns true when the test passes, false otherwise.
	 */
	public static boolean test3() { 
		try {
			HashtableMap Tester1 = new HashtableMap();

			Tester1.put("first", 1);
			Tester1.put("second", 2);
			Tester1.put("third", 3);
			Tester1.put("fourth", 4);
			Tester1.clear();
			if(!(Tester1.size() == 0)) {
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	/*
	 * This method tests the containsKey method of the HashtableMap class.
	 * 
	 * @returns true when the test passes, false otherwise.
	 */
	public static boolean test4() {
		try {
			HashtableMap Tester1 = new HashtableMap();

			Tester1.put("first", 1);
			Tester1.put("second", 2);
			Tester1.put("third", 3);
			Tester1.put("fourth", 4);
			if(!Tester1.containsKey("second") == true) {
				return false;
			}

		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	/*
	 * This method tests the rehash method of the HashtableMap class.
	 * 
	 * @returns true when the test passes, false otherwise.
	 */
	public static boolean test5() { 
		try {
			HashtableMap Tester1 = new HashtableMap(5); //set capacity to 5.
			Tester1.put("first", 1);
			Tester1.put("second", 2);
			Tester1.put("third", 3);
			Tester1.put("fourth", 4); //exceeds 0.75 limit.
			Tester1.put("fifth", 5);
			Tester1.put("sixth", 6);
			if(!Tester1.containsKey("second") == true) {
				return false;
			}
			//checks if all the contents have been successfully transferred.
			if(!(Tester1.get("third").equals(3))) {
				return false;
			}
			if(!(Tester1.get("first").equals(1))) {
				return false;
			}

		}catch(Exception e){
			return false;
		}
		return true;

	}
}
