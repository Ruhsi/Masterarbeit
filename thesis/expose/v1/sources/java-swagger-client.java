@Path("/")
public interface ReportRestServiceApi  {

    @GET
    @Path("/report/generate")
    @Produces({ "application/json" })
   AppReportModel generate(@QueryParam("id") @NotNull @Min(0) Long id);
}
