package Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataCreater {

    private Date date = new Date();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy");
    private SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("' ('HH:mm')'");

    public String getDateDeal() {

        Calendar calendar = Calendar.getInstance();
        String dealDate = simpleDateFormat.format(calendar.getTime());

        return dealDate;
    }

    public String getTimeDeal() {

        Calendar calendar = Calendar.getInstance();
        String dealTime = simpleTimeFormat.format(calendar.getTime());

        return dealTime;
    }

}



