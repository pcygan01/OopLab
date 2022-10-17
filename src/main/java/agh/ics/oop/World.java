package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        run(convert(args));
        System.out.println("Stop");
    }

    public static void run(Direction[] directions){
        for(Direction e : directions){
            String message = switch(e){
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak skręca w lewo";
                case RIGHT -> "Zwierzak skręca w prawo";
                default -> "";
            };
            System.out.println(message);
        }
    }

    public static Direction[] convert(String[] args) {
        int i = 0;
        Direction[] directions = new Direction[args.length];
        for(String arg : args) {
            switch (arg) {
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "r" -> directions[i] = Direction.RIGHT;
                case "l" -> directions[i] = Direction.LEFT;
                default -> {}
            }
            i++;
        }
        return directions;
    }
}
