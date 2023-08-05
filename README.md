# Getting Started
This is a project for VE441: App Development for Entrepreneurs (2023 Summer Semester).
You can have access to our project cloned from github.com or Github Desktop.
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

![7.20](https://github.com/ZhengyiLu01/Fashionista/blob/main/images/story%20map_7.12.png)

## The engine  architecture:

![f7e17b6f84e96c70b28f071315d2584](https://github.com/ZhengyiLu01/Fashionista/assets/63914308/40f73fb5-0a0b-4374-8b17-5b5688cd9786)

The user will firstly take several images of their body, and pick one product on the front end. The front end will send body images and product ID to `main`. 

`main` will send user's body image to `body 3D model` which will then generate a body 3D model of the user's body. This body 3D model, along with the user ID, will be saved to `Local storage`. In the future, the user can directly use their old models, instead of taking new pictures.   

`main` will also send product ID to `Cloths model` which will then retrieve the cloths 3D model from `Model database and API`. The retrieved cloths 3D model, along with the body 3D model, will be sent to `Merge` to generate the dressing effect of the user wearing the desired cloths with desired size. The merged 3D model will also be saved to local storage for future use.


# APIs and Controller
"Nettelo": This is used to create a 3d body model. The front end 'main' will send the 4 photo to Nettelo. The Nettelo will analyze the photo and create a 3D model, which is sent back to the front end to be confirmed. 
[3D BODY SCAN API]
User inputs MULTIPLE photos for body scanning. Our app sends POST request for these images and sends a GET request to Nettelo's API. Netello sends 200 level code indicating that the request was successful; if failed the API sends 400 code indicating that the request was unsuccessful.

[RETAIL API](https://cloud.google.com/retail/docs/reference/rest) and [RAPID API](https://rapidapi.com/): Use this API store to integrate APIs easily

[TAOBAO API](https://rapidapi.com/gabrielius.u/api/taobao-api/) and [AMAZON PRICE API](https://rapidapi.com/ebappa1971/api/amazon-price/): to integrate purchasing and pricing from third part apps for our the stretch goals

"Clothware.io": Photo to 3D Cloth; Expensive, one garment request at a time.
"Avaturn": to create 3D avatar based on input measurements https://docs.avaturn.me/docs/integration/sdk/introduction/
"ReadyPlayer me": Interactive avatar capbaple of cloth chnage https://docs.readyplayer.me/

"FireBase": Wishlist/Cart Database.

If we are using existing OS subsystems or 3rd-party SDKs for implementing the engine, we will interact with them through appropriate adapters or libraries. As scheduled, if we utilize Google Cloud services like Cloud Storage or Cloud Functions, we would interact with their respective SDKs to handle image storage or trigger serverless functions for backend processing.

This initial design provides a basic structure for communication between the front-end and back-end engine, but it's important to note that the specific implementation details may evolve and be refined as the development progresses and additional considerations arise.
# View UI/UX
## UI/UX Flow
![UI modeling](https://github.com/ZhengyiLu01/Fashionista/blob/main/images/UI%20flow_modeling.png)
![UI tryon](https://github.com/ZhengyiLu01/Fashionista/blob/main/images/UI%20flow_tryon.png)
![UI cart](https://github.com/ZhengyiLu01/Fashionista/blob/main/images/UI%20flow_Cart.png)
## Usability Test Results
### Numerical Results
Success: 
All of our test participants were able to do core functions of our app: generating model, trying 
on a cloth on generated model & adding it to cart.
Majority of our test particiants (67%) were able to access the camera to generate model. All of 
our participants used the manual size input function to generate mdel.
Limitation:
Data from usability test was incomplete because of how we designed our questions.
Some functionalities were found to be complicated/time-consuming.
![Usabilitytest_1](https://github.com/ZhengyiLu01/Fashionista/blob/main/images/Usabilitytest_1.png)
### Summary of Findings Qualitatively
![Usabilitytest_2](https://github.com/ZhengyiLu01/Fashionista/blob/main/images/Usabilitytest_2.png)
## Final Design Justifications
### Home Page
● Using concise buttons for the home page to ensure that users can easily turn to the three functions of our app: modeling, try-on and cart

● Both suitable for first-time and regular users, they can choose to start from the very beginning steps of modeling or directly search for clothes with existing models
![Finaljustification_1](https://github.com/ZhengyiLu01/Fashionista/blob/main/images/Finaljustification_1.png)
### Collect Size
● Add the name of different parameters in front of the entry boxes since in the previous one users can’t see the name once they enter a number

● Add two new parameters “arm length” and “leg length” to help generate the models.
![Finaljustification_2](https://github.com/ZhengyiLu01/Fashionista/blob/main/images/Finaljustification_2.png)
### Searching Page
● Using a more concise searching page for users to get recommendations for clothes choice.

● Remove the redundant filters from the searching page, only leaving the most important filter: 2D or 3D models
![Finaljustification_3](https://github.com/ZhengyiLu01/Fashionista/blob/main/images/Finaljustification_3.png)
### Cart
● Rearranging the filters on the cart: we delete the “Top-rated” filter since it is not important in the cart stage

● Remove the rating on each clothes and replace it with a “delete” button which enable users to directly delete it instead of decreasing the amount to zero

● Add the “link” text to help users to find the links
![Finaljustification_4](https://github.com/ZhengyiLu01/Fashionista/blob/main/images/Finaljustification_4.png)

# Team Roster
### Chengsong Zhang
Contributions:

Mainly work on Back-end, including initially establishing files for API and data collection. Design the engine architecture.

### Chengyu Wu
Contributions:

Work on the trello body for building cards and set criterias. Arrange Utibility tests with other group and edit the video.

### Dongbin Park
Contributions:

Implement the cart and link activity for the front-end view. Added a cart that holds the item chosen, and can have the items changed in quantity including said item. 

Then, makes a receipt so that the user can remember what they chose, and added a download receipt button that allows the user to keep it saved. Also created the variables of the class cartItem. 

For paperwork, designed the skeletal product and MVP for story board. Also made the value proposition comic and the questionaire - questions for the final proposal and the Pretest questions for the UIUX.


### Helina Fikru Yilma
Contributions:

Work on Back-end and Implementing the search Activity for categories of clothes for the front view.

### Zhaoting Wu
Contributions:

Subcontribute to implement the front-end view, main activity and body modeling activity.

Conduct the App running test of front end and debug.

For paperwork, responsible for the challenge part and paper review.

### Zhengyi Lu
Contributions:

For code part, implement the front-end view, including main activity and body modeling activity. Generate an initial structure for the Shopping activity.

Design UI for home page and generate model part. Design the whole structure of the app, including the page transition flow.

Help with the cart and link part. Improve the cart UI to make it consistant with the whole app. Help debug with the data transmission between cart and the receipt.

For paperwork, design the texts and slides for all presentations. Write the UI/UX part in the final document.

## Challenges

1.	Generate model for the users by entering the body data of users.
2.	Offering the 2D and 3D model of clothes.
3.	Combine the body model and clothes model to show the try-on effect of users.
4.	Generate model for the users by taking pictures of users.
5.  Connecting two different classes that share the same item.

    Solved by using mutable List.
6.  Deciding what variables to implement.

    Made sure to make each item contain a name, price, rating, category, etc.
7. How to make a download button for the receipt, and make each picture seperate instead of overwriting each other for each save.

    Used the output file function to create a picture. For each picture, added a timestamp of when the screenshot was taken so that multiple receipts could be saved.