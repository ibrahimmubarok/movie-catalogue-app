package com.ibeybeh.submission.moviecatalogue.utils

import com.ibeybeh.submission.moviecatalogue.data.source.local.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.MoviesData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.TvShowData

object DataDummyHelper {

    fun generateDummyMovies(): List<MoviesData> {

        val movies = ArrayList<MoviesData>()

        movies.add(
            MoviesData(
                id = 299536,
                posterPath = "https://image.tmdb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg",
                genre = "Adventure / Action / Science Fiction",
                title = "Avengers: Infinity War",
                overview = "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                releaseDate = "25 April 2018",
                voteAverage = 8.3,
                homepage = "https://www.marvel.com/movies/avengers-infinity-war",
                runtime = "149"
            )
        )
        movies.add(
            MoviesData(
                id = 10191,
                posterPath = "https://image.tmdb.org/t/p/original/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/kxklJL1v8MYEU5xdU6W5VvmBwVz.jpg",
                genre = "Fantasy / Adventure / Animation / Family",
                title = "How to Train Your Dragon",
                overview = "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                releaseDate = "10 Maret 2010",
                voteAverage = 7.8,
                homepage = "http://www.howtotrainyourdragon.com/",
                runtime = "98"
            )
        )
        movies.add(
            MoviesData(
                id = 450001,
                posterPath = "https://image.tmdb.org/t/p/original/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/grtVFGJ4ts0nDAPpc1JWbBoVKTu.jpg",
                genre = "Action",
                title = "Master Z: Ip Man Legacy",
                overview = "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                releaseDate = "20 Desember 2018",
                voteAverage = 5.9,
                homepage = "http://www.themoviedb.org/movie/450001-cheung-tin-chi",
                runtime = "107"
            )
        )
        movies.add(
            MoviesData(
                id = 428078,
                posterPath = "https://image.tmdb.org/t/p/original/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/rm2oMykm5nX6SzXFr7TGHkO6r8Z.jpg",
                genre = "Adventure / Science Fiction",
                title = "Mortal Engines",
                overview = "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                releaseDate = "27 November 2018",
                voteAverage = 6.1,
                homepage = "http://www.mortalengines.com",
                runtime = "129"
            )
        )
        movies.add(
            MoviesData(
                id = 438799,
                posterPath = "https://image.tmdb.org/t/p/original/l76Rgp32z2UxjULApxGXAPpYdAP.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/sHNC8hjAu4ZKXYhG3cp8ghRZ02B.jpg",
                genre = "Horror / War / Science Fiction",
                title = "Overlord",
                overview = "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                releaseDate = "01 November 2018",
                voteAverage = 6.7,
                homepage = "http://www.overlordmovie.com",
                runtime = "110"
            )
        )
        movies.add(
            MoviesData(
                id = 82690,
                posterPath = "https://image.tmdb.org/t/p/original/zWoIgZ7mgmPkaZjG0102BSKFIqQ.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/ziC23LkMYj8gToQQYQGWSGJCLNF.jpg",
                genre = "Family / Animation / Comedy / Adventure",
                title = "Wreck-It Ralph",
                overview = "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started.",
                releaseDate = "01 November 2012",
                voteAverage = 7.3,
                homepage = "http://disney.go.com/wreck-it-ralph",
                runtime = "101"
            )
        )
        movies.add(
            MoviesData(
                id = 375588,
                posterPath = "https://image.tmdb.org/t/p/original/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/zSJT1sKGRKcmP4I9b8dIOuepw6I.jpg",
                genre = "Adventure / Action / Thriller",
                title = "Robin Hood",
                overview = "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                releaseDate = "21 November 2018",
                voteAverage = 5.9,
                homepage = "https://www.robinhood.movie",
                runtime = "116"
            )
        )
        movies.add(
            MoviesData(
                id = 452832,
                posterPath = "https://image.tmdb.org/t/p/original/hgWAcic93phg4DOuQ8NrsgQWiqu.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/ridcUDnFumpMB5AAsIvFafTSx5i.jpg",
                genre = "Thriller / Mystery / Drama",
                title = "Serenity",
                overview = "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                releaseDate = "24 Januari 2019",
                voteAverage = 5.4,
                homepage = "https://www.themoviedb.org/movie/452832-serenity",
                runtime = "102"
            )
        )
        movies.add(
            MoviesData(
                id = 324857,
                posterPath = "https://image.tmdb.org/t/p/original/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/7d6EY00g1c39SGZOoCJ5Py9nNth.jpg",
                genre = "Action / Adventure / Animation / Science Fiction / Comedy",
                title = "Spider-Man: Into the Spider-Verse",
                overview = "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \\\"Kingpin\\\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                releaseDate = "06 Desember 2018",
                voteAverage = 8.4,
                homepage = "http://www.intothespiderverse.movie",
                runtime = "117"
            )
        )
        movies.add(
            MoviesData(
                id = 505954,
                posterPath = "https://image.tmdb.org/t/p/original/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/3QVSM3DYxvov57j25vxDNJGHUpQ.jpg",
                genre = "War / Action / Drama / History",
                title = "T-34",
                overview = "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                releaseDate = "27 Desember 2018",
                voteAverage = 6.9,
                homepage = "https://www.themoviedb.org/movie/505954-34",
                runtime = "139"
            )
        )

        return movies
    }

    fun generateDummyTvShows(): List<TvShowData> {

        val tvShows = ArrayList<TvShowData>()

        tvShows.add(
            TvShowData(
                id = 60735,
                posterPath = "https://image.tmdb.org/t/p/original/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
                genre = "Drama / Sci-Fi & Fantasy",
                name = "The Flash",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                firstAirDate = "07 Oktober 2014",
                voteAverage = 7.7,
                homepage = "http://www.cwtv.com/shows/the-flash/",
                numberOfEpisodes = 142,
                numberOfSeasons = 7
            )
        )
        tvShows.add(
            TvShowData(
                id = 31910,
                posterPath = "https://image.tmdb.org/t/p/original/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/dTFnU3EQB79aDM4HnUj06Y9Xbq1.jpg",
                genre = "Animation / Action & Adventure / Sci-Fi & Fantasy",
                name = "Naruto Shippūden",
                overview = "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                firstAirDate = "15 February 2007",
                voteAverage = 8.6,
                homepage = "http://www.tv-tokyo.co.jp/anime/naruto/",
                numberOfEpisodes = 500,
                numberOfSeasons = 20
            )
        )
        tvShows.add(
            TvShowData(
                id = 4614,
                posterPath = "https://image.tmdb.org/t/p/original/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/yD1R7QCNqrcaf15AxkLbgRLI9Dz.jpg",
                genre = "Crime / Action & Adventure / Drama",
                name = "NCIS",
                overview = "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                firstAirDate = "23 September 2003",
                voteAverage = 7.4,
                homepage = "http://www.cbs.com/shows/ncis/",
                numberOfEpisodes = 412,
                numberOfSeasons = 18
            )
        )
        tvShows.add(
            TvShowData(
                id = 69050,
                posterPath = "https://image.tmdb.org/t/p/original/qZtAf4Z1lazGQoYVXiHOrvLr5lI.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                genre = "Mystery / Drama / Crime",
                name = "Riverdale",
                overview = "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                firstAirDate = "26 Januari 2017",
                voteAverage = 8.6,
                homepage = "http://www.cwtv.com/shows/riverdale/",
                numberOfEpisodes = 87,
                numberOfSeasons = 5
            )
        )
        tvShows.add(
            TvShowData(
                id = 34307,
                posterPath = "https://image.tmdb.org/t/p/original/9akij7PqZ1g6zl42DQQTtL9CTSb.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/5s9XHTB9SLPdg3mNU6BlSLnZ9Qq.jpg",
                genre = "Drama / Comedy",
                name = "Shameless",
                overview = "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                firstAirDate = "09 Januari 2011",
                voteAverage = 8.0,
                homepage = "http://www.sho.com/shameless",
                numberOfEpisodes = 134,
                numberOfSeasons = 11
            )
        )
        tvShows.add(
            TvShowData(
                id = 62688,
                posterPath = "https://image.tmdb.org/t/p/original/zsaiq8ZclPuneuN7loLEbsh1ANJ.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/jgb9xICHFX8wTGQ75js4uNbttQs.jpg",
                genre = "Drama / Sci-Fi & Fantasy / Action & Adventure",
                name = "Supergirl",
                overview = "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                firstAirDate = "26 Oktober 2015",
                voteAverage = 7.2,
                homepage = "http://cwtv.com/shows/supergirl",
                numberOfEpisodes = 113,
                numberOfSeasons = 6
            )
        )
        tvShows.add(
            TvShowData(
                id = 1622,
                posterPath = "https://image.tmdb.org/t/p/original/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original//nVRyd8hlg0ZLxBn9RaI7mUMQLnz.jpg",
                genre = "Drama / Mystery / Sci-Fi & Fantasy",
                name = "Supernatural",
                overview = "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                firstAirDate = "13 September 2005",
                voteAverage = 8.2,
                homepage = "http://www.cwtv.com/shows/supernatural",
                numberOfEpisodes = 327,
                numberOfSeasons = 15
            )
        )
        tvShows.add(
            TvShowData(
                id = 456,
                posterPath = "https://image.tmdb.org/t/p/original/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/hpU2cHC9tk90hswCFEpf5AtbqoL.jpg",
                genre = "Family / Animation / Comedy",
                name = "The Simpsons",
                overview = "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                firstAirDate = "17 Desember 1989",
                voteAverage = 7.8,
                homepage = "https://www.fox.com/the-simpsons/",
                numberOfEpisodes = 706,
                numberOfSeasons = 34
            )
        )
        tvShows.add(
            TvShowData(
                id = 75006,
                posterPath = "https://image.tmdb.org/t/p/original/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/qJxzjUjCpTPvDHldNnlbRC4OqEh.jpg",
                genre = "Action & Adventure / Sci-Fi & Fantasy / Drama",
                name = "The Umbrella Academy",
                overview = "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                firstAirDate = "15 February 2019",
                voteAverage = 8.7,
                homepage = "https://www.netflix.com/title/80186863",
                numberOfEpisodes = 20,
                numberOfSeasons = 2
            )
        )
        tvShows.add(
            TvShowData(
                id = 1402,
                posterPath = "https://image.tmdb.org/t/p/original/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/uro2Khv7JxlzXtLb8tCIbRhkb9E.jpg",
                genre = "Action & Adventure / Drama / Sci-Fi & Fantasy",
                name = "The Walking Dead",
                overview = "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                firstAirDate = "31 Oktober 2010",
                voteAverage = 8.1,
                homepage = "https://www.amc.com/shows/the-walking-dead",
                numberOfEpisodes = 154,
                numberOfSeasons = 11
            )
        )
        return tvShows
    }

    fun generateDummyMoviesEntity(): List<MoviesEntity> {

        val movies = ArrayList<MoviesEntity>()

        movies.add(
            MoviesEntity(
                id = 299536,
                posterPath = "https://image.tmdb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg",
                genre = "Adventure / Action / Science Fiction",
                title = "Avengers: Infinity War",
                overview = "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                releaseDate = "25 April 2018",
                voteAverage = 8.3,
                homepage = "https://www.marvel.com/movies/avengers-infinity-war",
                runtime = "149"
            )
        )
        movies.add(
            MoviesEntity(
                id = 10191,
                posterPath = "https://image.tmdb.org/t/p/original/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/kxklJL1v8MYEU5xdU6W5VvmBwVz.jpg",
                genre = "Fantasy / Adventure / Animation / Family",
                title = "How to Train Your Dragon",
                overview = "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                releaseDate = "10 Maret 2010",
                voteAverage = 7.8,
                homepage = "http://www.howtotrainyourdragon.com/",
                runtime = "98"
            )
        )
        movies.add(
            MoviesEntity(
                id = 450001,
                posterPath = "https://image.tmdb.org/t/p/original/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/grtVFGJ4ts0nDAPpc1JWbBoVKTu.jpg",
                genre = "Action",
                title = "Master Z: Ip Man Legacy",
                overview = "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                releaseDate = "20 Desember 2018",
                voteAverage = 5.9,
                homepage = "http://www.themoviedb.org/movie/450001-cheung-tin-chi",
                runtime = "107"
            )
        )
        movies.add(
            MoviesEntity(
                id = 428078,
                posterPath = "https://image.tmdb.org/t/p/original/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/rm2oMykm5nX6SzXFr7TGHkO6r8Z.jpg",
                genre = "Adventure / Science Fiction",
                title = "Mortal Engines",
                overview = "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                releaseDate = "27 November 2018",
                voteAverage = 6.1,
                homepage = "http://www.mortalengines.com",
                runtime = "129"
            )
        )
        movies.add(
            MoviesEntity(
                id = 438799,
                posterPath = "https://image.tmdb.org/t/p/original/l76Rgp32z2UxjULApxGXAPpYdAP.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/sHNC8hjAu4ZKXYhG3cp8ghRZ02B.jpg",
                genre = "Horror / War / Science Fiction",
                title = "Overlord",
                overview = "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                releaseDate = "01 November 2018",
                voteAverage = 6.7,
                homepage = "http://www.overlordmovie.com",
                runtime = "110"
            )
        )
        movies.add(
            MoviesEntity(
                id = 82690,
                posterPath = "https://image.tmdb.org/t/p/original/zWoIgZ7mgmPkaZjG0102BSKFIqQ.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/ziC23LkMYj8gToQQYQGWSGJCLNF.jpg",
                genre = "Family / Animation / Comedy / Adventure",
                title = "Wreck-It Ralph",
                overview = "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started.",
                releaseDate = "01 November 2012",
                voteAverage = 7.3,
                homepage = "http://disney.go.com/wreck-it-ralph",
                runtime = "101"
            )
        )
        movies.add(
            MoviesEntity(
                id = 375588,
                posterPath = "https://image.tmdb.org/t/p/original/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/zSJT1sKGRKcmP4I9b8dIOuepw6I.jpg",
                genre = "Adventure / Action / Thriller",
                title = "Robin Hood",
                overview = "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                releaseDate = "21 November 2018",
                voteAverage = 5.9,
                homepage = "https://www.robinhood.movie",
                runtime = "116"
            )
        )
        movies.add(
            MoviesEntity(
                id = 452832,
                posterPath = "https://image.tmdb.org/t/p/original/hgWAcic93phg4DOuQ8NrsgQWiqu.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/ridcUDnFumpMB5AAsIvFafTSx5i.jpg",
                genre = "Thriller / Mystery / Drama",
                title = "Serenity",
                overview = "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                releaseDate = "24 Januari 2019",
                voteAverage = 5.4,
                homepage = "https://www.themoviedb.org/movie/452832-serenity",
                runtime = "102"
            )
        )
        movies.add(
            MoviesEntity(
                id = 324857,
                posterPath = "https://image.tmdb.org/t/p/original/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/7d6EY00g1c39SGZOoCJ5Py9nNth.jpg",
                genre = "Action / Adventure / Animation / Science Fiction / Comedy",
                title = "Spider-Man: Into the Spider-Verse",
                overview = "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \\\"Kingpin\\\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                releaseDate = "06 Desember 2018",
                voteAverage = 8.4,
                homepage = "http://www.intothespiderverse.movie",
                runtime = "117"
            )
        )
        movies.add(
            MoviesEntity(
                id = 505954,
                posterPath = "https://image.tmdb.org/t/p/original/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/3QVSM3DYxvov57j25vxDNJGHUpQ.jpg",
                genre = "War / Action / Drama / History",
                title = "T-34",
                overview = "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                releaseDate = "27 Desember 2018",
                voteAverage = 6.9,
                homepage = "https://www.themoviedb.org/movie/505954-34",
                runtime = "139"
            )
        )

        return movies
    }

    fun generateDummyTvShowsEntity(): List<TvShowEntity> {

        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
                id = 60735,
                posterPath = "https://image.tmdb.org/t/p/original/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
                genre = "Drama / Sci-Fi & Fantasy",
                name = "The Flash",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                firstAirDate = "07 Oktober 2014",
                voteAverage = 7.7,
                homepage = "http://www.cwtv.com/shows/the-flash/",
                numberOfEpisodes = 142,
                numberOfSeasons = 7
            )
        )
        tvShows.add(
            TvShowEntity(
                id = 31910,
                posterPath = "https://image.tmdb.org/t/p/original/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/dTFnU3EQB79aDM4HnUj06Y9Xbq1.jpg",
                genre = "Animation / Action & Adventure / Sci-Fi & Fantasy",
                name = "Naruto Shippūden",
                overview = "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                firstAirDate = "15 February 2007",
                voteAverage = 8.6,
                homepage = "http://www.tv-tokyo.co.jp/anime/naruto/",
                numberOfEpisodes = 500,
                numberOfSeasons = 20
            )
        )
        tvShows.add(
            TvShowEntity(
                id = 4614,
                posterPath = "https://image.tmdb.org/t/p/original/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/yD1R7QCNqrcaf15AxkLbgRLI9Dz.jpg",
                genre = "Crime / Action & Adventure / Drama",
                name = "NCIS",
                overview = "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                firstAirDate = "23 September 2003",
                voteAverage = 7.4,
                homepage = "http://www.cbs.com/shows/ncis/",
                numberOfEpisodes = 412,
                numberOfSeasons = 18
            )
        )
        tvShows.add(
            TvShowEntity(
                id = 69050,
                posterPath = "https://image.tmdb.org/t/p/original/qZtAf4Z1lazGQoYVXiHOrvLr5lI.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                genre = "Mystery / Drama / Crime",
                name = "Riverdale",
                overview = "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                firstAirDate = "26 Januari 2017",
                voteAverage = 8.6,
                homepage = "http://www.cwtv.com/shows/riverdale/",
                numberOfEpisodes = 87,
                numberOfSeasons = 5
            )
        )
        tvShows.add(
            TvShowEntity(
                id = 34307,
                posterPath = "https://image.tmdb.org/t/p/original/9akij7PqZ1g6zl42DQQTtL9CTSb.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/5s9XHTB9SLPdg3mNU6BlSLnZ9Qq.jpg",
                genre = "Drama / Comedy",
                name = "Shameless",
                overview = "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                firstAirDate = "09 Januari 2011",
                voteAverage = 8.0,
                homepage = "http://www.sho.com/shameless",
                numberOfEpisodes = 134,
                numberOfSeasons = 11
            )
        )
        tvShows.add(
            TvShowEntity(
                id = 62688,
                posterPath = "https://image.tmdb.org/t/p/original/zsaiq8ZclPuneuN7loLEbsh1ANJ.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/jgb9xICHFX8wTGQ75js4uNbttQs.jpg",
                genre = "Drama / Sci-Fi & Fantasy / Action & Adventure",
                name = "Supergirl",
                overview = "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                firstAirDate = "26 Oktober 2015",
                voteAverage = 7.2,
                homepage = "http://cwtv.com/shows/supergirl",
                numberOfEpisodes = 113,
                numberOfSeasons = 6
            )
        )
        tvShows.add(
            TvShowEntity(
                id = 1622,
                posterPath = "https://image.tmdb.org/t/p/original/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original//nVRyd8hlg0ZLxBn9RaI7mUMQLnz.jpg",
                genre = "Drama / Mystery / Sci-Fi & Fantasy",
                name = "Supernatural",
                overview = "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                firstAirDate = "13 September 2005",
                voteAverage = 8.2,
                homepage = "http://www.cwtv.com/shows/supernatural",
                numberOfEpisodes = 327,
                numberOfSeasons = 15
            )
        )
        tvShows.add(
            TvShowEntity(
                id = 456,
                posterPath = "https://image.tmdb.org/t/p/original/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/hpU2cHC9tk90hswCFEpf5AtbqoL.jpg",
                genre = "Family / Animation / Comedy",
                name = "The Simpsons",
                overview = "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                firstAirDate = "17 Desember 1989",
                voteAverage = 7.8,
                homepage = "https://www.fox.com/the-simpsons/",
                numberOfEpisodes = 706,
                numberOfSeasons = 34
            )
        )
        tvShows.add(
            TvShowEntity(
                id = 75006,
                posterPath = "https://image.tmdb.org/t/p/original/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/qJxzjUjCpTPvDHldNnlbRC4OqEh.jpg",
                genre = "Action & Adventure / Sci-Fi & Fantasy / Drama",
                name = "The Umbrella Academy",
                overview = "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                firstAirDate = "15 February 2019",
                voteAverage = 8.7,
                homepage = "https://www.netflix.com/title/80186863",
                numberOfEpisodes = 20,
                numberOfSeasons = 2
            )
        )
        tvShows.add(
            TvShowEntity(
                id = 1402,
                posterPath = "https://image.tmdb.org/t/p/original/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/uro2Khv7JxlzXtLb8tCIbRhkb9E.jpg",
                genre = "Action & Adventure / Drama / Sci-Fi & Fantasy",
                name = "The Walking Dead",
                overview = "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                firstAirDate = "31 Oktober 2010",
                voteAverage = 8.1,
                homepage = "https://www.amc.com/shows/the-walking-dead",
                numberOfEpisodes = 154,
                numberOfSeasons = 11
            )
        )
        return tvShows
    }
}