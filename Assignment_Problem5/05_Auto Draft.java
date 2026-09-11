import java.util.Arrays;

public class Problem5 implements Comparable<Problem5>
{
    String name;
    int matches;
    double average;
    boolean injured;

    Problem5(String name, int matches, double average, boolean injured)
    {
        this.name = name;
        this.matches = matches;
        this.average = average;
        this.injured = injured;
    }

    static boolean isDraftable(int matches)
    {
        return matches >= 10;
    }

    static boolean isDraftable(int matches, boolean injured)
    {
        return matches >= 5 && !injured;
    }

    public int compareTo(Problem5 other)
    {
        if(this.average < other.average)
            return 1;
        else if(this.average > other.average)
            return -1;
        else
            return 0;
    }

    static String draftAndRank(Problem5[] players)
    {
        Problem5[] draftable = new Problem5[players.length];
        int count = 0;

        for(int i = 0; i < players.length; i++)
        {
            if(isDraftable(players[i].matches) ||
               isDraftable(players[i].matches, players[i].injured))
            {
                draftable[count] = players[i];
                count++;
            }
        }

        Problem5[] finalList = Arrays.copyOf(draftable, count);
        Arrays.sort(finalList);

        String result = "";

        for(int i = 0; i < finalList.length; i++)
        {
            result = result + (i + 1) + ". " + finalList[i].name;

            if(i < finalList.length - 1)
                result = result + " | ";
        }

        return result;
    }

    public static void main(String[] args)
    {
        Problem5[] players = {
            new Problem5("Virat", 15, 48.0, false),
            new Problem5("Rahul", 7, 55.0, false),
            new Problem5("Sameer", 3, 60.0, false),
            new Problem5("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
