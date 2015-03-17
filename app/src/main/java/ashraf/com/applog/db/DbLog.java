package ashraf.com.applog.db;

import android.content.Context;

import com.orm.SugarRecord;
import java.util.Date;


public class DbLog extends SugarRecord<DbLog> {
    public String packageName;
    public String operation;
    public Date date;

    public DbLog()
    {

    }

    public DbLog(String packageName,String operation)
    {
        this.packageName = packageName;
        this.operation = operation;
        this.date = new Date();
    }
}
