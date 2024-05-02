# Assessment Backend - Java Springboot Developer Xsis

## Create, Read, Update, Delete Movies

### Create Movies
 - Endpoint     : "/Movies"
 - Method       : "POST"
 - Description  : return the details of a movies in JSON format
 - JSON Body (request Body) : 
 ```json
{
    "id" : 1,
    "title" : "Pengabdi Setan 2 Comunion",
    "description" : "dalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017 Pengabdi Setan.",
    "rating" : 7.0,
    "image" : "",
    "created_at" : "2022-08-01 10:56:31",
    "updated_at": "2022-08-13 09:30:23"
}
```
 - response :
```json
{
    "id" : 1,
    "title" : "Pengabdi Setan 2 Comunion",
    "description" : "dalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017 Pengabdi Setan.",
    "rating" : 7.0,
    "image" : "",
    "created_at" : "2022-08-01 10:56:31",
    "updated_at": "2022-08-13 09:30:23"
}
```

### Get All Movies
 - Endpoint     : "/Movies"
 - Method       : "GET"
 - Description  : return all of movies in JSON format
```json
[
    {
        "id" : 1,
        "title" : "Pengabdi Setan 2 Comunion",
        "description" : "dalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017 Pengabdi Setan.",
        "rating" : 7.0,
        "image" : "",
        "created_at" : "2022-08-01 10:56:31",
        "updated_at": "2022-08-13 09:30:23"
    },
    {
        "id" : 2,
        "title" : "Pengabdi Setan 2",
        "description" : "dalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017 Pengabdi Setan.",
        "rating" : 7.0,
        "image" : "",
        "created_at" : "2022-08-01 10:56:31",
        "updated_at": "2022-08-13 09:30:23"
    },
]
```

### Get Movies by ID
 - Endpoint     : "/Movies/{id}"
 - Method       : "GET"
 - Description  : return the movies in JSON format
```json
{
    "id" : 1,
    "title" : "Pengabdi Setan 2 Comunion",
    "description" : "dalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017 Pengabdi Setan.",
    "rating" : 7.0,
    "image" : "",
    "created_at" : "2022-08-01 10:56:31",
    "updated_at": "2022-08-13 09:30:23"
}
```

### Update Movies
 - Endpoint     : "/Movies/{id}"
 - Method       : "PATCH"
 - Description  : Update Movies with param id and request body
 - JSON Body (request Body) : 
```json
{
    "id" : 2,
    "title" : "Pengabdi Setan 2 Comunion",
    "description" : "dalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017 Pengabdi Setan.",
    "rating" : 7.0,
    "image" : "",
    "created_at" : "2022-08-01 10:56:31",
    "updated_at": "2022-08-13 09:30:23"
}
```
 - response :
```json
{
    "id" : 2,
    "title" : "Pengabdi Setan 2 Comunion",
    "description" : "dalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017 Pengabdi Setan.",
    "rating" : 7.0,
    "image" : "",
    "created_at" : "2022-08-01 10:56:31",
    "updated_at": "2022-08-13 09:30:23"
}
```

### Delete Movies By ID
 - Endpoint     : "/Movies/{id}"
 - Method       : "DELETE"
 - Description  : Delete Movies with param id
 - response (String) :  Deleted successfully!