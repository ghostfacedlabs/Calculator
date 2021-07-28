package com.ghostfacedlabs.calculator;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private String x = "0";
    private String y = "0";
    private boolean add = false;
    private boolean subtract = false;
    private boolean divide = false;
    private boolean multiply = false;
    private static final DecimalFormat df0 = new DecimalFormat("#");
    private final StringBuilder f = new StringBuilder();
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setButtons();

    }

    public void setButtons() {
        TextView result = findViewById(R.id.result_view);

        Button acButton = findViewById(R.id.ac_button);
        acButton.setOnClickListener(view -> result.setText("0"));

        Button cButton = findViewById(R.id.c_button);
        cButton.setOnClickListener(view -> {
            String text = result.getText().toString();

            if (text.length() == 1) {
                result.setText("0");
            } else {
                result.setText(text.substring(0, text.length() - 1));
            }
        });

        Button sevenButton = findViewById(R.id.seven_button);
        sevenButton.setOnClickListener(view -> {
            String text = result.getText().toString();
            if (text.equals("0")) {
                result.setText("7");
            } else {
                String update = text + "7";
                result.setText(update);
            }
            System.out.println(result.getText().toString());
        });

        Button eightButton = findViewById(R.id.eight_button);
        eightButton.setOnClickListener(view -> {
            String text = result.getText().toString();
            if (text.equals("0")) {
                result.setText("8");
            } else {
                String update = text + "8";
                result.setText(update);
            }
            System.out.println(result.getText().toString());
        });

        Button nineButton = findViewById(R.id.nine_button);
        nineButton.setOnClickListener(view -> {
            String text = result.getText().toString();
            if (text.equals("0")) {
                result.setText("9");
            } else {
                String update = text + "9";
                result.setText(update);
            }
            System.out.println(result.getText().toString());
        });

        Button fourButton = findViewById(R.id.four_button);
        fourButton.setOnClickListener(view -> {
            String text = result.getText().toString();
            if (text.equals("0")) {
                result.setText("4");
            } else {
                String update = text + "4";
                result.setText(update);
            }
            System.out.println(result.getText().toString());
        });

        Button fiveButton = findViewById(R.id.five_button);
        fiveButton.setOnClickListener(view -> {
            String text = result.getText().toString();
            if (text.equals("0")) {
                result.setText("5");
            } else {
                String update = text + "5";
                result.setText(update);
            }
            System.out.println(result.getText().toString());
        });

        Button sixButton = findViewById(R.id.six_button);
        sixButton.setOnClickListener(view -> {
            String text = result.getText().toString();
            if (text.equals("0")) {
                result.setText("6");
            } else {
                String update = text + "6";
                result.setText(update);
            }
            System.out.println(result.getText().toString());
        });

        Button oneButton = findViewById(R.id.one_button);
        oneButton.setOnClickListener(view -> {
            String text = result.getText().toString();
            if (text.equals("0")) {
                result.setText("1");
            } else {
                String update = text + "1";
                result.setText(update);
            }
            System.out.println(result.getText().toString());
        });

        Button twoButton = findViewById(R.id.two_button);
        twoButton.setOnClickListener(view -> {
            String text = result.getText().toString();
            if (text.equals("0")) {
                result.setText("2");
            } else {
                String update = text + "2";
                result.setText(update);
            }
            System.out.println(result.getText().toString());
        });

        Button threeButton = findViewById(R.id.three_button);
        threeButton.setOnClickListener(view -> {
            String text = result.getText().toString();
            if (text.equals("0")) {
                result.setText("3");
            } else {
                String update = text + "3";
                result.setText(update);
            }
            System.out.println(result.getText().toString());
        });

        Button zeroButton = findViewById(R.id.zero_button);
        zeroButton.setOnClickListener(view -> {
            String text = result.getText().toString();
            if (!text.equals("0")) {
                String update = text + "0";
                result.setText(update);
            }
            System.out.println(result.getText().toString());
        });

        Button decimalButton = findViewById(R.id.decimal_button);
        decimalButton.setOnClickListener(view -> {
            String text = result.getText().toString() + ".";
            result.setText(text);
        });

        Button equalsButton = findViewById(R.id.equals_button);
        equalsButton.setOnClickListener(view -> {
            f.setLength(0);

            for (int i = 0; i < getDecimalPlaces(); i++) {
                f.append("#");
            }
            DecimalFormat df = new DecimalFormat("#." + f);

            y = result.getText().toString();

            if (add) {
                result.setText(add(df));
            } else if (subtract) {
                result.setText(subtract(df));
            } else if (multiply) {
                result.setText(multiply(df));
            } else if (divide) {
                result.setText(divide(df));
            }

            x = "0";
            y = "0";
        });


        Button plusButton = findViewById(R.id.plus_button);
        plusButton.setOnClickListener(view -> {
            x = result.getText().toString();
            result.setText("0");
            add = true;
            multiply = false;
            subtract = false;
            divide = false;

        });

        Button minusButton = findViewById(R.id.minus_button);
        minusButton.setOnClickListener(view -> {
            x = result.getText().toString();
            result.setText("0");
            add = false;
            multiply = false;
            subtract = true;
            divide = false;

        });

        Button multiplyButton = findViewById(R.id.multiply_button);
        multiplyButton.setOnClickListener(view -> {
            x = result.getText().toString();
            result.setText("0");
            add = false;
            multiply = true;
            subtract = false;
            divide = false;

        });

        Button percentButton = findViewById(R.id.percent_button);
        percentButton.setOnClickListener(view -> {
            f.setLength(0);

            for (int i = 0; i < getDecimalPlaces(); i++) {
                f.append("#");
            }
            DecimalFormat df = new DecimalFormat("#." + f);
            x = result.getText().toString();
            result.setText(percent(df));
            add = false;
            multiply = false;
            subtract = false;
            divide = false;

        });

        Button divideButton = findViewById(R.id.divide_button);
        divideButton.setOnClickListener(view -> {
            x = result.getText().toString();
            result.setText("0");
            add = false;
            multiply = false;
            subtract = false;
            divide = true;

        });
    }

    public String add(DecimalFormat df) {


        double xInt = parseValue(x);
        // 1.222
        double yInt = parseValue(y);
        // 1.111


        double result = xInt + yInt;

        if (result == Math.floor(result)) {
            return df0.format(result);
        }

        return df.format(result);

    }

    public String subtract(DecimalFormat df) {

        double xInt = parseValue(x);
        // 1.222
        double yInt = parseValue(y);
        // 1.111


        double result = xInt - yInt;

        if (result == Math.floor(result)) {
            return df0.format(result);
        }
        return df.format(result);


    }

    public String divide(DecimalFormat df) {

        try {
            double xInt = parseValue(x);
            // 1.222
            double yInt = parseValue(y);
            // 1.111


            double result = xInt / yInt;

            if (result == Math.floor(result)) {
                return df0.format(result);
            }

            return df.format(result);

        } catch (Exception e) {
            Toast makeToast = Toast.makeText(getApplicationContext(), "Cannot divide by 0", Toast.LENGTH_SHORT);
            makeToast.show();
            return "0";
        }


    }

    public String multiply(DecimalFormat df) {

        double xInt = parseValue(x);
        // 1.222
        double yInt = parseValue(y);
        // 1.111


        double result = xInt * yInt;
        System.out.println(result);

        if (result == Math.floor(result)) {
            return df0.format(result);
        }
        return df.format(result);


    }

    public String percent(DecimalFormat df) {

        double xInt = Double.parseDouble(x);

        return df.format(xInt / 100);
    }

    public double parseValue(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException n) {
            return 0.0;
        }
    }

    public int getDecimalPlaces() {
        String longest;

        if (x.length() > y.length()) {
            longest = x;
        } else {
            longest = y;
        }

        int indexOfDecimal = longest.indexOf(".") + 1;
        return longest.substring(indexOfDecimal).length();

    }



}