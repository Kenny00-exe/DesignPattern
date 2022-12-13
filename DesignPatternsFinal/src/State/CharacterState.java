package State;

public abstract class CharacterState {

    protected StateContext stateContext;

    public void setContext(StateContext stateContext) {
        this.stateContext = stateContext;
    }

    public abstract void Rest();

    public abstract void attendGame();

    public abstract double getState();
}
