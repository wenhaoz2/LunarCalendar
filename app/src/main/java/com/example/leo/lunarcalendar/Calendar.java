package com.example.leo.lunarcalendar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;


public class Calendar extends AppCompatActivity {

    Button button;
    CalendarView calendarView;
    TextView myCalendar;
    TextView lunar;
    private int Year;
    private int Month;
    private int Day;

    @Override
    protected void onCreate(Bundle savedInstanceState) { ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        myCalendar =  (TextView) findViewById(R.id.myCalendar);
        lunar = (TextView) findViewById(R.id.Lunar);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String theDate = (month + 1) + "/" + dayOfMonth + "/" + year;
                myCalendar.setText(theDate);
                Year = year;
                Month = month;
                Day = dayOfMonth;
            }
        });
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] Animals = new String[] {"鼠 Rat","牛 Ox","虎 Tiger","兔 Rabbit","龙 Dragon",
                        "蛇 Snake","马 Horse","羊 Sheep","猴 Monkey","鸡 Rooster","狗 Dog","猪 Pig"};
                String[] LunarYear = new String[] {"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};
                String[] LuYear = new String[] {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
                String theLunar = "The Lunar is:" + "\n" + "Year of " + Animals[(Year - 4) % 12]
                        + "\n"  + "Year of " + LunarYear[Year % 10] + LuYear[Year % 12];
                lunar.setText(theLunar);
            }
        });
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lunar = "https://www.yourchineseastrology.com/calendar/";
                Uri webad = Uri.parse(lunar);
                Intent gotoLunar = new Intent(Intent.ACTION_VIEW, webad);
                if (gotoLunar.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoLunar);
                }
            }
        });
    }
}
