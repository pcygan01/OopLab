package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.util.List;


public class App extends Application {
    private AbstractWorldMap map;
    private IEngine engine;
    private Vector2d[] positions;
    public void init(){
        try{
            System.out.println("Start");
            String[] args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};


            //IWorldMap map = new RectangularMap(10, 5);
            this.map = new GrassField(10);
            //Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            this.positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
            this.engine = new SimulationEngine(args, map, positions);
            engine.run();

            System.out.println("Stop");
        } catch (IllegalArgumentException ex){
            System.out.println(ex);
        }
    }

    public void start(Stage primaryStage){
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        Vector2d lowerLeft = this.map.getLowerLeft();
        Vector2d upperRight = this.map.getUpperRight();

        List<String> rawParams = getParameters().getRaw();
        //int i = Integer.parseInt(rawParams.get(0));
        //int j = Integer.parseInt(rawParams.get(1));
        //nie widze sensu korzystania z rawParams
        Label yx = new Label("y/x");
        grid.add(yx, 0,0);
        GridPane.setHalignment(yx, HPos.CENTER);
        grid.getColumnConstraints().add(new ColumnConstraints(40));
        grid.getRowConstraints().add(new RowConstraints(40));
        for(int i = 0; i < upperRight.x - lowerLeft.x + 1; i++){
            Label id = new Label("" + (map.getLowerLeft().x + i));
            grid.add(id, i + 1, 0);
            GridPane.setHalignment(id, HPos.CENTER);
            grid.getColumnConstraints().add(new ColumnConstraints(40));
        }
        for(int j = 0; j < upperRight.y - lowerLeft.y + 1; j++){
            Label id = new Label("" + (map.getUpperRight().y - j));
            grid.add(id, 0, j + 1);
            GridPane.setHalignment(id, HPos.CENTER);
            grid.getRowConstraints().add(new RowConstraints(40));
        }
        for(int i = 0; i < (upperRight.x - lowerLeft.x + 1); i++){
            for(int j = 0; j < (upperRight.y - lowerLeft.y + 1); j++){
                Vector2d pos = new Vector2d(map.getLowerLeft().x + i, map.getUpperRight().y - j);
                if(map.objectAt(pos) != null){
                    Label element = new Label("" + map.objectAt(pos));
                    grid.add(element, i + 1, j + 1);
                    GridPane.setHalignment(element, HPos.CENTER);
                }
            }
        }
        //Label label = new Label("Zwierzak");
        Scene scene = new Scene(grid, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
