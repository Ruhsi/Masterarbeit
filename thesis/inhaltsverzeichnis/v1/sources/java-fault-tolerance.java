@Produces   // CDI Producer
@OAuthToken // CDI Qualifier
@Dependent  // CDI Scope
@Retry(delay = 100L, maxRetries = 5, retryOn = {
  TokenResponseException.class})
@Timeout(value = 5L, unit = ChronoUnit.SECONDS)
String obtainOauthToken() throws IOException {
    return tokenRequest.execute().getAccessToken();
}
