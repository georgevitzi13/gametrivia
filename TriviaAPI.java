package ergasia.kanoniki;



import Exemption.TriviaAPIException;
import ergasia.kanoniki.TriviaInfo;
import java.util.List;
import java.util.ArrayList;

public class TriviaAPIService {
    private String apiUrl;

    public TriviaAPIService(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public List<TriviaInfo> getQuestions(String category) throws TriviaAPIException {
        // Κώδικας που καλεί το API και επιστρέφει λίστα με ερωτήσεις
        List<TriviaInfo> questions = new ArrayList<>();
        questions.add(new TriviaInfo("What is Java?", "A programming language", "Easy"));
        questions.add(new TriviaInfo("What is 2+2?", "4", "Easy"));
        return questions;
    }
}
