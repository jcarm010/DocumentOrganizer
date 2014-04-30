
import java.util.Date;
import java.util.List;
import ui.CalendarUI;
import ui.CalendarUI.DateSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lalo
 */
public class LambdaExample {
    
    public static void main(String [] args){
        CalendarUI myCalendar = new CalendarUI();
        DateSelectionListener myListener = new DateSelectionListener() {
            @Override
            public void selectedDatesEvent(List<Date> dates) {
                for(Date d: dates)
                    System.out.println("Date: "+ d);
            }
        };
        myCalendar.addDateSelectionListener(myListener);
        myCalendar.setVisible(true);
    }
}
