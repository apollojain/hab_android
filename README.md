Introduction
======================
Welcome to the Intro to Android Workshop!

Never created an Android app? Well, you;
After you finish this, you'll have:

* Created an Android Virtual Device (AVD) Emulator
* Worked with the Android Activity Lifecycle
* Imported and used some of Android's built-in packages to make cool apps
* Learned the basics of creating an awesome UI
* Learned how to create UI fragments

Step 0: Before you begin
=========================
Remember to do the following:
* Use Google! Results from [stackoverflow.com](http://stackoverflow.com) are an amazing resource. You get to utilize the knowledge of the global computer science developer community. However, don't just copy-paste answers from the web. Make sure you understand exactly what's going on before you copy-paste anything.
* Ask your neighbors. Working in groups is extremely productive as each of you can fill the gaps of knowledge the others have. Also, it's a good opportunity to make friends and find future potential project partners!
* Ask H@B members for help. That's what they're here to do! 

With all this in mind, several H@B members have volunteered to assist people with creating this workshop. So, if you ever need help, look for these awesome people:

<table>
    <tr>
    <td>Apollo Jain</td>
    <td>Alan Li</td>
	<td>Kenny Chung</td>
	<td>Aditya Gande</td>
    </tr>
</table>

Episode I: The Eclipse Menace
============================================
First of all, you need to actually open Eclipse! Let's do it. 
* If you haven't already, extract your ADT bundle (the zip folder from the Android website, which you can download
from the link on the Android Workshop Facebook Page) to somewhere you can easily access it. 
* Open this folder and click on "eclipse"
* Double click on "eclipse.exe"
* ADT should start up

Now, let's create a project!
* Go to File -> New -> Android Application Project
* Name your project Text2Talk (although you can pretty much name it whatever you want to). Change "example" in the package name to your name or your company name. Otherwise, you will not be able to upload your app to the app store
* Change Target API to API 19 and the "Compile with" to API 19 as well. When the API is set 20 or above, there are sometimes issues with rendering text boxes (EditTexts)
* Uncheck "Create custom launcher icon"
* Check "Blank Activity"
* Keep clicking next after this and then click "Finish"

Episode II: Attack of the Android (AVD) Emulator
==========================================

Use the following steps to install a stable Android Virtual Device for use in DS
labs and projects.

Unless otherwise stated, all these steps are executed from within Eclipse.

#### Part 1 ####
Help menu -> Check for updates
Be sure you are running the latest version of Eclipse.
</br>
#### Part 2 ####
Window menu -> Android SDK Manager
Install the following API if it is not already installed.
 - Android 4.4.2 (API 19)
</br>
You can check if it is installed by looking at the "Status" column on the right.
</br>
#### Part 3 ####
Eclipse -> Window -> Android Virtual Device Manager

Create a New... Android Virtual Device
Give your device a name like "4.4.2AndroidDevice"  (The name cannot have spaces.)
Choose a Device such as Nexus S (be sure you choose a smartphone, not a tablet)
Choose Target: Android 4.4.2 - API Level 19
Choose CPU/ABI of "ARM" (currently the most prevalent processor)
Click "OK"
</br>
#### Part 4 ####
Start the Android Virtual Device
Select 4.4.2AndroidDevice
Click "Start..."
Click "Launch"
</br>
At this point, the new Android Virtual Device (AVD) should start up. Once the
AVD is fully started, you drag the lock to the right to the unlock icon to 
unlock the phone. It can take a couple minutes to get the AVD fully going. 
Sometimes the first time the AVD is launched it seems to not show the lock.
Try clicking on the Home button.

Episode III: Revenge of the User Interface
==========================================
#### Part 1 ####
Move your mouse to the left-hand panel.
Go to Text2Talk -> res -> layout -> activity_main.xml.
Double click on "activity_main.xml" near the bottom of the screen. 
You should be able to see all of the text currently on the screen.
Delete all of it.
#### Part 2 ####
Go to Palette -> Layouts and drag a "Linear Layout (Vertical) into the 
gray space in the center of the screen
#### Part 3 ####
Go to Palette -> Form Widgets and drag a Large Text View (the thing that 
says "Large") into the gray area of your screen. Go to the right hand side of the screen and scroll down to "Gravity". Type 
"center_horizontal" into the input field.  This should center your title. 
Now on the right hand side of your screen, scroll up to "Padding Top" and 
type 20dp. This will shift your title down a little bit. 
#### Part 4 ####
Go to "Text" on the right hand side of the screen and enter "@string/app_name" 
into the input box. This will change the Text View's contents to the name of your app. 
If you want to see where this comes from, go to Resources at the bottom of the screen. Click the "strings.xml" button. 
Below the string labelled "action_settings, type: 
```xml
...
<string app_name="title">Text2Talk</string>
<string app_name="button">Speak</string>
...
```
#### Part 5 ####
Now go to Palette -> Text Fields under the Large Text.
Type "center_horizontal" into Gravity. Change the "Padding Top" to 20dp. 
Go to Palette -> Form Widgets and drag a Button into the gray area of your 
screen. Go down to "Width" in the right-hand panel and type "fill_parent" into your 
text box. Lastly, go to "activity_main.xml" in the bottom tab, go to the <Button> tags, and 
modify it so it looks like this:
```xml
...
<Button
        android:id="@+id/button1"
        android:layout_height="wrap_content"
        android:onClick="speakText"
        android:layout_margin="10dp"
        android:layout_width="match_parent"
        android:text="@string/button" />
...
```
In case you're curious, the "onClick" attribute is basically a "listener" that waits for you to click it. 
It will then trigger the "speakText" function, which we will write in our Java code. 


Congrats! You've just made an Android User Interface Layout! Pat yourselves on the back!

Episode IV: A Java Hope
==========================================

Now, let's program our app!
#### Part 1 ####
First let's deal with adding some UI elements and seeing what happens onCreate.
Type the code below. Try not to just copy and paste, as it really helps to have 
this stuff in muscle memory!
Comments have been added for your viewing pleasure:
```java
...
	//A LITTLE OF OUR OWN CODE
	TextToSpeech ttobj; //declaring a ttobj variable
	private EditText write; //declaring an EditText variable so you can manipulate it later
	//ENDS HERE
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//OUR CODE STARTS HERE
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
		//ENDS HERE
	}
...
```
* You are probably going to get a lot of import errors at this point. To fix these, hover over anything with a red squiggly under it, 
and click "Import ______" for each one. 
* In case you're curious, onCreate is part of the Activity Life Cycle and indicates what happens when you actually create the app.

#### Part 2 ####
Now, let's add an onPause method. This deals with things that occur when your app loses focus with its current activity. We will want
to destroy our TextToSpeech object so that it doesn't take up too much memory, because what often happens in this case is that someone 
wants to, for instance, use another app. Here is the code; place it below your onCreate method:

```java
...
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
...
```

#### Part 3 ####
Last but not least, let us actually write the method that allows us to convert text to speech. The comments understand how 
the magic happens:
```java
...
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
...
```

* By the way, sorry we couldn't come up with any clever Star Wars references for this particular part. We ran out of ideas...