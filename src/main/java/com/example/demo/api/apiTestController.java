package com.example.demo.api;

import io.codef.api.EasyCodef;
import io.codef.api.EasyCodefServiceType;

import java.io.IOException;
//import org.springframework.web.bind.annotation.RestController;

public class apiTestController {




    public static void main(String[] args) throws IOException {

        // #1.쉬운 코드에프 객체 생성
        EasyCodef codef = new EasyCodef();

/** #2.데모 클라이언트 정보 설정
 * - 데모 서비스 가입 후 코드에프 홈페이지에 확인 가능(https://codef.io/#/account/keys)
 * - 데모 서비스로 상품 조회 요청시 필수 입력 항목	*/
codef.setClientInfoForDemo("475bbc7a-9562-46b2-b84a-29937f8570a6", "0643a2c7-8c13-469b-a9ff-e8e91b613233");


/** #4.RSA암호화를 위한 퍼블릭키 설정
 * - 데모/정식 서비스 가입 후 코드에프 홈페이지에 확인 가능(https://codef.io/#/account/keys)
 * - 암호화가 필요한 필드에 사용 (ex)encryptValue(String plainText); */
codef.setPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArpVJ4hxX8z2RLM6drWgnhXtD+RyTkqEPJvdHPHeJxOAAIf4gIbWFu" +
        "NNQpwsSxAfXTGR+c9dh4WOUGS5/fJXhdgUqKYH7f9FL/Ay/mBRP+61plF3fLSQBWnjQmQ2DR6o/akU16VujR3E+k7pCsm+VWHuai68mVd59m" +
        "NA7WSwLXtvNvItuefzeFumxNnoUAn8soFYrcEDW5u/qRiFYb+eABi3C4+PpYB1KmnRjNc4ysiqljeu29fuVEmKUcLtsHSWLs8BL/UfGsV8" +
        "JmGrkL0gIQZfqOz5lKgI4pXKAORACIMExxh0/IE5AMfmwDxp0f+j024I10dBIIuRy9fpI40xC4wIDAQAB");

    /** #5.코드에프 토큰 발급 요청 - 서비스타입(API:정식, DEMO:데모, SANDBOX:샌드박스) */
    String accessToken1 = codef.requestToken(EasyCodefServiceType.DEMO);	// 토큰 요청1 (requestToken)
System.out.println(accessToken1);

//    String accessToken2 = codef.requestToken(EasyCodefServiceType.DEMO);	// 토큰 요청2 (requestToken)
//System.out.println(accessToken2);
//
//    //assertEquals("성능 향상을 위한 재사용 토큰 이용 확인", accessToken1, accessToken2);
//
//    String accessToken3 = codef.requestNewToken(EasyCodefServiceType.SANDBOX);// 신규 토큰 요청1 (requestNewToken)
//System.out.println(accessToken3);
//
//    String accessToken4 = codef.requestNewToken(EasyCodefServiceType.SANDBOX);// 신규 토큰 요청2 (requestNewToken)
//System.out.println(accessToken4);

    //assertNotEquals("토큰 권한 변경 등에 따라 필요한 신규 토큰 발급 확인", accessToken3, accessToken4);
}
}