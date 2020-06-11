public class MultiChoiceQuestion extends Question{

    private int Answer = 0;
    private String[] options;


    public MultiChoiceQuestion(String question, int points, int answer, int numbOfOptions) {
        super(question, points);
        this.Answer = answer;
        options = new String[numbOfOptions + 1];
    }

    public int getAnswer() {
        return this.Answer;
    }

    //checking if an inputted answer is correct
    public boolean checkAnswer(int otherAnswer) {
        return this.Answer == otherAnswer;
    }

    //adding an string(option) to the array of options for the object.
    public void addOption(String newOption) {
        if (newOption == null){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < options.length; i++){
            if(options[i] == null){
                options[i] = newOption;
                break;
            }
        }
    }
    //printing all options
    public void printOptions() {
        for (int i = 0; i < options.length - 1; i++) {
            System.out.print((i + 1) + ":  ");
            System.out.println(options[i]);
        }
    }
    //Printing the value of a singular option
    public String printOption(int indexOfOption){
        return options[indexOfOption - 1];
    }

    public String toString(){
        return super.toString() + "  Correct answer: " + this.Answer;
    }


}
