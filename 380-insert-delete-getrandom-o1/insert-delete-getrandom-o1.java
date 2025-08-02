import java.util.*;

class RandomizedSet {

    Map<Integer, Integer> indexToValue;
    Map<Integer, Integer> valueToIndex;
    int currentIndex;
    Random rand;

    public RandomizedSet() {
        indexToValue = new HashMap<>();
        valueToIndex = new HashMap<>();
        currentIndex = 0;
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) {
            return false;
        }

        indexToValue.put(currentIndex, val);
        valueToIndex.put(val, currentIndex);
        currentIndex++;
        return true;
    }

    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) {
            return false;
        }

        int indexToRemove = valueToIndex.get(val);
        int lastIndex = currentIndex - 1;
        int lastVal = indexToValue.get(lastIndex);

        // Swap last element with element to be removed
        indexToValue.put(indexToRemove, lastVal);
        valueToIndex.put(lastVal, indexToRemove);

        // Remove last element
        indexToValue.remove(lastIndex);
        valueToIndex.remove(val);

        currentIndex--;
        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(currentIndex);
        return indexToValue.get(randomIndex);
    }
}
