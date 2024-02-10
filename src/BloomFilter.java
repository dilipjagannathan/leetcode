import java.util.BitSet;

public class BloomFilter<T> {

    private BitSet bitSet;
    private int size;
    private int numHashFunctions;

    public BloomFilter(int size, int numHashFunctions) {
        this.size = size;
        this.numHashFunctions = numHashFunctions;
        this.bitSet = new BitSet(size);
    }

    // Add an element to the Bloom Filter
    public void add(T element) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = getHash(element, i);
            bitSet.set(hash % size, true);
        }
    }

    // Check if an element is possibly in the Bloom Filter
    public boolean contains(T element) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = getHash(element, i);
            if (!bitSet.get(hash % size)) {
                return false;
            }
        }
        return true;
    }

    // Hash function generator for different hash functions
    private int getHash(T element, int index) {
        long hash1 = element.hashCode();
        return Math.abs((int) (hash1 % size));
    }

    public static void main(String[] args) {
        // Example usage
        BloomFilter<String> bloomFilter = new BloomFilter<>(1000, 3);

        // Add elements to the Bloom Filter
        bloomFilter.add("apple");
        bloomFilter.add("banana");
        bloomFilter.add("orange");

        // Check if elements are possibly in the Bloom Filter
        System.out.println("Contains 'apple': " + bloomFilter.contains("apple"));     // true
        System.out.println("Contains 'grape': " + bloomFilter.contains("grape"));     // false (possibly false positive)
        System.out.println("Contains 'orange': " + bloomFilter.contains("orange"));   // true
    }
}
