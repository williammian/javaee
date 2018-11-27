package br.com.wm.websockets;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/hello")
public class HelloWorldEndpoint {

    public HelloWorldEndpoint() {
        System.out.println("classe carregada " + this.getClass());
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.printf("Sessão aberta, id: %s%n", session.getId());
        try {
            session.getBasicRemote().sendText("Olá, nós estamos conectados com sucesso.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.printf("Mensagem recebida. Sessão id: %s Mensagem: %s%n",
                session.getId(), message);
        try {
            session.getBasicRemote().sendText(String.format("Nós recebemos sua mensagem: %s%n", message));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @OnError
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @OnClose
    public void onClose(Session session) {
        System.out.printf("Sessão fechada com id: %s%n", session.getId());
    }
}
