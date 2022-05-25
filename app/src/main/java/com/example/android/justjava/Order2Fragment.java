package com.example.android.justjava;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class Order2Fragment extends Fragment {

    private Order2Comm mCallback;
    private Order2Comm_2 mCallback_2;

    LinearLayout order;
    LinearLayout take_away;
    LinearLayout delivery;
    LinearLayout outerOrder;
    LinearLayout outerTake_away;
    LinearLayout outerDelivery;

    boolean ifDelivery = false;
    private int choice = -1;

    public Order2Fragment() {
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order2, container, false);

        order = view.findViewById(R.id.order);
        take_away = view.findViewById(R.id.take_away);
        delivery = view.findViewById(R.id.delivery);
        outerOrder = view.findViewById(R.id.outerOrder);
        outerTake_away = view.findViewById(R.id.outerTake_away);
        outerDelivery = view.findViewById(R.id.outerDelivery);

        if (choice == 0) {
            take_away.setBackgroundColor(Color.TRANSPARENT);
            outerTake_away.setBackgroundColor(Color.TRANSPARENT);
            delivery.setBackgroundColor(Color.TRANSPARENT);
            outerDelivery.setBackgroundColor(Color.TRANSPARENT);
            order.setBackgroundColor(Color.parseColor("#dcdcdc"));
            outerOrder.setBackgroundColor(Color.parseColor("#bebebe"));
        } else if (choice == 1) {
            order.setBackgroundColor(Color.TRANSPARENT);
            outerOrder.setBackgroundColor(Color.TRANSPARENT);
            delivery.setBackgroundColor(Color.TRANSPARENT);
            outerDelivery.setBackgroundColor(Color.TRANSPARENT);
            take_away.setBackgroundColor(Color.parseColor("#dcdcdc"));
            outerTake_away.setBackgroundColor(Color.parseColor("#bebebe"));
        } else if (choice == 2) {
            order.setBackgroundColor(Color.TRANSPARENT);
            outerOrder.setBackgroundColor(Color.TRANSPARENT);
            take_away.setBackgroundColor(Color.TRANSPARENT);
            outerTake_away.setBackgroundColor(Color.TRANSPARENT);
            delivery.setBackgroundColor(Color.parseColor("#dcdcdc"));
            outerDelivery.setBackgroundColor(Color.parseColor("#bebebe"));
        }

        ifDelivery = false;

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                take_away.setBackgroundColor(Color.TRANSPARENT);
                outerTake_away.setBackgroundColor(Color.TRANSPARENT);
                delivery.setBackgroundColor(Color.TRANSPARENT);
                outerDelivery.setBackgroundColor(Color.TRANSPARENT);
                order.setBackgroundColor(Color.parseColor("#dcdcdc"));
                outerOrder.setBackgroundColor(Color.parseColor("#bebebe"));
                ifDelivery = false;
                choice = 0;
                mCallback.messageFromOrder2(choice);
                mCallback_2.messageFromOrder2_2(ifDelivery);
            }
        });

        take_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order.setBackgroundColor(Color.TRANSPARENT);
                outerOrder.setBackgroundColor(Color.TRANSPARENT);
                delivery.setBackgroundColor(Color.TRANSPARENT);
                outerDelivery.setBackgroundColor(Color.TRANSPARENT);
                take_away.setBackgroundColor(Color.parseColor("#dcdcdc"));
                outerTake_away.setBackgroundColor(Color.parseColor("#bebebe"));
                ifDelivery = false;
                choice = 1;
                mCallback.messageFromOrder2(choice);
                mCallback_2.messageFromOrder2_2(ifDelivery);
            }
        });

        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order.setBackgroundColor(Color.TRANSPARENT);
                outerOrder.setBackgroundColor(Color.TRANSPARENT);
                take_away.setBackgroundColor(Color.TRANSPARENT);
                outerTake_away.setBackgroundColor(Color.TRANSPARENT);
                delivery.setBackgroundColor(Color.parseColor("#dcdcdc"));
                outerDelivery.setBackgroundColor(Color.parseColor("#bebebe"));
                ifDelivery = true;
                choice = 2;
                mCallback.messageFromOrder2(choice);
                mCallback_2.messageFromOrder2_2(ifDelivery);
            }
        });
        return view;
    }

    public interface Order2Comm {
        void messageFromOrder2(int choice2);
    }

    public interface Order2Comm_2 {
        void messageFromOrder2_2(boolean ifDelivery);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Order2Comm) {
            mCallback = (Order2Comm) context;
        } else {
            /*throw new RuntimeException(context.toString()
                    + " must implement OrderComm");*/
        }

        if (context instanceof Order2Comm_2) {
            mCallback_2 = (Order2Comm_2) context;
        } else {
            /*throw new RuntimeException(context.toString()
                    + " must implement OrderComm");*/
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
        mCallback_2 = null;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getChoice() {
        return choice;
    }
}
