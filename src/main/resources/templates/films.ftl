<!DOCTYPE html>
<html>
    <head>
        <title>Star Wars Wiki</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/x-icon" href="/fav/favicon.png">
        <link href="/css/grid.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>

    <body>
        <nav class="navbar navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="/">
                    <img src="/fav/favicon.png" alt="icon" width="30" height="24" class="d-inline-block align-text-top ms-3">
                    Star Wars Wiki
                </a>
            </div>
        </nav>

        <div class="grid-display mt-5">
            <#list films as film>
                <div class="grid-item card mt-5" style="width: 18rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Title: ${film.title}</li>
                        <li class="list-group-item">Episode: ${film.episode}</li>
                        <li class="list-group-item">Director: ${film.director}</li>
                        <li class="list-group-item">Producer: ${film.producer}</li>
                        <li class="list-group-item">ReleaseDate: ${film.releaseDate}</li>
                    </ul>
                </div>
            </#list>
        </div>

        <nav aria-label="pages">
            <ul class="pagination justify-content-center mt-5">
                <#if (previous??)>
                    <li class="page-item">
                        <a class="page-link" href="${previous}" tabindex="-1">Previous</a>
                    </li>
                <#else>
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                    </li>
                </#if>
                <#if (next??)>
                    <li class="page-item">
                        <a class="page-link" href="${next}" tabindex="-1">Next</a>
                    </li>
                <#else>
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Next</a>
                    </li>
                </#if>
            </ul>
        </nav>

        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>

</html>