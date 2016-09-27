package edu.bard.todolist_lab1;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class InputFragment extends Fragment {

    private OnItemAddedListener newItemListener;

    public interface OnItemAddedListener {
        public void onNewItemAdded(String newItem);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.input_fragment, container, false);

        final EditText mEditText = (EditText)v.findViewById(R.id.myEditText);

        mEditText.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String newItem = mEditText.getText().toString();
                    newItemListener.onNewItemAdded(newItem);
                    mEditText.setText("");
                    handled = true;
                }
                return handled;
            }
        });
        Button mItemButton = (Button) v.findViewById(R.id.addButton);
        mItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mEditText.getText().toString().trim().length() > 0) {
                    ListItemView.addItem(mEditText.getText().toString());
                    mEditText.setText("");
                }
            }
        });
        return v;
    }
}