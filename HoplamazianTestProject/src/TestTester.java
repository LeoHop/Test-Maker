import java.util.Scanner;
import java.io.*;

public class TestTester {

    public static void main(String[] args) {
        System.out.println("Enter the path name for your text file with question information (see testTemplate.txt): ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        //Getting the file from my computer where the test information is
        File f = new File(fileName);
        System.out.println("---------------------------------------------------------------------");
        Scanner reader = null;

        //making sure the file is readable
        try {
            reader = new Scanner(f);
        } catch (Exception e) {
            System.exit(0);
        }


        //reading only the first line while getting the # of questions
        String firstLine = reader.nextLine();
        int numbQuestions = Integer.parseInt(firstLine);
        CombineQuestions combine = new CombineQuestions(numbQuestions);

        //looping through every line in the file
        while (reader.hasNext()) {
            String line = reader.nextLine();
            String[] items = line.split(", ");

            //Determining which question type it is
            //constructs a new question with the parameters given
            if (items[1].equals("MultiChoice")){
                int answer = Integer.parseInt(items[4]);
                int points = Integer.parseInt(items[3]);
                int numbOptions = 0;
                for(int i = 0; i < items.length; i++){
                    if (i > 4){
                        numbOptions++;
                    }
                }
                MultiChoiceQuestion q5 = new MultiChoiceQuestion(items[2], points, answer, numbOptions);
                for(int i = 0; i < items.length; i++){
                    if (i > 4){
                        q5.addOption(items[i]);
                    }
                }
                combine.addQuestion(q5);
            }

            if (items[1].equals("TrueFalse")){
                boolean answer = Boolean.parseBoolean(items[4]);
                int points = Integer.parseInt(items[3]);
                TrueFalseQuestions q5 = new TrueFalseQuestions(answer, items[2], points);
                combine.addQuestion(q5);
            }

            if (items[1].equals("ShortAnswer")){
                int points = Integer.parseInt(items[3]);
                int numbKeywords = 0;
                for(int i = 0; i < items.length; i++){
                    if (i > 3){
                        numbKeywords++;
                    }
                }
                ShortAnswerQuestion q5 = new ShortAnswerQuestion(numbKeywords, items[2], points);
                for(int i = 0; i < items.length; i++){
                    if(i > 3){
                        q5.addKeyword(items[i]);
                    }
                }
                combine.addQuestion(q5);
            }
        }
        //Printing the questions from the information given above
        //while checking the user's answer to see if it's
        //correct, like a real test.
        int userPoints = 0;
        int totalPoints = 0;
        //seeing if the user would like to take the test
        System.out.println("Would you like to take the test? (yes or no): ");
        String testAnswer = scanner.nextLine();
        if (testAnswer.contains("yes") || testAnswer.contains("Yes")){
            System.out.println("---------------------------------------------------------------------");
            //Giving the user the test
            for(int i = 0; i < combine.getArray().length; i++) {
                Question q = combine.getQuestion(i);
                combine.printQuestion(i);
                totalPoints += q.getPointValue();
                if (combine.checkAnswer(q) == true){
                    userPoints += q.getPointValue();
                }
            }
            double percent = (userPoints * 100) / totalPoints;

            System.out.println("------------------------------------------------------------- ");
            System.out.println("The test is now over");
            System.out.println(" ");
            System.out.println(" ");

            //Printing all questions with their answers
            combine.printAnswers();

            //Scoring the user
            System.out.println("Points: " + userPoints + "/" + totalPoints);
            System.out.println("Percentage: " + percent + "%");
            System.out.print("Grade: ");
            if (percent > 93){
                System.out.print("A");
            } else if (percent <= 93 && percent >= 90){
                System.out.print("A-");
            } else if (percent < 90 && percent >= 86){
                System.out.print("B+");
            } else if (percent < 86 && percent >= 83){
                System.out.print("B");
            } else if (percent < 83 && percent >= 80) {
                System.out.print("B-");
            } else if (percent < 80 && percent >= 76){
                System.out.print("C+");
            } else if (percent < 76 && percent >= 74){
                System.out.print("C");
            } else if (percent < 74 && percent >= 70){
                System.out.print("C-");
            } else if (percent < 70 && percent >= 67){
                System.out.print("D+");
            } else if (percent < 67 && percent >= 63){
                System.out.print("D");
            } else if (percent < 63 && percent >= 60){
                System.out.print("D-");
            } else if (percent < 60){
                System.out.print("F");
            }
            System.out.println(" ");
        } else if (testAnswer.contains("no") || testAnswer.contains("No")){
            System.out.println("Thank you! Goodbye.");
        } else {
            throw new IllegalArgumentException();
        }
    }

}