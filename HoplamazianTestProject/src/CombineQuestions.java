import java.util.Scanner;

public class CombineQuestions{

    private Question[] questions;
    private int numQuestions;

    public CombineQuestions(int maxQuestions){
        this.numQuestions = 0;
        this.questions = new Question[maxQuestions];
    }

    //adding a question object to the array of questions
    public void addQuestion(Question q1){
        if (q1 == null){
            throw new IllegalArgumentException();
        }
        questions[numQuestions] = q1;
        numQuestions += 1;
    }

    //printing individual questions from the array of questions
    public void printQuestion(int indexOfQuestion) {
        System.out.println("Question " + (indexOfQuestion + 1) + ": ");
        if (questions[indexOfQuestion] instanceof MultiChoiceQuestion){
            System.out.println(questions[indexOfQuestion].getQuestion() + "?");
        } else {
            System.out.println(questions[indexOfQuestion].getQuestion());
        }
    }

    //returning a question from the question list as the object, not a string
    public Question getQuestion(int indexOfQuestion){
        return questions[indexOfQuestion];
    }

    //returns the array as an array, not a string
    public Question[] getArray() {
        return questions;
    }

    //Gets an input from the user, then checks if that answers right
    public boolean checkAnswer(Question question) {
        if (question instanceof ShortAnswerQuestion) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type a short response: ");
            String input = scanner.nextLine();
            ShortAnswerQuestion short1 = (ShortAnswerQuestion) question; // DOWNCAST
            return short1.checkAnswer(input);
        } else if (question instanceof TrueFalseQuestions) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your answer (true or false): ");
            String input = scanner.nextLine();
            boolean answer = Boolean.parseBoolean(input);
            TrueFalseQuestions tF1 = (TrueFalseQuestions) question;
            return tF1.checkAnswer(answer);
        } else if (question instanceof MultiChoiceQuestion) {
            MultiChoiceQuestion mult1 = (MultiChoiceQuestion) question;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Options:");
            mult1.printOptions();
            System.out.println("Enter your answer (option number): ");
            int input = scanner.nextInt();
            return mult1.checkAnswer(input);
        } else {
            return false;
        }
    }

    //prints all of the questions along side their correct answers
    public void printAnswers(){
        for (int i = 0; i < questions.length; i++){
            Question question = questions[i];
            if (question instanceof ShortAnswerQuestion) {
                System.out.println("Question " + (i + 1) + ": " + question.getQuestion() );
                System.out.println( "Keywords needed: " + ((ShortAnswerQuestion) question).getKeywords());
                System.out.println(" ");
            } else if (question instanceof TrueFalseQuestions) {
                System.out.println("Question " + (i + 1) + ": " + question.getQuestion() + "?" );
                System.out.println("Correct Answer: " + ((TrueFalseQuestions) question).getAnswer());
                System.out.println(" ");
            } else if (question instanceof MultiChoiceQuestion) {
                System.out.println("Question " + (i + 1) + ": " + question.getQuestion()  + "?");
                System.out.println("Correct Answer:  " + ((MultiChoiceQuestion) question).printOption(i));
                System.out.println("Correct Option Number: " + ((MultiChoiceQuestion) question).getAnswer());
                System.out.println(" ");
            }
        }
    }



}

