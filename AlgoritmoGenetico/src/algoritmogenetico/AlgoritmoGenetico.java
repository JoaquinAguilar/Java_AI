package algoritmogenetico;

import java.util.Random;

public class AlgoritmoGenetico {


    public static void main(String[] args) {

        Random random = new Random();
        int tamPob=20;
        int size=12;
        int li=-2;
        int ls=2;
        int matriz [][] = new int [tamPob] [size];
    
        for (int x = 0; x < matriz.length; x++) {
                for (int y = 0; y < matriz[x].length; y++) {
                    matriz[x][y] = random.nextInt(2);                   
                }
    }//Aqui termina el for
        
    //Decodificación (Pasar de binario a decimal)
    int matriz2 []=new int [tamPob];
    int exp = 0;
    
    for (int x = 0; x < matriz.length; x++) {
                for (int y = 0; y < matriz[x].length; y++) {
                    exp=11-y;
                    matriz2[x]+=matriz[x][y]*Math.pow(2, exp); 
                }
    }

    
    double matriz3 []=new double[tamPob];
    
    //Numero real (X)
    for (int x = 0; x < matriz.length; x++) {
                for (int y = 0; y < matriz[x].length; y++) {
                    double xr= li+((matriz2[x]/(Math.pow(2, size)-1))*(ls-li));
                    matriz3[x]=xr;
                }
    }
    
    double matriz4 []=new double[tamPob];
    
    //Evaluando la funcion (x^2)
    for (int x = 0; x < matriz.length; x++) {
                for (int y = 0; y < matriz[x].length; y++) {
                    double fx=Math.pow(matriz3[x],2);
                    matriz4[x]=fx;
                }
    }

    //Aqui se encuentra em mejor (pokemon theme)
    double mejor = Double.POSITIVE_INFINITY;
    double mejorx = Double.POSITIVE_INFINITY;
    for(int p=0; p<matriz4.length;p++){
        if(matriz4[p]<mejor){ 
            mejor=matriz4[p];
            mejorx=matriz3[p];
        }
    }
        System.out.println();
        System.out.print("El mejor de la generación original es: fx= "+String.format("%.6f",mejor) +" x= " + String.format("%.6f", mejorx));
        System.out.println();    
    //Hacer las dos selecciones
    int sel1=0;
    int sel2=0;
    
//    System.out.println("Torneo binario");
    int matriz5[][]=new int [tamPob][size];
    int matriz6 []= new int[tamPob];
    double matriz7[]=new double[tamPob];
    double matriz8[]=new double[tamPob];
    
    for(int v=0;v<6;v++){
        boolean cRand=true;
        while(cRand==true){
            sel1=random.nextInt(tamPob)+1;
            sel2=random.nextInt(tamPob)+1;
            if(sel1==sel2){
                cRand=true;
            }else{
                cRand=false;
            }      
        }
        
        double win=0;
        int ind = 0;

        
            if(matriz4[sel1-1]<matriz4[sel2-1]){
                    win=matriz4[sel1-1];
                    ind=sel1-1;
                }else{
                win=matriz4[sel2-1];
                ind=sel2-1;
            }
        //Población de padres     
        for (int y = 0; y < matriz5[v].length; y++) {
                    matriz5[v][y] = matriz[ind][y];                   
        }      
//        System.out.println("Selección 1: "+sel1+"   "+"Selección 2: "+sel2+"   "+"El ganador es: "+String.format("%.3f",win));
//        System.out.println();
//    matriz6[v]=matriz2[ind];
//    matriz7[v]=matriz3[ind];
//    matriz8[v]=matriz4[ind]; 


    }//Aqui termina el for de la selección
//    System.out.println("Población de nuevos padres");
         
    
    for (int x = 0; x < matriz5.length; x++) {
                for (int y = 0; y < matriz5[x].length; y++) {
                    exp=11-y;
                    matriz6[x]+=matriz5[x][y]*Math.pow(2, exp); 
                }
    }
        
        for (int x = 0; x < matriz5.length; x++) {
                for (int y = 0; y < matriz5[x].length; y++) {
                    double xrt= li+((matriz6[x]/(Math.pow(2, size)-1))*(ls-li));
                    matriz3[x]=xrt;
                }
    }
        for (int x = 0; x < matriz5.length; x++) {
                for (int y = 0; y < matriz5[x].length; y++) {
                    double fxt=Math.pow(matriz3[x],2);
                    matriz4[x]=fxt;
                }
    }
    
        for (int x = 0; x < matriz5.length; x++) {
                for (int y = 0; y < matriz5[x].length; y++) {
                    if(y<matriz5[x].length-1){   
                     if(y==0){/*System.out.print(x+1+" ");*/}                      
//                    System.out.print(matriz5[x][y]);
                    }
                    else{ 
//                        System.out.println(matriz5[x][y]+"   "+matriz6[x]+"   "+ String.format("%.3f",matriz3[x])+"  "+String.format("%.3f",matriz4[x]));
//                        System.out.println(matriz5[x][y]+"   "+matriz6[x]+"   "+ String.format("%.3f", matriz7[x])+"  "+String.format("%.3f",matriz8[x]));
                    }
                }
        }
        
//Cruza de un punto         
    int pC=random.nextInt(size);
    int pC1=random.nextInt(size);
    int pC2=random.nextInt(size);
    double vC1=random.nextDouble();
    double vC2=random.nextDouble();
    double vC3=random.nextDouble();
    int matrizH1[][]=new int[tamPob][size];
    
        for (int o = 0; o < 200; o++) {
            System.out.print("La generación es: "+(o+1));
//Hijos
//pareja 1
//        System.out.println("Hijos:");
        if(vC1<=0.6){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < pC; j++) {
                matrizH1[i][j]=matriz5[i][j];
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = pC; j < 12; j++) {
                if (i==0) {
                matrizH1[i][j]=matriz5[i+1][j];
                }else{
                matrizH1[i][j]=matriz5[i-1][j];
                }
            }
        }
        }else{
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <size; j++) {
                matrizH1[i][j]=matriz5[i][j];
            }
        }
    }
        
//pareja 2
        if(vC2<=0.6){
        for (int i = 2; i < 4; i++) {
            for (int j = 0; j < pC1; j++) {
                matrizH1[i][j]=matriz5[i][j];
            }
        }
        for (int i = 2; i < 4; i++) {
            for (int j = pC1; j < 12; j++) {
                if (i==2) {
                matrizH1[i][j]=matriz5[i+1][j];
                }
                if (i==3){
                matrizH1[i][j]=matriz5[i-1][j];
                }
            }
        }
        }else{
        for (int i = 2; i < 4; i++) {
            for (int j = 0; j <size; j++) {
                matrizH1[i][j]=matriz5[i][j];
            }
        }
        }

//pareja 3
        if(vC3<=0.6){
        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < pC2; j++) {
                matrizH1[i][j]=matriz5[i][j];
            }
        }
        for (int i = 4; i < 6; i++) {
            for (int j = pC2; j < 12; j++) {
                if (i==4) {
                matrizH1[i][j]=matriz5[i+1][j];
                }
                if (i==5){
                matrizH1[i][j]=matriz5[i-1][j];
                }
            }
        }
        }else{
        for (int i = 4; i < 6; i++) {
            for (int j = 0; j <size; j++) {
                matrizH1[i][j]=matriz5[i][j];
            }
        }
        }
        
        for (int x = 0; x < matrizH1.length; x++) {
                for (int y = 0; y < matrizH1[x].length; y++) {
                    if(y<matrizH1[x].length-1){   
                     if(y==0){/*System.out.print(x+1+" ");*/}                      
//                    System.out.print(matrizH1[x][y]);
                    }
                    else{ 
//                        System.out.println(matrizH1[x][y]);
                    }
                
        }
    } 
    System.out.println();
    
//Mutación
        for (int i = 0; i < tamPob; i++) {
            double rM=random.nextDouble(); //Random de mutación
            int rP=random.nextInt(size); //Random para la posición de la permutación
//            System.out.println("La probabilidad de mutación es: "+String.format("%.3f",rM)+" |"+" El individuo es: "+(i+1)+" |"+" La posición es: "+rP);
            if (rM<=0.8) {
                if (matrizH1[i][rP]==0) {
                    matrizH1[i][rP]=1;
                }else{
                    matrizH1[i][rP]=0;
                }
            }
        }
        
//Evaluación de los mutantes
    int matrizBD[]=new int[tamPob];
    double matrizX[]=new double[tamPob];
    double matrizX2[]=new double[tamPob];
    
//Binario a decimal
    for (int x = 0; x < matrizH1.length; x++) {
                for (int y = 0; y < matrizH1[x].length; y++) {
                    exp=11-y;
                    matrizBD[x]+=matrizH1[x][y]*Math.pow(2, exp); 
                }
    }
//x
    for (int x = 0; x < matrizH1.length; x++) {
                for (int y = 0; y < matrizH1[x].length; y++) {
                    double xr= li+((matrizBD[x]/(Math.pow(2, size)-1))*(ls-li));
                    matrizX[x]=xr;
                }
    }
//x^2
    for (int x = 0; x < matrizH1.length; x++) {
                for (int y = 0; y < matrizH1[x].length; y++) {
                    double fx=Math.pow(matrizX[x],2);
                    matrizX2[x]=fx;
                }
    }
    
//    System.out.println();
//    System.out.println("Mutación: ");
    for (int x = 0; x < matrizH1.length; x++) {
                for (int y = 0; y < matrizH1[x].length; y++) {
                    if(y<matrizH1[x].length-1){   
                     if(y==0){/*System.out.print(x+1+" ");*/}                      
//                    System.out.print(matrizH1[x][y]);
                    }
                    else{ 
//                       System.out.println(matrizH1[x][y]+"   "+matrizBD[x]+"   "+ String.format("%.3f",matrizX[x])+"  "+String.format("%.3f",matrizX2[x]));
                    }
                
        }
    }
//Mejor de la población de hijos
    double mejor2 = Double.POSITIVE_INFINITY;
    double mejorx2 = Double.POSITIVE_INFINITY;
    for(int p=0; p<matrizX2.length;p++){
        if(matrizX2[p]<mejor2){ 
            mejor2=matrizX2[p];
            mejorx2=matrizX[p];
        if (matriz4[p]<mejor) {
            mejor=matriz4[p];
            mejorx=matriz3[p];
        }
      }
    }
    if (mejor<mejor2) {
            System.out.println("El mejor de todos es: fx= "+String.format("%.6f",mejor)+" x= "+String.format("%.6f", mejorx));
            mejor=mejor;
    }else{
        System.out.println("El mejor de todos es: fx= "+String.format("%.6f",mejor2)+" x= "+String.format("%.6f", mejorx2));
        mejor=mejor2;
        }       
    }
}
}