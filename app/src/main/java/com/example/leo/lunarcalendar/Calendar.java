package com.example.leo.lunarcalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class Calendar extends AppCompatActivity {

    CalendarView calendarView;
    TextView myCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        myCalendar =  (TextView) findViewById(R.id.myLunarCalendar);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String theDate = (month + 1) + "/" + dayOfMonth + "/" + year;
                myCalendar.setText(theDate);
            }
        });
    }
}
