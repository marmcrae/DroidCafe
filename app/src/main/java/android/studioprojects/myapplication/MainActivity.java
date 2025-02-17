package android.studioprojects.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.DateIntervalInfo;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "android.studioprojects.myapplication.extra.Message";
    private String mOrderMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);


            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                return true;

            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                return true;

            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                return true;

            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;

            case R.id.action_settings:
                Intent settingsIntent = new Intent(this,
                        SettingsActivity.class);
                startActivity(settingsIntent);
                return true;

            default:

        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }



    public void showDonutOrder(View view) {
        Toast.makeText(this, "You ordered a donut!", Toast.LENGTH_SHORT).show();
    }


    public void showIceCreamOrder(View view) {
        Toast.makeText(this, "You ordered an ice cream sunday!", Toast.LENGTH_SHORT).show();
    }


    public void showMacaroonOrder(View view) {
        Toast.makeText(this, "You ordered a macaroon!", Toast.LENGTH_SHORT).show();
    }
}
