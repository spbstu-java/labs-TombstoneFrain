public interface MoveStrategy {

    public void move();
}

class WalkMoveStrategy implements MoveStrategy {

    @Override
    public void move() {
        System.out.println("Герой идёт пешком.");
    }
}
class RunMoveStrategy implements MoveStrategy {

    @Override
    public void move() {
        System.out.println("Герой бежит.");
    }
}
class FlyMoveStrategy implements MoveStrategy {

    @Override
    public void move() {
        System.out.println("Герой летит.");
    }
}