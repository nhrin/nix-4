package ua.com;


public class MathSet<T extends Number> implements ISet<T> {

    private Number[] data;
    private static final int DEFAULT_CAPACITY = 20;
    private int size;

    public int getSize() {
        return size;
    }

    public MathSet() {
        data = new Number[DEFAULT_CAPACITY];
    }

    public MathSet(int capacity) {
        data = new Number[capacity];

    }

    MathSet(Number[] numbers) {
        data = new Number[DEFAULT_CAPACITY];
        for (Number number : numbers) {
            add(number);
        }
    }

    MathSet(Number[]... numbers) {
        for (Number[] arr : numbers) {
            for (Number number : arr) {
                add(number);
            }
        }
    }

    MathSet(ISet numbers) {
        data = new Number[DEFAULT_CAPACITY];
        join(numbers);
    }

    MathSet(ISet... numbers) {
        data = new Number[DEFAULT_CAPACITY];
        for (ISet iSet : numbers) {
            join(iSet);
        }
    }

    private boolean isUnique(Number n) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(n))
                return false;
        }
        return true;
    }

    private void autoIncrementSize(int length) {
        Number[] newSet = new Number[length];
        System.arraycopy(data, 0, newSet, 0, size);
        data = newSet;
    }

    private void isRightIndexes(int firstIndex, int lastIndex) {
        if (firstIndex < 0 || firstIndex > size - 1 || lastIndex > size - 1 || lastIndex < 0 || lastIndex < firstIndex)
            throw new RuntimeException("Wrong indexes");
    }

    private int getValueIndex(Number value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public void add(Number n) {
        if (isUnique(n) || size == 0) {
            if (size == data.length - 1)
                autoIncrementSize(size + 50);
            data[size++] = n;
        }
    }

    @Override
    public void add(Number... n) {
        for (Number i : n) {
            add(i);
        }
    }

    @Override
    public void join(ISet ms) {
        Number[] tmp = ms.toArray();
        for (Number i : tmp) {
            add(i);
        }
    }

    @Override
    public void join(ISet... ms) {
        for (ISet i : ms) {
            join(i);
        }
    }

    @Override
    public void sortDesc() {
        sortDesc(0, size - 1);
    }

    @Override
    public void sortDesc(int firstIndex, int lastIndex) {
        isRightIndexes(firstIndex, lastIndex);
        Number tmp;
        for (int i = firstIndex; i <= lastIndex; i++) {
            for (int j = firstIndex; j <= lastIndex; j++) {
                if (data[j].doubleValue() < data[i].doubleValue()) {
                    tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }

    @Override
    public void sortDesc(Number value) {
        if (getValueIndex(value) != -1) {
        } else throw new RuntimeException("This number not found");
        sortDesc(getValueIndex(value), size - 1);
    }

    @Override
    public void sortAsc() {
        sortAsc(0, size - 1);

    }

    @Override
    public void sortAsc(int firstIndex, int lastIndex) {
        isRightIndexes(firstIndex, lastIndex);
        Number tmp;
        for (int i = firstIndex; i <= lastIndex; i++) {
            for (int j = firstIndex; j <= lastIndex; j++) {
                if (data[j].doubleValue() >= data[i].doubleValue()) {
                    tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }


    @Override
    public void sortAsc(Number value) {
        sortAsc(0, size - 1);
    }

    @Override
    public Number get(int index) {
        isRightIndexes(0, index);
        return data[index];
    }

    @Override
    public Number getMax() {
        Number tmp = data[0];
        for (Number n : data) {
            if (n == null) continue;
            if (n.doubleValue() > tmp.doubleValue()) {
                tmp = n;
            }
        }
        return tmp;
    }

    @Override
    public Number getMin() {
        Number tmp = data[0];
        for (Number n : data) {
            if (n == null) continue;
            if (n.doubleValue() < tmp.doubleValue()) {
                tmp = n;
            }
        }
        return tmp;
    }

    @Override
    public Number getAverage() {
        Number sum = 0;
        for (Number n : data) {
            sum = sum.doubleValue() + n.doubleValue();
        }

        return sum.doubleValue() / size;
    }

    @Override
    public Number getMedian() {
        Number median;
        if (this.size % 2 == 0)
            median = (data[this.size / 2].doubleValue() + data[this.size / 2 - 1].doubleValue()) / 2;
        else
            return data[this.size / 2];
        return median;
    }

    @Override
    public Number[] toArray() {
        Number[] set = new Number[size];
        if (size >= 0)
            System.arraycopy(data, 0, set, 0, size);
        return set;

    }

    @Override
    public Number[] toArray(int firstIndex, int lastIndex) {
        isRightIndexes(firstIndex, lastIndex);
        return new Number[0];
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public ISet squash(int firstIndex, int lastIndex) {
        isRightIndexes(firstIndex, lastIndex);
        Number[] data = new Number[size - (lastIndex - firstIndex)];
        int i = 0;
        for (int j = 0; j < firstIndex; j++) {
            data[i] = data[j];
            i++;
        }
        for (int j = lastIndex; j < size; j++) {
            data[i] = data[j];
            i++;
        }
        return new MathSet(data);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public void clear(Number[] numbers) {
        for (Number n : numbers) {
            for (int i = 0; i < size; i++) {
                if (n.equals(data[i])) data[i] = null;
            }
        }
    }
    @Override
    public void show () {
        for (Number n : data) {
            System.out.println(n);
        }
    }
}
