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

public class RemoveEmployee extends Activity {
    DatabaseHelper myDb;
    EditText editTextId;
    Button btnDelete;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.removeemployee);
		myDb = new DatabaseHelper(this);
		editTextId = (EditText)findViewById(R.id.edtdelete_id);
		btnDelete= (Button)findViewById(R.id.btndelete_delete);
		DeleteData();
	}
	public void DeleteData() {
		btnDelete.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String id=editTextId.getText().toString();
					if (TextUtils.isEmpty(id)) {
						Toast.makeText(RemoveEmployee.this, "Plase enter ID Which you want to delete", Toast.LENGTH_LONG).show();
						return;
					}
					Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
					if(deletedRows > 0) {
						Toast.makeText(RemoveEmployee.this, "Data Deleted", Toast.LENGTH_LONG).show();
						editTextId.setText("");
					}
					else {
						Toast.makeText(RemoveEmployee.this, "Data not Deleted", Toast.LENGTH_LONG).show();
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

	



