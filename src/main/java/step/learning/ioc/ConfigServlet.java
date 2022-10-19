package step.learning.ioc;

import com.google.inject.servlet.ServletModule;

import step.learning.FiltersServlet;
import step.learning.GuiceServlet;
import step.learning.HomeServlet;
import step.learning.filters.DBFilter;
import step.learning.filters.DemoFilter;

public class ConfigServlet extends ServletModule {
    @Override
    protected void configureServlets() {
        filter("/*").through(DemoFilter.class);
        filter("/*").through(DBFilter.class);

        serve("/filters").with(FiltersServlet.class);
        serve("/guice").with(GuiceServlet.class);
        serve("").with(HomeServlet.class);
    }
}
