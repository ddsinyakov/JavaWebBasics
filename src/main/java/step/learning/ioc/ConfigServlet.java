package step.learning.ioc;

import com.google.inject.servlet.ServletModule;

import step.learning.filters.AuthFilter;
import step.learning.servlets.FiltersServlet;
import step.learning.servlets.GuiceServlet;
import step.learning.servlets.HomeServlet;
import step.learning.filters.DBFilter;
import step.learning.filters.DemoFilter;
import step.learning.servlets.RegUserServlet;

public class ConfigServlet extends ServletModule {
    @Override
    protected void configureServlets() {
        filter("/*").through(DemoFilter.class);
        filter("/*").through(DBFilter.class);
        filter("/*").through(AuthFilter.class);

        serve("/filters").with(FiltersServlet.class);
        serve("/guice").with(GuiceServlet.class);
        serve("/register/").with(RegUserServlet.class);
        serve("").with(HomeServlet.class);

    }
}
