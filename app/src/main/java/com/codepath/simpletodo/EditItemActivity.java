package com.codepath.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    String oldItem;
    DBUtils itemDB;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        oldItem = getIntent().getStringExtra("item");
        position = getIntent().getIntExtra("position", 0);
        itemDB = DBUtils.getInstance(this);
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText(oldItem);
        editText.setSelection(oldItem.length());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onEditItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.editText);
        String newItem = etNewItem.getText().toString();
        itemDB.updateItem(oldItem, newItem);

        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("item", newItem);
        data.putExtra("position", position);
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }
}
