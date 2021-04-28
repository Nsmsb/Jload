package Dataframe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Column<T>{

    private final String name;
    // private Class<T> type;
    private final List<T> values;

    public  Column(String name, Collection<T> data) {
        this.name = name;
        this.values = new ArrayList<T>(data);
    }

    public Column(String name) {
        this.name = name;
        this.values = new ArrayList<T>();
    }

    // methodes

    /**
     * get a value in the column
     * @param index index of the value (row in DataFrame)
     * @return the index th value
     * @throws IndexOutOfBoundsException if index is out Of range
     */
    public T getAt(int index) throws IndexOutOfBoundsException {
        return values.get(index);
    }

    /**
     * get name of the column
     * @return the name of the column
     */
    public String getName() {
        return this.name;
    }

    /**
     * insert a new value to the colunm
     * @param element the new value
     */
    public void insert(T element) {
        values.add(element);
    }

    /**
     * update an element in the column
     * @param index index of the column (row in the DataFrame
     * @param e new Value
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public void updateAt(int index, T e) throws IndexOutOfBoundsException {
        values.set(index, e);
    }

    /**
     * check the size of the columns
     * @return size of columns
     */
    public int getSize() {
        return values.size();
    }

    /**
     * check if a column is empty
     * @return True if the column is empty
     */
    boolean isEmpty() {
        return values.isEmpty();
    }

}
