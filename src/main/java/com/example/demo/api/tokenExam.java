package com.example.demo.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.codef.api.EasyCodef;
import io.codef.api.EasyCodefServiceType;
import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class tokenExam {

    public static void main(String[] args) throws UnsupportedEncodingException, JsonProcessingException, InterruptedException {

        // 사업자등록상태(휴폐업조회)(Connected ID 미사용)

/** #1.쉬운 코드에프 객체 생성 및 클라이언트 정보 설정 */
        EasyCodef codef = new EasyCodef();
        codef.setClientInfoForDemo("475bbc7a-9562-46b2-b84a-29937f8570a6", "0643a2c7-8c13-469b-a9ff-e8e91b613233");
        //codef.setClientInfo(EasyCodefClientInfo.CLIENT_ID, EasyCodefClientInfo.CLIENT_SECRET);
        codef.setPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArpVJ4hxX8z2RLM6drWgnhXtD+RyTkqEPJvdHPHeJxOAAIf4" +
                "gIbWFuNNQpwsSxAfXTGR+c9dh4WOUGS5/fJXhdgUqKYH7f9FL/Ay/mBRP+61plF3fLSQBWnjQmQ2DR6o/akU16VujR3E+k7pCs" +
                "m+VWHuai68mVd59mNA7WSwLXtvNvItuefzeFumxNnoUAn8soFYrcEDW5u/qRiFYb+eABi3C4+PpYB1KmnRjNc4ysiqljeu29fuVEmK" +
                "UcLtsHSWLs8BL/UfGsV8JmGrkL0gIQZfqOz5lKgI4pXKAORACIMExxh0/IE5AMfmwDxp0f+j024I10dBIIuRy9fpI40xC4wIDAQAB");

/** #5.요청 파라미터 설정 - 각 상품별 파라미터를 설정(https://developer.codef.io/products) */
        HashMap<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("organization", "0002"); // 기관코드 설정
        parameterMap.put("loginType", "5");
        parameterMap.put("loginTypeLevel", "1");
        parameterMap.put("userName", "윤혜린");
        parameterMap.put("phoneNo", "01040721761");
        parameterMap.put("identity", "20010328");
        parameterMap.put("inquiryType", "0");
        parameterMap.put("searchStartYear","2020");
        parameterMap.put("searchEndYear","2023");
        parameterMap.put("type","0");
        parameterMap.put("telecom", "0");

/** #6.코드에프 정보 조회 요청 - 서비스타입(API:정식, DEMO:데모, SANDBOX:샌드박스) */
        String productUrl = "/v1/kr/public/pp/nhis-health-checkup/result"; // (예시)사업자등록상태(휴폐업조회) URL
        String result = codef.requestProduct(productUrl, EasyCodefServiceType.DEMO, parameterMap);

/**	#7.코드에프 정보 결과 확인	*/
        System.out.println(result);

        HashMap<String, Object> responseMap = new ObjectMapper().readValue(result, HashMap.class);
        HashMap<String, Object> resultMap = (HashMap<String, Object>)responseMap.get("result");

        //assertEquals("코드에프 상품 요청 결과 실패(반환된 코드와 메시지 확인 필요)", "CF-00000", (String)resultMap.get("code"));
    }
}
