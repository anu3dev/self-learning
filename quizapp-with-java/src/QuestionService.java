import java.util.Scanner;

public class QuestionService {
	Question[] questions = new Question[5];
	String selection[] = new String[5];

    public QuestionService(){
        questions[0] = new Question(1, "size of int", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, "size of double", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "size of char", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "size of long", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "size of boolean", "1", "2", "4", "8", "1");
    }

    public void displayQuestions(){
        for(Question question : questions) {
            System.out.println(question.toString());
        }
    }
    
    @SuppressWarnings("resource")
	public void playQuiz(){
        int i=0;
        for(Question q : questions){
            System.out.print("Question " + (i+1) + " : ");
            System.out.println(q.getQuestion());
            
            System.out.println("");
            
            System.out.println("Option 1: " + q.getOpt1());
            System.out.println("Option 2: " + q.getOpt2());
            System.out.println("Option 3: " + q.getOpt3());
            System.out.println("Option 4: " + q.getOpt4());
            
            System.out.println("");

            System.out.print("type the right answer: ");
            Scanner sc = new Scanner(System.in);

            selection[i] = sc.nextLine().trim();
            i++;
        }
    }
    
    public void printScore(){
        int score=0;
        for(String s : selection){
            System.out.println(s);
        }
        
        for(int i=0;i<5;i++){
            Question q = questions[i];
            String answer = q.getAnswer();
            String selAnswer = selection[i];

            if(answer.equals(selAnswer)){
                score++;
            }
        }
        
        System.out.println("Your score : " + score);
    }
    
	public void handleUser(){
        int questionNo = 0;
        float score = 0.00f;
        
        for(Question q : questions){
            System.out.print("\n" + "Question " + (questionNo+1) + " : " + q.getQuestion() + "\n" + "\n");       
            System.out.println("Option 1: " + q.getOpt1());
            System.out.println("Option 2: " + q.getOpt2());
            System.out.println("Option 3: " + q.getOpt3());
            System.out.println("Option 4: " + q.getOpt4() + "\n" + "\n" + "Type the right answer OR Type SKIP to skip this question: ");
            
            @SuppressWarnings("resource")
			Scanner sc1 = new Scanner(System.in);
            String userRes = sc1.nextLine().trim();
            
			boolean isQuesToBeSkipped = userRes.equals("SKIP");
			
            if (isQuesToBeSkipped){
            	questionNo++;
            } else {
                boolean isAnsCorrect = userRes.equals(q.getAnswer());
                
                score = isAnsCorrect ? score + 1 : score - 0.25f;
                System.out.println("\n" + (isAnsCorrect ? "Congrts" : "Oops") + "! you got it " + (isAnsCorrect ? "right" : "wrong") + "\n" + "Your score is: " + score + "\n");
            }
        }
    }
	
	public void handleAdmin() {}
	
	public void roles() {
        System.out.println("Enter user role: " + "\n" + "For admin, type ADMIN" + "\n" + "For user, type USER");
        
        @SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
        String userRole = sc1.nextLine().trim();
        
        if(userRole.equals("USER")) {
        	handleUser();
        } else if(userRole.equals("ADMIN")) {
        	handleAdmin();
        } else {
        	System.out.println("\n" + "Seems your are not a valid user type...");
        }
    }
}
