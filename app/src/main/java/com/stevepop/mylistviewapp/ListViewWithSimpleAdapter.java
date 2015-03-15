package com.stevepop.mylistviewapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListViewWithSimpleAdapter extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_view_with_simple_adapter);

        String[] contacts = new String[] {"Steve Popoola","John Martin","James Joe","Martin Tyler", "Mary Martin", "Stella Rees"};

        ArrayAdapter<String> contactsArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, contacts);

        ListView contactsList = (ListView)findViewById(R.id.listView1);
        contactsList.setAdapter(contactsArrayAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view_with_simple_adapter, menu);
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
}
