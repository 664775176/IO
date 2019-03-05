package com.zhangchao.designpattern.bridge;
//屌丝分身
class Loser extends Soul{
    
    public Loser(){
        System.out.println("制造一个无技能的屌丝分身");
    }
    
    public void doAllLikePeople(){
        System.out.println("分身可以像正常人一样做任何事");
    }
    
    public void show(){
        System.out.println("展示屌丝形象");
    }
    
}
//高富帅分身
class TRH extends Soul {
    
    public TRH(){
        System.out.println("制造一个无技能的高富帅分身");
    }

    public void doAllLikePeople(){
        System.out.println("分身可以像正常人一样做任何事");
    }
    
    public void show(){
        System.out.println("展示高富帅形象");
    }
    
}