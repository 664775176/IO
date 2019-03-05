package com.zhangchao.designpattern.bridge;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Appearance
 * @description: TODO
 * @date 2018/11/21 19:07
 */
public interface Appearance {

    public void show();
}

class BadLoser implements Appearance{
    @Override
    public void show() {
        System.out.println("展示屌丝形象");
    }
}
class GoodTRH implements Appearance {
    @Override
    public void show() {
        System.out.println("展示高富帅形象");
    }
}