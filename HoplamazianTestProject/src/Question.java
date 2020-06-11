public class Question {

    private String question;
    private int pointValue = 0;


    public Question(String Q, int points){
        this.question = Q;
        this.pointValue = points;
    }

    public String getQuestion(){
        return this.question;
    }

    public int getPointValue(){
        return this.pointValue;
    }

    public String toString(){
        return "Question: " + this.question + "? " + " Point Value: " + this.pointValue;
    }

}
