package com.example.android.justjava;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Order4Fragment extends Fragment {

    private int quantities[] = new int[7];

    LinearLayout c;

    String pNames[] = new String[7];
    String water = "• Water", espresso = "• Espresso", milk_foam = "• Milk Foam", steamed_milk = "• Steamed Milk", whipped_cream = "• Whipped Cream",
            chocolate = "• Chocolate", ice = "• Ice";

    public Order4Fragment() {
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order4, container, false);

        c = view.findViewById(R.id.order4Container);

        pNames[0] = "Americano";
        pNames[1] = "Cappuccino";
        pNames[2] = "Espresso";
        pNames[3] = "Latte";
        pNames[4] = "Macchiato";
        pNames[5] = "Mocha";
        pNames[6] = "Iced Espresso";

        boolean first = true;

        for (int i = 0; i < 7; i++) {
            if (quantities[i] > 0) {
                for (int j = 0; j < quantities[i]; j++) {
                    View v = getLayoutInflater().inflate(R.layout.toppings, null);

                    //fill
                    ImageView productImage = v.findViewById(R.id.productImage);
                    TextView productName = v.findViewById(R.id.ProductName_TextView);
                    TextView t1 = v.findViewById(R.id.t1);
                    TextView t2 = v.findViewById(R.id.t2);
                    TextView t3 = v.findViewById(R.id.t3);
                    TextView t4 = v.findViewById(R.id.t4);
                    Button arrowButton = v.findViewById(R.id.arrow_button);
                    LinearLayout hiddenView = v.findViewById(R.id.hiddenView);
                    LinearLayout r = v.findViewById(R.id.rr);

                    Button i1 = v.findViewById(R.id.i1);
                    Button i2 = v.findViewById(R.id.i2);
                    Button i3 = v.findViewById(R.id.i3);
                    Button i4 = v.findViewById(R.id.i4);
                    Button i5 = v.findViewById(R.id.i5);
                    Button i6 = v.findViewById(R.id.i6);
                    Button i7 = v.findViewById(R.id.i7);
                    Button i8 = v.findViewById(R.id.i8);
                    Button i9 = v.findViewById(R.id.i9);

                    Button d1 = v.findViewById(R.id.d1);
                    Button d2 = v.findViewById(R.id.d2);
                    Button d3 = v.findViewById(R.id.d3);
                    Button d4 = v.findViewById(R.id.d4);
                    Button d5 = v.findViewById(R.id.d5);
                    Button d6 = v.findViewById(R.id.d6);
                    Button d7 = v.findViewById(R.id.d7);
                    Button d8 = v.findViewById(R.id.d8);
                    Button d9 = v.findViewById(R.id.d9);

                    TextView q1 = v.findViewById(R.id.q1);
                    TextView q2 = v.findViewById(R.id.q2);
                    TextView q3 = v.findViewById(R.id.q3);
                    TextView q4 = v.findViewById(R.id.q4);
                    TextView q5 = v.findViewById(R.id.q5);
                    TextView q6 = v.findViewById(R.id.q6);
                    TextView q7 = v.findViewById(R.id.q7);
                    TextView q8 = v.findViewById(R.id.q8);
                    TextView q9 = v.findViewById(R.id.q9);

                    i1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q1.getText().toString().equals("No")) {
                                q1.setText("Low");
                            } else if (q1.getText().toString().equals("Low")) {
                                q1.setText("Medium");
                            } else if (q1.getText().toString().equals("Medium")) {
                                q1.setText("High");
                            } else if (q1.getText().toString().equals("High")) {
                                q1.setText("No");
                            } else {
                                q1.setText("error");
                            }
                        }
                    });
                    i2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q2.getText().toString().equals("No")) {
                                q2.setText("Low");
                            } else if (q2.getText().toString().equals("Low")) {
                                q2.setText("Medium");
                            } else if (q2.getText().toString().equals("Medium")) {
                                q2.setText("High");
                            } else if (q2.getText().toString().equals("High")) {
                                q2.setText("No");
                            }
                        }
                    });
                    i3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q3.getText().toString().equals("No")) {
                                q3.setText("Low");
                            } else if (q3.getText().toString().equals("Low")) {
                                q3.setText("Medium");
                            } else if (q3.getText().toString().equals("Medium")) {
                                q3.setText("High");
                            } else if (q3.getText().toString().equals("High")) {
                                q3.setText("No");
                            }
                        }
                    });
                    i4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q4.getText().toString().equals("No")) {
                                q4.setText("Low");
                            } else if (q4.getText().toString().equals("Low")) {
                                q4.setText("Medium");
                            } else if (q4.getText().toString().equals("Medium")) {
                                q4.setText("High");
                            } else if (q4.getText().toString().equals("High")) {
                                q4.setText("No");
                            }
                        }
                    });
                    i5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q5.getText().toString().equals("No")) {
                                q5.setText("Low");
                            } else if (q5.getText().toString().equals("Low")) {
                                q5.setText("Medium");
                            } else if (q5.getText().toString().equals("Medium")) {
                                q5.setText("High");
                            } else if (q5.getText().toString().equals("High")) {
                                q5.setText("No");
                            }
                        }
                    });
                    i6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q6.getText().toString().equals("No")) {
                                q6.setText("Low");
                            } else if (q6.getText().toString().equals("Low")) {
                                q6.setText("Medium");
                            } else if (q6.getText().toString().equals("Medium")) {
                                q6.setText("High");
                            } else if (q6.getText().toString().equals("High")) {
                                q6.setText("No");
                            }
                        }
                    });
                    i7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q7.getText().toString().equals("No")) {
                                q7.setText("Low");
                            } else if (q7.getText().toString().equals("Low")) {
                                q7.setText("Medium");
                            } else if (q7.getText().toString().equals("Medium")) {
                                q7.setText("High");
                            } else if (q7.getText().toString().equals("High")) {
                                q7.setText("No");
                            }
                        }
                    });
                    i8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q8.getText().toString().equals("No")) {
                                q8.setText("Low");
                            } else if (q8.getText().toString().equals("Low")) {
                                q8.setText("Medium");
                            } else if (q8.getText().toString().equals("Medium")) {
                                q8.setText("High");
                            } else if (q8.getText().toString().equals("High")) {
                                q8.setText("No");
                            }
                        }
                    });
                    i9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q9.getText().toString().equals("No")) {
                                q9.setText("Low");
                            } else if (q9.getText().toString().equals("Low")) {
                                q9.setText("Medium");
                            } else if (q9.getText().toString().equals("Medium")) {
                                q9.setText("High");
                            } else if (q9.getText().toString().equals("High")) {
                                q9.setText("No");
                            }
                        }
                    });

                    d1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q1.getText().toString().equals("No")) {
                                q1.setText("High");
                            } else if (q1.getText().toString().equals("Low")) {
                                q1.setText("No");
                            } else if (q1.getText().toString().equals("Medium")) {
                                q1.setText("Low");
                            } else if (q1.getText().toString().equals("High")) {
                                q1.setText("Medium");
                            }
                        }
                    });
                    d2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q2.getText().toString().equals("No")) {
                                q2.setText("High");
                            } else if (q2.getText().toString().equals("Low")) {
                                q2.setText("No");
                            } else if (q2.getText().toString().equals("Medium")) {
                                q2.setText("Low");
                            } else if (q2.getText().toString().equals("High")) {
                                q2.setText("Medium");
                            }
                        }
                    });
                    d3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q3.getText().toString().equals("No")) {
                                q3.setText("High");
                            } else if (q3.getText().toString().equals("Low")) {
                                q3.setText("No");
                            } else if (q3.getText().toString().equals("Medium")) {
                                q3.setText("Low");
                            } else if (q3.getText().toString().equals("High")) {
                                q3.setText("Medium");
                            }
                        }
                    });
                    d4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q4.getText().toString().equals("No")) {
                                q4.setText("High");
                            } else if (q4.getText().toString().equals("Low")) {
                                q4.setText("No");
                            } else if (q4.getText().toString().equals("Medium")) {
                                q4.setText("Low");
                            } else if (q4.getText().toString().equals("High")) {
                                q4.setText("Medium");
                            }
                        }
                    });
                    d5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q5.getText().toString().equals("No")) {
                                q5.setText("High");
                            } else if (q5.getText().toString().equals("Low")) {
                                q5.setText("No");
                            } else if (q5.getText().toString().equals("Medium")) {
                                q5.setText("Low");
                            } else if (q5.getText().toString().equals("High")) {
                                q5.setText("Medium");
                            }
                        }
                    });
                    d6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q6.getText().toString().equals("No")) {
                                q6.setText("High");
                            } else if (q6.getText().toString().equals("Low")) {
                                q6.setText("No");
                            } else if (q6.getText().toString().equals("Medium")) {
                                q6.setText("Low");
                            } else if (q6.getText().toString().equals("High")) {
                                q6.setText("Medium");
                            }
                        }
                    });
                    d7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q7.getText().toString().equals("No")) {
                                q7.setText("High");
                            } else if (q7.getText().toString().equals("Low")) {
                                q7.setText("No");
                            } else if (q7.getText().toString().equals("Medium")) {
                                q7.setText("Low");
                            } else if (q7.getText().toString().equals("High")) {
                                q7.setText("Medium");
                            }
                        }
                    });
                    d8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q8.getText().toString().equals("No")) {
                                q8.setText("High");
                            } else if (q8.getText().toString().equals("Low")) {
                                q8.setText("No");
                            } else if (q8.getText().toString().equals("Medium")) {
                                q8.setText("Low");
                            } else if (q8.getText().toString().equals("High")) {
                                q8.setText("Medium");
                            }
                        }
                    });
                    d9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View vi) {
                            if (q9.getText().toString().equals("No")) {
                                q9.setText("High");
                            } else if (q9.getText().toString().equals("Low")) {
                                q9.setText("No");
                            } else if (q9.getText().toString().equals("Medium")) {
                                q9.setText("Low");
                            } else if (q9.getText().toString().equals("High")) {
                                q9.setText("Medium");
                            }
                        }
                    });


                    productName.setText(pNames[i]);

                    if (first) {
                        hiddenView.setVisibility(View.VISIBLE);
                        first = false;
                    }

                    switch (i) {
                        case 0:
                            t1.setText(water);
                            t2.setText(espresso);
                            t3.setText("");
                            t4.setText("");
                            productImage.setImageResource(R.drawable.americano);
                            break;
                        case 1:
                            t1.setText(milk_foam);
                            t2.setText(steamed_milk);
                            t3.setText(espresso);
                            t4.setText("");
                            productImage.setImageResource(R.drawable.cappuccino);
                            break;
                        case 2:
                            t1.setText(espresso);
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            productImage.setImageResource(R.drawable.espresso);
                            break;
                        case 3:
                            t1.setText(milk_foam);
                            t2.setText(steamed_milk);
                            t3.setText(espresso);
                            t4.setText("");
                            productImage.setImageResource(R.drawable.latte);
                            break;
                        case 4:
                            t1.setText(milk_foam);
                            t2.setText(espresso);
                            t3.setText("");
                            t4.setText("");
                            productImage.setImageResource(R.drawable.macchiato);
                            break;
                        case 5:
                            t1.setText(whipped_cream);
                            t2.setText(steamed_milk);
                            t3.setText(chocolate);
                            t4.setText(espresso);
                            productImage.setImageResource(R.drawable.mocha);
                            break;
                        case 6:
                            t1.setText(ice);
                            t2.setText(espresso);
                            t3.setText("");
                            t4.setText("");
                            productImage.setImageResource(R.drawable.iced_espresso);
                            break;
                        default:
                            //do nothing
                    }

                    arrowButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // If the CardView is already expanded, set its visibility
                            //  to gone and change the expand less icon to expand more.
                            if (hiddenView.getVisibility() == View.VISIBLE) {

                                // The transition of the hiddenView is carried out
                                //  by the TransitionManager class.
                                // Here we use an object of the AutoTransition
                                // Class to create a default transition.
                                TransitionManager.beginDelayedTransition(r,
                                        new AutoTransition());
                                hiddenView.setVisibility(View.GONE);
                                arrowButton.setBackgroundResource(R.drawable.ic_expand);
                            }

                            // If the CardView is not expanded, set its visibility
                            // to visible and change the expand more icon to expand less.
                            else {

                                TransitionManager.beginDelayedTransition(r,
                                        new AutoTransition());
                                hiddenView.setVisibility(View.VISIBLE);
                                arrowButton.setBackgroundResource(R.drawable.ic_shrink);
                            }
                        }
                    });
                    /*if(v.getParent() != null) {
                        ((ViewGroup)v.getParent()).removeView(v); // <- fix
                    }*/
                    c.addView(v);
                }
            }
        }

        return view;
    }

    public void mailFromOrder3(int choice[]) {
        this.quantities = choice;
    }

}
