<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Cooking Miam Miam</a>
        </div>

        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="/recettes">Toutes les recettes</a></li>
                <li><a href="/recette-du-moment">Recette du moment</a></li>

            </ul>
            <sec:authorize access="isAuthenticated()">
            <ul class="nav navbar-nav navbar-right">
                    <li>Déconnexion<li>
            </ul>
            </sec:authorize>
        </div>
    </div>
</nav>