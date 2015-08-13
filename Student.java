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
public class Student {
    private String id;
    private String answers;
    
    public Student(String id, String answers)
    {
        this.id = id;
        this.answers = answers;
    }
    
    public Student(String id)
    {
        this.id = id;
        this.answers = "";
    }
    
    public String getID()
    {
        return this.id;
    }
    
    public void setAnswers(String answers)
    {
        if (id != null)
            this.answers = answers;
    }
    
    public String getAnswers()
    {
        return this.answers;
    }
}
