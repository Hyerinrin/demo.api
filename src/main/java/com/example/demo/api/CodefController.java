package com.example.demo.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.codef.api.EasyCodef;
import io.codef.api.EasyCodefServiceType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.UUID;

@RestController
public class CodefController {

    /**
     * 깃헙
     * https://github.com/codef-io/easycodef-java
     * */
    @GetMapping("/")
    public String getCodef() throws UnsupportedEncodingException, JsonProcessingException, InterruptedException {
        /** #1.쉬운 코드에프 객체 생성 및 클라이언트 정보 설정 */
        EasyCodef codef = new EasyCodef();
        codef.setClientInfoForDemo("475bbc7a-9562-46b2-b84a-29937f8570a6", "0643a2c7-8c13-469b-a9ff-e8e91b613233");
        //codef.setClientInfo(EasyCodefClientInfo.CLIENT_ID, EasyCodefClientInfo.CLIENT_SECRET);
        codef.setPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArpVJ4hxX8z2RLM6drWgnhXtD+RyTkqEPJvdHPHeJxOAAIf4" +
                "gIbWFuNNQpwsSxAfXTGR+c9dh4WOUGS5/fJXhdgUqKYH7f9FL/Ay/mBRP+61plF3fLSQBWnjQmQ2DR6o/akU16VujR3E+k7pCs" +
                "m+VWHuai68mVd59mNA7WSwLXtvNvItuefzeFumxNnoUAn8soFYrcEDW5u/qRiFYb+eABi3C4+PpYB1KmnRjNc4ysiqljeu29fuVEmK" +
                "UcLtsHSWLs8BL/UfGsV8JmGrkL0gIQZfqOz5lKgI4pXKAORACIMExxh0/IE5AMfmwDxp0f+j024I10dBIIuRy9fpI40xC4wIDAQAB");


        /** #2. 입력부 요청 파라미터 설정 - 각 상품별 파라미터를 설정(https://developer.codef.io/products) */
        HashMap<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("organization", "0002"); // 기관코드 설정
        parameterMap.put("loginType", "5");
        parameterMap.put("loginTypeLevel", "1");
        parameterMap.put("userName", "윤혜린");
        parameterMap.put("phoneNo", "01040721761");
        parameterMap.put("identity", "20010328");
        parameterMap.put("inquiryType", "0");
        parameterMap.put("searchStartYear", "2022");
        parameterMap.put("searchEndYear", "2023");
        parameterMap.put("type", "0");
        parameterMap.put("telecom", "0");

        /** #3.코드에프 정보 조회 요청 - 서비스타입(API:정식, DEMO:데모, SANDBOX:샌드박스) */
        String productUrl = "/v1/kr/public/pp/nhis-health-checkup/result"; // 건강검진결과 api
        String result = codef.requestProduct(productUrl, EasyCodefServiceType.DEMO, parameterMap);

/**    #4.코드에프 정보 결과 확인	*/
        System.out.println(result);

        HashMap<String, Object> responseMap = new ObjectMapper().readValue(result, HashMap.class);
        HashMap<String, Object> resultMap = (HashMap<String, Object>) responseMap.get("result");


        Thread.sleep(15000);
        System.out.println("15초 경과!");
        /** #5.추가인증 입력부 파라미터 설정 */
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("organization", "0002"); //기관코드 필수 입력

        /** #6. 간편인증 추가인증 입력부*/
        paramMap.put("simpleAuth", "1");
        paramMap.put("is2Way", true);

        paramMap.put("twoWayInfo", (HashMap<String, Object>) responseMap.get("data"));


        // 추가인증 요청 시에는 이지코드에프.requestCertification 으로 호출
        String re;
        re = codef.requestCertification(productUrl, EasyCodefServiceType.DEMO, paramMap);
        System.out.println("추가인증 : " + re);

        return re;
    }
}

