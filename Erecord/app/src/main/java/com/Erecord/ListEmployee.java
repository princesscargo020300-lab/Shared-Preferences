package com.Erecord;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.zip.Inflater;

public class ListEmployee extends Activity {
	Button Employeelist;
	DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listemployee);
		
		
        myDb = new DatabaseHelper(this);
        Employeelist=(Button)findViewById(R.id.employeelist);
        viewAll();

    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    public void viewAll() {
        Employeelist.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Cursor res = myDb.getAllData();
					if(res.getCount() == 0) {
						//SHOW MESSAGE
						showMessage("Employee List","No Records");
						return;
					}

					StringBuffer buffer = new StringBuffer();
					while (res.moveToNext()) {
						buffer.append("Id :"+ res.getString(0)+"\n");
						buffer.append("Last Name :"+ res.getString(1)+"\n");
						buffer.append("First Name :"+ res.getString(2)+"\n");
						buffer.append("Birthday :"+ res.getString(3)+"\n");
						buffer.append("Current Address :"+ res.getString(4)+"\n");
						buffer.append("Permanent Address :"+ res.getString(5)+"\n");
						buffer.append("Highest Degree :"+ res.getString(6)+"\n");
						buffer.append("Designation :"+ res.getString(7)+"\n");
						buffer.append("Contact :"+ res.getString(8)+"\n");
						buffer.append("________________________________________\n\n");
						
						
						
						
						}

				
					showMessage("Employee list",buffer.toString());
				}
			});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater Inflater =getMenuInflater();
		Inflater.inflate(R.menu.menu,menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()){


			case R.id.back:
				Intent Intent1=new Intent(this,Dashboard.class);
				this.startActivity(Intent1);
			    return true;


			case R.id.logout:
				Intent Intent2=new Intent(this,MainActivity.class);
				this.startActivity(Intent2);
				Toast.makeText(getApplicationContext(), "Log out Successfuly",Toast.LENGTH_SHORT).show();
				return true;

		}

		return super.onOptionsItemSelected(item);


	}


}

	





