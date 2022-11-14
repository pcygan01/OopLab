package agh.ics.oop.gui;

import agh.ics.oop.Animal;

import javax.swing.*;

import java.awt.Graphics;
import java.util.ArrayList;

import static java.lang.Math.min;

public class Gui extends JPanel{
    private int cols;
    private int rows;
    JFrame frame = new JFrame("Map");
    ArrayList<Animal> animals;



    public Gui(int cols, int rows, ArrayList<Animal> animals){
        this.cols = cols;
        this.rows = rows;
        this.animals = animals;
    }

    public void run() {

        //frame.setSize(1920,1080);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        final int cellSize = min(60, min((int)(frame.getWidth()- 150) / this.cols, (int) (frame.getHeight()-150) / rows));

        //System.out.println(frame.getBounds().height + " " + frame.getWidth());
        Board board = new Board(this.cols, this.rows, cellSize);
        DrawAnimals drawAnimals = new DrawAnimals(this.cols, this.rows, cellSize, this.animals);
        frame.add(drawAnimals);
        frame.setVisible(true);
        frame.add(board);
        frame.setVisible(true);
    }
//
//    public void drawAnimals(ArrayList<Animal> animals){
//        final int cellSize = min(60, min((int)(frame.getWidth()- 150) / this.cols, (int) (frame.getHeight()-150) / rows));
//        DrawAnimals drawAnimals = new DrawAnimals(cols, rows, cellSize, animals);
//        //tu sie moze wywalic
//        frame.add(drawAnimals);
//        frame.setVisible(true);
//    }

}


