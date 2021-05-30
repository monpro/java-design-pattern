package com.monpro.designpattern.oopbasic.apiauthenticator;

public class ApiAuthenticatorImpl implements ApiAuthenticator {

  private CredentialStorage credentialStorage;

  public ApiAuthenticatorImpl(CredentialStorage credentialStorage) {
    this.credentialStorage = credentialStorage;
  }

  @Override
  public void auth(String url) {
    ApiRequest apiRequest = ApiRequest.createFromUrl(url);
    auth(apiRequest);
  }

  @Override
  public void auth(ApiRequest apiRequest) {
    String appId = apiRequest.getAppId();
    String token = apiRequest.getToken();
    long timeStamp = apiRequest.getTimeStamp();
    String url = apiRequest.getBaseUrl();

    AuthToken authToken = new AuthToken(token, timeStamp);
    if (authToken.isExpired()) {
      throw new RuntimeException("token is expired");
    }
    String password = credentialStorage.getPasswordByAppId(appId);
    AuthToken serverAuthToken = AuthToken.generate(url, appId, password, timeStamp);
    if (!serverAuthToken.match(authToken)) {
      throw new RuntimeException("Verification failed");
    }
  }
}
