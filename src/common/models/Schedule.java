package common.models;

import java.time.LocalDate;

public class Schedule {
    public String s_id;
    public String b_id;
    public int showDuration; // Duration for which it is to be shown on the billboard at one time;
    public LocalDate end_time;
    public LocalDate start_time;
    public Boolean is_recurring;
    public int recur_period; //recur_period is to be stored in milliseconds;

    public void getScheduleByBId(String s_id){
        //Query the bilboard table by b_id and create a billboard object

        // sample data from server
        String b_id_from_server = "";
        int showDuration_from_server = 3600; // Duration for which it is to be shown on the billboard at one time;
        LocalDate end_time_from_server = LocalDate.of(2020, 3, 28); ;
        LocalDate start_time_from_server = LocalDate.of(2020, 3, 30); ;
        Boolean is_recurring_from_server = true;
        int recur_period_from_server = 7200; //recur_period is to be stored in milliseconds;


        //Set th
        this.s_id = s_id;
        this.b_id = b_id_from_server;
        this.showDuration = showDuration_from_server;
        this.end_time = end_time_from_server;
        this.start_time = start_time_from_server;
        this.is_recurring = is_recurring_from_server;
        this.recur_period = recur_period_from_server;
    }
}
