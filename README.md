# Game of Basecamp

GlobalLogic JavaBaseCamp Lviv 2019 final project.

## Features💡

- [x] Fetching info about certain character from the API 💂🏻
- [x] Fetching info about certain house from the API 🏠
- [x] Fetching info about certain book from the API 📖
- [x] Writing data into the database 📚
- [x] Fight your enemies, because winter is coming!❄️
- [x] Makes you feel happy 👽

## Getting started

### Prerequisites

What things do you need to install

```
Java SDK 11
Maven 3.6.0+
```

### Installation

- Clone Git repository
```
$ git clone https://github.com/korostenskyiHub/Game-of-Basecamp.git
```

## Examples
- For fetching random character, you have to make HTTP POST request on:

```
$ curl -X POST "http://localhost:8080/"
```

You should receive this JSON response:
```
{
    "status": "OK",
    "message": "1"
}
```

```"status"``` represents HTTP Response Code.

```"message"``` shows ```UUID``` in local database of fetched character.

The following methods (for example, ```fight``` etc.) need several characters, saved in local database. So, run this command multiple times.

- For showing all the content of local database use this HTTP GET request:

```
$ curl "http://localhost:8080/?page=<Page Number>"
```

You can specify the amount of objects, got in JSON via specifying this number as optional request param ```pageSize```.

By default ```pageSize``` equals 5.
```
$ curl "http://localhost:8080/?page=<Page Number>&pageSize=<Amount of Objects>"
```

The output should be the following:

```
$ curl "http://localhost:8080/?page=0&pageSize=2"

{
    "status": "OK",
    "result": [
        {
            "id": 1,
            "url": "https://www.anapioficeandfire.com/api/characters/56",
            "name": "Aenys Frey",
            "gender": "Male",
            "culture": "",
            "born": "In or between 240 AC and 247 AC",
            "died": "In 300 AC, at Near Winterfell",
            "titles": [
                "Ser"
            ],
            "aliases": [
                ""
            ],
            "father": "",
            "mother": "",
            "spouse": "https://www.anapioficeandfire.com/api/characters/1045",
            "allegiances": [
                "https://www.anapioficeandfire.com/api/houses/143"
            ],
            "books": [
                "https://www.anapioficeandfire.com/api/books/1",
                "https://www.anapioficeandfire.com/api/books/2",
                "https://www.anapioficeandfire.com/api/books/3",
                "https://www.anapioficeandfire.com/api/books/5",
                "https://www.anapioficeandfire.com/api/books/8"
            ],
            "povBooks": [],
            "tvSeries": [
                ""
            ],
            "playedBy": [
                ""
            ]
        },
        {
            "id": 2,
            "url": "https://www.anapioficeandfire.com/api/characters/365",
            "name": "Ellery Vance",
            "gender": "Male",
            "culture": "",
            "born": "",
            "died": "",
            "titles": [
                "Ser"
            ],
            "aliases": [
                ""
            ],
            "father": "",
            "mother": "",
            "spouse": "",
            "allegiances": [
                "https://www.anapioficeandfire.com/api/houses/404"
            ],
            "books": [
                "https://www.anapioficeandfire.com/api/books/3",
                "https://www.anapioficeandfire.com/api/books/5"
            ],
            "povBooks": [],
            "tvSeries": [
                ""
            ],
            "playedBy": [
                ""
            ]
        }
    ]
}
```

```"status"``` represents HTTP Response Code.

```"result"``` represents the array of ```Character``` objects.

- For making a fight between 2 characters, use the following:

```
$ curl "http://localhost:8080/<UUID of First Character>?enemy=<UUID of Second Character>"
```

The output should be as following:

```
$ curl "http://localhost:8080/1?enemy=3"

{
    "status": "OK",
    "message": "Aenys Frey (id: 1) from House Frey of the Crossing was fighting against Lancel Lannister (id: 3) from House Lannister of Casterly Rock on the place of House Nayland of Hag's Mire (id: 279) and was a winner"
}
```

**NOTE!**

If character DOES NOT have ```House```, application will consider it from ```"Unknown house"```

- For fetching certain ```Character``` use:

```
$ curl "http://localhost:8080/character/<Character Id>"
```

The output should be as following:

```
$ curl "http://localhost:8080/character/2"

{
    "id": 7,
    "url": "https://www.anapioficeandfire.com/api/characters/2",
    "name": "Walder",
    "gender": "Male",
    "culture": "",
    "born": "",
    "died": "",
    "titles": [
        ""
    ],
    "aliases": [
        "Hodor"
    ],
    "father": "",
    "mother": "",
    "spouse": "",
    "allegiances": [
        "https://www.anapioficeandfire.com/api/houses/362"
    ],
    "books": [
        "https://www.anapioficeandfire.com/api/books/1",
        "https://www.anapioficeandfire.com/api/books/2",
        "https://www.anapioficeandfire.com/api/books/3",
        "https://www.anapioficeandfire.com/api/books/5",
        "https://www.anapioficeandfire.com/api/books/8"
    ],
    "povBooks": [],
    "tvSeries": [
        "Season 1",
        "Season 2",
        "Season 3",
        "Season 4",
        "Season 6"
    ],
    "playedBy": [
        "Kristian Nairn"
    ]
}
```

- For fetching certain ```Book``` use:

```
$ curl "http://localhost:8080/book/<Book Id>"
```

The output should be as following:

```
$ curl "http://localhost:8080/book/2"

{
    "id": 8,
    "url": "https://www.anapioficeandfire.com/api/books/2",
    "name": "A Clash of Kings",
    "isbn": "978-0553108033",
    "authors": [
        "George R. R. Martin"
    ],
    "numberOfPages": 768,
    "publisher": "Bantam Books",
    "country": "United States",
    "mediaType": "Hardback",
    "released": "1999-02-02T00:00:00.000+0000",
    "characters": [
        "https://www.anapioficeandfire.com/api/characters/2",
        "https://www.anapioficeandfire.com/api/characters/12",
        "https://www.anapioficeandfire.com/api/characters/13",
        "https://www.anapioficeandfire.com/api/characters/16",
        "https://www.anapioficeandfire.com/api/characters/20",
        ...
    ],
    "povCharecters": null
}
```

- For fetcing certain ```House``` use:

```
$ curl "http://localhost:8080/houses/<House id>"
```

The output should be as folowwing:

```
$ curl "http://localhost:8080/houses/2"

{
    "id": 9,
    "url": "https://www.anapioficeandfire.com/api/houses/2",
    "name": "House Allyrion of Godsgrace",
    "region": "Dorne",
    "coatOfArms": "Gyronny Gules and Sable, a hand couped Or",
    "words": "No Foe May Pass",
    "titles": [
        ""
    ],
    "seats": [
        "Godsgrace"
    ],
    "currentLord": "https://www.anapioficeandfire.com/api/characters/298",
    "heir": "https://www.anapioficeandfire.com/api/characters/1922",
    "overlord": "https://www.anapioficeandfire.com/api/houses/285",
    "founded": "",
    "diedOut": "",
    "ancestralWeapons": [
        ""
    ],
    "cadetBranches": [],
    "swornMembers": [
        "https://www.anapioficeandfire.com/api/characters/298",
        "https://www.anapioficeandfire.com/api/characters/1129",
        "https://www.anapioficeandfire.com/api/characters/1301",
        "https://www.anapioficeandfire.com/api/characters/1922"
    ]
}
```

## Author
- Roman Korostenskyi -> [Github](https://github.com/korostenskyiHub) 