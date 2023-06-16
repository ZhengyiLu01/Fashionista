# Getting Started
## Front-end Dependencies

The front-end of the Android app relies on the following third-party tools, libraries, and SDKs:

1. [Android Jetpack](https://developer.android.com/jetpack?hl=zh-cn): A set of libraries, tools, and architectural guidance to help build robust and efficient Android apps.
2. [Nettelo](http://nettelo.com/)：3D Body Scan API
3. ([Clothware.io](https://www.clothware.io/)：Photo to 3D Cloth)
4. [Firebase](https://firebase.google.com/?hl=zh-cn): A platform for building mobile and web applications，used as Wishlist/Cart Database

## Back-end Dependencies

The back-end of the Android app relies on the following third-party tools, libraries, SDKs, and APIs:

1. [Google Cloud Functions](https://cloud.google.com/functions?hl=zh-cn): Use for image uploads or user actions to perform backend processing.
2. [Google Cloud Firestore](https://cloud.google.com/firestore?hl=zh-cn): A database that can be used to store and retrieve user data, such as user profiles, clothing preferences, and shopping history.

# Model and Engine 
## The story map:

![6.16](https://github.com/ZhengyiLu01/Fashionista/blob/main/images/Story%20map%206.16.png)

## The engine  architecture:

![f7e17b6f84e96c70b28f071315d2584](https://github.com/ZhengyiLu01/Fashionista/assets/63914308/40f73fb5-0a0b-4374-8b17-5b5688cd9786)

The user will firstly take several images of their body, and pick one product on the front end. The front end will send body images and product ID to `main`. 

`main` will send user's body image to `body 3D model` which will then generate a body 3D model of the user's body. This body 3D model, along with the user ID, will be saved to `Local storage`. In the future, the user can directly use their old models, instead of taking new pictures.   

`main` will also send product ID to `Cloths model` which will then retrieve the cloths 3D model from `Model database and API`. The retrieved cloths 3D model, along with the body 3D model, will be sent to `Merge` to generate the dressing effect of the user wearing the desired cloths with desired size. The merged 3D model will also be saved to local storage for future use.


# APIs and Controller
"Nettelo": This is used to create a 3d body model. The front end 'main' will send the 4 photo to Nettelo. The Nettelo will analyze the photo and create a 3D model, which is sent back to the front end to be confirmed. 

# View UI/UX

# Team Roster
### Chengsong Zhang
Contributions:

### Chengyu Wu
Contributions:

### Dongbin Park
Contributions:

### Helina Fikru Yilma
Contributions:

### Zhaoting Wu
Contributions:

### Zhengyi Lu
Contributions:

