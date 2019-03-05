package com.zhangchao.designpattern.bridge;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Client
 * @description: TODO
 * @date 2018/11/21 19:15
 */
public class Client {
    public static void main(String[] args) {
        AbstractSoul soul = new Doppelganger();
        soul.setAppearance(new BadLoser());
        soul.setSkill(new Invisible());
        soul.doAllLikePeople();
        System.out.println("----------------------------");
        soul.show();
        soul.skill();
        soul.setSkill(new Volant());
        soul.setAppearance(new GoodTRH());
        System.out.println("----------------------------");
        soul.show();
        soul.skill();

    }
}
