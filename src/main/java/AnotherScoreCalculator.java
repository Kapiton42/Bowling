import java.util.ArrayList;

/**
 * Created by kapiton on 13.02.16.
 */
public class AnotherScoreCalculator {
    public static int calculateScore(String[] hits) {
        ArrayList<Integer> intHits = createIntArray(hits);

        int score = 0;
        int frameIndex = 0;
        for(int i = 0; i < 10; i++) {
            if(intHits.get(frameIndex) == 10) {
                score += calculateStrike(intHits, frameIndex);
                frameIndex++;
            } else if((intHits.get(frameIndex) + intHits.get(frameIndex + 1)) == 10) {
                score += calculateSpare(intHits, frameIndex);
                frameIndex += 2;
            } else {
                score += calculateSampleFrame(intHits, frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private static ArrayList<Integer> createIntArray(String[] hits) {
        ArrayList<Integer> intHits = new ArrayList<Integer>();
        for (String hit : hits) {
            for (int j = 0; j < hit.length(); j++) {
                if (hit.charAt(j) == 'x')
                    intHits.add(10);
                else if (hit.charAt(j) == '/')
                    intHits.add(10 - Character.getNumericValue(hit.charAt(j - 1)));
                else
                    intHits.add(Character.getNumericValue(hit.charAt(j)));
            }
        }

        return intHits;
    }

    private static int calculateSampleFrame(ArrayList<Integer> hits, int frameIndex) {
        return hits.get(frameIndex) + hits.get(frameIndex + 1);
    }

    private static int calculateStrike(ArrayList<Integer> hits, int frameIndex) {
        return 10 + calculateSampleFrame(hits, frameIndex + 1);
    }

    private static int calculateSpare(ArrayList<Integer> hits, int frameIndex) {
        return 10 + hits.get(frameIndex + 2);
    }
}