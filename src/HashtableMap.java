// --== CS400 Project One File Header ==--
// Name: Bill Lee
// CSL Username: billl
// Email: blee266@wisc.edu
// Lecture #: 002
// Notes to Grader: <any optional extra notes to your grader>
import java.util.LinkedList;
import java.util.NoSuchElementException;
/*
 * This class implements the characters of a Hash Table.
 * 
 * @implements MapADT
 */
public class HashtableMap <KeyType, ValueType> implements MapADT <KeyType, ValueType> {
	int size;
	int capacity;
	protected LinkedList<HashNode<KeyType, ValueType>>[] hashTable;
	/*
	 * This constructor represents a Hash Table with custom capacity.
	 * 
	 * @param capacity is the capacity of the Hash Table.
	 */
	@SuppressWarnings("unchecked")
	public HashtableMap(int capacity) {

		size = 0;
		this.capacity = capacity;
		hashTable = (LinkedList<HashNode<KeyType, ValueType>>[]) new LinkedList[this.capacity];
	}

	/*
	 * This constructor represents a Hash Table with default(20) capacity.
	 * 
	 * @param capacity is the capacity of the Hash Table.
	 */
	@SuppressWarnings("unchecked")
	public HashtableMap() {
		size = 0;
		this.capacity = 20;
		hashTable = (LinkedList<HashNode<KeyType, ValueType>>[]) new LinkedList[this.capacity];

	} // with default capacity = 20
	/*
	 * This method places a new key-value pair into the Hash Table
	 * 
	 * @param key is the key value of the Hash Table.
	 * @param value is the value part of the Hash Table.
	 * @returns true if the key is successfully put in, false otherwise.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean put(KeyType key, ValueType value) {
		if(key == null || containsKey(key)) {
			return false;
		}
		HashNode keyValPair = new HashNode<>(key, value);
		if (this.hashTable[getIndex(key)] == null) {

			hashTable[getIndex(key)] = new LinkedList<>();
			hashTable[getIndex(key)].addFirst(keyValPair);
			size++;
			if((double) size / capacity >= 0.75) {
				rehash();
			}
			return true;
		}
		else {
			hashTable[getIndex(key)].addLast(keyValPair);
			size++;
			if((double) size / capacity >= 0.75) {
				rehash();
			}
			return true;
		}

	}
	/*
	 * This method rehashes the current Hash Table by making a new table with double
	 * the capacity and transferring the data inside it to the new Table.
	 */
	@SuppressWarnings("unchecked")
	private void rehash() {
		capacity = capacity*2;
		LinkedList<HashNode<KeyType, ValueType>>[] tempList = hashTable;
		hashTable = new LinkedList[capacity];
		for(int i = 0; i < capacity/2; i++) {
			hashTable[i] = tempList[i];
		}

	}
	/*
	 * This method returns a value of a key-val pair when a corresponding key value
	 * is in the input
	 * 
	 * @param key is the key value that is input in order to find the matching value.
	 * @throws NoSuchElementException when the pair doesn't exist.
	 * @returns the corresponding value of the key.
	 */
	@Override
	public ValueType get(KeyType key) throws NoSuchElementException {

		if(key == null || hashTable[getIndex(key)] == null) {
			throw new NoSuchElementException("The pair is null");
		}
		if(containsKey(key) == false) {
			throw new NoSuchElementException("The key is not within the table");
		}
		for(int i = 0; i < hashTable[getIndex(key)].size(); i++) {
			if(hashTable[getIndex(key)].get(i).getKey().equals(key)) {
				return (ValueType)hashTable[getIndex(key)].get(i).getVal();
			}
		}
		return null;
	}
	/*
	 * This method gets the index of the key within the table
	 * 
	 * @param key is the key whose index is supposed to be found.
	 * @returns the index of the key
	 */
	private int getIndex(KeyType key) {
		int keyHash =key.hashCode();
		return Math.abs(keyHash % capacity);
	}
	/*
	 * Size returns the value of the size.
	 * 
	 * @returns size
	 */

	@Override
	public int size() {
		return this.size;
	}
	/*
	 * This method finds out if a table has that specific key or not
	 * 
	 * @param key that's being searched for
	 * @returns true if the key is in the table, false otherwise.
	 */

	@Override
	public boolean containsKey(KeyType key) {
		if (size == 0 || key == null || hashTable[getIndex(key)] == null) {
			return false;
		}
		for (int i = 0; i < hashTable[getIndex(key)].size(); i++) {
			if(hashTable[getIndex(key)].get(i).getKey().equals(key)) {
				return true;
			}


		}
		return false;
	}
	/*
	 * This method removes the specific key within the table
	 * 
	 * @param key is the key that is being removed
	 * @returns the removed value that corresponds to the key.
	 */

	@Override
	public ValueType remove(KeyType key) {
		if(key == null || hashTable[getIndex(key)] == null) {
			throw new NoSuchElementException("The key or the pair is null");
		}
		for(int i = 0; i < size; i++) {
			if(hashTable[getIndex(key)].get(i).getKey().equals(null)) {
				throw new NoSuchElementException("The pair is not in the array");
			}
			if(hashTable[getIndex(key)].get(i).getKey() == key) {
				ValueType temp = hashTable[getIndex(key)].get(i).getVal();
				hashTable[getIndex(key)] = null;
				--size;
				return temp;
			}
			i++;
		}
		return null;

	}
	/*
	 * This method clears the whole Hash Table
	 */

	@Override
	public void clear() {
		size = 0;
		for(int i = 0; i < capacity; i++) {
			hashTable[i] = null;
		}
	}

}
