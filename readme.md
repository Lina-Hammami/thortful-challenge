# Welcome to Thortful Challenge API!

You  can find below the steps needed for install and run the springboot app.


# Steps
- Clone this link, type this line into your terminal: 
  `git clone https://github.com/Lina-Hammami/thortful-challenge.git`
- Open the project on your preferred IDE (example IntelliJ)
- Make sure you have installed the convenient java version (java17)
- Run the application (Shift+F10 in IntelliJ)
- Consume the apis with postman or any preferred equivalent

# REST API Endpoints

## Get All Countries

- **Endpoint:** `/api/countries`
- **Method:** `GET`
- **Example URL:** `http://localhost:8080/api/countries`

[//]: # ()
[//]: # (## Get Country by Name)

[//]: # ()
[//]: # ()
[//]: # (- **Endpoint:** `/api/countries/{name}`)

[//]: # ()
[//]: # (- **Method:** `GET`)

[//]: # ()
[//]: # (- **Example URL:** `http://localhost:8080/api/countries/tunisia`)

## Get Country Capital by Name

- **Endpoint:** `/api/countries/{name}/capital`
- **Method:** `GET`
- **Example URL:** `http://localhost:8080/api/countries/tunisia/capital`

## Get Country Currency by Name

- **Endpoint:** `/api/countries/{name}/currency`
- **Method:** `GET`
- **Example URL:** `http://localhost:8080/api/countries/tunisia/currency`

## Get Country Language by Name

- **Endpoint:** `/api/countries/{name}/language`
- **Method:** `GET`
- **Example URL:** `http://localhost:8080/api/countries/canada/language`

## Get Countries by Timezone

- **Endpoint:** `/api/countries/timezone/{timezone}`
- **Method:** `GET`
- **Example URL:** `http://localhost:8080/api/countries/timezone/UTC+02:00`
