package quizgameproject;

import java.util.List;
import java.util.Scanner;

public class QuizBrain {
	        private int questionNumber;  // keep of the question the user is at
	        private int score;  // keep track of the user correct answers
	        private List<QuestionModel> questionList;
			public QuizBrain(List<QuestionModel> questionList) {
				this.questionNumber = 0;
				this.score = 0;
				this.questionList = questionList;
			}
			
			/**
		    *  returns the user score
		    * @return returns the current score of the user
		    */
			 public int getScore() {
				return score;
			}
			 
		  /**
		    *  returns the current question the user is at
		    * 
		    */
			public int getQuestionNumber() {
				return questionNumber;
			}

			/**
	            *  Moves to next question
	            * @param userAnswer user choice from the console
	            * @param correctAnswer value check the user answer against 
	            * 
	            */
			public void nextQuestion() {
				Scanner scanner = new Scanner(System.in);
				QuestionModel currentQuestion = questionList.get(questionNumber);
				this.questionNumber++;
				System.out.print("Q."+ questionNumber + ": " + currentQuestion.getText() + " True/False: ");
				String userAnswer = scanner.nextLine();
				checkUserAnswer(userAnswer, currentQuestion.getAnswer());
				// close scanner after reading user answers
				if(questionList.size() == questionNumber)
					scanner.close();
			}
           /**
            * Checks if the user answer against the correct answers. Increment score if the it is right
            * @param userAnswer user choice from the console
            * @param correctAnswer value check the user answer against 
            * 
            */
			private void checkUserAnswer(String userAnswer, String correctAnswer) {
				 
				if(userAnswer.toLowerCase().equals(correctAnswer.toLowerCase())) {
					this.score++;  // increment score if player got it right
					System.out.println("Correct! You got it right.");
				} else {
					System.out.println("You got it wrong!");
				}
				System.out.println("The correct answer was: " + correctAnswer);
				System.out.println("You current score is: " + this.score + "/" + questionNumber + "\n");
			}
		/**
        * checks if there are more questions or not
        * @returns returns true if there are more questions otherwise false 
        * 
        */
		public boolean stillHasMoreQuestion() {
			 
			return questionNumber < questionList.size() ? true : false;
		}

}
