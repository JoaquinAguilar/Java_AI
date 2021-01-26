package hillclimbing;

public class NQueen {
    private int row;
    private int column;

    public NQueen(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void move () {
        row++;   //Se mueve horizontalmente
    }

    public boolean ifConflict(NQueen q){
        //  Revisar filas y columnas para ver si hay conflicto
        if(row == q.getRow() || column == q.getColumn())
            return true;
            //  Revisar diagonales
        else if(Math.abs(column-q.getColumn()) == Math.abs(row-q.getRow()))
            return true;
        return false;
    }
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}