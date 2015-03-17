package ashraf.com.applog;

import android.content.*;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import ashraf.com.applog.db.DbLog;

public class PackageChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context ctx, Intent intent) {
        Uri data = intent.getData();
        Log.d("recv", "Action: " + intent.getAction());
        Log.d("recv", "The DATA: " + data);
        //boolean replacing = intent.getBooleanExtra(Intent.EXTRA_REPLACING, false);
        //String tmp = "Action: " + intent.getAction();
        //tmp += "The DATA: " + data;
        //Toast.makeText(ctx,tmp,Toast.LENGTH_LONG).show();


        DbLog l = new DbLog(data.toString().replace("package:",""),intent.getAction());
        l.save();
    }
}