public class Hero {

    MoveStrategy moveStrategy = new WalkMoveStrategy();

    public void move() {
        moveStrategy.move();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}