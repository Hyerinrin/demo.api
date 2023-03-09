package com.example.demo.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.codef.api.EasyCodef;

import java.io.UnsupportedEncodingException;

public class authExam {

    public static void main(String[] args) throws UnsupportedEncodingException, JsonProcessingException, InterruptedException {

/** #1.쉬운 코드에프 객체 생성 및 클라이언트 정보 설정 */
        EasyCodef codef = new EasyCodef();
        codef.setClientInfoForDemo("475bbc7a-9562-46b2-b84a-29937f8570a6", "0643a2c7-8c13-469b-a9ff-e8e91b613233");
        //codef.setClientInfo(EasyCodefClientInfo.CLIENT_ID, EasyCodefClientInfo.CLIENT_SECRET);
        codef.setPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArpVJ4hxX8z2RLM6drWgnhXtD+RyTkqEPJvdHPHeJxOAAIf4" +
                "gIbWFuNNQpwsSxAfXTGR+c9dh4WOUGS5/fJXhdgUqKYH7f9FL/Ay/mBRP+61plF3fLSQBWnjQmQ2DR6o/akU16VujR3E+k7pCs" +
                "m+VWHuai68mVd59mNA7WSwLXtvNvItuefzeFumxNnoUAn8soFYrcEDW5u/qRiFYb+eABi3C4+PpYB1KmnRjNc4ysiqljeu29fuVEmK" +
                "UcLtsHSWLs8BL/UfGsV8JmGrkL0gIQZfqOz5lKgI4pXKAORACIMExxh0/IE5AMfmwDxp0f+j024I10dBIIuRy9fpI40xC4wIDAQAB");
    }
}
