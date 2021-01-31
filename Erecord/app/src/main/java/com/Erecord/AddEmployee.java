package com.Erecord;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.Erecord.MainActivity;
import java.util.zip.Inflater;

public class AddEmployee extends Activity {
    DatabaseHelper myDb;
    EditText Lastname,Firstname,Birthday,Currentaddress,Permanentaddress,Highestdegree,Designation,Contact ,editTextId;
    Button btnAddData;
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addemployee);
		
		
		myDb = new DatabaseHelper(this);
		Lastname = (EditText)findViewById(R.id.editText_lastname);
		Firstname = (EditText)findViewById(R.id.editText_firstname);
		Birthday = (EditText)findViewById(R.id.editText_birthday);
		Currentaddress = (EditText)findViewById(R.id.editText_currentaddress);
		Permanentaddress = (EditText)findViewById(R.id.editText_permamentaddress);
		Highestdegree = (EditText)findViewById(R.id.editText_highestdegree);
		Designation = (EditText)findViewById(R.id.editText_designation);
		Contact = (EditText)findViewById(R.id.editText_contact);
		btnAddData = (Button)findViewById(R.id.button_add);
		AddData();
	}
	public  void AddData() {
		btnAddData.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String lname = Lastname.getText().toString();
					String fname = Firstname.getText().toString();
					String birth = Birthday.getText().toString();
					String currentadd = Currentaddress.getText().toString();
					String permanentadd = Permanentaddress.getText().toString();
					String highestdeg = Highestdegree.getText().toString();
					String des = Designation.getText().toString();
					String contact = Contact.getText().toString();
					
					
					
					
					if (TextUtils.isEmpty(lname)) {
						Toast.makeText(AddEmployee.this, "Plase enter the Last Name", Toast.LENGTH_LONG).show();
						return;
					}
					if (TextUtils.isEmpty(fname)) {
						Toast.makeText(AddEmployee.this, "Plase enter the First Name", Toast.LENGTH_LONG).show();
						return;
					}
					if (TextUtils.isEmpty(birth)) {
						Toast.makeText(AddEmployee.this, "Plase enter the Birthday", Toast.LENGTH_LONG).show();
						return;
					}
					if (TextUtils.isEmpty(currentadd)) {
						Toast.makeText(AddEmployee.this, "Plase enter the Current Address", Toast.LENGTH_LONG).show();
						return;
					}
					
					

					if (TextUtils.isEmpty(permanentadd)) {
						Toast.makeText(AddEmployee.this, "Plase enter the Permanent Address", Toast.LENGTH_LONG).show();
						return;
					}
					if (TextUtils.isEmpty(highestdeg)) {
						Toast.makeText(AddEmployee.this, "Plase enter the Highest Degree", Toast.LENGTH_LONG).show();
						return;
					}
					if (TextUtils.isEmpty(des)) {
						Toast.makeText(AddEmployee.this, "Plase enter the Desigantion", Toast.LENGTH_LONG).show();
						return;
					}
					if (TextUtils.isEmpty(contact)) {
						Toast.makeText(AddEmployee.this, "Plase enter the Contact", Toast.LENGTH_LONG).show();
						return;
					}
					
					
					
					
					boolean isInserted = myDb.insertData(lname,fname,birth,currentadd,permanentadd,highestdeg,des,contact);
					if (isInserted == true){
						Toast.makeText(AddEmployee.this, "Data Inserted", Toast.LENGTH_LONG).show();
						Lastname.setText("");
						Firstname.setText("");
						Birthday.setText("");
						Currentaddress.setText("");
						Permanentaddress.setText("");
						Highestdegree.setText("");
						Designation.setText("");
						Contact.setText("");
					}
					else
						Toast.makeText(AddEmployee.this,"Data not Inserted",Toast.LENGTH_LONG).show();
				}
			}
		);
	}
	public void showMessage(String title,String Message){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setCancelable(true);
		builder.setTitle(title);
		builder.setMessage(Message);
		builder.show();
	


//MENU

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
			
			case R.id.about:
				Intent Intent0=new Intent(this,About.class);
				this.startActivity(Intent0);
			    return true;

			
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

	









