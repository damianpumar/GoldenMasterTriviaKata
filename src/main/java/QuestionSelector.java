import java.util.LinkedList;

public class QuestionSelector {
    private final LinkedList popQuestions = new LinkedList();
    private final LinkedList scienceQuestions = new LinkedList();
    private final LinkedList sportsQuestions = new LinkedList();
    private final LinkedList rockQuestions = new LinkedList();

    public QuestionSelector() {
        for (int questionNumber = 0; questionNumber < 50; questionNumber++) {
            addQuestions(questionNumber);
        }
    }

    public void askQuestion(String chosenCategory) {
        if (chosenCategory == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (chosenCategory == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (chosenCategory == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (chosenCategory == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }

    private void addQuestions(int questionNumber) {
        popQuestions.addLast("Pop Question " + questionNumber);
        scienceQuestions.addLast(("Science Question " + questionNumber));
        sportsQuestions.addLast(("Sports Question " + questionNumber));
        rockQuestions.addLast("Rock Question " + questionNumber);
    }
}
