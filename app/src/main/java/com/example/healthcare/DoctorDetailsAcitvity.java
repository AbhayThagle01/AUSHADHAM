package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsAcitvity extends AppCompatActivity {
    private String [][] doctor_details1 ={
            {"Doctor Name : Ajits Singh","Hospital Address : Pune","Exp : 16yrs","Mobile No : 9234572341","600"},
            {"Doctor Name : Prasads Pawar","Hospital Address : Agra","Exp : 15yrs","Mobile No : 9432562451","800"},
            {"Doctor Name : Rajus Kumar","Hospital Address : Delhi","Exp : 19yrs","Mobile No : 9342612341","1000"},
            {"Doctor Name : Ashoks Pandey","Hospital Address : Delhi","Exp : 12yrs","Mobile No : 9632144354","800"},
            {"Doctor Name : Deepaks Thakur","Hospital Address : Kanpur","Exp : 12yrs","Mobile No : 9735614353","900"}
    };
    private String [][] doctor_details2 ={
            {"Doctor Name : Ajitt Singh","Hospital Address : Pune","Exp : 16yrs","Mobile No : 9234572341","600"},
            {"Doctor Name : Prasadt Pawar","Hospital Address : Agra","Exp : 15yrs","Mobile No : 9432562451","800"},
            {"Doctor Name : Rajut Kumar","Hospital Address : Delhi","Exp : 19yrs","Mobile No : 9342612341","1000"},
            {"Doctor Name : Ashokt Pandey","Hospital Address : Delhi","Exp : 12yrs","Mobile No : 9632144354","800"},
            {"Doctor Name : Deepakt Thakur","Hospital Address : Kanpur","Exp : 12yrs","Mobile No : 9735614353","900"}
    };
    private String [][] doctor_details3 ={
            {"Doctor Name : Ajit Singhy","Hospital Address : Pune","Exp : 16yrs","Mobile No : 9234572341","600"},
            {"Doctor Name : Prasad Pawary","Hospital Address : Agra","Exp : 15yrs","Mobile No : 9432562451","800"},
            {"Doctor Name : Raju Kumary","Hospital Address : Delhi","Exp : 19yrs","Mobile No : 9342612341","1000"},
            {"Doctor Name : Ashok Pandeyy","Hospital Address : Delhi","Exp : 12yrs","Mobile No : 9632144354","800"},
            {"Doctor Name : Deepak Thakury","Hospital Address : Kanpur","Exp : 12yrs","Mobile No : 9735614353","900"}
    };
    private String [][] doctor_details4 ={
            {"Doctor Name : Ajit Singhu","Hospital Address : Pune","Exp : 16yrs","Mobile No : 9234572341","600"},
            {"Doctor Name : Prasad Pawaru","Hospital Address : Agra","Exp : 15yrs","Mobile No : 9432562451","800"},
            {"Doctor Name : Raju Kumaru","Hospital Address : Delhi","Exp : 19yrs","Mobile No : 9342612341","1000"},
            {"Doctor Name : Ashok Pandeyu","Hospital Address : Delhi","Exp : 12yrs","Mobile No : 9632144354","800"},
            {"Doctor Name : Deepak Thakuru","Hospital Address : Kanpur","Exp : 12yrs","Mobile No : 9735614353","900"}
    };
    private String [][] doctor_details5 ={
            {"Doctor Name : Ajit Singhi","Hospital Address : Pune","Exp : 16yrs","Mobile No : 9234572341","600"},
            {"Doctor Name : Prasad Pawari","Hospital Address : Agra","Exp : 15yrs","Mobile No : 9432562451","800"},
            {"Doctor Name : Raju Kumari","Hospital Address : Delhi","Exp : 19yrs","Mobile No : 9342612341","1000"},
            {"Doctor Name : Ashok Pandeyi","Hospital Address : Delhi","Exp : 12yrs","Mobile No : 9632144354","800"},
            {"Doctor Name : Deepak Thakuri","Hospital Address : Kanpur","Exp : 12yrs","Mobile No : 9735614353","900"}
    };
TextView tv;
Button btn;
String[][] doctor_details={};
HashMap<String,String> item;
ArrayList list;
SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details_acitvity);
        tv=findViewById(R.id.textViewODTitle);
        btn=findViewById(R.id.buttonODBack);
        Intent it=getIntent();
        String title =it.getStringExtra("title");
        tv.setText(title);
if(title.compareTo("Family Physicians")==0){
    doctor_details=doctor_details1;
}
else if(title.compareTo("Dietician")==0){
    doctor_details=doctor_details2;
        }
else if(title.compareTo("Dentist")==0){
    doctor_details=doctor_details3;
}
else if(title.compareTo("Surgeon")==0){
    doctor_details=doctor_details4;
}
else {
    doctor_details=doctor_details5;
}
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsAcitvity.this,FindDoctorActivity.class));
            }
        });

list=new ArrayList();
for(int i=0;i<doctor_details.length;i++) {
    item = new HashMap<String, String>();
    item.put("line1", doctor_details[i][0]);
    item.put("line2", doctor_details[i][1]);
    item.put("line3", doctor_details[i][2]);
    item.put("line4", doctor_details[i][3]);
    item.put("line5", "Cons Fees" + doctor_details[i][4] + "/-");
    list.add(item);

}
sa=new SimpleAdapter(this,list,
        R.layout.multi_lines,
        new String[]{"line1","line2","line3","line4","line5"},
        new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
ListView lst=findViewById(R.id.listViewOD);
lst.setAdapter(sa);
//lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Intent it=new Intent(DoctorDetailsAcitvity.this,BookAppointmentActivity.class);
//
//        it.putExtra("text1", title);
//        it.putExtra("text2", doctor_details[i][0]);
//        it.putExtra("text3", doctor_details[i][1]);
//        it.putExtra("text4", doctor_details[i][3]);
//        it.putExtra("text5", doctor_details[i][4]);
//        startActivity(it);
//    }
//});

    }
}