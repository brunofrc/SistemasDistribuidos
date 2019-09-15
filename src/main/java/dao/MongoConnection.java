package dao;

import com.mongodb.DB;
import com.mongodb.Mongo;

public class MongoConnection {

    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DB_NAME = "mongodb";

    private static MongoConnection uniqInstance;

    private Mongo mongo;
    private DB db;

    private MongoConnection() {
    }

    public static synchronized MongoConnection getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new MongoConnection();
        }
        return uniqInstance;
    }

    public DB getDB() {
        if (mongo == null) {
                mongo = new Mongo(HOST, PORT);
                db = mongo.getDB(DB_NAME);
        }
        return db;
    }
}