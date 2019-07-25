import java.util.Random;

public class Rule {
    private final Random randomRoll;
    private final CategorySelector categorySelector;
    private final QuestionSelector questionSelector;

    public Rule() {
        this(new Random());
    }

    Rule(Random randomRoll) {
        this.randomRoll = randomRoll;
        this.categorySelector = new CategorySelector();
        this.questionSelector = new QuestionSelector();
    }

    public int nextRoll() {
        return randomRoll.nextInt(5) + 1;
    }

    public int nextAnswer() {
        return randomRoll.nextInt(9);
    }

    public void askQuestion(int place) {
        String chosenCategory = categorySelector.choiceCategory(place);

        questionSelector.askQuestion(chosenCategory);
    }
}
