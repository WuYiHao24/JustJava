package com.example.android.justjava;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class Order6Fragment extends Fragment {

    LinearLayout visa;
    LinearLayout mastercard;
    LinearLayout paypal;
    LinearLayout gpay;
    LinearLayout cash;
    LinearLayout coupon;

    boolean ifDelivery = false;
    private int choice = -1;

    public Order6Fragment() {
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order6, container, false);

        visa = view.findViewById(R.id.visa);
        mastercard = view.findViewById(R.id.mastercard);
        paypal = view.findViewById(R.id.paypal);
        gpay = view.findViewById(R.id.gpay);
        cash = view.findViewById(R.id.cash);
        coupon = view.findViewById(R.id.coupon);

        if (ifDelivery) {
            cash.setVisibility(View.VISIBLE);
        } else {
            cash.setVisibility(View.GONE);
        }

        if (choice == 0) {
            mastercard.setBackgroundColor(Color.TRANSPARENT);
            paypal.setBackgroundColor(Color.TRANSPARENT);
            gpay.setBackgroundColor(Color.TRANSPARENT);
            cash.setBackgroundColor(Color.TRANSPARENT);
            coupon.setBackgroundColor(Color.TRANSPARENT);
            visa.setBackgroundColor(Color.parseColor("#dcdcdc"));
        } else if (choice == 1) {
            visa.setBackgroundColor(Color.TRANSPARENT);
            paypal.setBackgroundColor(Color.TRANSPARENT);
            gpay.setBackgroundColor(Color.TRANSPARENT);
            cash.setBackgroundColor(Color.TRANSPARENT);
            coupon.setBackgroundColor(Color.TRANSPARENT);
            mastercard.setBackgroundColor(Color.parseColor("#dcdcdc"));
        } else if (choice == 2) {
            mastercard.setBackgroundColor(Color.TRANSPARENT);
            visa.setBackgroundColor(Color.TRANSPARENT);
            gpay.setBackgroundColor(Color.TRANSPARENT);
            cash.setBackgroundColor(Color.TRANSPARENT);
            coupon.setBackgroundColor(Color.TRANSPARENT);
            paypal.setBackgroundColor(Color.parseColor("#dcdcdc"));
        } else if (choice == 3) {
            mastercard.setBackgroundColor(Color.TRANSPARENT);
            paypal.setBackgroundColor(Color.TRANSPARENT);
            visa.setBackgroundColor(Color.TRANSPARENT);
            cash.setBackgroundColor(Color.TRANSPARENT);
            coupon.setBackgroundColor(Color.TRANSPARENT);
            gpay.setBackgroundColor(Color.parseColor("#dcdcdc"));
        } else if (choice == 4) {
            mastercard.setBackgroundColor(Color.TRANSPARENT);
            paypal.setBackgroundColor(Color.TRANSPARENT);
            gpay.setBackgroundColor(Color.TRANSPARENT);
            visa.setBackgroundColor(Color.TRANSPARENT);
            coupon.setBackgroundColor(Color.TRANSPARENT);
            cash.setBackgroundColor(Color.parseColor("#dcdcdc"));
        } else if (choice == 5) {
            mastercard.setBackgroundColor(Color.TRANSPARENT);
            paypal.setBackgroundColor(Color.TRANSPARENT);
            gpay.setBackgroundColor(Color.TRANSPARENT);
            cash.setBackgroundColor(Color.TRANSPARENT);
            visa.setBackgroundColor(Color.TRANSPARENT);
            coupon.setBackgroundColor(Color.parseColor("#dcdcdc"));
        }

        visa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mastercard.setBackgroundColor(Color.TRANSPARENT);
                paypal.setBackgroundColor(Color.TRANSPARENT);
                gpay.setBackgroundColor(Color.TRANSPARENT);
                cash.setBackgroundColor(Color.TRANSPARENT);
                coupon.setBackgroundColor(Color.TRANSPARENT);
                visa.setBackgroundColor(Color.parseColor("#dcdcdc"));
                choice = 0;
            }
        });

        mastercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visa.setBackgroundColor(Color.TRANSPARENT);
                paypal.setBackgroundColor(Color.TRANSPARENT);
                gpay.setBackgroundColor(Color.TRANSPARENT);
                cash.setBackgroundColor(Color.TRANSPARENT);
                coupon.setBackgroundColor(Color.TRANSPARENT);
                mastercard.setBackgroundColor(Color.parseColor("#dcdcdc"));
                choice = 1;
            }
        });

        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mastercard.setBackgroundColor(Color.TRANSPARENT);
                visa.setBackgroundColor(Color.TRANSPARENT);
                gpay.setBackgroundColor(Color.TRANSPARENT);
                cash.setBackgroundColor(Color.TRANSPARENT);
                coupon.setBackgroundColor(Color.TRANSPARENT);
                paypal.setBackgroundColor(Color.parseColor("#dcdcdc"));
                choice = 2;
            }
        });

        gpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mastercard.setBackgroundColor(Color.TRANSPARENT);
                paypal.setBackgroundColor(Color.TRANSPARENT);
                visa.setBackgroundColor(Color.TRANSPARENT);
                cash.setBackgroundColor(Color.TRANSPARENT);
                coupon.setBackgroundColor(Color.TRANSPARENT);
                gpay.setBackgroundColor(Color.parseColor("#dcdcdc"));
                choice = 3;
            }
        });

        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mastercard.setBackgroundColor(Color.TRANSPARENT);
                paypal.setBackgroundColor(Color.TRANSPARENT);
                gpay.setBackgroundColor(Color.TRANSPARENT);
                visa.setBackgroundColor(Color.TRANSPARENT);
                coupon.setBackgroundColor(Color.TRANSPARENT);
                cash.setBackgroundColor(Color.parseColor("#dcdcdc"));
                choice = 4;
            }
        });

        coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mastercard.setBackgroundColor(Color.TRANSPARENT);
                paypal.setBackgroundColor(Color.TRANSPARENT);
                gpay.setBackgroundColor(Color.TRANSPARENT);
                cash.setBackgroundColor(Color.TRANSPARENT);
                visa.setBackgroundColor(Color.TRANSPARENT);
                coupon.setBackgroundColor(Color.parseColor("#dcdcdc"));
                choice = 5;
            }
        });

        return view;
    }

    public void mailFromOrder2(boolean ifDelivery) {
        this.ifDelivery = ifDelivery;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getChoice() {
        return choice;
    }
}
