/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week11_0706012010011;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author reyna
 */
public class Soal1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random rand = new Random();
        
        int loop_play = 1;
        
        int limit = 2, start_turn = rand.nextInt(limit), turn = 0;
        int loop = 1;
        int loop_turn = 1;
        int start = 1;
        
        int score1 = 0, score2 = 0, health1 = 10, health2 = 10;
        String guess;
        int correct = 0 ;
        
        String category = null, question = null, answer = null;
         
        while(loop_turn == 1){
            loop_turn = 0;
            if(start == 1){
                start_turn = rand.nextInt(limit);
                start = 0;
            }
            if(start_turn == 0){
                System.out.println("Player 1 Enter Question");
                System.out.println("==========================================");
                System.out.print("Category : ");
                category = s.nextLine();
                System.out.print("Question : ");
                question = s.nextLine();
                answer = question;
                question = "";
                turn = 1;
                for(int i = 0; i < answer.length(); i++){
                    if(answer.charAt(i) == ' '){
                        question += "  ";
                    } else {
                        question += "_ ";
                    }
                }
                for(int i = 1; i <= 50; i++){
                    System.out.println("");
                }
            } else if(start_turn == 1){
                System.out.println("Player 2 Enter Question");
                System.out.println("==========================================");
                System.out.print("Category : ");
                category = s.nextLine();
                System.out.print("Question : ");
                question = s.nextLine();
                answer = question;
                question = "";
                turn = 0;
                for(int i = 0; i < answer.length(); i++){
                    if(answer.charAt(i) == ' '){
                        question += " ";
                    } else {
                        question += "_ ";
                    }
                }
                for(int i = 1; i <= 50; i++){
                    System.out.println("");
                }
            }
        }
        play:
        while(loop_play == 1){
            loop_play = 0;
            while(turn == 0 && loop == 1){
                loop = 0;
                System.out.printf("Player 1's Turn (Score = %d, Life = %d)\n", score1, health1);
                System.out.println("Category : " + category);
                System.out.println(question);
                System.out.print("Type an Alphabet : ");
                guess = s.next();
                if(guess.length() > 1){
                    loop = 1;
                    continue;
                }
                int counter = 0;
                for(int i = 0; i < answer.length(); i++){
                    if(guess.charAt(0) == answer.charAt(i)){
                        question = question.substring(0, i + counter) + guess + question.substring(i + counter + 1);
                        loop = 1;
                        correct++;
                    }
                    counter++;
                }
                System.out.println(question);
                if(correct > 0){
                    correct = 0;
                    System.out.print("Take a Guess (Y/N) ? ");
                    String input = s.next();
                    if(input.equalsIgnoreCase("Y")){
                        System.out.print("Your Guess: ");
                        input = s.next() + s.nextLine();
                        if(input.equalsIgnoreCase(answer)){
                            System.out.println("");
                            System.out.println("CORRECT !!");
                            score1++;
                            if(score1 < 5){
                                loop_turn = 1;
                                loop = 0;
                                start_turn = 0;
                                while (loop_turn == 1) {
                                    loop_turn = 0;
                                    if (start == 1) {
                                        start_turn = rand.nextInt(limit);
                                        start = 0;
                                    }
                                    if (start_turn == 0) {
                                        System.out.println("Player 1 Enter Question");
                                        System.out.println("==========================================");
                                        System.out.print("Category : ");
                                        category = s.next();
                                        System.out.print("Question : ");
                                        question = s.next();
                                        answer = question;
                                        question = "";
                                        turn = 1;
                                        for (int i = 0; i < answer.length(); i++) {
                                            if (answer.charAt(i) == ' ') {
                                                question += "  ";
                                            } else {
                                                question += "_ ";
                                            }
                                        }
                                        for (int i = 1; i <= 50; i++) {
                                            System.out.println("");
                                        }
                                        loop = 1;
                                        loop_play = 1;
                                        continue play;
                                    } else if (start_turn == 1) {
                                        System.out.println("Player 2 Enter Question");
                                        System.out.println("==========================================");
                                        System.out.print("Category : ");
                                        category = s.next();
                                        System.out.print("Question : ");
                                        question = s.next();
                                        answer = question;
                                        question = "";
                                        turn = 0;
                                        for (int i = 0; i < answer.length(); i++) {
                                            if (answer.charAt(i) == ' ') {
                                                question += " ";
                                            } else {
                                                question += " ";
                                            }
                                        }
                                        for (int i = 1; i <= 50; i++) {
                                            System.out.println("");
                                        }
                                        loop = 1;
                                        loop_play = 1;
                                        continue play;
                                    }
                                }
                            } else {
                                System.out.println("Player 1 Won!!!");
                                break;
                            }
                        } else {
                            System.out.println("");
                            System.out.println("WRONG ANSWER!!");
                            loop = 1;
                            continue;
                        }
                    } else {
                        loop = 1;
                        continue;
                    }
                } else {
                    System.out.println("WRONG!! No such letter");
                    health1--;
                    if(health1 > 0){
                        loop = 1;
                    } else {
                        System.out.println("Player 2 Won!!!");
                        break;
                    }
                }
            }
            while(turn == 1 && loop == 1){
                loop = 0;
                System.out.printf("Player 2's Turn (Score = %d, Life = %d)\n", score2, health2);
                System.out.println("Category : " + category);
                System.out.println(question);
                System.out.print("Type an Alphabet : ");
                guess = s.next();
                if(guess.length() > 1){
                    loop = 1;
                    continue;
                }
                int counter = 0;
                for(int i = 0; i < answer.length(); i++){
                    if(guess.charAt(0) == answer.charAt(i)){
                       question = question.substring(0, i + counter) + guess + question.substring(i + counter + 1);
                       loop = 1;
                       correct++;
                    }
                    counter++;
                }
                System.out.println(question);
                if(correct > 0){
                    correct = 0;
                    System.out.print("Take a Guess (Y/N) ? ");
                    String input = s.next();
                    if(input.equalsIgnoreCase("Y")){
                        System.out.print("Your Guess: ");
                        input = s.next() + s.nextLine();
                        if(input.equalsIgnoreCase(answer)){
                            System.out.println("");
                            System.out.println("CORRECT !!");
                            score2++;
                            if(score2 < 5){
                                loop_turn = 1;
                                loop = 0;
                                start_turn = 1;
                                while (loop_turn == 1) {
                                    loop_turn = 0;
                                    if (start == 1) {
                                        start_turn = rand.nextInt(limit);
                                        start = 0;
                                    }
                                    if (start_turn == 0) {
                                        System.out.println("Player 1 Enter Question");
                                        System.out.println("==========================================");
                                        System.out.print("Category : ");
                                        category = s.next();
                                        System.out.print("Question : ");
                                        question = s.next();
                                        answer = question;
                                        question = "";
                                        turn = 1;
                                        for (int i = 0; i < answer.length(); i++) {
                                            if (answer.charAt(i) == ' ') {
                                                question += "  ";
                                            } else {
                                                question += "_ ";
                                            }
                                        }
                                        for (int i = 1; i <= 50; i++) {
                                            System.out.println("");
                                        }
                                        loop = 1;
                                        loop_play = 1;
                                        continue play;
                                    } else if (start_turn == 1) {
                                        System.out.println("Player 2 Enter Question");
                                        System.out.println("==========================================");
                                        System.out.print("Category : ");
                                        category = s.next();
                                        System.out.print("Question : ");
                                        question = s.next();
                                        answer = question;
                                        question = "";
                                        turn = 0;
                                        for (int i = 0; i < answer.length(); i++) {
                                            if (answer.charAt(i) == ' ') {
                                                question += "  ";
                                            } else {
                                                question += "_ ";
                                            }
                                        }
                                        for (int i = 1; i <= 50; i++) {
                                            System.out.println("");
                                        }
                                        loop = 1;
                                        loop_play = 1;
                                        continue play;
                                    }
                                }
                            } else {
                                System.out.println("Player 2 Won!!!");
                                break;
                            }
                        } else {
                            System.out.println("");
                            System.out.println("WRONG ANSWER!!");
                            loop = 1;
                            continue;
                        }
                    } else {
                        loop = 1;
                        continue;
                    }
                } else {
                    System.out.println("WRONG!! No such letter");
                    health2--;
                    if(health2 > 0){
                        loop = 1;
                    } else {
                        System.out.println("Player 1 Won!!!");
                        break;
                    }
                }
                System.out.println(question);
            }
        }
    }
}
