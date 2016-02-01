**SQRL - Secure Quick Reliable Login**  
![I'm a QR Code](https://www.grc.com/sqrl/512-bit-master-key.png)
A SQRL App for Android that will allow for secure website authentication without the hassle of multiple online identities and username/password combinations.  
The app uses the QR code or link from a participating website which contains the URL and a random cryptographic challenge to create a unique user identity. From this, a public-private keypair is created which is the basis for the user's *digital signature*. 
 
---

Our project consists of both an Android application to authenticate a user and a website that will accept SQRL and create the cryptographic challenge for the app's user. Behind the scenes, the cryptography and security is handled by the website. See the Github for the website here: <https://github.com/mediix/SQRL_Web>  
For more information about SQRL, see the website at <https://www.grc.com/sqrl/sqrl.htm>
