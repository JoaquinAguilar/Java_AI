package automatacalentador;

public class Maquina implements Runnable {
    private int estado;
    private int temperatura;
    
    public Maquina(){
    estado = Estados.APAGADO.ordinal();
    temperatura=5;
    System.out.println("==Estado Inicial: "+Estados.values()[estado]+"==");
    }

    @Override
    public void run() { //Para escribir el ontrol
        while(true){
            switch(estado){
                case 0:
                    if(temperatura < 50){
                        estado = Estados.PRENDIDO.ordinal();
                        System.out.println("==Estado Actual: "+Estados.values()[estado]+"==");
                    }else{
                        temperatura--;
                        try{
                            Thread.sleep(200);
                        }catch(InterruptedException ex){}
                    }
                    break;
                case 1:
                    if(temperatura > 85){
                        estado = Estados.APAGADO.ordinal();
                        System.out.println("==Estado Actual: "+Estados.values()[estado]+"==");
                    }else{
                        temperatura++;
                        try{
                            Thread.sleep(100);
                        }catch(InterruptedException ex){}
                    }
                    break;
            }
            System.out.println("Temp = "+temperatura);
        }
    }
    
    
    
}
