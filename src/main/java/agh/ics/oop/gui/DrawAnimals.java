package agh.ics.oop.gui;

import agh.ics.oop.Animal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawAnimals extends JPanel {
    int cols;
    int rows;
    static final int originX = 80;
    static int originY = 37;
    static int cellSize;
    ArrayList<Animal> animals;

    public DrawAnimals(int cols, int rows, int cellSize, ArrayList<Animal> animals){
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        this.animals = animals;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(Animal a: animals){
            String s = a.getDirection().toString();
            int x = a.getPosition().x;
            int y = a.getPosition().y;
            g.drawString(s, originX + x * cellSize + cellSize/2, originY + cellSize * (rows - y) - cellSize/2);
        }

    }

}
