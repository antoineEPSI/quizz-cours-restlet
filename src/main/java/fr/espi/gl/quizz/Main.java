package fr.espi.gl.quizz;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import fr.espi.gl.quizz.web.QuizzApplication;
import fr.espi.gl.quizz.web.configuration.GuiceProductionModule;
import org.restlet.Component;
import org.restlet.data.Protocol;

public class Main {

    public static void main(String[] args)  {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8080);
        Injector injector = Guice.createInjector(Stage.PRODUCTION, new GuiceProductionModule());
        component.getDefaultHost().attach(new QuizzApplication(injector));
        try {
            component.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}