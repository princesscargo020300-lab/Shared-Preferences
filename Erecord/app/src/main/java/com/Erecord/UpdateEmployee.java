package com.Erecord;


import android.app.Activity;
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

public class UpdateEmployee extends Activity {
    DatabaseHelper myDb;
    EditText Lastname,Firstname,Birthday,Currentaddress ,Permanentaddress,Highestdegree,Designation,Contact,Id;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateemployee);
        myDb = new DatabaseHelper(this);
        Lastname = (EditText)findViewById(R.id.update_lastname);
        Firstname = (EditText)findViewById(R.id.update_firstname);
        Birthday = (EditText)findViewById(R.id.update_birthday);
        Currentaddress = (EditText)findViewById(R.id.update_currentaddress);
		Permanentaddress = (EditText)findViewById(R.id.update_permamentaddress);
        Highestdegree = (EditText)findViewById(R.id.update_highestdegree);
        Designation = (EditText)findViewById(R.id.update_designation);
        Contact = (EditText)findViewById(R.id.update_contact);
		Id = (EditText)findViewById(R.id.update_id);
        btnUpdate = (Button)findViewById(R.id.btnupdate);
        UpdateData();
    }

    public void UpdateData() {
        btnUpdate.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String id = Id.getText().toString();

					if (TextUtils.isEmpty(id)) {
						Toast.makeText(UpdateEmployee.this, "Plase enter ID which you want to update", Toast.LENGTH_LONG).show();
						return;
					}
					boolean isUpdate = myDb.updateData(Id.getText().toString(),
													   Lastname.getText().toString(),
													   Firstname.getText().toString(),
													   Birthday.getText().toString(),
													   Currentaddress.getText().toString(),
													   Permanentaddress.getText().toString(),
													   Highestdegree.getText().toString(),
													   Designation.getText().toString(),
													   Contact.getText().toString());
					if(isUpdate == true) {
						Toast.makeText(UpdateEmployee.this, "Data Update", Toast.LENGTH_LONG).show();
						Lastname.setText("");
						Firstname.setText("");
						Birthday.setText("");
						Currentaddress.setText("");
						Permanentaddress.setText("");
						Highestdegree.setText("");
						Designation.setText("");
						Contact.setText("");
						Id.setText("");
					}
					else {
						Toast.makeText(UpdateEmployee.this, "Data not Updated", Toast.LENGTH_LONG).show();
					}
				}
			}
        );

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

	






