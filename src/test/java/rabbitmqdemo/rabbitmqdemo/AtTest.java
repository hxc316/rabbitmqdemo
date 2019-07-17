package rabbitmqdemo.rabbitmqdemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AtTest extends RabbitmqdemoApplicationTests{

    @Autowired
    private A1 a1;

    @Test
    public void s(){
        a1.s();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
