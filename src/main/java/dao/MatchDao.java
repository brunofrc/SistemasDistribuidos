package dao;

import com.mongodb.DBObject;
import entity.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatchDao extends EntityDao {

        public MatchDao() {
            super(Match.class);
        }

        public void save(Match match) {
            Map mapMatch =
                    new MatchConverter().converterToMap(match);

            save(mapMatch);
        }

        public void update(Match oldMatch, Match newMatch) {
            Map query =
                    new MatchConverter().converterToMap(oldMatch);

            Map map =
                    new MatchConverter().converterToMap(newMatch);

            update(query, map);
        }

        public void delete(Match match) {
            Map map =
                    new MatchConverter().converterToMap(match);

            delete(map);
        }

        public Match findMatch(Map mapKeyValue) {
            DBObject dbObject = findOne(mapKeyValue);

            Match match =
                    new MatchConverter().converterToMatch(dbObject);

            return match;
        }

        public List findMatches() {
            List<DBObject> dbObject = findAll();

            List<Match> matches = new ArrayList<Match>();

            for (DBObject dbo : dbObject) {
                Match match = new MatchConverter().converterToMatch(dbo);

                matches.add(match);
            }

            return matches;
        }

        public List findMatches(Map mapKeyValue) {
            List<DBObject> dbObject = findKeyValue(mapKeyValue);

            List<Match> matches = new ArrayList<Match>();

            for (DBObject dbo : dbObject) {
                Match match = new MatchConverter().converterToMatch(dbo);

                matches.add(match);
            }

            return matches;
        }
    }

