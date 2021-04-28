import org.junit.Test;
import utils.DefineType;

import static org.junit.Assert.*;

public class TestDefineType {

    @Test
    public void TestIsInt() {
        assertFalse("qdsfd is not an Int", DefineType.isInt("qdsfd"));
        assertTrue("3 is an Int", DefineType.isInt("3"));
        assertFalse("5.0 is an Int", DefineType.isInt("5.0"));
    }

}
