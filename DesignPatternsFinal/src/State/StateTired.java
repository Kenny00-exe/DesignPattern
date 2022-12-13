package State;

public class StateTired extends CharacterState {
    @Override
    public void Rest() {
        super.stateContext.setCharacterState(new StateGood());
    }

    @Override
    public void attendGame() {
    }

    @Override
    public double getState() {
        return 0.9;
    }

    @Override
    public String toString() {
        return "StateTired";
    }
}
