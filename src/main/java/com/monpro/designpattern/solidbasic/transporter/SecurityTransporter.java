package com.monpro.designpattern.solidbasic.transporter;

import org.apache.commons.lang3.StringUtils;
import sun.net.www.http.HttpClient;

public class SecurityTransporter extends Transporter {
  private String appId;
  private String appToken;

  public SecurityTransporter(HttpClient httpClient, String appId, String appToken) {
    super(httpClient);
    this.appId = appId;
    this.appToken = appToken;
  }

  @Override
  public Response sendRequest(Request request) {
//    if(StringUtils.isNotBlank(appId) && StringUtils.isNotBlank(appToken)) {
//      request.addPayload("app-id", appId);
//      request.addPayload("app-token", appToken);
//    }
    // following code will break LSP
    // cause if the exception is thrown, it will break the logic of parent class
    if (StringUtils.isBlank(appId) || StringUtils.isBlank(appToken)) {
      throw new RuntimeException("");
    }
    request.addPayload("app-id", appId);
    request.addPayload("app-token", appToken);
    return super.sendRequest(request);
  }
}
