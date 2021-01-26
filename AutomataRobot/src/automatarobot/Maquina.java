package automatarobot;

import java.util.Random;

public class Maquina implements Runnable{
    private int estado;
    private int x,y;
    private Objeto objetos[]=new Objeto[10];
    private Objeto bateria;
    private int indice;
    private int energia;
    
    public Maquina(){
        estado=Estados.NBUSQUEDA.ordinal();
        x=320; y=240;
        indice=-1;
        energia=1000;
    }
    public void Inicializar(Objeto[] objetos, Objeto bateria){
        this.objetos=objetos.clone(); //.clone() genera una copia del arreglo de objetos.
        this.bateria=bateria;
    }

    @Override
    public void run() {
        while(true){
            switch(estado){
                case 0:
                    Busqueda();//Accion del estado
                    if(x==objetos[indice].getX()&&               //Transición
                                y==objetos[indice].getY()){
                        objetos[indice].setActivo(false); //Recoge el objeto
                        estado=Estados.NBUSQUEDA.ordinal();
                    }else if(energia<400){
                        estado=Estados.BATERIA.ordinal();
                    }
                    break;
                case 1:
                    NuevaBusqueda();
                    estado=(indice<0)? Estados.ALEATORIO.ordinal()//Estados va a tomar el valor de aleatorio si el indice es
                            :Estados.BUSQUEDA.ordinal();          //menor a 0 si no toma el de busqueda.
                    break;
                case 2:
                    IrBateria();
                    if(x==bateria.getX()&&y==bateria.getY()){
                        estado=Estados.RECARGAR.ordinal();
                    }if(energia<=0){
                        estado=Estados.MUERTO.ordinal();
                    }
                    break;
                case 3:
                    Recargar();
                    estado=Estados.BUSQUEDA.ordinal();
                    break;
                case 4:
                    Muerto();
                    break;
                case 5:
                    Aleatorio();
                    if(energia<=0){
                        estado=Estados.MUERTO.ordinal();
                    }
                    break;
            }
            try{
                Thread.sleep(50);
            }catch(InterruptedException ex){}
        }
    }
    
    public void Busqueda(){
        System.out.println("== BUSQUEDA ==");
        if(x<objetos[indice].getX())x++;
        else if(x>objetos[indice].getX())x--;
        
        if(y<objetos[indice].getY())y++;
        else if(y>objetos[indice].getY())y--;
        
        energia--;
    }
    public void NuevaBusqueda(){
        System.out.println("== NUEVA BUSQUEDA ==");
        indice=-1;
        for(int n=0; n<10; n++){
            if(objetos[n].isActivo()){
                indice=n;
            }
        }
    }
    public void IrBateria(){
        System.out.println("== IR BATERIA ==");
        if(x<bateria.getX())x++;
        else if(x>bateria.getX())x--;
        
        if(y<bateria.getY())y++;
        else if(y>bateria.getY())y--;
        
        energia--;
    }
    public void Recargar(){
        System.out.println("== RECARGAR ==");
        energia=1000;
    }
    public void Muerto(){
        System.out.println("== MUERTO x_x ==");
    }
    public void Aleatorio(){
        System.out.println("== ALEATORIO ==");
        Random random=new Random();
        int ny=random.nextInt(3);
        int nx=random.nextInt(3);
        
        x+=nx-1;
        y+=ny-1;
        
        energia--;
    }
}
