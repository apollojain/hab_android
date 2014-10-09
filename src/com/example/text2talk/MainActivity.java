package com.example.text2talk;

import java.util.Locale; //allows us to specify a location, which determines the setting of the "voice" speaking
import java.util.Random;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
//import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	TextToSpeech ttobj;
	private EditText write;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        write = (EditText) findViewById(R.id.editText1); //you actually get the EditText
        ttobj = new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener(){ //When you initialize the TextToSpeech, you want to set the language
                    @Override
                public void onInit(int status){
                        if(status != TextToSpeech.ERROR){
                            ttobj.setLanguage(Locale.US); //set the language of the textToSpeech, which is the Locale
                        }
                    }
                });
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	    String toSpeak = write.getText().toString();
	    write = (EditText) findViewById(R.id.editText1); //you actually get the EditText
	    // Checks the orientation of the screen
	    if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
	    	setContentView(R.layout.fragment_main);
	    	EditText et1 = (EditText)findViewById(R.id.editText1);
	    	et1.setText(toSpeak);
	    } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
	    	setContentView(R.layout.activity_main);
	    	EditText et1 = (EditText)findViewById(R.id.editText1);
	    	et1.setText(toSpeak);
	    }
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
    @Override
    public void onPause(){
    	/*
         * If you leave the program you want to make sure it doesn't crash
         * 
         */
    	
        if(ttobj != null){
            ttobj.stop();
            ttobj.shutdown();
        }
       
        super.onPause();
        
    }
    
    
    public void speakText(View view){ 
    	/*
    	 * A View occupies a rectangular area on the screen and is responsible for drawing and event handling. 
    	 * View is the base class for widgets, which are used to create interactive UI components (buttons, text fields, etc.).
    	 */
        String toSpeak = write.getText().toString();
        //basically, we're taking the text from the write EditText and putting it into toSpeak
        Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
        //above, you're getting the string toSpeak and displaying it in a Toast, which is like a speech bubble
        ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
        //now you are actually speaking the contents of the toSpeak string and flushing the string from the queue so you can add new stuff.

    }
}
