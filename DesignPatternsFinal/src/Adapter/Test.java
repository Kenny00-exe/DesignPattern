package Adapter;

import java.util.Scanner;

public class Test {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        int type;
        System.out.println("请选择你要使用的支付方式：\n1、支付宝  2、微信");
        type = scan.nextInt();
        switch (type) {
            case 1: {
                new AliAdapter().pay();
                break;
            }
            case 2: {
                new WechatPay().pay();
                break;
            }
        }
    }
}
