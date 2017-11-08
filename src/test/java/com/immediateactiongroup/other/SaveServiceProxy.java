package com.immediateactiongroup.other;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/10/30 下午10:46
 */
public class SaveServiceProxy implements SaveService {

    private SaveService target;

    public SaveServiceProxy(SaveService target){
        this.target = target;
    }
    @Override
    public void save() {
        System.out.println("----before save----");

        target.save();

        System.out.println("----after save----");
    }

    public static void main(String[] args) {
        SaveService saveService = new SaveServiceImpl();
        SaveService saveServiceProxy = new SaveServiceProxy(saveService);
        saveServiceProxy.save();

    }
}
