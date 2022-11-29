package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {

    public OptionsParser(){
    }

    MoveDirection[] parse(String[] args){
        MoveDirection[] res = new MoveDirection[args.length];
        int i = 0;
        for(String arg: args){
            switch(arg){
                case "f", "forward" -> res[i] = MoveDirection.FORWARD;
                case "b", "backward" -> res[i] = MoveDirection.BACKWARD;
                case "r", "right" -> res[i] = MoveDirection.RIGHT;
                case "l", "left" -> res[i] = MoveDirection.LEFT;
                default -> {
                    throw new IllegalArgumentException(arg + " is not legal move specification");
                }
            }
            i++;
        }
        res = Arrays.copyOfRange(res, 0, i);
        return res;
    }
}
