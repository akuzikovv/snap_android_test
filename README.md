# Testing Snapchat application on Android platform via Appium


# How to setup
Install the next instruments:
- IntelliJ IDEA
- Apache Ant
- Apache Maven
- Node.js
- Android SDK 
- Virtual Box 
- Genymotion (if you want to run test on android emulator)
- Appium 

Preparing to run:
- Real device should be connected via USB with turned on USB debugging option on it;
- Application should be installed at the device;
- register Snapchat account
- choose English language
- add 'receiver' user to friends
- Appropriate receiver should be entered in the "Snapchat.feature" file in the next line:
   - "When Enter the "enter the receiver name" receiver"
- Enter the appropriate info of your device to the next properties in the "MyAndroidDriver" class :
  - capabilities.setCapability("deviceName", "Enter device Name");
  - capabilities.setCapability("platformVersion", "enter platform Version like 7.1.0");
- Enter the appropriate login & password to the "Credentials.json" file in appropriate fields.


# Run via Maven
For running tests you  have  to use Maven. 
Just  click  on  the Clean and then Verify and tests will start.