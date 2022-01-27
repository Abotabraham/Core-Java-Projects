package quizgameproject;
/**
 * This program models True/False quiz game from Open Trivia Database. 
 *
 *@author George Abot Abraham Ret
 *@version 1.0, 05/09/2021
 */
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
  
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class QuizGameApplication {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
				// parsing file "data.json"
				Object obj = new JSONParser().parse(new FileReader("./src/quizgameproject/data.json"));
				String question_text = "";
			    String question_answer = "";
			    
				// typecasting obj to JSONObject
				JSONObject jsonObject = (JSONObject)obj;		
				// getting questions and answers from json object
				Iterator<Map.Entry<String, String>> itr1;
				JSONArray jsonarray = (JSONArray) jsonObject.get("results");
				List<QuestionModel> questionBank = new ArrayList<>(); 
				
					     
				// iterating questions from json array using iterator
				Iterator<?> itr2 = jsonarray.iterator();
				
				while (itr2.hasNext())
				{
					itr1 = ((Map<String, String>) itr2.next()).entrySet().iterator();
					while (itr1.hasNext()) {
						Entry<String, String> pair = itr1.next();
						// get question from given the key
						if(pair.getKey().equals("question")) {
							question_text = (String) pair.getValue();
							//System.out.println(question_text);
						}
						// get the answer given the key
						if(pair.getKey().equals("correct_answer")) {
							question_answer = (String) pair.getValue();
							//System.out.println(question_answer);
						}
						
					}
					// create a new question and add to the list of questions
					QuestionModel newQuestion = new QuestionModel(question_text, question_answer);
					questionBank.add(newQuestion);
				}
				QuizBrain quiz = new QuizBrain(questionBank);
				
				while (quiz.stillHasMoreQuestion())
				       quiz.nextQuestion();
				System.out.println("You've completed the quiz.");
				System.out.println("You current score is: " + quiz.getScore() + "/" + quiz.getQuestionNumber() + "\n");
			}
		}

	


