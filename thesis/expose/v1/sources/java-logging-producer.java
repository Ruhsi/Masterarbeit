@ApplicationScoped
public class LoggerConfiguration {

  @Produces
  @Default
  @Dependent
  Logger createLogger(final InjectionPoint ip) {
      if (ip.getBean() != null) {
          return Logger.getLogger(ip.getBean().getBeanClass());
      } else if (ip.getMember() != null) {
          return Logger.getLogger(ip.getMember().getDeclaringClass());
      } else {
          return Logger.getLogger("default");
      }
  }
}
