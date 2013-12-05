package ua.example.apitest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
EditText editText1;
Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText1 = (EditText)findViewById(R.id.editText1);
		 button1 = (Button)findViewById(R.id.button1);
		ApiText api = new ApiText();
		DB dba = new DB(this);
		dba.open();
		
	}
	
	@Override
	public void onClick(View v)
	{
		switch (v.getId()) 
		{
		case R.id.button1:{
			ApiText api = new ApiText();
			String t1 = api.confirmEditText(editText1);
			editText1.setText("");
		}
		
	    }
		
	
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
