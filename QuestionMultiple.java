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
public class QuestionMultiple implements Question{
    private String answerCandidates;
    private String answerKey;
    
    public QuestionMultiple(String alpha, String answer )
    {
            answerKey =  answer;
            answerCandidates = alpha;
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
        for (int i = 0; i < answer.length(); i++)
        {
            if (!answerCandidates.contains(("" + answer.charAt(i))))
                return false;
        }
        
        //checking if answer matches answer key
        if (answer.length() != answerKey.length()) return false;
        for (int i = 0; i < answer.length(); i++)
            {
                if (!answerKey.contains(("" + answer.charAt(0))))
                    return false;
            }
        return true;
    }
    
    public static void main(String[] args)
    {
        Question q = new QuestionMultiple("abcdefg", "fad");
        if(q.verifyAnswer("a")) System.out.println("One incorrect");
        if(q.verifyAnswer("f")) System.out.println("Two incorrect");
        if(q.verifyAnswer("daf")) System.out.println("Three is correct ");
        if(q.verifyAnswer("dfa")) System.out.println("Four is correct");
    }
}
