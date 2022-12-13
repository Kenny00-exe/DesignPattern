package Adapter;

public class AliAdapter extends AliPay implements Pay {
    //适配器类，用于适配支付宝和普通付款
    @Override
    public void pay() {
        this.specialPay();
    }
}