package com.zhangchao.designpattern.observer.event4;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Button
 * @description: TODO
 * @date 2018/11/16 15:05
 */
public class Button {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public ClickListener getOnClick() {
        return onClick;
    }

    public void setOnClick(ClickListener onClick) {
        this.onClick = onClick;
    }

    public DbClickListener getOnDbClick() {
        return onDbClick;
    }

    public void setOnDbClick(DbClickListener onDbClick) {
        this.onDbClick = onDbClick;
    }

    public MouseMoveListener getMove() {
        return move;
    }

    public void setMove(MouseMoveListener move) {
        this.move = move;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String id;
    private String value;
    private ClickListener onClick;
    private DbClickListener onDbClick;
    private MouseMoveListener move;
    
    public void click(){
        onClick.click(new ClickEvent(this));
    }
    public void dbClick(){
        onDbClick.dbClick(new DbClickEvent(this));
    }
    public void move(){
        move.move(new MouseMoveEvent(this));
    }
}
