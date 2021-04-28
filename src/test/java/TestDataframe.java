
import Dataframe.Dataframe;
import Dataframe.Column;
import org.junit.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDataframe {


    private Dataframe dataframe;

    @Before
    public void setUp() throws Exception {
        String[][] list = new String[][] {{"prenom","ville","age"},{"walid","SMH","23"},{"nassim","Grenoble","23"},{"axel","Toulouse","20"},{"marion","Paris","20"}};
        dataframe = new Dataframe(list);
    }

    @Test
    public void TestDataFrameInfos() throws IOException {
        assertTrue("Il y'a 3 column!", dataframe.nbColumns() == 3);
        assertTrue("Il y'a 4 lignes!", dataframe.nbRows() == 4);

        Column c1 = dataframe.getColumn(0);
        Column c3 = dataframe.getColumn(2);

        assertTrue("Column 1 n'est pas de type int !", c1.getAt(0) instanceof String);
        assertTrue("Column 3 est de type int !", c3.getAt(0) instanceof Integer);
    }

    @Test
    public void TestSHowFive() {
        System.out.println("------------- First FIVE 1 -------------");
        dataframe.showFiveFirst();
        System.out.println("----------------------------------------");

    }

}
