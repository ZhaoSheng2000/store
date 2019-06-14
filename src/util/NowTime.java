package util;
import java.util.Date;
import java.text.SimpleDateFormat;
public class NowTime {
	private String date = "";
    public String getSystemTime()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        Date current_time = new Date();
        date = formatter.format(current_time);
        return date;
    }
}
