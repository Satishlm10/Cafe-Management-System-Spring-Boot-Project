# Cafe-Management-System-Spring-Boot-Project
2024/03/30
Cafe management System 
-User Controller
-User Service
-User Repo
-User SignUp api with validation, checking if the user is already registered and exception handling.
-Cafe utils class for handling the responses from the apis created 
-Cafe Constant class for defining the constants for the application
Project Structure
-Controller
  -ControllerImpl
    -Conterller Interfaces

-Service
  -ServiceImpl
    -Service Interfaces

-Repositories
  -Repositories for the entities

-Entity
  -Users

--------------------------------------------------------------------------------------------------------------------
2024/03/31
- UserServiceImpl takes parameter of Map object
- it is used for validation then coverted to dto using Modelmapper for taking the values in Map object as the values for UserDto object
- then the dto object is changed to user entity object and the values from dto is passed to user object then the fields which we will not make available in dto also will be added to the user object
- then we will return user object and save it to database using userRepo.
