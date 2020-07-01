package com.javase.dynamicProxy;

public class GamePlayer implements IGamePlayer {
    private String name;

    public GamePlayer(String name){
        this.name=name;
    }
    @Override
    public void login(String user, String pass) {
        System.out.println("---登陆---");
    }

    @Override
    public void killBoss() {
        System.out.println("---杀死boss---");
    }

    @Override
    public void upgrade() {
        System.out.println("---升级---");
    }
}
