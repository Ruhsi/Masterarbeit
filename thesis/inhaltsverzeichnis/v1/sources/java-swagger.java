@Path("/report")
@Api(value="ReportRestService", description="Customer report service")
public interface ReportRestService {

  @Path("/generate")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @ApiOperation(value="Customer report", response=ReportModelDto.class)
  ReportModelDto generate(@QueryParam("id") @NotNull @Min(0) Long id);
}
