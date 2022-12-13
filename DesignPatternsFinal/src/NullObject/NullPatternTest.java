package NullObject;

import java.util.Scanner;

public class NullPatternTest {
    public static void main(String[] args) {

        //Player init
        System.out.println("请输入想要查询的玩家名称:");
        Scanner scanner = new Scanner(System.in);
        AbstractCustomer abstractCustomer = null;
        String name = scanner.nextLine();
        CustomerFactory customerFactory = new CustomerFactory();
        abstractCustomer = customerFactory.getCustomer(name);
        boolean result = abstractCustomer.isNil();
        if (!result) {
            System.out.println("该玩家存在");
        } else {
            System.out.println("玩家不存在");
        }
    }
}
