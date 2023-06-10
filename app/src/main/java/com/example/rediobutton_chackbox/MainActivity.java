package com.example.rediobutton_chackbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.rediobutton_chackbox.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;

    private String am_pm;
    ActivityMainBinding binding;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.settime.setOnClickListener(new View.OnClickListener() {
            Calendar calendar=Calendar.getInstance();
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
                        calendar.set(Calendar.HOUR_OF_DAY, hours);
                        calendar.set(Calendar.MINUTE, minutes);
                        if (calendar.get(Calendar.AM_PM) == Calendar.AM) {
                            am_pm = "AM";
                        } else if (calendar.get(Calendar.AM_PM) == Calendar.PM) {
                            am_pm = "PM";
                        }
                        String strHrsToShow = (calendar.get(Calendar.HOUR) == 0) ?"12":Integer.toString( calendar.get(Calendar.HOUR) );

                        binding.settime.setText(""+strHrsToShow+":"+minutes+" "+am_pm);

                    }
                },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
                dialog.show();
            }

        });

        binding.setcalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        binding.setcalender.setText(day+"/"+month+"/"+year);
                        Log.d("TTT", "onDateSet: ");
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });

        binding.male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.time.setText(""+binding.male.getText().toString());
            }
        });

        binding.female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.time.setText(""+binding.female.getText().toString());
            }
        });


        binding.java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.java.isChecked())
                {
                    list.add("Java/");

                    binding.timeChackbox.setText(""+list);
                }
                else if(!binding.java.isChecked())
                {
                    list.remove("Java/");

                    binding.timeChackbox.setText(""+list);
                }
            }
        });

        binding.kotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.kotlin.isChecked())
                {
                    list.add("Kotlin/");

                    binding.timeChackbox.setText(""+list);
                }
                else if(!binding.kotlin.isChecked())
                {
                    list.remove("Kotlin/");

                    binding.timeChackbox.setText(""+list);
                }
            }
        });

        binding.python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.python.isChecked())
                {
                    list.add("Python/");

                    binding.timeChackbox.setText(""+list);
                }
                else if(!binding.python.isChecked())
                {
                    list.remove("Python/");

                    binding.timeChackbox.setText(""+list);
                }
            }
        });
    }
}