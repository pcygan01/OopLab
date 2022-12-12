package agh.ics.oop;

import java.util.Comparator;

public class MyComparator implements Comparator<Vector2d> {

    public final boolean compareX;

    public MyComparator(boolean compareX){
        this.compareX = compareX;
    }

    @Override
    public int compare(Vector2d pos1, Vector2d pos2){
        if (compareX){
            if(pos1.x > pos2.x){
                return 1;
            }
            else if (pos1.x < pos2.x){
                return -1;
            }
            else if (pos1.y > pos2.y){
                return 1;
            }
            else if(pos1.y < pos2.y){
                return -1;
            }
        }
        else {
            if (pos1.y > pos2.y) {
                return 1;
            } else if (pos1.y < pos2.y) {
                return -1;
            } else if (pos1.x > pos2.x) {
                return 1;
            } else if (pos1.x < pos2.x) {
                return -1;
            }
        }
        return 0;
    }
}
