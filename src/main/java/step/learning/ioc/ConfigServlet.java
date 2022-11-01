package step.learning.ioc;

import com.google.inject.servlet.ServletModule;

import step.learning.filters.AuthFilter;
import step.learning.servlets.*;
import step.learning.filters.DBFilter;
import step.learning.filters.DemoFilter;

public class ConfigServlet extends ServletModule {
    @Override
    protected void configureServlets() {
        filter("/*").through(DemoFilter.class);
        filter("/*").through(DBFilter.class);
        filter("/*").through(AuthFilter.class);

        serve("/filters").with(FiltersServlet.class);
        serve("/guice").with(GuiceServlet.class);
        serve("/register/").with(RegUserServlet.class);
        serve("/image/*").with(DownloadServlet.class);
        serve("/profile").with(ProfileServlet.class);
        serve("/").with(HomeServlet.class);

    }
}
