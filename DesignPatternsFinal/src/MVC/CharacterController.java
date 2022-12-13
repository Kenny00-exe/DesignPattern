package MVC;

import SimpleFactory.Player;

public class CharacterController {
    private Player model;
    private CharacterViews view;

    public CharacterController(Player model, CharacterViews views) {
        this.model = model;
        this.view = views;
    }

    public void setCharacterName(String name){
        model.setCharacterName(name);
    }

    public String getCharacterName(){
        return model.getCharacterName();
    }

    public void updateView(){
        view.printCharacterDetails(model.getCharacterName());
    }
}
