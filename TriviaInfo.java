package ergasia.kanoniki;

public class TriviaInfo {
    private String question;
    private String correctAnswer;
    private String difficulty;

    public TriviaInfo(String question, String correctAnswer, String difficulty) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
