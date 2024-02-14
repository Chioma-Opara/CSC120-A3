import java.util.Scanner;
import java.util.Random;

class Conversation {
  /** 
   * Conversation class allows a user converse with a very simple chatbot   
  **/
  public static void main(String[] arguments) {
    // can of random phrases
    String[] cannedPhrases = { "Mmm-hm", "OK...", "Hmm...", "Yeah...", "Tell me more" };

    // ask the user to choose a number of rounds of conversation
    System.out.println("How many rounds of conversation would you like?");
    Scanner sc = new Scanner(System.in);
    int num_of_rounds = sc.nextInt();
    sc.nextLine();

    // initialize an array to store transcript
    String[] transcript = new String[2 + num_of_rounds * 2]; // add 2 elements for greeting and bye

    // print a short greeting to start the conversation
    String greeting = "Hello! What brings you here today?";
    System.out.println(greeting);
    transcript[0] = greeting;

    // take turns accepting input from the user and printing responses
    for (int i = 1; i <= num_of_rounds; i++) {
      String userinput = sc.nextLine();

      String[] words = userinput.split(" ");
      // checks and replaces mirror words
      for (int j = 0; j < words.length; j++) {
        if (words[j].equals("I")) {
          words[j] = "you";
        } else if (words[j].equals("me")) {
          words[j] = "you";
        } else if (words[j].equals("we")) {
          words[j] = "you";
        } else if (words[j].equals("my")) {
          words[j] = "your";
        } else if (words[j].equals("your")) {
          words[j] = "my";
        } else if (words[j].equals("am")) {
          words[j] = "are";
        } else if (words[j].equals("you")) {
          words[j] = "I";
        }
      }
      transcript[-1 + i * 2] = userinput; // adds userinput to transcript

      String chatbotResponse = String.join(" ", words);

      // If chatbot's response is exactly the same as user input, pick a random response from cannedPhrases
      if (chatbotResponse.equals(userinput)) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(5);
        chatbotResponse = cannedPhrases[randomNumber];
      }
      System.out.println(chatbotResponse);
      transcript[i * 2] = chatbotResponse; // adds chatbot response to transcript
    }
    sc.close();

    // say goodbye
    String farewell = "Sorry, I have to go now. It was nice talking with you. Have a great day. Bye!";
    System.out.println(farewell);
    transcript[1 + num_of_rounds * 2] = farewell; // last element in array is farewell

    // print a transcript of the entire conversation
    System.out.println(); // print blank line for readability
    System.out.println("TRANSCRIPT:");
    for (int i = 0; i < transcript.length; i++) {
      System.out.println(transcript[i]);
    }
  }
}




/**
* NOTES TO ME
* Within a void method you can't use a return statement because the method doesn't return anything 
* NEXT: Try upgrading the code to mirror the user's response. What logical rules do you typically follow 
* in changing pronouns. Write pseudocode to help you
**/