public class Main {
    public static void main(String[] args) {
        Hero newHero = new Hero();

        newHero.setMoveStrategy(new WalkMoveStrategy());
        newHero.move();

        newHero.setMoveStrategy(new RunMoveStrategy());
        newHero.move();

        newHero.setMoveStrategy(new FlyMoveStrategy());
        newHero.move();
    }
}