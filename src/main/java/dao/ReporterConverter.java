package dao;

import com.mongodb.DBObject;
import entity.Reporter;

import java.util.HashMap;
import java.util.Map;

public class ReporterConverter {

    public Map converterToMap(Reporter reporter) {
        Map mapPhone = new HashMap();
        mapPhone.put("name", reporter.getName());
        mapPhone.put("userName", reporter.getUserName());
        mapPhone.put("passWord", reporter.getPassWord());

        return mapPhone;
    }

    public Reporter converterToReporter(HashMap hashMap) {
        Reporter reporter = new Reporter();
        reporter.setName((String) hashMap.get("name"));
        reporter.setUserName((String) hashMap.get("userName"));
        reporter.setPassWord((String) hashMap.get("passWord"));

        return reporter;
    }
}
