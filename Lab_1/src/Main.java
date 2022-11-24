public class Main {
    public static void main(String[] args) {
        Hero newHero = new Hero();

        newHero.move();

        newHero.setMoveStrategy(new RunMoveStrategy());
        newHero.move();

        newHero.setMoveStrategy(new FlyMoveStrategy());
        newHero.move();
    }
}