@ApplicationScoped
public class ReportServiceImpl implements ReportService {

  @Inject
  private Logger log;

  @Override
  public ReportModel generateReportForCustomer(Long id) {
      log.info("Generating report for customer id");
  }
}
