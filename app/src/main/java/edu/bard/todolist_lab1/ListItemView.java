package edu.bard.todolist_lab1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by drewcarlson1123 on 9/25/16.
 */
public class ListItemView extends Fragment {
    public static String TAG = "ListItemView";
    private ListView mListView;
    private static ArrayList<String> mToDoItems;
    private static ArrayAdapter<String> aa;

    @Override
    public void onCreate(Bundle stuff) {
        super.onCreate(stuff);
        // Create the ArrayList and the ArrayAdapter
        mToDoItems = new ArrayList<String>();
        aa = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, mToDoItems);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle stuff) {
        View v = inflater.inflate(R.layout.listitemview_fragment, container, false);

        mListView = (ListView) v.findViewById(R.id.myListFragment);


        mListView.setAdapter(aa);

        return v;
    }

    public static void addItem(String item) {
        mToDoItems.add(0, item);
        aa.notifyDataSetChanged();
    }
}
