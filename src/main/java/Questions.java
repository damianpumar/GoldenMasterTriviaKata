import java.util.LinkedList;

public class Questions {

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public Questions() {
        for (int questionNumber = 0; questionNumber < 50; questionNumber++) {
            addQuestions(questionNumber);
        }
    }

    public void askQuestion(String currentCategory) {
        if (currentCategory == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }

    private void addQuestions(int questionNumber) {
        popQuestions.addLast("Pop Question " + questionNumber);
        scienceQuestions.addLast(("Science Question " + questionNumber));
        sportsQuestions.addLast(("Sports Question " + questionNumber));
        rockQuestions.addLast("Rock Question " + questionNumber);
    }
}