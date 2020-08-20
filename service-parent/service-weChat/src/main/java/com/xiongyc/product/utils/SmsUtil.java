package com.xiongyc.product.utils;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsUtil {

	public static void send(String regionId, String accessKeyId, String secret,String domain, String version, String action,String mobile, String signName, String templateCode, String templateParamJson, String outId) {
		DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, secret);
		IAcsClient client = new DefaultAcsClient(profile);

		CommonRequest request = new CommonRequest();
		request.setSysMethod(MethodType.POST);
		request.setSysDomain(domain);
		request.setSysVersion(version);
		request.setSysAction(action);
		request.putQueryParameter("RegionId", regionId);
		request.putQueryParameter("PhoneNumbers", mobile);
		request.putQueryParameter("SignName", signName);
		request.putQueryParameter("TemplateCode", templateCode);
		request.putQueryParameter("TemplateParam", templateParamJson);
		request.putQueryParameter("OutId", outId);
		try {
			log.info("======> SMS REQUEST:" + JSON.toJSONString(request));
			CommonResponse response = client.getCommonResponse(request);
			log.info("======> SMS RESPONSE:" + response.getData());
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
