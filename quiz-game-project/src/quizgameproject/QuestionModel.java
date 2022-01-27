package quizgameproject;

public class QuestionModel {
   private String text;
   private String answer;
   public QuestionModel(String q_text, String q_answer) {
	   this.text = q_text;
	   this.answer = q_answer;
   }
   
   /**
    *  returns the question text
    * @return returns the question text 
    */
public String getText() {
	return text;
}
 
/**
 *  returns the correct question answer
 * @return returns the correct answer of the current question 
 * 
 */
public String getAnswer() {
	return answer;
}
 
   
}
