import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {

    private final SortedMap<Integer, String> ring = new TreeMap<>();

    public void addNode(String node) {
        int hash = getHash(node);
        ring.put(hash, node);
    }

    public void removeNode(String node) {
        int hash = getHash(node);
        ring.remove(hash);
    }

    public String getNodeForKey(String key) {
        if (ring.isEmpty()) {
            return null;
        }

        int hash = getHash(key);
        SortedMap<Integer, String> tailMap = ring.tailMap(hash);
        if (tailMap.isEmpty()) {
            return ring.get(ring.firstKey()); // Wrap around if no exact match found
        }

        return tailMap.get(tailMap.firstKey());
    }

    private int getHash(String value) {
        // You can use a proper hash function like MD5 or SHA-256
        return value.hashCode();
    }

    public static void main(String[] args) {
        ConsistentHashing consistentHashing = new ConsistentHashing();

        // Add nodes to the ring
        consistentHashing.addNode("Node1");
        consistentHashing.addNode("Node2");
        consistentHashing.addNode("Node3");

        // Get node for a key
        String key = "someKey";
        String node = consistentHashing.getNodeForKey(key);
        System.out.println("Node for key '" + key + "': " + node);

        // Remove a node from the ring
        consistentHashing.removeNode("Node2");

        // Get node for the same key after node removal
        node = consistentHashing.getNodeForKey(key);
        System.out.println("Node for key '" + key + "' after removal: " + node);
    }
}