package automatarobot;

public class Objeto {
    private boolean activo;
    private int x,y;
    
    public Objeto(){
    }

    public Objeto(boolean activo, int x, int y) {
        this.activo = activo;
        this.x = x;
        this.y = y;
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
