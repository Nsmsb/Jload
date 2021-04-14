package Dataframe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColumnTest {

    private Column<String> col;

    @Before
    public void setUp() throws Exception {
        col = new Column<String>("name");
        col.insert("Alice");
        col.insert("Bob");
    }

    @Test
    public void getAt() {
        String e = col.getAt(0);
        assertEquals("Read/get test Colums.getAt()", "Alice", e);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void  getAtException() {
        col.getAt(-1);
        assertTrue("Exception test on Column.getAt()", true);
    }

    @Test
    public void insert() {
        int size = col.getSize();
        col.insert("March");
        assertEquals("Insertion test Columns.insert()", size+1, col.getSize());
    }

    @Test
    public void updateAt() {
        String prev = col.getAt(0);
        col.updateAt(0, "John");
        assertNotEquals("Update test Columns.updateAt()", prev, col.getAt(0));
        assertEquals("Update test 2 Columns.updateAt()", "John", col.getAt(0));
    }

    @Test
    public void isEmpty() {
        assertFalse("Empty test Column.isEmpty()", col.isEmpty());
        col = new Column<String>("Name");
        assertTrue("Empty test Column.isEmpty()", col.isEmpty());
    }
}