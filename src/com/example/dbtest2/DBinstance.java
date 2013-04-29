package com.example.dbtest2;

import java.io.IOException;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DBinstance extends Activity {
	private EditText word ;
	private TextView definition;
	private DBahelper myDbHelper ;
	private Button gobtn; 
	SQLiteDatabase db;
	//public String wordText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dbcontract);
		 
	     myDbHelper = new DBahelper(this);
 gobtn = (Button) findViewById(R.id.gobtn);

word = (EditText) findViewById(R.id.word);
definition = (TextView) findViewById(R.id.definition);

	     try {

	     	myDbHelper.createDataBase();

		} catch (IOException ioe) {

			throw new Error("Unable to create database");

		}

		try {

			myDbHelper.openDataBase();
			db = myDbHelper.getWritableDatabase();

		}catch(SQLException sqle){

			throw sqle;

		}
		gobtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			 public void onClick(View arg0) {
				String wordText = word.getText().toString();
					

				// definition.setText(wordText);
				if(wordText=="")
				{
					 definition.setText("678 9");
				}
				else
				{
					try
					{
					Cursor c = db.rawQuery("SELECT brhkameaning FROM engkacustomwords where engword = \""+wordText+"\"", null);

					if (c == null ) {
								definition.setText("123");
									} 
					else
					{
						if  (c.moveToFirst())
									{
									definition.setTypeface(Typeface.createFromAsset(getAssets(), "BRHKND.TTF"));
									definition.setText(c.getString(c.getColumnIndex("brhkameaning")));
									}
						else
						{
							definition.setText(":(");
						}
					}
					}
					catch(Exception e)
					{
						definition.setText(e.toString());
					}
				}			
			
			}		

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dbcontract, menu);
		return true;
	}

}
