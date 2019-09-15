package dao;

import com.mongodb.DBObject;
import entity.Match;
import entity.Status;

import java.util.HashMap;
import java.util.Map;

public class MatchConverter {

    public Map converterToMap(Match match) {
        Map mapMatch = new HashMap();
        mapMatch.put("hostTeam", match.getHostTeam());
        mapMatch.put("hostTeamScore", match.getHostTeamScore());
        mapMatch.put("guestTeam", match.getGuestTeam());
        mapMatch.put("guestTeamScore", match.getGuestTeamScore());
        mapMatch.put("inProgress", match.isInProgress());
        mapMatch.put("reporter",
                new ReporterConverter().converterToMap(match.getReporter())
        );

        return mapMatch;
    }

    public Match converterToMatch(DBObject dbo) {
        Match match = new Match();
        match.setId(dbo.get("_id").toString());
        match.setHostTeam((String) dbo.get("hostTeam"));
        match.setHostTeamScore((Integer) dbo.get("hostTeamScore"));
        match.setGuestTeam((String) dbo.get("guestTeam"));
        match.setGuestTeamScore((Integer) dbo.get("guestTeamScore"));
        match.setInProgress((Boolean) dbo.get("inProgress"));
        match.setReporter(new ReporterConverter().converterToReporter(
                (HashMap) dbo.get("reporter"))
        );

        return match;
    }
}
