package com.junia;

import Classes.*;
import Classes.Enum.*;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.staticFiles.add(staticFiles -> {
                staticFiles.directory = "web";
                staticFiles.location = Location.CLASSPATH;});

            config.routes.get("/api/test", ctx ->
                    ctx.result("Connexion au serveur réussie"));
        }).start(7070);

        Ajarakan ajarakan1 = new Ajarakan();
    }

//            config.staticFiles.add(staticFiles -> {
//            staticFiles.directory = "web";
//            staticFiles.location = Location.CLASSPATH;
//            });
//        }).start(7070);
//
//        app.get("/api/test", (Context ctx) -> ctx.result("Connexion au serveur Java réussie"));
//        }

}
