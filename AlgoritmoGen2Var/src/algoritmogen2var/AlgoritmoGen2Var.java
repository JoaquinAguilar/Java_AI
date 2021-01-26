package algoritmogen2var;

import java.util.Random;

public class AlgoritmoGen2Var {

    public static void main(String[] args) {
        Random random = new Random();
        int pob=900;
        int size=24;
        int li=-3;
        int ls=3;
        int matriz [][] = new int [pob] [size]; //Población original
        int matriz2[]=new int [pob];// Binario a decimal
        int exp=0;
        double matriz3[]=new double[pob];//Valores de X
        double matrizx2[]=new double[pob];
        double matrizx3[]=new double[pob];
        double matriz4[]=new double[pob];//Valores de f(x)
        double fx=0;
        double x1=0;
        double mejorfx=Double.POSITIVE_INFINITY;//Mejor fx gen actual
        double mejorx=Double.POSITIVE_INFINITY;//Mejor x gen actual
        int matriz5[]=new int[pob];//Arreglo de ganadores
        double prC=0.7; //Probabilidad de cruza propuesta
        double prCA=0; // probabilidad de cruza aleatoria
        int pC=0;//punto de cruza
        int matrizC[][]= new int [pob][size];//Matriz de cruza
        double pM=0.2;//Mutación propuesta
        double pMA=0;//probabilidad de mutación aleatora
        int pos=0;
        double mejorTfx=Double.POSITIVE_INFINITY; //mejor fx gen todos
        double mejorTx=Double.POSITIVE_INFINITY;//Mejor x gen todos
        double mejorTx2=Double.POSITIVE_INFINITY;
        double mejorHfx=Double.POSITIVE_INFINITY;
        double mejorHx=Double.POSITIVE_INFINITY;
        double mejorHx2=Double.POSITIVE_INFINITY;
        //Constantes
        double g = -32.17;
        double yo = 300;
        double m = 0.25;
        double k = 0.1;
        double t = 0;
        
    for (int x = 0; x < matriz.length; x++) {
                for (int y = 0; y < matriz[x].length; y++) {
                    if (y<matriz[x].length-1) {
                    matriz[x][y]=random.nextInt(2);
                    }else{
                    matriz[x][y]=random.nextInt(2);
                    }
                }
    }
    //Binario a decimal    
    for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < ((matriz[x].length/2) -1)  ; y++) {
                exp = ((matriz[1].length/2)-1) - y;
                
                matriz2[x]+=matriz[x][y]*Math.pow(2, exp);
            }
            for (int y = (matriz[x].length/2); y < matriz[x].length; y++) {
                
                exp=(matriz[x].length -1)-y;
                matrizx2[x]+=matriz[x][y]*Math.pow(2,exp);
                
            }
//            System.out.println("x1 =" + matriz2[x]);
//            System.out.println("x2 =" + matrizx2[x]);

        }
    
    //Numero real (x1, x2)
    for (int x = 0; x < matriz.length; x++) {
            x1=li+(((matriz2[x]/(Math.pow(2,(size/2))-1)))*(ls-li));
            matriz3[x] = x1;
        }
                for (int x = 0; x < matriz.length; x++) {
            x1=li+(((matrizx2[x]/(Math.pow(2,(size/2))-1)))*(ls-li));
            matrizx3[x]=x1;
        }
    
    //Evaluando la función (x^2)
    for (int x = 0; x < matriz.length; x++) {
                    fx=Math.pow(matriz3[x], 2)+Math.pow(matrizx3[x], 2);
                    matriz4[x]=fx;
//                System.out.println(matriz4[x]);
    }
    
    
    //Aqui se encuentra el mejor (pokemon theme)
    for(int p=0; p<matriz4.length;p++){
        if(matriz4[p]<mejorfx){ 
            mejorfx=matriz4[p];
            mejorx=matriz3[p];
        }
        if(mejorfx<mejorTfx){
            mejorTfx=matriz4[p];
            mejorTx=matriz3[p];
            mejorTx2=matrizx3[p];
        }
    }
        System.out.print("El mejor de la generación original es: fx= "+String.format("%.6f",mejorTfx) +" x= " + String.format("%.6f", mejorTx)+" x= "+String.format("%.6f", mejorTx2));
        System.out.println();
//  Torneo binario
    for (int i = 0; i < pob; i++) {
            boolean f=true;
            int win=0; 
                    
            int r=random.nextInt(pob);
            int r2=random.nextInt(pob);
            while (f==true) {
                if (r==r2) {
                    r2=random.nextInt(pob);
                    f=true;
                } else {
                    f=false;
                }
            }
            if (matriz4[r]<matriz4[r2]) {
                win=r+1;
                matriz5[i]=r;
            } else {
                win=r2+1;
                matriz5[i]=r2;
            }

            // System.out.println((i+1)+". \t Selección 1: " + (r+1) + "\t Selección 2: " + (r2+1) + "\t Ganador: "+ ganador);
        
        //Población de padres     
//        for (int y = 0; y < mP[i].length; y++) {
//                    mP[i][y] = matriz[ind][y];                   
        }      
//        System.out.print("Selección 1: "+sel1+"   "+"Selección 2: "+sel2+"   "+"El ganador es: "+(ind+1));
//        System.out.println();
//        mBDP[i]=mBD[ind];
//        mXP[i]=mX[ind];
//        mX2P[i]=mXP[ind]; 
//    
//    }

    for (int o = 0; o < 700; o++) {
    System.out.print("La generación es: "+(o+1));
    System.out.println();
    //Cruza
        int cont = 0;

        for (int x = 0; x < (pob); x = x + 2) {
            if (prCA<prC) {
                pC=random.nextInt(size);
                for (int y = 0; y < pC; y++) {
                    matrizC[cont][y]=matriz[matriz5[x]][y];
                }
                for (int y = pC; y < size; y++) {
                    matrizC[cont][y]=matriz[matriz5[x+1]][y];
                }
                for (int y = 0; y < pC; y++) {
                    matrizC[cont+1][y]=matriz[matriz5[x+1]][y];
                }
                for (int y = pC; y < size; y++) {
                    matrizC[cont+1][y]=matriz[matriz5[x]][y];
                }
                cont=cont+2;
            } else {

                for (int y = 0; y < size; y++) {
                    matrizC[cont][y]=matriz[matriz5[x]][y];
                }
                for (int y = 0; y < size; y++) {
                    matrizC[cont+1][y]=matriz[matriz5[x+1]][y];

                }

                cont = cont + 2;

            }
        }
    
    //Mutación
    int matrizH[][]=new int[pob][size];//guarda los hijos
    for (int i = 0; i < matrizC.length; i++) {
        pMA=random.nextDouble(); //Random de mutación
        pos=random.nextInt(size); //Random para la posición de la permutación
             //System.out.println("La probabilidad de mutación es: "+String.format("%.3f",rM)+" |"+" El individuo es: "+(i+1)+" |"+" La posición es: "+rP); 
             if (pMA<pM) {
                for (int y = 0; y < matrizC[i].length; y++) {
                if(y==pos){
                    if(matrizC[i][y]==0){
                        matrizH[i][y]=1;
                    }else if(matrizC[i][y]==1){
                        matrizH[i][y]=0;
                    }
                }else{
                    matrizH[i][y]=matrizC[i][y];
                }
                }
                }else{
                 for (int y = 0; y < matrizC[i].length; y++) {
                     matrizH[i][y]=matrizC[i][y];
                 }
             }
    }
//Evaluación de los mutantes

//Binario a decimal
    int matrizHBD[]=new int[pob];
    int matrizHBD2[]=new int[pob];
    exp=0;
    
    for (int x = 0; x < matrizH.length; x++) {
                for (int y = 0; y < ((matrizH[x].length/2)-1); y++) {
                    exp=((matrizH[x].length/2)-1)-y;
                    matrizHBD[x]+=matrizH[x][y]*Math.pow(2, exp); 
                }
                for (int y = (matrizH.length/2); y < matrizH[x].length; y++) {
                    exp=(matrizH[x].length-1)-y;
                    matrizHBD2[x]+=matrizH[x][y]*Math.pow(2, exp);
        }
    }
//x
    double matrizHX[]=new double[pob];
    double matrizHX2[]=new double[pob];
    for (int x = 0; x < matriz.length; x++) {
                x1=li+(((matrizHBD[x]/(Math.pow(2,(size/2))-1)))*(ls-li));
                matrizHX[x] = x1;
            }
            
    for (int x = 0; x < matriz.length; x++) {
                x1=li+(((matrizHBD2[x]/(Math.pow(2,(size/2))-1)))*(ls-li));
                matrizHX2[x] = x1;
            }
    
//x^2
    double matrizHFX[]=new double[pob];
    for (int x = 0; x < matrizH.length; x++) {
                    fx=Math.pow(matrizHX[x],2)+Math.pow(matrizHX2[x],2);
                    matrizHFX[x]=fx;             
    }
    
//    System.out.println();
//    System.out.println("Mutación: ");
//    for (int x = 0; x < mH.length; x++) {
//                for (int y = 0; y < mH[x].length; y++) {
//                    if(y<mH[x].length-1){   
//                     if(y==0){/*System.out.print(x+1+" ");*/}                      
//                    System.out.print(mH[x][y]);
//                    }
//                    else{ 
//                       System.out.println(mH[x][y]+"   "+mBDM[x]+"   "+ String.format("%.3f",mXM[x])+"  "+String.format("%.3f",mX2M[x]));
//                    }
//                
//        }
//    }
    
    for(int p=0; p<matrizHFX.length;p++){
        if(matrizHFX[p]<mejorHfx){ 
            mejorHfx=matrizHFX[p];
            mejorHx=matrizHX[p];
            mejorHx2=matrizHX2[p];
        }
        if (mejorHfx<mejorTfx) {
            mejorTfx=matrizHFX[p];
            mejorTx=matrizHX[p];
            mejorTx2=matrizHX2[p];
        }
    }
    
    System.out.println("El mejor de la generación es: x= "+String.format("%.6f",mejorTx)+" x2= "+String.format("%.6f",mejorTx2)+"\t f(x)= "+String.format("%.6f", mejorTfx));
    
    for (int x = 0; x < matriz.length; x++) {
        for (int y = 0; y < matriz[x].length; y++) {
            matriz[x][y] = matrizH[x][y];
        }
    }
        for (int x = 0; x < matriz.length; x++) {
            matriz2[x]=matrizHBD[x];
            matrizx2[x]=matrizHBD2[x];
        }
        
        for (int x = 0; x < matriz.length; x++) {
            matriz3[x]=matrizHX[x];
            matrizx3[x]=matrizHX2[x];
        }
        
        for (int x = 0; x < matriz.length; x++) {
            matriz4[x]=matrizHFX[x];
        }
        
    } //For grandote
    }
}