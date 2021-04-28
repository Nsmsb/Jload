package Dataframe;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents a Dataframe object
 *
 * @author walid BOUKRIS
 */


public class Dataframe<T> {
    private List<String> labels;
    private HashMap<String, List<T>> content;
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
        List<String> labels = getLabels();
        int index = 0;
        for (String l: labels) {
            if(l.equals(label)){
                return this.content.get(index);
            }
            index ++;
        }
        throw new IOException();
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
        List<String> res = new ArrayList<>();

        for (int i = 0; i< this.content.size();i++){
            Column c = this.content.get(i);
            res.add(c.getName());
        }
        return res;
    }

    public List<Column> getContent() {
        return null;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    /**
     *  Show the 5 last rows of the dataFrame
     */
    public void showFiveLast(){
        int max = Math.max(0,content.get(0).getSize()- 5);
        for (int i = max;i<content.get(0).getSize();i++){
            for (int j=0;j<content.size();j++){
                Column c = content.get(j);
                System.out.print(c.getAt(i)+";");
            }
            System.out.println();
        }
    }

    /**
     *  Show the All rows of the dataFrame
     */
    public void showAll(){
        for (int i = 0;i<content.get(0).getSize();i++){
            for (int j=0;j<content.size();j++){
                Column c = content.get(j);
                System.out.print(c.getAt(i)+";");
            }
            System.out.println();
        }
    }


    /**
     *  Show rows of the dataFrame between i1 and i2
     */
    public void showBetween(int i1, int i2){
        if(i2<i1 || i1 < 0 || i2 < 0 || i2>content.get(0).getSize()){
            return;
        }
        for (int i = i1;i<i2;i++){
            for (int j=0;j<content.size();j++){
                Column c = content.get(j);
                System.out.print(c.getAt(i)+";");
            }
            System.out.println();
        }


    }
}
