//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import algorithms.RabinIAlgo;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        RabinIAlgo rk = new RabinIAlgo();
        rk.search(text, pattern);

    }
}