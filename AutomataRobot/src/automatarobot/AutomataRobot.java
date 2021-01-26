package automatarobot;

import java.util.Random;

public class AutomataRobot {

    public static void main(String[] args) {
        Random random=new Random();
        Objeto lo[]=new Objeto[10];
        for(int n=0;n<10;n++){
            lo[n]=new Objeto(true,random.nextInt(639),random.nextInt(459));
        }
        Objeto bateria=new Objeto(true,random.nextInt(639),random.nextInt(459));
        Maquina robotillo=new Maquina();
        robotillo.Inicializar(lo, bateria);
        robotillo.run();
    }        
}
