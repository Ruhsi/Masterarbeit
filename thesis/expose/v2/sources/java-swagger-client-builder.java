Client client; ReportRestServiceApi api;
ResteasyClientBuilder builder = new ResteasyClientBuilder();

// Configure and build client
client = builder.connectionCheckoutTimeout(2, TimeUnit.SECONDS)
                .establishConnectionTimeout(2, TimeUnit.SECONDS)
                .socketTimeout(2, TimeUnit.SECONDS)
                .connectionTTL(2, TimeUnit.SECONDS)
                .connectionPoolSize(200)
                .register(ClientTracingFeature.class)
                .register(AppendOAuthFilter.class).build();

// Create proxy for JAX-RS interface
api = ProxyBuilder.builder(ReportRestServiceApi.class,
                           client.target(url))
                  .defaultConsumes(MediaType.TEXT_PLAIN).build();
