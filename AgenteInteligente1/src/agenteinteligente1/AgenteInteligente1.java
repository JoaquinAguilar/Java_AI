package agenteinteligente1;

import java.util.Random;

public class AgenteInteligente1 {

    public static void main(String[] args) {
    Random random = new Random();
    int randx = 0;
    int randy = 0;
    
    boolean cRand = true;    

    //Creación del mundo
        
    int mundo [][] = new int [13] [16];
    for(int i=0; i<=12; i++){
        mundo[i][0]=1;
    }
    for(int j=0+1;j<=15;j++){
        mundo[0][j]=1;
    }
    for(int k=0+1;k<=15;k++){
        mundo[12][k]=1;
    }
    for(int l=0+1;l<=12;l++){
        mundo[l][15]=1;
    }
    
    mundo[1][14]=1;
    mundo[2][14]=1;
    mundo[3][14]=1;
    mundo[4][14]=1;
    mundo[1][13]=1;
    mundo[2][13]=1;
    mundo[3][13]=1;
    mundo[4][13]=1;
    mundo[1][12]=1;
    mundo[2][12]=1;
    mundo[3][12]=1;
    mundo[4][12]=1;
    mundo[9][14]=1;
    mundo[10][14]=1;
    mundo[11][14]=1;
    mundo[12][14]=1;
    mundo[9][13]=1;
    mundo[10][13]=1;
    mundo[11][13]=1;
    mundo[12][13]=1;
    mundo[9][12]=1;
    mundo[10][12]=1;
    mundo[11][12]=1;
    mundo[12][12]=1;
    mundo[8][12]=1;
    mundo[8][13]=1;
    mundo[8][14]=1;
    mundo[11][6]=1;
    mundo[11][7]=1;
    mundo[11][8]=1;
    mundo[10][6]=1;
    mundo[10][7]=1;
    mundo[10][8]=1;
    
    //objeto
    mundo[5][3]=1;
    mundo[6][3]=1;    
    mundo[7][3]=1;
    mundo[7][4]=1;
    mundo[6][4]=1;
    mundo[5][4]=1;
    mundo[7][7]=1;
    mundo[6][7]=1;
    mundo[5][7]=1;
    mundo[7][8]=1;
    mundo[6][8]=1;
    mundo[5][8]=1;
    mundo[5][5]=1;
    mundo[5][6]=1;
    
    //Agente     
    while(cRand==true){
        randx=random.nextInt(13);
        randy=random.nextInt(16);
        if(mundo[randx][randy]==1){
            cRand=true;
        }
        else{
            mundo[randx][randy]=5;
            cRand=false;
        }
    } 
        System.out.println("El agente cayó en: ["+randx+","+randy+"]");
    
    for(int i=0;i<13;i++){
    //Sensores
    int s1x=randx-1;
    int s1y=randy-1;
    int s2x=randx-1;
    int s2y=randy;    
    int s3x=randx-1;
    int s3y=randy+1;  
    int s4x=randx;
    int s4y=randy+1;  
    int s5x=randx+1;
    int s5y=randy+1;  
    int s6x=randx+1;
    int s6y=randy;  
    int s7x=randx+1;
    int s7y=randy-1; 
    int s8x=randx;
    int s8y=randy-1; 
    
    //Caracteristicas
    int x1=0;
    int x2=0;
    int x3=0;
    int x4=0;
    
    if(mundo[s2x][s2y]==1||mundo[s3x][s3y]==1){
        x1=1;
    }
    if(mundo[s4x][s4y]==1||mundo[s5x][s5y]==1){
        x2=1;
    }
    if(mundo[s6x][s6y]==1||mundo[s7x][s7y]==1){
        x3=1;
    }
    if(mundo[s8x][s8y]==1||mundo[s1x][s1y]==1){
        x4=1;
    }
    
    mundo[randx][randy]=0; //Reinicia los random
    //Acciones
//    int py=randy;
//    int px=randx;
    
    if(x1==1&&x2==0){ //East
        randy++;
        mundo[randx][randy]=5;
        randy=randy;
    }
    
    if(x2==1&&x3==0){ //South
        randx++;
        mundo[randx][randy]=5;
        randx=randx;
    }
    
    if(x3==1&&x4==0){ //West
        randy--;
        mundo[randx][randy]=5;
        randy=randy;
    }
    
    if(x4==1&&x1==0){ //North
        randx--;
        mundo[randx][randy]=5;
        randx=randx;
    }
    
    if(x1==0&&x2==0&&x3==0&&x4==0){ //North
        randx--;
        mundo[randx][randy]=5;
        randx=randx;
    }
   
    
    for (int x=0; x<13;x++){
        for (int y=0;y<16;y++){
            if(mundo[x][y]==1){
            System.out.print(mundo[x][y]); 
            System.out.print(" ");
            }
            else if(mundo[x][y]==0){
                System.out.print("  ");
                }
            else{
                System.out.print("μ ");
            }
        }
                    System.out.println();
    }
    try{
        Thread.sleep(500);
    } catch (InterruptedException ex){
    }
    }
    
    }
}
