package State;

public class StateGood extends CharacterState {
    @Override
    public void Rest() {
        super.stateContext.setCharacterState(new StatePerfect());
    }

    @Override
    public void attendGame() {
        super.stateContext.setCharacterState(new StateTired());
    }

    @Override
    public double getState() {
        return 1.0;
    }

    @Override
    public String toString() {
        return "StateGood";
    }
}
