package com.tda367.game.Model;

public class Goldhandler extends MainHandler {
    private int gold = 0;


    public void handleRequest(Request request){

        if (request.getDescription() == HandlerItemDefiners.GOLD) {
            addGold(request.getValue());
        }

    }

    private void addGold(int amount){
        this.gold+=amount;
    }

}
