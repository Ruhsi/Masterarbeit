@Traced
public class ReportServiceImpl implements ReportService {

   // Prevent tracing for this method
   @Traced(false)
   public void doStruff() { ... }
}
