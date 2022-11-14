package agh.ics.oop.gui;

import agh.ics.oop.Animal;

import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;

public class Board extends JPanel {
    //private static final long serialVesionUID = 1L;


    int cols;
    int rows;
    static final int originX = 80;
    static int originY = 37;
    static int cellSize;

    public Board(int cols, int rows, int cellSize){
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
    }



    @Override
    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        for (int i = 0; i <= rows; i++){
            g.drawLine(originX, originY + i * cellSize, originX + cols * cellSize, originY + i * cellSize);
        }
        for (int i = 0; i <= cols; i++){
            g.drawLine(originX + i * cellSize, originY, originX + i * cellSize, originY + rows * cellSize);
        }
        for (int i = 0; i < cols; i++) {
            String s = Integer.toString(i);
            g.drawString(s, originX + cellSize/2 + i * cellSize, originY + (rows) * cellSize + 30);
        }
        for (int i = 0; i < rows; i++) {
            String s = Integer.toString(rows - i - 1);
            g.drawString(s,originX - 30, originY + cellSize/2 + i * cellSize);
        }
    }

}
