package br.com.wm.jms;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsProvider {
	
	public static ConnectionFactory getConnectionFactory () {
        /*Permite que os clientes se conectem uns aos outros dentro da
                 VM sem a sobrecarga da comunicação de rede */
        ConnectionFactory connectionFactory =
                  new ActiveMQConnectionFactory("vm://localhost");

        return connectionFactory;
    }

}
