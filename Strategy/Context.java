public class Context {
    private OperationStrategy strategy;

    public Context() {
        this.strategy = new AddStrategy();
    }

    public void changeStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int a, int b) {
        return strategy.execute(a, b);
    }
}