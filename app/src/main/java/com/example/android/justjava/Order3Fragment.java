package com.example.android.justjava;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Order3Fragment extends Fragment {

    private Order3Comm mCallback;

    private int q1 = 0, q2 = 0, q3 = 0, q4 = 0, q5 = 0, q6 = 0, q7 = 0;
    private int quantities[] = new int[7];

    TextView q1TextView, q2TextView, q3TextView, q4TextView, q5TextView, q6TextView, q7TextView;

    public Order3Fragment() {
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order3, container, false);

        q1TextView = view.findViewById(R.id.q1);
        q2TextView = view.findViewById(R.id.q2);
        q3TextView = view.findViewById(R.id.q3);
        q4TextView = view.findViewById(R.id.q4);
        q5TextView = view.findViewById(R.id.q5);
        q6TextView = view.findViewById(R.id.q6);
        q7TextView = view.findViewById(R.id.q7);

        q1TextView.setText(String.valueOf(q1));
        q2TextView.setText(String.valueOf(q2));
        q3TextView.setText(String.valueOf(q3));
        q4TextView.setText(String.valueOf(q4));
        q5TextView.setText(String.valueOf(q5));
        q6TextView.setText(String.valueOf(q6));
        q7TextView.setText(String.valueOf(q7));

        return view;
    }

    public interface Order3Comm {
        void messageFromOrder3(int choice3[]);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Order3Comm) {
            mCallback = (Order3Comm) context;
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

    public int[] getQuantities(){
        quantities[0] = q1;
        quantities[1] = q2;
        quantities[2] = q3;
        quantities[3] = q4;
        quantities[4] = q5;
        quantities[5] = q6;
        quantities[6] = q7;
        return quantities;
    }

    public void sendQuantities() {
        quantities[0] = q1;
        quantities[1] = q2;
        quantities[2] = q3;
        quantities[3] = q4;
        quantities[4] = q5;
        quantities[5] = q6;
        quantities[6] = q7;
        mCallback.messageFromOrder3(quantities);
    }

    public void reset() {
        q1 = q2 = q3 = q4 = q5 = q6 = q7 = 0;
    }

    private int increment(int q) {
        if (q < 100) {
            return q+1;
        } else {
            return 100;
        }
    }

    private int decrement(int q) {
        if (q > 0) {
            return q-1;
        } else {
            return 0;
        }
    }

    public void increment1(View v) {
        q1 = increment(q1);
        q1TextView.setText(String.valueOf(q1));
    }

    public void decrement1(View v) {
        q1 = decrement(q1);
        q1TextView.setText(String.valueOf(q1));
    }

    public void increment2(View v) {
        q2 = increment(q2);
        q2TextView.setText(String.valueOf(q2));
    }

    public void decrement2(View v) {
        q2 = decrement(q2);
        q2TextView.setText(String.valueOf(q2));
    }
    public void increment3(View v) {
        q3 = increment(q3);
        q3TextView.setText(String.valueOf(q3));
    }

    public void decrement3(View v) {
        q3 = decrement(q3);
        q3TextView.setText(String.valueOf(q3));
    }
    public void increment4(View v) {
        q4 = increment(q4);
        q4TextView.setText(String.valueOf(q4));
    }

    public void decrement4(View v) {
        q4 = decrement(q4);
        q4TextView.setText(String.valueOf(q4));
    }
    public void increment5(View v) {
        q5 = increment(q5);
        q5TextView.setText(String.valueOf(q5));
    }

    public void decrement5(View v) {
        q5 = decrement(q5);
        q5TextView.setText(String.valueOf(q5));
    }
    public void increment6(View v) {
        q6 = increment(q6);
        q6TextView.setText(String.valueOf(q6));
    }

    public void decrement6(View v) {
        q6 = decrement(q6);
        q6TextView.setText(String.valueOf(q6));
    }
    public void increment7(View v) {
        q7 = increment(q7);
        q7TextView.setText(String.valueOf(q7));
    }

    public void decrement7(View v) {
        q7 = decrement(q7);
        q7TextView.setText(String.valueOf(q7));
    }
}