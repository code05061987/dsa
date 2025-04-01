package dsa.dp;

/**
 * 2140. Solving Questions With Brainpower
 * <p>
 * You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].
 * <p>
 * The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.
 * <p>
 * For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
 * If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
 * If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
 * Return the maximum points you can earn for the exam.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: questions = [[3,2],[4,3],[4,4],[2,5]]
 * Output: 5
 * Explanation: The maximum points can be earned by solving questions 0 and 3.
 * - Solve question 0: Earn 3 points, will be unable to solve the next 2 questions
 * - Unable to solve questions 1 and 2
 * - Solve question 3: Earn 2 points
 * Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.
 * Example 2:
 * <p>
 * Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
 * Output: 7
 * Explanation: The maximum points can be earned by solving questions 1 and 4.
 * - Skip question 0
 * - Solve question 1: Earn 2 points, will be unable to solve the next 2 questions
 * - Unable to solve questions 2 and 3
 * - Solve question 4: Earn 5 points
 * Total points earned: 2 + 5 = 7. There is no other way to earn 7 or more points.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= questions.length <= 105
 * questions[i].length == 2
 * 1 <= pointsi, brainpoweri <= 105
 */

public class Brainpower {

    /*
    Explanation :
    I traverse backwards to compute what max we can get when we reach for that particular exam.
    And then return the max out of all

    {{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}}
                                                        65
                                                 65
                                          65
                                   123
                             123
                     139
              157
        86
     */
    public long mostPoints(int[][] questions) {
        long mostPoints = 0L;
        long []maxVals = new long[questions.length];

        for (int i = questions.length - 1; i >= 0; i--) {
            long val = questions[i][0];
            if(questions[i][1] + i + 1< questions.length){
                val += maxVals[questions[i][1] + i + 1];
            }
            mostPoints = Math.max(val, mostPoints);
            maxVals[i] = mostPoints;

        }


        return mostPoints;
    }
}
