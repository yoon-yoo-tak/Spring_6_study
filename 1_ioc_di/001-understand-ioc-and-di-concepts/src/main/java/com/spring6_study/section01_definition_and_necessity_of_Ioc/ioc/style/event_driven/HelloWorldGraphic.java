package com.spring6_study.section01_definition_and_necessity_of_Ioc.ioc.style.event_driven;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloWorldGraphic extends JFrame {
    public HelloWorldGraphic() {
        setTitle("HelloWorldGraphic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        Container container = getContentPane();
        JButton button = new JButton("Hello");
        button.addActionListener(e -> System.out.println("Hello"));
        container.add(button);
        setVisible(true);
    }
}
