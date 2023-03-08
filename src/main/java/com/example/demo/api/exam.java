package com.example.demo.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.codef.api.EasyCodef;
import io.codef.api.EasyCodefServiceType;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class exam {

    public static void main(String[] args) throws UnsupportedEncodingException, JsonProcessingException, InterruptedException {

        /** #1.쉬운 코드에프 객체 생성 및 클라이언트 정보 설정 */
        EasyCodef codef = new EasyCodef();
        codef.setClientInfoForDemo("475bbc7a-9562-46b2-b84a-29937f8570a6", "0643a2c7-8c13-469b-a9ff-e8e91b613233");
        //codef.setClientInfo(EasyCodefClientInfo.CLIENT_ID, EasyCodefClientInfo.CLIENT_SECRET);
        codef.setPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArpVJ4hxX8z2RLM6drWgnhXtD+RyTkqEPJvdHPHeJxOAAIf4" +
                "gIbWFuNNQpwsSxAfXTGR+c9dh4WOUGS5/fJXhdgUqKYH7f9FL/Ay/mBRP+61plF3fLSQBWnjQmQ2DR6o/akU16VujR3E+k7pCs" +
                "m+VWHuai68mVd59mNA7WSwLXtvNvItuefzeFumxNnoUAn8soFYrcEDW5u/qRiFYb+eABi3C4+PpYB1KmnRjNc4ysiqljeu29fuVEmK" +
                "UcLtsHSWLs8BL/UfGsV8JmGrkL0gIQZfqOz5lKgI4pXKAORACIMExxh0/IE5AMfmwDxp0f+j024I10dBIIuRy9fpI40xC4wIDAQAB");

        /** #2.식별 아이디 생성 / 요청 식별 아이디(SSO(동일계정) 구분값) / 사용자 계정을 식별할 수 있는 유일 값 세팅 (ex. 아이디 + UUID)
         *  다건요청에서 사용되는 식별아이디는 각 요청에 필수로 입력해야 합니다.
         * */
        String ID = "testID" + UUID.randomUUID();

/** #3.다건 요청에 대한 결과값을 확인하기 위해 API요청 Thread를 생성하여 확인 */
        for (int i = 0; i < 2; i++) {

            /** #4.요청 파라미터 설정 - 각 상품별 파라미터를 설정(https://developer.codef.io/products) */
            // 다건요청 확인을 위해 조회 연도를 다르게 설정
            // 요청A : 2018년도 데이터 / 요청 B : 2019년도 데이터
            String searchStartYear = String.valueOf(2021 + i);
            String searchEndYear = String.valueOf(2021 + i);

            HashMap<String, Object> parameterMap = new HashMap<String, Object>();
            parameterMap.put("organization", "0002");
            parameterMap.put("loginType", "5"); // "0":(공동/금융)인증서 "5":간편인증
            parameterMap.put("loginTypeLevel", "1");  // 1:카카오톡, 2:페이코, 3:삼성패스, 4:KB모바일, 5:통신사(PASS), 6:네이버, 7:신한인증서, 8: toss
            parameterMap.put("userName", "윤혜린");
            parameterMap.put("phoneNo", "01040721761");
            parameterMap.put("identity", "20010328");
            parameterMap.put("inquiryType", "0");

            parameterMap.put("id", ID); //식별아이디

            parameterMap.put("searchStartYear", searchStartYear);
            parameterMap.put("searchEndYear", searchEndYear);
            parameterMap.put("type", "1");

            /** #5.Thread 실행*/
            Thread t = new requestThread(codef, parameterMap, i);
            t.start();

            // API 요청A와 요청B 다건 요청을 위해서는 요청A 처리 후 요청B를 처리할 수 있도록
            // 요청A 송신 후 약 0.5초 ~ 1초 이내 요청B 송신 필요
            Thread.sleep(1000);

        }
    }



}
