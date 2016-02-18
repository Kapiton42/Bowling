/**
 * Created by kapiton on 02.02.16.
 */
public class ScoreCalculator {
    public static int calculateScore(String[] data) {
        int score = 0;

        for(int i = 0; i < 10; i++)
            score += calculateHit(data, i);

        return score;
    }

    private static int calculateHit(String[] data, int numberOfHit) {
        if(numberOfHit == 9)
            return calculateLastHit(data);

        if(data[numberOfHit].equals("x"))
            return calculateStrike(data, numberOfHit);

        if(data[numberOfHit].substring(1, 2).equals("/"))
            return calculateSpare(data, numberOfHit);

        return Integer.parseInt(data[numberOfHit].substring(0, 1))
                + Integer.parseInt(data[numberOfHit].substring(1, 2));
    }
    private static int calculateStrike(String[] data, int numberOfHit) {
        int score = 10;

        if(numberOfHit == 8) {
            return score + value(data[9], 0) + value(data[9], 1);
        }

        if(data[numberOfHit + 1].equals("x")) {
            score += 10;
            if(data[numberOfHit + 2].substring(0, 1).equals("x"))
                score += 10;
            else
                score += Integer.parseInt(data[numberOfHit + 2].substring(0, 1));
            return score;
        }

        if(data[numberOfHit + 1].substring(1, 2).equals("/")) {
            score += 10;
            return score;
        }

        return score + Integer.parseInt(data[numberOfHit + 1].substring(0, 1))
                + Integer.parseInt(data[numberOfHit + 1].substring(1, 2));
    }
    private static int calculateSpare(String[] data, int numberOfHit) {
        if(data[numberOfHit + 1].substring(0, 1).equals("x"))
            return 20;
        return 10 + value(data[numberOfHit + 1], 0);
    }
    private static int calculateLastHit(String[] data) {
        int score = 0;
        if(data[9].substring(0, 1).equals("x"))
            score += 10;
        else
            score += value(data[9], 0);

        if(data[9].substring(1, 2).equals("x"))
            score += 10;
        else
        if(data[9].substring(1, 2).equals("/"))
            score = 10;
        else
            score += value(data[9], 1);

        if (data[9].length() == 3)
            if(data[9].substring(2, 3).equals("x"))
                score += 10;
            else
                score += value(data[9], 2);

        return score;
    }
    private static int value(String hit, int position) {
        if(hit.substring(position, position + 1).equals("x"))
            return 10;
        if(hit.substring(position, position + 1).equals("/"))
            return 10 - Integer.parseInt(hit.substring(0, 1));
        return Integer.parseInt(hit.substring(position, position + 1));
    }
}