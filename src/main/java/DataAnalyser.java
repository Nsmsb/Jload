import java.util.List;

public interface DataAnalyser {
    /**
     * Operations on provided by Jload on the DataFrame
     */

    List getRow(int index);
    void insert(List row);
    void deleteRow(int index);

    List getColumns(String key);
    void addColumns(String key);
    void deleteColumns(String key);

}
