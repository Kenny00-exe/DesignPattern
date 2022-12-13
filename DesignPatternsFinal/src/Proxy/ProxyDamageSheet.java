package Proxy;

public class ProxyDamageSheet implements DamageSheet {

    private RealDamageSheet realDamageSheet;

    @Override
    //查看已攻略副本
    public void printDamageSheet() {
        if (realDamageSheet == null) {
            this.realDamageSheet = new RealDamageSheet();
        }
        System.out.println("加载数据中...");
        realDamageSheet.printDamageSheet();
        System.out.println("数据加载完成！");
    }
}
