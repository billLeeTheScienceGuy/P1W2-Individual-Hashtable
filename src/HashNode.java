// --== CS400 Project One File Header ==--
// Name: Bill Lee
// CSL Username: billl
// Email: blee266@wisc.edu
// Lecture #: 002
// Notes to Grader: <any optional extra notes to your grader>
/*
 * This class represents the Nodes (key-value) of the Hash Table
 */
public class HashNode <KeyType, ValueType> {
	KeyType key;
	ValueType val;
	/*
	 * This constructor represents a node (key-value) pair of the Hash Table
	 * 
	 * @param keyInp is the input key value of the node
	 * @param valInp is the input value of the node.
	 */
	public HashNode(KeyType keyInp, ValueType valInp) {
		key = keyInp;
		val = valInp;
	}
	/*
	 * This method calles the key value
	 * 
	 * @returns the key value
	 */
	public KeyType getKey(){
		return key;
	}
	/*
	 * This method calls the value part
	 * 
	 * @returns the value.
	 */
	public ValueType getVal() {
		return val;
	}


}
