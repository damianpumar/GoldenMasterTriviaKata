import java.util.Arrays;

public class Category {
    public String printAndReturnCategory(int currentPlace) {
        String category = currentCategory(currentPlace);

        System.out.println("The category is " + category);

        return category;
    }

    private String currentCategory(int currentPlace) {
        if (isCurrentPlace(currentPlace,0, 4, 8)) return "Pop";

        if (isCurrentPlace(currentPlace, 1, 5, 9)) return "Science";

        if (isCurrentPlace(currentPlace, 2, 6, 10)) return "Sports";

        return "Rock";
    }

    private boolean isCurrentPlace(int currentPlace, int... places) {
        return Arrays.stream(places).anyMatch(p -> currentPlace == p);
    }
}
