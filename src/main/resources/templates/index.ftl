<!DOCTYPE html>
<html>
    <head>
        <title>Star Wars Wiki</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/x-icon" href="/fav/favicon.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>

    <body>
        <nav class="navbar navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="/fav/favicon.png" alt="icon" width="30" height="24" class="d-inline-block align-text-top ms-3">
                    Star Wars Wiki
                </a>
            </div>
        </nav>
        <div class="container-lg d-flex justify-content-around mt-5">
            <div class="card" style="width: 18rem;">
                <img src="/images/characters.png" alt="characters" width="30" height="350" class="card-img-top" alt="Characters">
                <div class="card-body">
                    <h5 class="card-title">Characters</h5>
                    <p class="card-text">Search and find info about the characters in the franchise</p>
                    <a href="/characters" class="btn btn-primary">Click Here</a>
                </div>
            </div>

            <div class="card" style="width: 18rem;">
                <img src="/images/starships.png" alt="starships" width="30" height="350" class="card-img-top" alt="Characters">
                <div class="card-body">
                    <h5 class="card-title">Starships</h5>
                    <p class="card-text">Search and find info about the starships in the franchise</p>
                    <a href="/starships" class="btn btn-primary">Click Here</a>
                </div>
            </div>

            <div class="card" style="width: 18rem;">
                <img src="/images/movies.png" alt="movies" width="30" height="350" class="card-img-top" alt="Characters">
                <div class="card-body">
                    <h5 class="card-title">Movies</h5>
                    <p class="card-text">Search and find info about the movies of the franchise</p>
                    <a href="/films" class="btn btn-primary">Click Here</a>
                </div>
            </div>
        </div>
        <script src="/js/index.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>

</html>