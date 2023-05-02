package se.kth.iv1350.seminar3.view;

import se.kth.iv1350.seminar3.controller.*;

public class View{
    private Controller contr;

    public View(Controller contr){
        this.contr = contr;
    }

    public void test(){
        contr.startSale();
        contr.scanItem(3, 2);
    }
}