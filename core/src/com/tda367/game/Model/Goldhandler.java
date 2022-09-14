package com.tda367.game.Model;

public class Goldhandler extends MainHandler {
    private int gold = 0;


    public void handleRequest(Request request){

        if (request.getDescription() == HandlerItemDefiners.GOLD) {
            addGold(request.getValue());
        }
        else if (m_successor != null)
        {
            m_successor.handleRequest(request);
        }
    }

    private void addGold(int amount){
        System.out.println(amount);
        this.gold+=amount;
    }

    public int getGold() {return gold;}
}
