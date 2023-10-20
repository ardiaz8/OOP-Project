package oop_project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class SoccerQuestions extends JFrame implements ActionListener {
    private JLabel questionLabel; // Label to display the current question
    private JButton[] optionsButtons; // Array of buttons for answer options
    private int currentQuestion; // Index of the current question
    private int score; // Accumulated score
    
    // List of questions and answers
    private String[] questions = {
        "What is the team with the most Champions Leagues?",
        "Who was the first Mexican to play for FC Barcelona?",
        "How many minutes does a soccer game last?"
    };
    
    private String[][] answers = {
        {"Real Madrid", "Manchester United", "Barcelona"},
        {"Rafa Marquez", "Hugo Sanchez", "Chicharito"},
        {"90", "30", "75"}
    };
    
    private int[] accumulatedScore = {10, 20, 15};
    
    public SoccerQuestions() {
        super("Trivia Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());
        
        questionLabel = new JLabel();
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(questionLabel, BorderLayout.NORTH);
        
        JPanel optionsPanel = new JPanel(new GridLayout(3, 1));
        optionsButtons = new JButton[3];
        for (int i=0; i<3; i++) {
            optionsButtons[i] = new JButton();
            optionsButtons[i].addActionListener(this);
            optionsPanel.add(optionsButtons[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);
        
        currentQuestion = 0;
        score = 0;
        displayQuestion();
        
        setVisible(true);    
    }
    
    // Verify the answer selected by the player
    private void verifyAnswer(int selectedOption) {
        if (selectedOption >= 0 && selectedOption <3) {
            if (answers[currentQuestion][selectedOption].equals
                    (answers[currentQuestion][0])) {
                score += accumulatedScore[currentQuestion];
            }
            currentQuestion++;
            displayQuestion();
        }
    }
    
    // Display the final score dialog and end the game
    private void endGame() {
        JOptionPane.showMessageDialog(this, "Game over. Score: " +
                score);
        System.exit(0);
    }
    
    // Display the next question or end the game if there are no more questions
    private void displayQuestion() {
        if(currentQuestion < questions.length) {
            questionLabel.setText(questions[currentQuestion]);
            for (int i=0; i<3; i++) {
            optionsButtons[i].setText(answers[currentQuestion][i]);
        }
        } else {
            endGame();
        }
    }
    
    // Handle user actions when clicking on an answer button
    @Override 
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<3;i++) {
            if(e.getSource() == optionsButtons[i]) {
                verifyAnswer(i);
                break;
            }
        }
    }
    
    // Main method to start the game
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SoccerQuestions();
            }
        });
    }

}
