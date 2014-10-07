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
* Ask H@B members for help. Hack Jam is a learning experience for most people. It's a good time to take on something new so many people will be in your situation. Don't be afraid to ask people at Hack Jam for help. Chances are, they'll be able to assist you in some way.

With all this in mind, several H@B members have volunteered to assist people with the beginner hack. So, if you ever need help, look for these awesome people:

<table>
    <tr>
    <td>Apollo Jain</td>
    <td>Alan Li</td>
	<td>Kenny Chung</td>
	<td>Aditya Gande</td>
    </tr>
</table>

Step 1:  Creating a new Android Application
============================================
1) Go to File -> New -> Android Application Project
2) Name your project Text2Talk (although you can pretty much name it whatever you want to)
	* change "example" in the package name to your name or your company name. Otherwise, you will not be able to upload your app to the app store
3) Change Target API to API 19 and the "Compile with" to API 19 as well. When the API is set 20 or above, there are sometimes issues with rendering text boxes (EditTexts)
4) Uncheck "Create custom launcher icon"
5) Check "Blank Activity"
6) Keep clicking next after this and then click "Finish"

Step 2: Creating an Android (AVD) Emulator
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

Step 3: Creating a User Interface (Episode I: The UI Menace)
==========================================
#### Part 1 ####
Move your mouse to the left-hand panel
#### Part 2 ####
Go to Text2Talk -> res -> layout -> activity_main.xml
#### Part 3 ####
Click on "activity_main.xml" near the bottom of the screen
#### Part 4 ####
Delete all text
#### Part 5 ####
Go to Palette -> Layouts and drag a "Linear Layout (Vertical) into the 
gray space in the center of the screen
#### Part 6 ####
Go to Palette -> Form Widgets and drag a Large Text View (the thing that 
says "Large") into the gray area of your screen.
#### Part 7 ####
Go to the right hand side of the screen and scroll down to "Gravity". Type 
"center_horizontal" into the input field.  This should center your title. 
#### Part 8 ####
Now on the right hand side of your screen, scroll up to "Padding Top" and 
type 20dp. This will shift your title down a little bit. 
#### Part 9 ####
Go to "Text" on the right hand side of the screen and enter "@string/app_name" 
into the input box. Where is this coming from, you ask? Let's look!
#### Part 10 ####
Go to Resources at the bottom of the screen. Click the "strings.xml" button. 
Below the string labelled "action_settings, type: 
```xml
...
<string name="title">Text2Talk</string>
...
```
#### Part 11 ####
Now go to Palette -> Text Fields under the Large Text
#### Part 12 ####
Type "center_horizontal" into Gravity. Change the "Padding Top" to 20dp. 
#### Part 13 ####
Go to Palette -> Form Widgets and drag a Button into the gray area of your 
screen. 
#### Part 14 ####
Go down to "Width" in the right-hand panel and type "fill_parent" into your 
text box

Congrats! You've just made an Android User Interface Layout! Pat yourselves on the back!

Step 4: Now, onto coding!
==========================================

