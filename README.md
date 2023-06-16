# Getting Started

# Model and Engine
The user will firstly take several images of their body, and pick one product on the front end. The front end will send body images and product ID to `main`. `main` will send user's body image to `body 3D model` which will then generate a body 3D model of the user's body. This body 3D model, along with the user ID, will be saved to `Local storage`. In the future, the user can directly use their old models, instead of taking new pictures. `main` will also send product ID to `Cloths model` which will then retrieve the cloths 3D model from `Model database and API`. The retrieved cloths 3D model, along with the body 3D model, will be sent to `Merge` to generate the dressing effect of the user wearing the desired cloths with desired size. The merged 3D model will also be saved to local storage for future use.
![f7e17b6f84e96c70b28f071315d2584](https://github.com/ZhengyiLu01/Fashionista/assets/63914308/40f73fb5-0a0b-4374-8b17-5b5688cd9786)

# APIs and Controller

# View UI/UX

# Team Roster
