package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        run(new OptionsParser().parse(args));


        Animal animal = new Animal();
        System.out.println(animal);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        System.out.println(animal);

        System.out.println("Stop");
    }
    //odpowiedz na pytanie: mozna stworzyc liste zwierzat i przy tworzeniu nowego sprawdzac po kolei zwierzeta czy maja taka pozycje
    public static void run(MoveDirection[] directions){
        for(MoveDirection e : directions){
            String message = switch(e){
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak skręca w lewo";
                case RIGHT -> "Zwierzak skręca w prawo";
            };
            System.out.println(message);
        }
    }
}
