package edu.bard.todolist_lab1;
/*
  Most basic Todo List in one activity, no fragments.


CMSC 374
HW #2 Fragments: Feedback

Names: Drew and Noah

     Rubric
----------------------------------------------------------
40	1. App functions correctly from end user perspective.
20	2. Fragments are correctly created.
7	3. Fragments share information on the adapter arraylist.
5	4. Code is clearly commented.
20	5. Code is readable and well constructed.

Score: 92


----------------

Comments

My comments in your code are marked with XX in a comment.

You handle communication by making the list view use a static method.
This means there can only be on such object.  Instead you should
mediate via the parent (activity).

1. App functions correctly from end user perspective. YES, resources used, too.

2. Fragments are correctly created. Only one is.

3. Fragments share information on the adapter arraylist. NO

4. Code is clearly commented.
You ignore commenting important methods.


5. Code is readable and well constructed.
Yes...good throughout.






 */
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import static edu.bard.todolist_lab1.ListItemView.*;

public class ToDoList extends Activity {
    public static String TAG = "todolab";
    private EditText mEditText; // enter todo item
    private Button mItemButton; // add the item to the list
    private ArrayList<String> mToDoItems; // list of items
    private ArrayAdapter<String> aa; // adapter from list to viewlist
    private ListView mListView;

    @Override
    public void onCreate(Bundle stuff) {
        super.onCreate(stuff);

        // Inflate your view
        setContentView(R.layout.main); // Extracts resources, autogenerates R.java from XML file

        // Create Fragment Manager
        FragmentManager fm = getFragmentManager();
        Fragment listItems = fm.findFragmentById(R.id.myListView);
        Fragment inputFrag = fm.findFragmentById(R.id.myInputView);

        if (inputFrag == null) {
            inputFrag = new InputFragment();
            fm.beginTransaction().add(R.id.myInputView, inputFrag).commit();
        }

        if (listItems == null) {
            listItems = new ListItemView();
            fm.beginTransaction().add(R.id.myListView, listItems).commit();
        }

        // Get references to UI widgets
        //mEditText = (EditText) findViewById(R.id.myEditText);
        //mItemButton = (Button) findViewById(R.id.addButton);
        //mListView = (ListView) findViewById(R.id.myListFragment);

        // Create the ArrayList and the ArrayAdapter
        //mToDoItems = new ArrayList<String>();
        //aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mToDoItems);

        // Bind the listview to the array adapter
        //mListView.setAdapter(aa);

        // Add key listener to add the new todo item
        // when the middle D-pad button is pressed.
//        mItemButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                ListItemView.addItem(mEditText.getText().toString());
//                //mToDoItems.add(0, mEditText.getText().toString());
//                //aa.notifyDataSetChanged();
//                mEditText.setText("");
//            }
//        });

        Log.i(TAG, "Entered onCreate");
    }
//
//    public void onNewItemAdded(String newItem) {
//        ListItemView listFrag = (ListItemView) getFragmentManager().findFragmentById(R.id.myListFragment);
//        listFrag.
//    }

    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Entered onStart");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Entered onRestart");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Entered onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Entered onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Entered onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Entered onDestroy");
    }


}


