package com.company;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.sql.SQLOutput;


public class Controller implements ActionListener {
    private Viewer viewer;
    public Controller(Viewer viewer) {
        this.viewer = viewer;
    }


    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();

        String answer = openFile("foo_and_bar/xanadu.txt");

        System.out.println(answer);

        viewer.update(answer);
    }

    private String openFile(String fileName){

        String xyz = "";

        File file = new File(fileName);

        try {
            FileReader in = new FileReader(file);
            BufferedReader inputStream = new BufferedReader(in);
            String l;
            while ((l = inputStream.readLine()) !=null) {
                xyz = xyz + l + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException ioe) {
            System.out.println(ioe);
        }

        return xyz;
    }
}
