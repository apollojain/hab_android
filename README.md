Introduction
======================
Welcome to the Intro to Android Workshop!

Never created an Android app? Well, you've come to the right place!
After you finish this, you'll have:

* Created an Android Virtual Device (AVD) Emulator
* Worked with the Android Activity Lifecycle
* Imported and used some of Android's built-in packages to make cool apps
* Learned the basics of creating an awesome UI
* Learned how to create UI fragments

Before you begin
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

#### Part 2 ####
Window menu -> Android SDK Manager
Install the following API if it is not already installed.
 - Android 4.4.2 (API 19)
You can check if it is installed by looking at the "Status" column on the right.

#### Part 3 ####
Eclipse -> Window -> Android Virtual Device Manager

Create a New... Android Virtual Device
Give your device a name like "4.4.2AndroidDevice"  (The name cannot have spaces.)
Choose a Device such as Nexus S (be sure you choose a smartphone, not a tablet)
Choose Target: Android 4.4.2 - API Level 19
Choose CPU/ABI of "ARM" (currently the most prevalent processor)
Click "OK"

#### Part 4 ####
Start the Android Virtual Device
Select 4.4.2AndroidDevice
Click "Start..."
Click "Launch"

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
Delete all of it. You'll get errors, but that's ok. 
We want to start from scratch. 

#### Part 2 ####
Go to Palette -> Layouts and drag a "Linear Layout (Vertical) into the 
gray space in the center of the screen

#### Part 3 ####
Go to Palette -> Form Widgets and drag a Large Text View (the thing that 
says "Large") into the gray area of your screen. Go to the right hand side of the screen and scroll down to "Gravity". Type "center_horizontal" into the input field.  Also be sure to change the width to "fill_parent." This should center your title.
Now on the right hand side of your screen, scroll up to "Padding Top" and 
type 20dp. This will shift your title down a little bit. 

#### Part 4 ####
Go to "Text" on the right hand side of the screen and enter "@string/app_name" 
into the input box. This will change the Text View's contents to the name of your app. 
If you want to see where this comes from, go to res -> values -> strings.xml. 
Below the string labelled "action_settings, type: 
```xml
...
<string app_name="title">Text2Talk</string>
<string app_name="button">Speak</string>
...
```
#### Part 5 ####
Now go to Palette -> Text Fields and drag over a Plain Text field.
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
Last but not least, let us actually write the method that allows us to convert text to speech. The comments explain how 
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

#### Part 4 ####
Just a bit of an aside: A quick lesson on debugging! What we're going to do now is go to our TextView

Episode V: The Fragments Strike Back
==================================
Now, we're going to launch into creating something called a fragment. A Fragment is basically a portion of the UI that you can use independently of your activity. We're going to use it to create different "views" when we align our phone in either portrait or landscape. 

#### Step 1 ####
Let's begin by adding a line to our AndroidManifest.xml on the left hand side of the screen under the <activity> tag: 

```xml
...
    
            android:configChanges="orientation|screenSize|layoutDirection"
...
```

This will allow us to configure certain things, like the orientation when we change a configuration like screen rotation. 

#### Step 2 ####
Now, let's actually create the fragment. Open up res and right click on "layout." Next, go to New -> Android XML File and name it "fragment_main.xml". This is useful when you want different views for different screen sizes (i.e. a tablet vs. a phone) or if you want to recycle the same fragment for a different Activity (what dictates how the app behaves. In our case, MainActivity converts Text to Speech, but you can create other ones). We will be using it to display different colors when you change the alignment of your screen. 

So, go to your old layout_main.xml file and copy all of your code over. Now, change the <LinearLayout> code to the following.


```xml
...
    
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:background="#BF5FFF"
    android:paddingTop="20dp" >
...
```

Do something similar for the activity_mail.xml: 
```xml
...
    
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:background="#BF5FFF"
    android:paddingTop="20dp" >
...
```

#### Step 3 ####

Now, we're going to add an onConfigurationChanged android lifecycle method. What this will do is look for changes in the layout orientation
of our app. If it's portrait, we'll change the fragment to activity_main.xml and if it's landscape, we'll change the fragment to fragment_main.xml. See the code below for more details and comments: 

```java
...
    
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
    
...
```

Awesome! You've now created some fragments. If you change your screen orientation, the color of the screen should change. 

Episode VI: Return of the ________________
=========================================
Congratulations! You've officially completed your first Android App!
At this point in time, you've only dipped your feet into the world of Android. There are many more things that you can do with this awesome technology. 

Some other things that you can learn regarding Android include: 
* Basic Key-Value Storage
* SQLite Storage
* Parse SDK (databasing, push notifications, etc.)
* Google Play SDK

Now it's your turn to create something incredible. Make some cool hacks!

