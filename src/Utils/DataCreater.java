package Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataCreater {

    private Date date = new Date();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy' ('HH:mm')'");

    public String getDateDeal() {

        Calendar calendar = Calendar.getInstance();
        String dealTime = simpleDateFormat.format(calendar.getTime());
        System.out.println(dealTime);
        return dealTime;
    }


}



