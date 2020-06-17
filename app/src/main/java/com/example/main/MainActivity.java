package com.example.main;
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BindList();
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LicenseActivity.class));
            }
        });
    }

    private void BindList() {
        ArrayList<String> listToBind = GetCountriesList();

        class CustomAdapter extends BaseAdapter {
            private List<String> list;

            public CustomAdapter(List<String> list) {
                this.list = list;
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return list.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView == null) {
                    convertView = LayoutInflater.from(getBaseContext()).inflate(R.layout.my_spinner_item, null);
                }
                TextView tv = convertView.findViewById(R.id.location);
                tv.setText(list.get(position));

                return convertView;
            }
        }
        CustomAdapter arrayAdapter = new CustomAdapter(listToBind);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!parent.getItemAtPosition(position).equals("지역선택")){
                    String location = parent.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),LocalCaseActivity.class);
                    intent.putExtra("location",location);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private ArrayList<String> GetCountriesList() {
        String[] array = {"지역선택","서울","경기","인천","강원","세종","충북","충남","대전","경북","대구","경남","부산","울산","전북","광주","전남","제주"};

        return new ArrayList<String>(Arrays.asList(array));
    }
}
