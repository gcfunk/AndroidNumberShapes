package com.example.gregfunk.androidnumbershapes;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    public class Number {
        int number;

        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;

            while (triangularNumber < number) {
                x++;
                triangularNumber += x;
            }

            return (triangularNumber == number);
        }

        public boolean isSquare() {
            Double sqrt = Math.sqrt(number);
            return (Math.floor(sqrt) == sqrt);
        }
    }

    public void testNumber(View view) {
        EditText userNumber = (EditText) findViewById(R.id.userNumber);

        String message = "";
        if (userNumber.getText().toString().isEmpty()) {
            message = "Please enter a number";
        } else {

            Number num = new Number();
            num.number = Integer.parseInt(userNumber.getText().toString());

            if (num.isTriangular() && num.isSquare()) {
                message = "Both a square and a triangular number";
            } else if (num.isTriangular()) {
                message = "Is a triangular number but not a square";
            } else if (num.isSquare()) {
                message = "Is a square number but not triangular";
            } else {
                message = "Neither a square nor a triangular number";
            }
        }
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
