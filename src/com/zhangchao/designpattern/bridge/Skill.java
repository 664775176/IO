package com.zhangchao.designpattern.bridge;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Skill
 * @description: TODO
 * @date 2018/11/21 19:03
 */
public interface Skill {

    public void skill();
}

class Invisible implements Skill {
    public void skill(){
        System.out.println("释放隐身技能");
    }
}

class ReadMind implements  Skill {
    public void skill(){
        System.out.println("释放读心术技能");
    }
}

class Volant implements  Skill {
    public void skill(){
        System.out.println("释放飞行技能");
    }
}