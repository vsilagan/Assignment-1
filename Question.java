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
public interface Question {
    public String getCandidates();
    public boolean verifyAnswer(String answer);

}
