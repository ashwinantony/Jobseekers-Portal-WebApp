/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.FileWriter;
import java.io.IOException;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Ashwin Antony
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "mydes"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class HelloMessageBean implements MessageListener {

    public HelloMessageBean() {
    }

    @Override
    public void onMessage(Message message) {

        try {
            TextMessage msg = (TextMessage) message;
            if (msg != null) {
                System.out.println(msg.getText());
                logWriter(msg.getText());
            }
        } catch (Exception e) {

        }
    }

    public void logWriter(String logs) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("E:\\Work Files\\Netbeans\\JobSeekersPortal\\JobSeekersPortal-ejb\\src\\java\\logfiles\\log.txt", true);
            writer.write(logs);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException ex) {

        }
    }

}
