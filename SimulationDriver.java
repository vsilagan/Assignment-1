/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IVoteSimulator;
import java.util.Random;
/**
 *
 * @author Virgilio Ilagan III
 */
public class SimulationDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IVoteSimulator Sim = new IVoteSimulator();
        Question q1 = new QuestionSingular("ABCD", "D");
        Question q2 = new QuestionMultiple("ABCDEFG", "CD");
        Random rand = new Random(System.currentTimeMillis());
        
        Sim.loadQuestion(q1);
        // now adding 1-10 students to simulator
        for (int i = 0; i < 10; i++)
        {
            String answer = "" + q1.getCandidates().charAt(rand.nextInt((q1.getCandidates().length())));
            Sim.addStudent(new Student(Integer.toString(rand.nextInt(10) + 1),answer));   
        }
        
        Sim.print();
        
        Sim.loadQuestion(q2);
        // now adding 0-9 students to simulator
        for (int i = 0; i < 10; i++)
        {
            String answer = "";
            for (int j = 0; j < q1.getCandidates().charAt(rand.nextInt((q1.getCandidates().length()))); j++)
            {
                char answerPiece = q1.getCandidates().charAt(rand.nextInt((q1.getCandidates().length())));
                if(!answer.contains("" + answerPiece)) answer += answerPiece;
            }
            Sim.addStudent(new Student(Integer.toString(rand.nextInt(10) + 1),answer));   
        }
        
        //because it is very unlikely for the simulator to get the correct answer,
        //adding a student with the correct answer to show that it is detectible.
        Sim.addStudent(new Student("111", "CD"));
        Sim.print();
    }
    
}
