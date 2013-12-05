package ua.example.apitest;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;



public class ApiText {
Context context;
DB dba = new DB(context);

public void setText(TextView tv1, TextView tv2, String t1, String t2){
	tv1.setText(t1);
	tv1.setText(t2);
}
public String confirmEditText(EditText eT1){
	String t1=eT1.getText().toString();
	return t1;
	
}
}



	
	


