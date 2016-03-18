package com.senior2.team17.soleino;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.bq.robotic.droid2ino.activities.BaseBluetoothConnectionActivity;
import com.bq.robotic.droid2ino.BluetoothConnection;
//import com.bq.robotic.droid2ino.utils.DeviceListDialogStyle;
//import com.bq.robotic.droid2ino.utils.Droid2InoConstants;

public class MainActivity  extends BaseBluetoothConnectionActivity {

    private BluetoothAdapter BA = BluetoothAdapter.getDefaultAdapter();
   // TextView steps = (TextView) findViewById(R.id.steps);



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button connect = (Button) findViewById(R.id.connect_button);
        connect.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if(!BA.isEnabled()){
                            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                            startActivityForResult(enableBtIntent, 0);

                        }


                        else{requestDeviceConnection();}


                    }
                }

        );

    }

    public void onActivityResult (int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            requestDeviceConnection();
        }
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

    @Override
    public void onNewMessage(String message){}
}
