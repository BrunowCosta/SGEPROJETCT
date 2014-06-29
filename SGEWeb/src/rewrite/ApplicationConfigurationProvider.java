package rewrite;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.Forward;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.Path;

@RewriteConfiguration
public class ApplicationConfigurationProvider  extends HttpConfigurationProvider
{
   @Override
   public int priority()
   {
     return 10;
   }

   @Override
   public Configuration getConfiguration(final ServletContext context)
   {
     return ConfigurationBuilder.begin()
       .addRule()
         .when(Direction.isInbound().and(Path.matches("/some/{page}/")))
         .perform(Forward.to("/resources/view/{page}.xhtml"))
         
         .addRule()
         .when(Direction.isInbound().and(Path.matches("/login/")))
         .perform(Forward.to("/resources/view/public/index.xhtml"));
    }
}