/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IVoteSimulator;
/**
 *
 * @author Virgilio Ilagan III
 */
public class QuestionSingular implements Question{
    private String answerCandidates;
    private String answerKey;
    
    public QuestionSingular(String alpha, String answer )
    {
        if (answer.length() == 1)
        {
            answerKey =  "" + answer.charAt(0);
            answerCandidates = alpha;
        }
    }

    @Override
    public String getCandidates()
    {
        return answerCandidates;
    }
    
    @Override
    public boolean verifyAnswer(String answer)
    {
        //checking if all the answers in the student's answer are in the list of
        //candidate answers.
            if (!answerCandidates.contains(("" + answer.charAt(0))))
                return false;
        
        //checking if answer matches answer key
        return (answer.length() == 1 && answer.charAt(0) == answerKey.charAt(0));
    }
    
    public static void main(String[] args)
    {
        Question q = new QuestionSingular("abcd", "d");
        if(q.verifyAnswer("a")) System.out.println("This is incorrect");
        if(q.verifyAnswer("f")) System.out.println("This is incorrect");
        if(q.verifyAnswer("da")) System.out.println("This is correct");
        if(q.verifyAnswer("d")) System.out.println("This is correct");
    }
}
