package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString(){
        return switch(this){
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case EAST -> "Wschód";
            case WEST -> "Zachód";
            default -> null;
        };
    }

    MapDirection next(){
        return switch(this){
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            case WEST -> NORTH;
            default -> null;
        };
    }

    MapDirection previous(){
        return switch(this){
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case WEST -> SOUTH;
            default -> null;
        };
    }

    Vector2d toUnitVector(){
        return switch(this){
            case NORTH -> new Vector2d(0,1);
            case SOUTH -> new Vector2d(0, -1);
            case EAST -> new Vector2d(1, 0);
            case WEST -> new Vector2d(-1, 0);
            default -> null;
        };
    }
}
