package com.stevepop.mylistviewapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steve
 */
public class ListViewWithBaseAdapter extends Activity {
    /**
     * This is the DTO for populating the ListView
     */
    public class SpContacts {
        String contactName;
        String contactNumber;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_simple_adapter);

        /** Get the Adapter **/
        final SpContactsAdapter contactsAdapter = new SpContactsAdapter();

        /** Get the reference of the ListView **/
        ListView contactList = (ListView)findViewById(R.id.listView1);

        /** Set the adapter in the ListView **/
        contactList.setAdapter(contactsAdapter);

        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SpContacts contact = contactsAdapter.getContact(position);

                Toast.makeText(ListViewWithBaseAdapter.this, contact.contactName,Toast.LENGTH_LONG).show();
            }
        });

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
                LayoutInflater inflater = (LayoutInflater) ListViewWithBaseAdapter.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        for(int i=0;i<10;i++)
        {
            SpContacts contact = new SpContacts();
            contact.contactName = "Contact "+i;
            contact.contactNumber = "Mobile " +i;
            contactList.add(contact);
        }

        return contactList;
    }

}
