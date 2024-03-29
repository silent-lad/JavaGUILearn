package common.models;

import common.networking.Message;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import java.text.MessageFormat;

public class Billboard {
    public String b_id;
    public String message;
    public String information;
    public String imageString;
    public String userId;
    public Boolean isUrl;
    public String s_id;

    public void getBillboardByBId(String b_id){
        //Query the bilboard table by b_id and create a billboard object

        // sample data from server
          String message_from_server = "Test";
          String information_from_server = "This is sample information";
          String imageString_from_server = "https://someImageUrl.com";
          String userId_from_server = "123";
          Boolean isUrl_from_server = true;
          String schedule_id_from_server = "23";

         this.message = message_from_server;
         this.information = information_from_server;
         this.imageString = imageString_from_server;
         this.userId = userId_from_server;
         this.isUrl = isUrl_from_server;
         this.s_id = schedule_id_from_server;
    }

    public Boolean isScheduledFor(int numberOfDaysFromToday){
        // Used to find if the function is scheduled for a particular number of days after today.
        Schedule scheduleForThisBillboard = new Schedule();
        scheduleForThisBillboard.getScheduleByBId(this.s_id);
        return ChronoUnit.DAYS.between(LocalDate.now(),scheduleForThisBillboard.end_time) >= 0 && LocalDate.now().isAfter(scheduleForThisBillboard.start_time);
    }

    public String createXml(){
        String XMLTemplate;
        if(this.isUrl){
            XMLTemplate = "<?\n" +
                    "        xml version=\"1.0\" encoding=\"UTF-8\"\n" +
                    "                <billboard background=\"#0000FF\">\n" +
                    "<message colour=\"#FFFF00\">{0}\n" +
                    " </billboard>\n" +
                    "</message>\n" +
                    " <picture url=\"{1}\" />\n" +
                    " <information colour=\"#00FFFF\">{2}\n" +
                    " </information>\n" +
                    "</billboard>";
        }else{
            XMLTemplate = "<?\n" +
                    "        xml version=\"1.0\" encoding=\"UTF-8\"\n" +
                    "                <billboard background=\"#0000FF\">\n" +
                    "<message colour=\"#FFFF00\">{0}\n" +
                    " </billboard>\n" +
                    "</message>\n" +
                    " <picture data=\"{1}\" />\n" +
                    " <information colour=\"#00FFFF\">{2}\n" +
                    " </information>\n" +
                    "</billboard>";
        }
        String XMLFinal = MessageFormat.format(XMLTemplate,this.message,this.imageString,this.information);

        return XMLFinal;
    }
}
