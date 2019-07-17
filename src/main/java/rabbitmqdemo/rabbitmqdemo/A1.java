package rabbitmqdemo.rabbitmqdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class A1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostConstruct
    public void a2(){
        log.info("@PostConstruct  启动监听回调 ");
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String s) {
                if(ack){
                    log.info("  =========>>> 回调成功 {}  id = {}", s , correlationData.getId());
                }else {
                    log.info(" =========>>> 回调失败 {}");
                }
            }
        });
    }

    public void s(){
        log.info("-----开始发送消息------");
        rabbitTemplate.convertAndSend("ex1","","22",new CorrelationData("2"));
    }

}
