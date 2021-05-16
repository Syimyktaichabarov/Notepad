package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;



public class Viewer {

    private  JTextArea textArea;

    public Viewer() {
        Controller controller = new Controller(this);
        initialization(controller);
    }

    private void initialization(Controller controller) {
        JMenuBar menuBar = getMyJMenuBar(controller);
        textArea = new JTextArea();
        JFrame frame = new JFrame("Notepad");
        frame.setSize(800,540);
        frame.setLocation(250,100);
        frame.add(textArea);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JMenuBar getMyJMenuBar(Controller controller) {

        JMenuItem newMenuItem = new JMenuItem("New", new ImageIcon("images/new.gif"));
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        JMenuItem newOpenItem = new JMenuItem("Open ... ", new ImageIcon("images/open.gif"));
        newOpenItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        newOpenItem.addActionListener(controller);

        JMenuItem newSaveItem = new JMenuItem("Save", new ImageIcon("images/save.gif"));
        newSaveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem newSaveAsItem = new JMenuItem("Save as ...", new ImageIcon("images/save_as.gif"));

        JMenuItem newPrintItem = new JMenuItem("Print", new ImageIcon("images/print.gif"));
        newPrintItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        JMenuItem exitMenuItem = new JMenuItem("Exit");

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        JMenuItem cutMenuItem = new JMenuItem("Cut", new ImageIcon("images/cut.gif"));
        cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));

        JMenuItem copyMenuItem = new JMenuItem("Copy", new ImageIcon("images/copy.gif"));
        copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));

        JMenuItem pasteMenuItem = new JMenuItem("Paste", new ImageIcon("images/past.gif"));
        pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));

        JMenuItem clearMenuItem = new JMenuItem("Clear", new ImageIcon("images/delit.gif"));
        clearMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));

        JMenuItem findMenuItem = new JMenuItem("Find", new ImageIcon("images/find.gif"));
        findMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));

        JMenuItem findMoreMenuItem = new JMenuItem("Find more...");
        findMoreMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,0));
        findMoreMenuItem.setEnabled(false);

        JMenuItem goMenuItem = new JMenuItem("Go", new ImageIcon("images/go.gif"));
        goMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));

        JMenuItem markerAllMenuItem = new JMenuItem("MarkerAll", new ImageIcon("images/marker.gif"));
        markerAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));

        JMenuItem timeMenuItem = new JMenuItem("Time and date", new ImageIcon("images/time.gif"));
        timeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,0));


        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');

        JMenuItem wordSpaceMenuItem = new JMenuItem("Word Space",new ImageIcon("images/wordSpace.gif"));

        JMenuItem fontMenuItem = new JMenuItem("Font",new ImageIcon("images/font.gif"));
        timeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));



        JMenu formatMenu = new JMenu("Format");

        JMenuItem statusSpaceMenuItem = new JMenuItem("Status space",new ImageIcon("images/options.gif"));

        JMenu viewMenu = new JMenu("View");

        JMenuItem viewHelpMenuItem = new JMenuItem("View Help");
        viewHelpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));

        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));

        JMenu helpMenu = new JMenu("Help");

        helpMenu.add(viewHelpMenuItem);
        helpMenu.add(aboutMenuItem);

        viewMenu.add(statusSpaceMenuItem);

        formatMenu.add(wordSpaceMenuItem);
        formatMenu.add(fontMenuItem);

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.add(clearMenuItem);
        editMenu.add(new JSeparator());
        editMenu.add(findMenuItem);
        editMenu.add(findMoreMenuItem);
        editMenu.add(goMenuItem);
        editMenu.add(new JSeparator());
        editMenu.add(markerAllMenuItem);
        editMenu.add(timeMenuItem);

        fileMenu.add(newMenuItem);
        fileMenu.add(newOpenItem);
        fileMenu.add(newSaveItem);
        fileMenu.add(newSaveAsItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(newPrintItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(exitMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        return menuBar;

    }

    public void update(String text) {

        textArea.setText(text);
    }
}
