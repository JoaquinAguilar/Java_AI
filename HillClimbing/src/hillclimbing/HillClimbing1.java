package hillclimbing;


import java.util.Random;

public class HillClimbing1 {
    
    private static int Iteraciones =0; //Iteraciones
    private static int heuristic = 0; //Encuentros resultantes
    
    public static NQueen[] generateBoard() {
        NQueen[] startBoard = new NQueen[8]; //Genera un tablero con 8 reinas
        Random rndm = new Random();
        for(int i=0; i<8; i++){
            startBoard[i] = new NQueen(rndm.nextInt(8), i);
        }
        return startBoard;
    }
    
    private static void printState (NQueen[] state) {
        int[][] tempBoard = new int[8][8];   //Tabla temporal donde se guardan resultados 
        for (int i=0; i<8; i++) {
            //Poner 1's en donde se encuentren las reinas
            tempBoard[state[i].getRow()][state[i].getColumn()]=1;
        }
        System.out.println();
        for (int i=0; i<8; i++) {
            for (int j= 0; j < 8; j++) {
                System.out.print(tempBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
    
     public static int findHeuristic (NQueen[] state) { //Encuentra la heuristica de las posiciones de las reinas
        int heuristic = 0;              //Cuando la heurística es 0, regresa lo que tiene
        for (int i = 0; i< state.length; i++) {
            for (int j=i+1; j<state.length; j++ ) {
                if (state[i].ifConflict(state[j])) {
                    heuristic++;
                }
            }
        }
        return heuristic;
    }
     
      public static NQueen[] nextBoard (NQueen[] presentBoard) { //Genera el siguiente tablero, con las siguientes posiciones
        NQueen[] nextBoard = new NQueen[8];
        NQueen[] tmpBoard = new NQueen[8];
        int presentHeuristic = findHeuristic(presentBoard); //Variables para comparar heuristicas
        int bestHeuristic = presentHeuristic; //Variable para la mejor heuristica encontrada
        int tempH;

        for (int i=0; i<8; i++) {
            nextBoard[i] = new NQueen(presentBoard[i].getRow(), presentBoard[i].getColumn());
            tmpBoard[i] = nextBoard[i];  //copiar el tablero actual al temporal 
        }
        //  Iteración de cada columna 
        for (int i=0; i<8; i++) {
            if (i>0)
                tmpBoard[i-1] = new NQueen (presentBoard[i-1].getRow(), presentBoard[i-1].getColumn());
            tmpBoard[i] = new NQueen (0, tmpBoard[i].getColumn());
        //  Iteración de cada fila
            for (int j=0; j<8; j++) {
                //Obtener la heuristica
                tempH = findHeuristic(tmpBoard);
                //Comprobar si el tablero temporal es mejor que el mejor tablero
                if (tempH < bestHeuristic) {
                    bestHeuristic = tempH;
                    //  Asignar el tablero temporal al mejor tablero
                    for (int k=0; k<8; k++) {
                        nextBoard[k] = new NQueen(tmpBoard[k].getRow(), tmpBoard[k].getColumn());
                    }
                }
                //Mover la reina
                if (tmpBoard[i].getRow()!=8-1)
                    tmpBoard[i].move();
            }
        }
        
//        if (bestHeuristic == presentHeuristic) { //Si la mejor heuristica es la actual, la variable genera la siguente table**
//            heuristic = findHeuristic(nextBoard);
//        } else
            heuristic = bestHeuristic;//Se agregan iteraciones al contador
        Iteraciones++;
        return nextBoard; 
    }
    
    public static void main(String[] args) {
        int presentHeuristic;
        
        //Crear el tablero inicial
        NQueen[] presentBoard = generateBoard();
        presentHeuristic = findHeuristic(presentBoard);
        //Comprobar si la tabla actual es la mejor solucion
        while (presentHeuristic != 0) {
            //Mientras la heuristica sea diferente de 0 seguir iterando
            printState(presentBoard); //Imprime cada iteracion del tablero
            presentBoard = nextBoard(presentBoard);
            presentHeuristic  = heuristic;
            if(Iteraciones>=10000){ //Cuando las iteraciones superen las 30, detener la busqueda
                break;
            }
        } 
        printState(presentBoard); //Imprime el tablero con la mejor solucion o el tablero actual si llega a la it. 30

        System.out.println("\nNúmero total de iteraciones realizadas: " + Iteraciones);
    }
    
}
