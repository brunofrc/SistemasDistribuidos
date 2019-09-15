package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EntityDao implements IDao {

    private Class persistentClass;
    private DBCollection dbCollection;

    public EntityDao(Class persistentClass) {
        this.persistentClass = persistentClass;
        this.dbCollection =
                MongoConnection.getInstance()
                        .getDB().getCollection(persistentClass.getSimpleName());
    }

    protected DBCollection getDbCollection() {
        return dbCollection;
    }

    public void save(Map mapEntity) {
        BasicDBObject document = new BasicDBObject(mapEntity);

        dbCollection.save(document);

    }

    public void update(Map mapQuery,
                       Map mapEntity) {
        BasicDBObject query = new BasicDBObject(mapQuery);

        BasicDBObject entity = new BasicDBObject(mapEntity);

        dbCollection.update(query, entity);
    }

    public void delete(Map mapEntity) {
        BasicDBObject entity = new BasicDBObject(mapEntity);

        dbCollection.remove(entity);
    }

    public DBObject findOne(Map mapEntity) {
        BasicDBObject query = new BasicDBObject(mapEntity);

        return dbCollection.findOne(query);
    }

    public List<DBObject> findAll() {
        List list = new ArrayList();

        DBCursor cursor = dbCollection.find();

        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        return list;
    }

    public List<DBObject> findKeyValue(Map keyValue) {
        List list = new ArrayList();

        DBCursor cursor = dbCollection.find(new BasicDBObject(keyValue));

        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        return list;
    }
}
