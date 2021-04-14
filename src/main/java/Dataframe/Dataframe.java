package Dataframe;

import java.io.IOException;
import java.util.List;

/**
 * Dataframe class to represent a DataFrame from a 2 dimensions table or a CSV File
 */

public class Dataframe {
    private List<String> labels;
    private List<Column> content;
    private int nbRows;

    /**
     * Create a Dataframe from a 2 dimensions table
     */
    public Dataframe(String[][] tableData){

    }

    /**
     * Create a Dataframe from a CSV File
     */
    public Dataframe(String path){

    }

    /**
     * @param label the title of the column to return
     * @return Column the content that represents the label, Exception if it doesn't exist
     */
    public Column getColumn(String label) throws IOException {
        return null;
    }

    /**
     * @param index the position of the column to return
     * @return Column in index position, Exception if index out of bounds
     */
    public Column getColumn(int index) throws IOException {
        return null;
    }

    /**
     *
     * @return int return the number of rows in the Dataframe
     */
    public int nbRows(){
        return this.nbRows;
    }

    /**
     *
     * @return int return the number of columns in the Dataframe
     */
    public int nbColumns(){
        return this.labels.size();
    }

    public List<String> getLabels() {
        return labels;
    }

    public List<Column> getContent() {
        return content;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public void setContent(List<Column> content) {
        this.content = content;
    }
}
