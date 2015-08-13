/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IVoteSimulator;
import java.util.ArrayList;
/**
 *
 * @author Virgilio Ilagan III
 */
public class IVoteSimulator {
    private ArrayList<Student> students;
    private Question question;
    
    public IVoteSimulator()
    {
        students = new ArrayList();
    }
    
    public void loadQuestion(Question newQuestion)
    {
        this.question = newQuestion;
    }
    
    
    public void addStudent(Student student)
    {   
        //if the student already exists in the list
        for (int i = 0; i < students.size(); i++)
        {
            if (student.getID().equals(students.get(i).getID()))
            {
                students.get(i).setAnswers(student.getAnswers());
                return;
            }
        }
        System.out.println("New student has joined!");
        students.add(student);
    }
    
    // prints out the current information within the service
    public void print()
    {
        if (question == null)
        {
            System.out.println("no question loaded!");
            return;
        }
        
        // Setting up vote counter
        // Vote index number corresponds to its index in the alphabet string.
        // Example "ab", a counter would be in 0, b counter would be in 1.
        String alphabet = question.getCandidates();
        int counter[] = new int[alphabet.length()];
        for (int i = 0; i < counter.length; i++)
            counter[i] = 0;
        int right = 0;
        int wrong = 0;

        //counting number of occurances;
        for (int i = 0; i < students.size(); i++)
        {
            String answer = students.get(i).getAnswers();
            
            for(int j = 0; j < alphabet.length(); j++)
            {
                if(answer.contains("" + alphabet.charAt(j)))
                {
                    counter[j]++;
                }
                
            }
            if (question.verifyAnswer(answer))   right++;
            else    wrong++;
        }
        
        for (int i = 0; i < counter.length; i++)
        {
            System.out.println(alphabet.charAt(i) + " : " + counter[i]);
        }
        System.out.println("Right : " + right);
        System.out.println("Wrong : " + wrong);
        
    }
    
    public static void main (String[] args)
    {
        IVoteSimulator i = new IVoteSimulator();
        i.addStudent(new Student("aaa", "3"));
        i.addStudent(new Student("Carl", "2"));
        i.print();
        Question q = new QuestionSingular("123","2");
        i.addStudent(new Student("Jill", "2"));
        i.loadQuestion(q);
        i.print();
        i.addStudent(new Student("aaa", "2"));
        i.print();
        q = new QuestionMultiple("123", "23");
        i.loadQuestion(q);
        i.print();
        i.addStudent(new Student ("Carl", "23"));
        i.print();
    }
}
