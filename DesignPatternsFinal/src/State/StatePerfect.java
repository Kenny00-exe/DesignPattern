package State;

public class StatePerfect extends CharacterState {
    @Override
    public void Rest() {
    }

    @Override
    public void attendGame() {
        super.stateContext.setCharacterState(new StateGood());
    }

    @Override
    public double getState() {
        return 1.1;
    }

    @Override
    public String toString() {
        return "StatePerfect";
    }
}
