package com.yrsoft.filter.handler;

import javax.ws.rs.core.Response.Status;


import org.apache.servicecomb.core.Handler;
import org.apache.servicecomb.core.Invocation;
import org.apache.servicecomb.swagger.invocation.AsyncResponse;
import org.apache.servicecomb.swagger.invocation.exception.CommonExceptionData;
import org.apache.servicecomb.swagger.invocation.exception.InvocationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LsjHandler implements Handler {

    private static final Logger LOGGER = LoggerFactory.getLogger(LsjHandler.class);
	
  @Override
  public void handle(Invocation invocation, AsyncResponse asyncResp) throws Exception {
    // 取出请求参数，这里的排列和服务契约描述的一致
//    Object arg = invocation.getArgs()[0];
//    String letStrangerPass = invocation.getContext("letStrangerPass");
//    if ("stranger".equalsIgnoreCase(arg.toString()) && !"true".equalsIgnoreCase(letStrangerPass)) {
//      // 把请求拦截下来，返回403
//      asyncResp.producerFail(new InvocationException(Status.FORBIDDEN, new CommonExceptionData("Don't know you :(")));
//      return;
//    }
	  LOGGER.info("进入拦截器");

    // 继续执行后面的逻辑
    invocation.next(asyncResp);
  }
}
