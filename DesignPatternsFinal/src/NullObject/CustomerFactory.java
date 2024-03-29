package NullObject;

import Iterator.PlayerContainer;

import java.util.*;

public class CustomerFactory {

    private ArrayList<String> names = new ArrayList<>();

    //将对象全部加入name中
    public CustomerFactory() {
        for (int i = 0; i < PlayerContainer.getInstance().size(); ++i) {
            names.add(PlayerContainer.getInstance().get(i).getCharacterName());
        }
    }

    //基于参数name返回real和null对象
    public AbstractCustomer getCustomer(String name) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}