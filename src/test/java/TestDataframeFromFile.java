
import Dataframe.Dataframe;
import org.junit.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import Dataframe.Column;

import static org.junit.Assert.assertTrue;

public class TestDataframeFromFile {


    private Dataframe dataframe;

    @Before
    public void setUp() throws Exception {
        String pathFile = "src/test/ressources/exemple.csv";
        dataframe = new Dataframe(pathFile);
    }


    @Test(expected = FileNotFoundException.class)
    public void TestDataFrameBadFile() throws FileNotFoundException {
        Dataframe dataframe1 = new Dataframe("BAD PATH");
    }

    @Test
    public void TestDataFrameInfos() throws IOException {
        assertTrue("Il y'a 5 column!", dataframe.nbColumns() == 5);
        assertTrue("Il y'a 6 lignes!", dataframe.nbRows() == 6);

        Column c1 = dataframe.getColumn(0);
        Column c3 = dataframe.getColumn(2);

        assertTrue("junie@example.com est Bon", c1.getAt(0).equals("junie@example.com"));
        assertTrue("2019-01-15 est bon", c1.getAt(0).equals("junie@example.com"));
        assertTrue("1 est Bon", c1.getAt(0).equals("junie@example.com"));

        assertTrue("Column 1 n'est pas de type int !", c1.getAt(0) instanceof String);
        assertTrue("Column 3 est de type int !", c3.getAt(0) instanceof Integer);
    }

    @Test
    public void TestSHowFiveFirst() {
        dataframe.showFiveFirst();
    }

    @Test
    public void TestDataFrameContent() throws IOException {

        Column c1 = dataframe.getColumn(0);
        Column c2 = dataframe.getColumn(1);
        Column c3 = dataframe.getColumn(2);
        Column c4 = dataframe.getColumn(3);
        Column c5 = dataframe.getColumn(4);

        assertTrue("junie@example.com est Bon", c1.getAt(0).equals("junie@example.com"));
        assertTrue("2019-01-15 est bon", c4.getAt(0).equals("2019-01-15"));
        assertTrue("1 est Bon", c5.getAt(0).equals(1));

        assertTrue("0682145672 est Bon", c3.getAt(0).equals(682145672));
        assertTrue("John est bon", c2.getAt(1).equals("John"));
    }


    @Test
    public void TestSHowFiveLast() {
        System.out.println("Last FIVE");
        dataframe.showFiveLast();
    }

}
