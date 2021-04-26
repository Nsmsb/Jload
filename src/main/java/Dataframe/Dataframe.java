package Dataframe;

import utils.DefineType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Dataframe class to represent a DataFrame from a 2 dimensions table or a CSV File
 */

public class Dataframe {
    private List<Column> content;
    private int nbRows;

    /**
     * Create a Dataframe from a 2 dimensions table
     * @param tableData representation of data in a 2 dimensions table
     */
    public Dataframe(String[][] tableData){
        this.nbRows = tableData.length - 1;
        content = new ArrayList<>();

        if(tableData.length>0){
            for (int j=0; j<tableData[0].length; j++) {
                List data = null;
                boolean isInt = false;
                if(tableData.length>1) {
                    isInt = DefineType.isInt(tableData[1][j]);
                    if(isInt){
                        data = new ArrayList<Integer>();
                    }else{
                        data = new ArrayList<String>();
                    }
                }

                for (int i=1; i<tableData.length; i++) {
                    if(isInt){
                        data.add(Integer.parseInt(tableData[i][j]));
                    }else{
                        data.add(tableData[i][j]);
                    }
                }
                Column currentColumn;
                if(tableData.length>1){
                    currentColumn = new Column(tableData[0][j],data);
                }else{
                    currentColumn = new Column(tableData[0][j]);
                }

                content.add(currentColumn);
            }
        }

    }

    /**
     * Create a Dataframe from a CSV File
     * @param path the path of the CSV File
     */
    public Dataframe(String path) throws FileNotFoundException {
        this.nbRows = 0;
        FileInputStream file;
        Scanner sc;
        try {
           file=new FileInputStream(path);
           sc =new Scanner(file);
        }catch (FileNotFoundException e){
            throw e;
        }

        String Currentline;
        String[] columnsName = null;
        List[] data = null;
        if(sc.hasNextLine()){
            Currentline = sc.nextLine();
            columnsName = Currentline.split(",");
            data = new List[columnsName.length];
        }

        if(sc.hasNextLine()){
            Currentline = sc.nextLine();
            String[] CurrentlineTab = Currentline.split(",");
            for (int i=0;i<data.length;i++){

                boolean isInt = DefineType.isInt(CurrentlineTab[i]);
                if(isInt){
                    data[i]  = new ArrayList<Integer>();
                    data[i].add(Integer.parseInt(CurrentlineTab[i]));
                }else{
                    data[i]  = new ArrayList<String>();
                    data[i].add(CurrentlineTab[i]);
                }
            }
            this.nbRows ++;
        }

        while(sc.hasNextLine())
        {
            Currentline = sc.nextLine();
            String[] CurrentlineTab = Currentline.split(",");

            for (int i=0;i<data.length;i++){
                if(data[i].get(0) instanceof Integer){
                    data[i].add(Integer.parseInt(CurrentlineTab[i]));
                }else{
                    data[i].add(CurrentlineTab[i]);
                }
            }
            this.nbRows ++;
        }
        content = new ArrayList<>();

        if(this.nbRows ==0){
            for (int i=0;i<data.length;i++) {
                this.content.add(new Column(columnsName[i]));
            }
        }else{
            for (int i=0;i<data.length;i++) {
                this.content.add(new Column(columnsName[i],data[i]));
            }
        }
        sc.close();
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
        return this.content.get(index);
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
        return this.content.size();
    }

    /**
     *
     * @return List<String> list contenant le nom de chaque column
     */
    public List<String> getLabels() {
        List<String> res = new ArrayList<>();

        for (int i = 0; i< this.content.size();i++){
            Column c = this.content.get(i);
            // res.add(c.getName()); A decommenter apres modif dans Column
        }
        return res;
    }

    /**
     *
     * @return List<Column> the content of the dataFrame
     */
    public List<Column> getContent() {
        return content;
    }

    /**
     *  Show the 5 first rows of the dataFrame
     */
    public void showFiveFirst(){
        int max = 5;
        if(content.size() > 0 && content.get(0).getSize() > 0 && content.get(0).getSize() < 5){
            max = content.get(0).getSize();
        }
        for (int i = 0;i<max;i++){
            for (int j=0;j<content.size();j++){
                Column c = content.get(j);
                System.out.print(c.getAt(i)+";");
            }
            System.out.println();
        }
    }

    /**
     *  Show the 5 last rows of the dataFrame
     */
    public void showFiveLast(){
        int max = Math.max(0,content.get(0).getSize()- 5);
        System.out.println(max);
        for (int i = max;i<content.get(0).getSize();i++){
            for (int j=0;j<content.size();j++){
                Column c = content.get(j);
                System.out.print(c.getAt(i)+";");
            }
            System.out.println();
        }
    }
}
