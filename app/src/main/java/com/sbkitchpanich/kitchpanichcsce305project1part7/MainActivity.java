package com.sbkitchpanich.kitchpanichcsce305project1part7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText filterText;

    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filterText = (EditText) findViewById(R.id.editText);

        ListView itemList = (ListView) findViewById(R.id.listView);

        String[] listViewAdapterContent = {"appointment - นัด", "bird - นก", "building - ตึก", "chest - อก", "child - เด็ก",
                "ripe - สุก", "six - หก", "small - เล็ก", "to bite - กัด", "to blow - พัด",
                "to cut - ตัด", "to love - รัก", "to recall - นึก", "to rest - พัก", "to scrub - ขัด",
                "to think - คิด", "to turn off - ปิด", "vegetable - ผัก", "wig - วิก", "wrong - ผิด"};

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listViewAdapterContent);

        itemList.setAdapter(listAdapter);

        //itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           // @Override
           // public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
// make Toast when click
                //Toast.makeText(getApplicationContext(), "Position " + position, Toast.LENGTH_LONG).show();
           // }
        filterText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.listAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

}