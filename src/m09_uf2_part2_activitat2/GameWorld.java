package M09_UF2_Part2_Activitat2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameWorld implements Runnable {

    /**
     * Declaramos nuestras variables e inicializamos la List
     */
    private WorldCanvas canvas;
    private List<Ball> bolitas= new ArrayList<>();
    private boolean mover=true;
    private Ball ball;

    /**
     * Creamos el nuevo hilo y lo iniciamos
     */
    public void startSimulation() {
        new Thread(this).start();
    }
    
    /**
     * Pasamos la variable mover a false.
     */
    public void endSimulation() {
        this.mover=false;
    }

    /**
     * Sobreescribimos run. Mientras mover sea true se entra en el for each
     * que recorre el ArrayList, para despues mover cada bola que este contenga.
     * A continuacion se hace un repain para permitir que las bolas lleguen a 
     * los margenes  (si estos han sido modificados). Tambien hay un try catch 
     * para evitar posibles errores, en este caso solo lo usamos para el
     * thread.sleep.
     */
    @Override
    public void run() {
        while (mover) {
            for (Ball bolita : bolitas) {
                bolita.move(canvas.getSize());
                
            }
            canvas.repaint();
                try {
                    Thread.sleep(27);
                } catch (InterruptedException ie) {

                }
        }

    }
    
    /**
     * Almacenamos el parametro recibido en una variable local.
     * @param canvas 
     */
    void init(WorldCanvas canvas) {
        this.canvas = canvas;
    }
    
    /**
     * Cada vez que es llamado añade una nueva bola al ArrayList
     * @param b 
     */
    void addBall(Ball b) {
        bolitas.add(b);
    }

    /**
     * Recuperamos la bola en la que esta el iterator(cursor).
     * @return 
     */
    Iterator<Ball> getBalls() {
        return bolitas.iterator();
    }

    /**
     * Midiendo la longitud de la lista conseguimos la cantidad de bolas que 
     * tenemos.
     * @return 
     */
    int getBallCount() {
        return bolitas.size();
    }

}
