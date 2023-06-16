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

![6.16](https://github.com/ZhengyiLu01/Fashionista/blob/main/images/Story%20map_2.png)

## The engine  architecture:

![f7e17b6f84e96c70b28f071315d2584](https://github.com/ZhengyiLu01/Fashionista/assets/63914308/40f73fb5-0a0b-4374-8b17-5b5688cd9786)

The user will firstly take several images of their body, and pick one product on the front end. The front end will send body images and product ID to `main`. 

`main` will send user's body image to `body 3D model` which will then generate a body 3D model of the user's body. This body 3D model, along with the user ID, will be saved to `Local storage`. In the future, the user can directly use their old models, instead of taking new pictures.   

`main` will also send product ID to `Cloths model` which will then retrieve the cloths 3D model from `Model database and API`. The retrieved cloths 3D model, along with the body 3D model, will be sent to `Merge` to generate the dressing effect of the user wearing the desired cloths with desired size. The merged 3D model will also be saved to local storage for future use.


# APIs and Controller
"Nettelo": This is used to create a 3d body model. The front end 'main' will send the 4 photo to Nettelo. The Nettelo will analyze the photo and create a 3D model, which is sent back to the front end to be confirmed. 
![3D BODY SCAN API]
User inputs MULTIPLE photos for body scanning. Our app sends POST request for these images and sends a GET request to Nettelo's API. Netello sends 200 level code indicating that the request was successful; if failed the API sends 400 code indicating that the request was unsuccessful.

![RETAIL API] (https://cloud.google.com/retail/docs/reference/rest)

![RAPID API] (https://rapidapi.com/)
Use this API store to integrate APIs easily

![TAOBAO API](https://rapidapi.com/gabrielius.u/api/taobao-api/) 
![AMAZON PRICE API] (https://rapidapi.com/ebappa1971/api/amazon-price/) : to integrate purchasing and pricing from third part apps for our the stretch goals

"Clothware.io": Photo to 3D Cloth; Expensive, one garment request at a time.

"FireBase": Wishlist/Cart Database.

If we are using existing OS subsystems or 3rd-party SDKs for implementing the engine, we will interact with them through appropriate adapters or libraries. As scheduled, if we utilize Google Cloud services like Cloud Storage or Cloud Functions, we would interact with their respective SDKs to handle image storage or trigger serverless functions for backend processing.

This initial design provides a basic structure for communication between the front-end and back-end engine, but it's important to note that the specific implementation details may evolve and be refined as the development progresses and additional considerations arise.
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

