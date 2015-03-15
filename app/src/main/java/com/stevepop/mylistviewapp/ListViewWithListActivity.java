package com.stevepop.mylistviewapp;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListViewWithListActivity extends ListActivity {

    private static final String TAG = "Contacts-Activity";
    /**
     * This is the DTO for populating the ListView
     */
    public class SpContacts {
        String contactName;
        String contactNumber;
    }

    SpContactsAdapter spContactsAdapter;


    List<SpContacts> contactsList = getDataForListView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_list_activity);

        spContactsAdapter = new SpContactsAdapter();
        setListAdapter(spContactsAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view_with_list, menu);
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

    @Override
    protected void onListItemClick(ListView l,View v,int position, long id ) {
        SpContacts contact = spContactsAdapter.getContact(position);

        Toast.makeText(ListViewWithListActivity.this, contact.contactName, Toast.LENGTH_LONG).show();
    }

    /**
     * Custom Adapter
     */
    public class SpContactsAdapter extends BaseAdapter {

        List<SpContacts> contactsList = getDataForListView();

        @Override
        public int getCount() {
            return contactsList.size();
        }

        @Override
        public Object getItem(int position) {
            return contactsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) ListViewWithListActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.listitem,viewGroup,false);
            }

            TextView contactName = (TextView)view.findViewById(R.id.contactName);
            TextView contactNumber = (TextView)view.findViewById(R.id.mobile);

            SpContacts contact = contactsList.get(position);

            contactName.setText(contact.contactName);
            contactNumber.setText(contact.contactNumber);

            return view;
        }

        /** Get the contact at a position **/
        public SpContacts getContact(int position) {

            return contactsList.get(position);
        }
    }

    /**
     * This method is used to create a populated list of SpContact objects
     * @return contactList
     */
    public List<SpContacts> getDataForListView()
    {

        List<SpContacts> contactList = new ArrayList<SpContacts>();
        String contactNameLists[] = {"Steve Popoola","Jackie Philips","Sharon Lee","Kate Shaw","Peter James"};
        String contactNumberList[] = {"07508328212","07508328213","07508328214","07508328215","07508328216"};
        Log.i(TAG,"Length of contactNameLists " + contactNameLists.length);

        for(int i=0;i<contactNameLists.length;i++)
        {
            SpContacts contact = new SpContacts();
            contact.contactName = contactNameLists[i];
            contact.contactNumber = contactNumberList[i];
            contactList.add(contact);
        }

        return contactList;
    }
}
