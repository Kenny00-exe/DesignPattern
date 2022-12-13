package State;

public class StateContext {
    private CharacterState characterState;

    public void setCharacterState(CharacterState characterState) {
        this.characterState = characterState;

        this.characterState.setContext(this);
    }

    public double getState() {
        return this.characterState.getState();
    }

}
