package ss8_clean_code_refactoring.bai_tap.refactoring_tennis_game;

public class TennisGame {
    public static final char SCORE_ZERO = 0;
    public static final char SCORE_ONE = 1;
    public static final char SCORE_TWO = 2;
    public static final char SCORE_THREE = 3;
    public static final char SCORE_FOUR = 4;

    public static String getScore(String player1Name, String player2Name, int playerScore1, int playerScore2) {
        String result = "";
        int tempScore = SCORE_ZERO;
        if (playerScore1 == playerScore2) {
            switch (playerScore1) {
                case SCORE_ZERO:
                    result = "Love-All";
                    break;
                case SCORE_ONE:
                    result = "Fifteen-All";
                    break;
                case SCORE_TWO:
                    result = "Thirty-All";
                    break;
                case SCORE_THREE:
                    result = "Forty-All";
                    break;
                default:
                    result = "Deuce";
                    break;

            }
        } else if (playerScore1 >= SCORE_FOUR || playerScore2 >= SCORE_FOUR) {
            getWinner(playerScore1, playerScore2);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = playerScore1;
                else {
                    result += "-";
                    tempScore = playerScore2;
                }
                switch (tempScore) {
                    case 0:
                        result += "Love";
                        break;
                    case 1:
                        result += "Fifteen";
                        break;
                    case 2:
                        result += "Thirty";
                        break;
                    case 3:
                        result += "Forty";
                        break;
                }
            }
        }
        return result;
    }

    public static void getWinner(int playerScore1, int playerScore2) {
        String result = "";
        int minusResult = playerScore1 - playerScore2;
        if (minusResult == SCORE_ONE) result = "Advantage player1";
        else if (minusResult == -SCORE_ONE) result = "Advantage player2";
        else if (minusResult >= SCORE_TWO) result = "Win for player1";
        else result = "Win for player2";
    }
}