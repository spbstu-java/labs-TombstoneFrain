public class Hero {

    MoveStrategy moveStrategy;

    public void move() {
        moveStrategy.move();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}