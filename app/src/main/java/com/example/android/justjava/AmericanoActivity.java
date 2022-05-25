package com.example.android.justjava;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AmericanoActivity extends AppCompatActivity {

    ImageButton backToMenu;
    TextView productName, t1, t2, t3, t4, productDesc;
    ImageView productImage;
    RelativeLayout relativeView, pNameRelative;
    ScrollView scrollView;

    public static int choice = -1;

    private String water = "• Water", espresso = "• Espresso", milk_foam = "• Milk Foam", steamed_milk = "• Steamed Milk", whipped_cream = "• Whipped Cream",
            chocolate = "• Chocolate", ice = "• Ice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = getLayoutInflater().inflate(R.layout.description, null);

        scrollView = view.findViewById(R.id.scrollView);
        relativeView = view.findViewById(R.id.relativeView);
        pNameRelative = view.findViewById(R.id.pNameRelative);
        productName = view.findViewById(R.id.productName);
        t1 = view.findViewById(R.id.t1);
        t2 = view.findViewById(R.id.t2);
        t3 = view.findViewById(R.id.t3);
        t4 = view.findViewById(R.id.t4);
        productDesc = view.findViewById(R.id.productDesc);
        productImage = view.findViewById(R.id.productImage);

        if (choice >= 10) {
            relativeView.setVisibility(View.GONE);
            productImage.setMaxHeight(235);
            pNameRelative.setBackgroundColor(Color.TRANSPARENT);
            pNameRelative.setPadding(6, 6, 6, 48);
            scrollView.setBackgroundColor(Color.TRANSPARENT);
        }

        switch (choice) {
            case 0:
                productName.setText("Americano");
                t1.setText(water);
                t2.setText(espresso);
                t3.setText("");
                t4.setText("");
                productImage.setImageResource(R.drawable.americano);
                productDesc.setText(R.string.americano_desc);
                break;
            case 1:
                productName.setText("Cappuccino");
                t1.setText(milk_foam);
                t2.setText(steamed_milk);
                t3.setText(espresso);
                t4.setText("");
                productImage.setImageResource(R.drawable.cappuccino);
                productDesc.setText(R.string.cappuccino_desc);
                break;
            case 2:
                productName.setText("Espresso");
                t1.setText(espresso);
                t2.setText("");
                t3.setText("");
                t4.setText("");
                productImage.setImageResource(R.drawable.espresso);
                productDesc.setText(R.string.espresso_desc);
                break;
            case 3:
                productName.setText("Latte");
                t1.setText(milk_foam);
                t2.setText(steamed_milk);
                t3.setText(espresso);
                t4.setText("");
                productImage.setImageResource(R.drawable.latte);
                productDesc.setText(R.string.latte_desc);
                break;
            case 4:
                productName.setText("Macchiato");
                t1.setText(milk_foam);
                t2.setText(espresso);
                t3.setText("");
                t4.setText("");
                productImage.setImageResource(R.drawable.macchiato);
                productDesc.setText(R.string.macchiato_desc);
                break;
            case 5:
                productName.setText("Mocha");
                t1.setText(whipped_cream);
                t2.setText(steamed_milk);
                t3.setText(chocolate);
                t4.setText(espresso);
                productImage.setImageResource(R.drawable.mocha);
                productDesc.setText(R.string.mocha_desc);
                break;
            case 6:
                productName.setText("Iced Espresso");
                t1.setText(ice);
                t2.setText(espresso);
                t3.setText("");
                t4.setText("");
                productImage.setImageResource(R.drawable.iced_espresso);
                productDesc.setText(R.string.iced_espresso_desc);
                break;
            case 10:
                productName.setText("Sugar");
                productImage.setImageResource(R.drawable.sugar);
                productDesc.setText(R.string.sugar_desc);
                break;
            case 11:
                productName.setText("Brown Sugar");
                productImage.setImageResource(R.drawable.brown_sugar);
                productDesc.setText(R.string.brown_sugar_desc);
                break;
            case 12:
                productName.setText("Whipped Cream");
                productImage.setImageResource(R.drawable.whipped_cream);
                productDesc.setText(R.string.whipped_cream_desc);
                break;
            case 13:
                productName.setText("Chocolate Syrup");
                productImage.setImageResource(R.drawable.chocolate_syrup);
                productDesc.setText(R.string.chocolate_syrup_desc);
                break;
            case 14:
                productName.setText("Cocoa Powder");
                productImage.setImageResource(R.drawable.cocoa_powder);
                productDesc.setText(R.string.cocoa_powder_desc);
                break;
            case 15:
                productName.setText("Honey");
                productImage.setImageResource(R.drawable.honey);
                productDesc.setText(R.string.honey_desc);
                break;
            case 16:
                productName.setText("Mint");
                productImage.setImageResource(R.drawable.mint);
                productDesc.setText(R.string.mint_desc);
                break;
            case 17:
                productName.setText("Vanilla Extract");
                productImage.setImageResource(R.drawable.vanilla_extract);
                productDesc.setText(R.string.vanilla_extract_desc);
                break;
            case 18:
                productName.setText("Cinnamon");
                productImage.setImageResource(R.drawable.cinnamon);
                productDesc.setText(R.string.cinnamon_desc);
                break;
            default:
                productName.setText("Error");
        }

        setContentView(view);
        getSupportActionBar().hide();

        backToMenu = findViewById(R.id.backToMenu);
        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
