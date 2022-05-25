package com.example.android.justjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SummaryFragment extends Fragment {

    private TextView shopTextView;
    private TextView typeTextView;
    private TextView notesTextView;
    private TextView totalCost;
    LinearLayout c;

    private int choice, choice2;
    private int quantities[] = new int[7];
    String pNames[] = new String[7];
    String notes = "";

    public SummaryFragment() {
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_summary, container, false);

        c = view.findViewById(R.id.summaryContainer);
        shopTextView = view.findViewById(R.id.shop);
        typeTextView = view.findViewById(R.id.order_type);
        notesTextView = view.findViewById(R.id.notesTextView);
        totalCost = view.findViewById(R.id.totalCost);

        pNames[0] = "Americano";
        pNames[1] = "Cappuccino";
        pNames[2] = "Espresso";
        pNames[3] = "Latte";
        pNames[4] = "Macchiato";
        pNames[5] = "Mocha";
        pNames[6] = "Iced Espresso";

        setShopTextView(choice);
        setTypeTextView(choice2);
        setNotesTextView();

        double tCost = 0;

        for (int i = 0; i < 7; i++) {
            if (quantities[i] > 0) {
                View v = getLayoutInflater().inflate(R.layout.product, null);

                tCost += 3.5 * quantities[i];

                //fill
                ImageView productImage = v.findViewById(R.id.productImage);
                TextView productName = v.findViewById(R.id.productName);
                TextView quantity = v.findViewById(R.id.quantity);

                productName.setText(pNames[i]);
                quantity.setText("x " + quantities[i]);

                switch (i) {
                    case 0:
                        productImage.setImageResource(R.drawable.americano);
                        break;
                    case 1:
                        productImage.setImageResource(R.drawable.cappuccino);
                        break;
                    case 2:
                        productImage.setImageResource(R.drawable.espresso);
                        break;
                    case 3:
                        productImage.setImageResource(R.drawable.latte);
                        break;
                    case 4:
                        productImage.setImageResource(R.drawable.macchiato);
                        break;
                    case 5:
                        productImage.setImageResource(R.drawable.mocha);
                        break;
                    case 6:
                        productImage.setImageResource(R.drawable.iced_espresso);
                        break;
                    default:
                        //do nothing
                }

                    /*if(v.getParent() != null) {
                        ((ViewGroup)v.getParent()).removeView(v); // <- fix
                    }*/
                c.addView(v);
            }
        }

        totalCost.setText("€ " + tCost);

        return view;
    }

    public void mailFromOrder(int choice) {
        this.choice = choice;
    }

    public void mailFromOrder2(int choice) {
        this.choice2 = choice;
    }

    public void mailFromOrder3(int choice[]) {
        this.quantities = choice;
    }

    public void mailFromOrder5(String notes) {
        this.notes = notes;
    }

    private void setShopTextView(int choice) {
        if (choice == 0) {
            shopTextView.setText("Uniondale BuckStar\n1228 Hempstead Turnpike, Uniondale\n+1 5165659886");
        } else if (choice == 1) {
            shopTextView.setText("Franklin Square BuckStar\n640 Franklin Avenue, Franklin Square\n+1 5162565668");
        } else if (choice == 2) {
            shopTextView.setText("Wayne West BuckStar\n57 state route 23, Wayne\n+1 9737850514");
        } else {
            shopTextView.setText("Error");
        }
    }

    private void setTypeTextView(int choice) {
        if (choice == 0) {
            typeTextView.setText("Normal Order");
        } else if (choice == 1) {
            typeTextView.setText("Take Away");
        } else if (choice == 2) {
            typeTextView.setText("Delivery");
        } else {
            typeTextView.setText("Error");
        }
    }

    private void setNotesTextView() {
        notesTextView.setText(notes);
    }
}
