package oop_project;

import javax.swing.SwingUtilities;

public class OOP_Project {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SoccerQuestions();
            }
        });
    }
    
}
