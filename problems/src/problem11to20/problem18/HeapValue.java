package problem11to20.problem18;

/**
 * Created by vikranth on 6/7/2016.
 */
public class HeapValue {
    int value;
    boolean accessed = false;

    public HeapValue(int value) {
        this.value = value;
    }

    public HeapValue(int value, boolean accessed) {
        this.value = value;
        this.accessed = accessed;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getAccessed() {
        return accessed;
    }

    @Override
    public String toString() {
        return "HeapValue{" +
                "value=" + value +
                ", accessed=" + accessed +
                '}';
    }

    public void setAccessed(boolean accessed) {
        this.accessed = accessed;
    }
}
