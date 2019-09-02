@Provider
public static class MDCContainerRequestFilter
  implements ContainerRequestFilter {

  @Override
  public void filter(ContainerRequestContext requestContext)
    throws IOException {
    final String tracingId = GlobalTracer.get().scopeManager().active()
                              .span().context().toString().split(":")[0];
    MDC.put("transaction.id", tracingId);
  }
}
