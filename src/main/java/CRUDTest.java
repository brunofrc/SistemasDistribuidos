import dao.MatchDao;
import entity.Match;
import entity.Reporter;
import org.bson.types.ObjectId;

import java.util.*;

public class CRUDTest {
    public static void main(String[] args) {
        //save();
        //update();
        //delete();
    }

    private static void save() {
        Reporter ph1 = new Reporter("bruno","bruno", "123");
        Match p1 = new Match("Corinthians", "Palmeiras");
        p1.setInProgress(true);
        p1.setReporter(ph1);
        new MatchDao().save(p1);


        List<Match> matches = new MatchDao().findMatches();
        for (Match match : matches) {
            System.out.println(match.toString());
        }
    }

    private static void update() {
        Map map = new HashMap();
        map.put("hostTeam", "Corinthians");
        map.put("guestTeam", "Palmeiras");
        Match query = new MatchDao().findMatch(map);

        Match match = query;
        match.setHostTeamScore(10);
        match.setGuestTeamScore(2);
        new MatchDao().update(query, match);

        Match matchUpdated = new MatchDao().findMatch(map);
        System.out.printf("Match updated " + matchUpdated.toString());
    }

    private static void delete() {
        Map map = new HashMap();
        map.put("hostTeam", "Corinthians");
        map.put("guestTeam", "Palmeiras");

        List<Match> query = new MatchDao().findMatches(map);

        for (Match match : query) {
            new MatchDao().delete(match);
        }

        List<Match> matches = new MatchDao().findMatches();
        for (Match match : matches) {
            System.out.println(match.toString());
        }
    }
}
