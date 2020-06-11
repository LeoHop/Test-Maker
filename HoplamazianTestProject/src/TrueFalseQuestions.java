public class TrueFalseQuestions extends Question{

    private boolean answer;

    public TrueFalseQuestions(boolean answer, String question, int points){
        super(question, points);
        this.answer = answer;
    }
    //Returning the correct answer
    public boolean getAnswer(){
        return this.answer;
    }
    //Checking an inputted answer for correctness
    public boolean checkAnswer(boolean userAnswer){
        return userAnswer == this.answer;
    }

    public String toString(){
        return super.toString() + " Answer: " + this.answer;
    }







}
