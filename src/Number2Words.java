/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ubuntu02
 */
public class Number2Words {

    public static void main(String[] args){
        System.out.println("Welcome to numeric to words");
        String words="0123456789";
        for(int i=0;i<words.length();i++){
            int asValue=words.charAt(i);
            System.out.println(asValue);
        }
    }

}
