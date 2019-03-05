package com.zhangchao.designpattern.observer.event4;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ButtonJsp
 * @description: TODO
 * @date 2018/11/16 15:15
 */
public class ButtonJsp {

    private Button button;
    public ButtonJsp(){
        button = new Button();
        button.setId("submitButton");//取submitButton为id
        button.setValue("提交");//提交按钮
        button.setOnClick(new ClickListener() {
           //我们给按钮注册点击监听器
            //按钮被点，我们就验证后提交
            public void click(ClickEvent clickEvent) {
                System.out.println("--------单击事件代码---------");
                System.out.println("if('表单合法'){");
                System.out.println("\t表单提交");
                System.out.println("}else{");
                System.out.println("\treturn false");
                System.out.println("}");
            }
        });
        button.setOnDbClick(new DbClickListener() {
            @Override
            public void dbClick(DbClickEvent event) {

            }
        });
        button.setMove(new MouseMoveListener() {
            @Override
            public void move(MouseMoveEvent mouseMoveEvent) {

            }
        });
    }

    public Button getButton(){
        return button;
    }
}
