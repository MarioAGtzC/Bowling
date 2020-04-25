package code;

import java.util.Scanner;
import java.util.ArrayList;

public class Juego {
    
    private Pinos pinos;
    private int ronda = 1;
    private int lanzamiento = 1;
    private Score score = new Score();
    private final Scanner reader = new Scanner(System.in);
    private final ArrayList<Integer> tiros = new ArrayList<Integer>(); //21 maximo de tiros - 12 minimo de tiros
    
    public ArrayList<Integer> getTiros() {
        return tiros;
    }
    
    public void empezarJuego() {
        while (ronda <= 10) {
            System.out.println("Ronda " + ronda);
            pinos = new Pinos();
            tirada();
            ronda++;
        }
        score.imprimirScore(tiros);
    }
    
    public void tirada() {
        System.out.println("Lanzamiento: " + lanzamiento);
        System.out.println("Pinos restantes: " + pinos.getPinos());
        System.out.print("Pinos tirados: ");
        int tiro = reader.nextInt();
        if(ronda == 10) {
            if(lanzamiento == 1) {
                if(pinos.getPinos() - tiro == 0) {
                    System.out.println("Strike");
                    getTiros().add(tiro);
                    lanzamiento ++;
                    tirada();
                }
                else {
                    lanzamiento ++;
                    getTiros().add(tiro);
                    pinos.setPinos(pinos.getPinos() - tiro);
                    tirada();
                }
            }
            else if(lanzamiento == 2) {
                if(getTiros().get(getTiros().size() - 2) != 10) {
                    if(pinos.getPinos() - tiro == 0) {
                        System.out.println("Spare");
                        lanzamiento ++;
                        getTiros().add(tiro);
                        pinos.setPinos(10);
                        tirada();
                    }
                    else {
                        getTiros().add(tiro);
                        getTiros().add(null);
                    }
                }
                else {
                    if(pinos.getPinos() - tiro == 0) {
                        System.out.println("Strike");
                        lanzamiento ++;
                        getTiros().add(tiro);
                        tirada();
                    }
                    else {
                        lanzamiento ++;
                        pinos.setPinos(pinos.getPinos() - tiro);
                        getTiros().add(tiro);
                        tirada();
                    }
                }
            }
            else if(lanzamiento == 3) {
                if(getTiros().get(getTiros().size() - 3) == 10) {
                    if(getTiros().get(getTiros().size() - 2) != 10) {
                        if(pinos.getPinos() - tiro == 0) {
                            System.out.println("Spare");
                            getTiros().add(tiro);
                        }
                    }
                    else {
                        if(pinos.getPinos() - tiro == 0) {
                            System.out.println("Strike");
                            getTiros().add(tiro);
                        }
                    }
                }
                else if(pinos.getPinos() - tiro == 0) {
                    System.out.println("Strike");
                    getTiros().add(tiro);
                }
            }
        }
        else if(lanzamiento == 1) {
            if(pinos.getPinos() - tiro == 0) {
                System.out.println("Strike");
                getTiros().add(null);
                getTiros().add(tiro);
            }
            else {
                lanzamiento++;
                pinos.setPinos(pinos.getPinos() - tiro);
                getTiros().add(tiro);
                tirada();
            }
        }
        else if(lanzamiento == 2) {
            if(pinos.getPinos() - tiro == 0) {
                System.out.println("Spare");
                getTiros().add(tiro);
            }
            else {
                getTiros().add(tiro);
            }
        }
        lanzamiento = 1;         
    }
}