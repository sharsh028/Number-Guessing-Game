import java.util.*;
class Range{
    static void range(){
        Scanner sc = new Scanner(System.in);
        System.out.print("What is the range you want to play in? : ");
        int range = sc.nextInt();
        randomNumber(range);
        sc.close();
    }
    static void randomNumber(int range){
        Random random = new Random();
        int randomNumber = random.nextInt(range);
        guessNumber(randomNumber);
    }
    static void guessNumber(int randomNumber){
        Scanner sc = new Scanner(System.in);
        int guess;
        int count = 0;
        while(true){
            System.out.print("Enter Your Guess : ");
            guess = sc.nextInt();
            count++;
            if(guess == randomNumber){
                System.out.println("-------------------------------------------");
                System.out.println("You Gussed The Correct Number in "+count+" tries.");
                System.out.println("-------------------------------------------");
                NumberGuessingGame.scorecard.add(count);
                NumberGuessingGame.homepage();
            }
            else if(guess > randomNumber){
                System.out.println("Your Guess Is High.");
            }
            else{
                System.out.println("Your Guess Is Low.");
            }
        }
    }
}

class Score{
    static void scoreCard(){
        System.out.println("-----------");
        System.out.println("SCORE BOARD");
        System.out.println("-----------");
        if(NumberGuessingGame.scorecard.isEmpty() == false){
            for(int i = 0;i<(NumberGuessingGame.scorecard.size());i++){
                System.out.println("Finished the number game in "+NumberGuessingGame.scorecard.get(i)+" tries.");
            }
        }
        else{
            System.out.println("Your Haven't Play The Game Yet.");
        }
        NumberGuessingGame.homepage();
    }
}

public class NumberGuessingGame {
    public static ArrayList<Integer> scorecard = new ArrayList<Integer>();
    static void homepage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("Welcome To !The Number Guessing Game!");
        System.out.println("-------------------------------------");
        System.out.println("1. Play Game");
        System.out.println("2. Score Board");
        System.out.println("3. Exit");
        System.out.println("-------------------------------------");
        System.out.print("Enter Your Choice : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Range.range();
                break;
        
            case 2:
                Score.scoreCard();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Enter Valid Option.");
                homepage();
        }
        sc.close();
    }
    public static void main(String[] args) {
        homepage();
    }
}
