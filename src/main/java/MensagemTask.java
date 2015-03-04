

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * IF62C Fundamentos de Programação 2
 * Exemplo de programação em Java.
 * Tarefa que exibe a hora atual na saída padrão.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class MensagemTask extends TimerTask {
    
    private final Date currentTime = new Date();
    private final SimpleDateFormat sdf = new SimpleDateFormat("'Hora:' HH:mm:ss");
    private final java.util.Timer t2 = new java.util.Timer("impar");
    private final long delay = 10*1000;
            
    @Override
    public void run() {
        currentTime.setTime(System.currentTimeMillis());
        System.out.println(sdf.format(currentTime));
        
        if(((currentTime.getTime()/1000)/60)%2 != 0){
            t2.schedule(
                    new java.util.TimerTask()
                    {
                        @Override
                        public void run() {
                            System.out.println("Esperando...");
                        }
                    }, delay, delay);
        } else t2.cancel();
    }
            
        
 }

