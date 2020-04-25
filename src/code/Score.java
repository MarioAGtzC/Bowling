package code;

import java.util.ArrayList;

public class Score {
    
    public void imprimirScore(ArrayList<Integer> tiros) {
        imprimirSeparador();
        imprimirRondas();
        imprimirSeparador();
        for (int i  = 0; i < tiros.size(); i++) {
            if(tiros.get(i) == null) {
                System.out.print("|   ");
            }
            else if(tiros.get(i) == 10) {
                System.out.print("| X ");
            }
            else {
                System.out.print("| " + tiros.get(i) + " ");
            }
        }
        System.out.println("|");
        
        imprimirSeparador();
        
        for (int i  = 1; i < 11; i++) {         
            System.out.print("|   " + 4 + "   ");
        }
        System.out.println("    |");
        
        imprimirSeparador();
    }
    
    private void imprimirSeparador() {
        for (int i  = 0; i < 10; i++) {         
            System.out.print("+-------");
        }
        System.out.println("----+");
    }
    
    private void imprimirRondas(){
        for (int i  = 1; i < 11; i++) {         
            System.out.print("|Ronda " + i);
        }
        System.out.println("   |");
    }
    
    
}