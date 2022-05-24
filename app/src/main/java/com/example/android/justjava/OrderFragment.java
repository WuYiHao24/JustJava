package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class OrderFragment extends Fragment {

    private OrderComm mCallback;
    private int choice = -1;

    LinearLayout uniondale;
    LinearLayout franklin;
    LinearLayout wayne;

    ImageView phone1, phone2, phone3, map1, map2, map3;

    public OrderFragment() {
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order, container, false);

        uniondale = view.findViewById(R.id.Uniondale);
        franklin = view.findViewById(R.id.FranklinSquare);
        wayne = view.findViewById(R.id.WayneWest);

        phone1 = view.findViewById(R.id.phone1);
        phone2 = view.findViewById(R.id.phone2);
        phone3 = view.findViewById(R.id.phone3);

        map1 = view.findViewById(R.id.map1);
        map2 = view.findViewById(R.id.map2);
        map3 = view.findViewById(R.id.map3);

        if (choice == 0) {
            franklin.setBackgroundColor(Color.TRANSPARENT);
            wayne.setBackgroundColor(Color.TRANSPARENT);
            uniondale.setBackgroundColor(Color.parseColor("#dcdcdc"));
        } else if (choice == 1) {
            uniondale.setBackgroundColor(Color.TRANSPARENT);
            wayne.setBackgroundColor(Color.TRANSPARENT);
            franklin.setBackgroundColor(Color.parseColor("#dcdcdc"));
        } else if (choice == 2) {
            uniondale.setBackgroundColor(Color.TRANSPARENT);
            franklin.setBackgroundColor(Color.TRANSPARENT);
            wayne.setBackgroundColor(Color.parseColor("#dcdcdc"));
        }

        uniondale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                franklin.setBackgroundColor(Color.TRANSPARENT);
                wayne.setBackgroundColor(Color.TRANSPARENT);
                uniondale.setBackgroundColor(Color.parseColor("#dcdcdc"));
                choice = 0;
                mCallback.messageFromOrder(choice);
            }
        });

        franklin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uniondale.setBackgroundColor(Color.TRANSPARENT);
                wayne.setBackgroundColor(Color.TRANSPARENT);
                franklin.setBackgroundColor(Color.parseColor("#dcdcdc"));
                choice = 1;
                mCallback.messageFromOrder(choice);
            }
        });

        wayne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uniondale.setBackgroundColor(Color.TRANSPARENT);
                franklin.setBackgroundColor(Color.TRANSPARENT);
                wayne.setBackgroundColor(Color.parseColor("#dcdcdc"));
                choice = 2;
                mCallback.messageFromOrder(choice);
            }
        });

        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + "+1 5165659886"));
                startActivity(dialIntent);
            }
        });

        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + "+1 5162565668"));
                startActivity(dialIntent);
            }
        });

        phone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + "+1 9737850514"));
                startActivity(dialIntent);
            }
        });

        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri mapsIntentUri = Uri.parse("geo:0,0?q=Starbucks+1228+Hempstead+Turnpike, Uniondale");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapsIntentUri);
                //mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        map2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri mapsIntentUri = Uri.parse("geo:0,0?q=Starbucks+640+Franklin+Avenue, Franklin+Square");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapsIntentUri);
                startActivity(mapIntent);
            }
        });

        map3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri mapsIntentUri = Uri.parse("geo:0,0?q=Starbucks+57+state+route+23, Wayne");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapsIntentUri);
                startActivity(mapIntent);
            }
        });

        return view;
    }

    public interface OrderComm {
        void messageFromOrder(int choice);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OrderComm) {
            mCallback = (OrderComm) context;
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

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getChoice() {
        return choice;
    }
}
