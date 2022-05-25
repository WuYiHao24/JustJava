package com.example.android.justjava;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener, OrderFragment.OrderComm, Order2Fragment.Order2Comm, Order2Fragment.Order2Comm_2, Order3Fragment.Order3Comm, Order5Fragment.Order5Comm {

    NavigationBarView navigationBarView;
    NavigationBarView navigationBarView2;
    FloatingActionButton fab;

    MenuFragment menuFragment = new MenuFragment();
    OrderFragment orderFragment = new OrderFragment();
    Order2Fragment orderFragment2 = new Order2Fragment();
    Order3Fragment orderFragment3 = new Order3Fragment();
    Order4Fragment orderFragment4 = new Order4Fragment();
    Order5Fragment orderFragment5 = new Order5Fragment();
    Order6Fragment orderFragment6 = new Order6Fragment();
    SummaryFragment summaryFragment = new SummaryFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    ToppingsFragment toppingsFragment = new ToppingsFragment();
    ThanksFragment thanksFragment = new ThanksFragment();

    private int orderCont = 0, currentPage = -1, sum = 0;
    private int orderFragmentChoice = -1, orderFragment2Choice = -1, orderFragment6Choice = -1;
    private int[] orderFragment3Choice = {0, 0, 0, 0, 0, 0, 0};

    private boolean menu = true, sendQ = true, sendN = true;

    private String water = "• Water", espresso = "• Espresso", milk_foam = "• Milk Foam", steamed_milk = "• Steamed Milk", whipped_cream = "• Whipped Cream",
            chocolate = "• Chocolate", ice = "• Ice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        navigationBarView = findViewById(R.id.bottomNavigationView);
        navigationBarView2 = findViewById(R.id.topNavigationView);
        fab = findViewById(R.id.fab);

        navigationBarView.setOnItemSelectedListener(this);
        navigationBarView.setSelectedItemId(R.id.menu);
        navigationBarView2.setOnItemSelectedListener(this);
        navigationBarView2.setSelectedItemId(R.id.coffee);

        Resources res = getResources();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (orderCont == -1) {
                    orderFragment6.setChoice(-1);

                    //change icon
                    fab.setImageDrawable(res.getDrawable(R.drawable.ic_forward));

                    getSupportFragmentManager().beginTransaction().replace(R.id.container, orderFragment).commit();
                    orderCont++;
                    currentPage = -1;
                } else if (orderCont == 0) {
                    orderFragmentChoice = orderFragment.getChoice();
                    if (orderFragmentChoice != 0 && orderFragmentChoice != 1 && orderFragmentChoice != 2) {
                        Toast.makeText(MainActivity.this, "Please select a coffee shop", Toast.LENGTH_SHORT).show();
                    } else {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, orderFragment2).commit();
                        orderCont++;
                        currentPage = 0;
                    }
                } else if (orderCont == 1) {
                    orderFragment2Choice = orderFragment2.getChoice();
                    if (orderFragment2Choice != 0 && orderFragment2Choice != 1 && orderFragment2Choice != 2) {
                        Toast.makeText(MainActivity.this, "Please select an order type", Toast.LENGTH_SHORT).show();
                    } else {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, orderFragment3).commit();
                        orderCont++;
                        currentPage = 1;
                    }
                } else if (orderCont == 2) {
                    orderFragment3Choice = orderFragment3.getQuantities();
                    for (int i = 0; i < 7; i++) {
                        sum += orderFragment3Choice[i];
                    }
                    if (sum <= 0) {
                        Toast.makeText(MainActivity.this, "Please add at least 1 coffee", Toast.LENGTH_SHORT).show();
                    } else {
                        if (sendQ) {
                            orderFragment3.sendQuantities();
                            sendQ = false;
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, orderFragment4).commit();
                        orderCont++;
                        currentPage = 2;
                    }
                    sum = 0;
                } else if (orderCont == 3) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, orderFragment5).commit();
                    orderCont++;
                    currentPage = 3;
                } else if (orderCont == 4) {
                    if (sendN) {
                        orderFragment5.sendNotes();
                        sendN = false;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, summaryFragment).commit();
                    orderCont++;
                    currentPage = 4;
                } else if (orderCont == 5) {
                    //change icon
                    fab.setImageDrawable(res.getDrawable(R.drawable.ic_confirm));
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, orderFragment6).commit();
                    orderCont++;
                    currentPage = 5;
                } else if (orderCont == 6) {
                    orderFragment6Choice = orderFragment6.getChoice();
                    if (orderFragment6Choice != 0 && orderFragment6Choice != 1 && orderFragment6Choice != 2 &&
                            orderFragment6Choice != 3 && orderFragment6Choice != 4 && orderFragment6Choice != 5) {
                        Toast.makeText(MainActivity.this, "Please select a payment method", Toast.LENGTH_SHORT).show();
                    } else {
                        //chance icon
                        fab.setImageDrawable(res.getDrawable(R.drawable.ic_back));

                        getSupportFragmentManager().beginTransaction().replace(R.id.container, thanksFragment).commit();
                        orderCont = -1;
                        currentPage = 6;
                        orderFragment3.reset();
                        orderFragment.setChoice(-1);
                        orderFragment2.setChoice(-1);
                        sendQ = true;
                        sendN = true;
                    }
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu:
                if (menu) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, toppingsFragment).commit();
                }
                navigationBarView2.setVisibility(View.VISIBLE);
                fab.setVisibility(View.GONE);
                return true;

            case R.id.order:
                orderCont = currentPage;
                fab.performClick();
                navigationBarView2.setVisibility(View.GONE);
                fab.setVisibility(View.VISIBLE);
                return true;

            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, settingsFragment).commit();
                navigationBarView2.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
                return true;

            case R.id.coffee:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
                navigationBarView2.setVisibility(View.VISIBLE);
                fab.setVisibility(View.GONE);
                menu = true;
                return true;

            case R.id.toppings:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, toppingsFragment).commit();
                navigationBarView2.setVisibility(View.VISIBLE);
                fab.setVisibility(View.GONE);
                menu = false;
                return true;
        }
        return false;
    }

    @Override
    public void messageFromOrder(int choice) {
        summaryFragment.mailFromOrder(choice);
    }

    @Override
    public void messageFromOrder2(int choice) {
        summaryFragment.mailFromOrder2(choice);
    }

    @Override
    public void messageFromOrder2_2(boolean ifDelivery) {
        orderFragment6.mailFromOrder2(ifDelivery);
    }

    @Override
    public void messageFromOrder3(int choice[]) {
        summaryFragment.mailFromOrder3(choice);
        orderFragment4.mailFromOrder3(choice);
    }

    @Override
    public void messageFromOrder5(String notes) {
        summaryFragment.mailFromOrder5(notes);
    }

    public void increment1(View v) {
        orderFragment3.increment1(v);
    }

    public void decrement1(View v) {
        orderFragment3.decrement1(v);
    }

    public void increment2(View v) {
        orderFragment3.increment2(v);
    }

    public void decrement2(View v) {
        orderFragment3.decrement2(v);
    }

    public void increment3(View v) {
        orderFragment3.increment3(v);
    }

    public void decrement3(View v) {
        orderFragment3.decrement3(v);
    }

    public void increment4(View v) {
        orderFragment3.increment4(v);
    }

    public void decrement4(View v) {
        orderFragment3.decrement4(v);
    }

    public void increment5(View v) {
        orderFragment3.increment5(v);
    }

    public void decrement5(View v) {
        orderFragment3.decrement5(v);
    }

    public void increment6(View v) {
        orderFragment3.increment6(v);
    }

    public void decrement6(View v) {
        orderFragment3.decrement6(v);
    }

    public void increment7(View v) {
        orderFragment3.increment7(v);
    }

    public void decrement7(View v) {
        orderFragment3.decrement7(v);
    }

    public void americanoDesc(View v) {
        AmericanoActivity.choice = 0;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void cappuccinoDesc(View v) {
        AmericanoActivity.choice = 1;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void espressoDesc(View v) {
        AmericanoActivity.choice = 2;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void latteDesc(View v) {
        AmericanoActivity.choice = 3;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void macchiatoDesc(View v) {
        AmericanoActivity.choice = 4;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void mochaDesc(View v) {
        AmericanoActivity.choice = 5;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void iced_espressoDesc(View v) {
        AmericanoActivity.choice = 6;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void sugarDesc(View v) {
        AmericanoActivity.choice = 10;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void brown_sugarDesc(View v) {
        AmericanoActivity.choice = 11;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void whipped_creamDesc(View v) {
        AmericanoActivity.choice = 12;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void chocolate_syrupDesc(View v) {
        AmericanoActivity.choice = 13;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void cocoa_powderDesc(View v) {
        AmericanoActivity.choice = 14;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void honeyDesc(View v) {
        AmericanoActivity.choice = 15;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void mintDesc(View v) {
        AmericanoActivity.choice = 16;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void vanilla_extractDesc(View v) {
        AmericanoActivity.choice = 17;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void cinnamonDesc(View v) {
        AmericanoActivity.choice = 18;
        Intent i = new Intent(MainActivity.this, AmericanoActivity.class);
        startActivity(i);
    }

    public void about(View v) {
        Intent i = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(i);
    }
}