package netgloo.configs;
import org.omg.CORBA.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import netgloo.Notification;

@Component
public class WebSocketChatEventListener {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    
   /* @Autowired
    Notification n;*/
    String message="hi";
    
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
    	//System.out.println(event.getUser().getName());
    	messagingTemplate.convertAndSend(
    	     
    	      "topic/notify", 
    	      new Notification(event.getUser().getName()+"  "+"joined")
    	    );
    	
      
    }
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
    	messagingTemplate.convertAndSend(
       	     
      	      "topic/notify", 
      	      new Notification(event.getUser().getName()+"  "+"Leaved")
      	    );
    }
}