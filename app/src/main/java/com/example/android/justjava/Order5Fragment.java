package com.example.android.justjava;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.*;

public class Order5Fragment extends Fragment {

    private Order5Comm mCallback;
    EditText notes_EditText;

    public Order5Fragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order5, container, false);

        notes_EditText = view.findViewById(R.id.notes_input);

        return view;
    }

    public interface Order5Comm {
        void messageFromOrder5(String notes);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Order5Comm) {
            mCallback = (Order5Comm) context;
        } else {
            /*throw new RuntimeException(context.toString()
                    + " must implement OrderComm");*/
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    public void sendNotes() {
        mCallback.messageFromOrder5(notes_EditText.getText().toString());
        notes_EditText.getText().clear();
    }
}
