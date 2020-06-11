public class ShortAnswerQuestion extends Question{

    private String[] keywords;
    private int numbKeywords = 0;


    public ShortAnswerQuestion(int numbKeywords, String question, int points){
        super(question, points);
        this.keywords = new String[numbKeywords];
        this.numbKeywords = 0;

    }
    //adding a keyword to the array of keywords
    public void addKeyword(String newKeyword){
        if (numbKeywords == keywords.length || newKeyword == null){
            throw new IndexOutOfBoundsException();
        }
        keywords[numbKeywords] = newKeyword;
        numbKeywords++;
    }
    //printing all keywords
    public String getKeywords(){
        String str = "[";
        for (int i = 0; i < keywords.length-1; i++) {
            str += keywords[i] + ", ";
        }
        str += keywords[keywords.length-1] + "]";
        return str;
    }

    //checking if another answer is correct
    public boolean checkAnswer(String input){
        for(int i = 0; i < keywords.length; i++){
            if(input.contains(keywords[i])){
                return true;
            }
        }
    return false;
    }

    public String toString(){
        return super.toString() + "   Keywords: " + this.getKeywords();
    }

}
