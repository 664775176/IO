package com.zhangchao.designpattern.bridge;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:AbstractSoul
 * @description: TODO
 * @date 2018/11/21 19:11
 */
public abstract class AbstractSoul {

    private Appearance appearance;
    private Skill skill;

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Skill getSkill() {
        return skill;
    }

    public AbstractSoul() {
    }

    public AbstractSoul(Skill skill) {
        this.skill = skill;
    }

    public AbstractSoul(Appearance appearance, Skill skill) {
        this.appearance = appearance;
        this.skill = skill;
    }

    public AbstractSoul(Appearance appearance) {
        this.appearance = appearance;

    }

    public void setSkill(Skill skill) {

        this.skill = skill;
    }

    public void skill(){
        skill.skill();
    }

    public void show(){
        appearance.show();
    }
    //抽象的方法，留给分身实现
    public abstract void doAllLikePeople();
}
class Doppelganger extends AbstractSoul{

    public Doppelganger(){
        System.out.println("制作一个暂无外貌和技能的分身");
    }

    public void doAllLikePeople(){
        System.out.println("分身可以像正常人一样做任何事");
    }

}