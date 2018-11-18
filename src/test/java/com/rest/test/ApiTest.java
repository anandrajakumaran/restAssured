package com.rest.test;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class ApiTest {

    @Test()
    public void manufacturerListTest() throws JSONException {

        int pagenumber = 0;

        boolean isTrue ;
        int hdCounter=0,nonHdCounter=0;
        Response response ;
        JSONObject jsonObject ;
        JSONArray jsonArr;

        do {
            String url = "http://api.viki.io/v4/videos.json?app=100250a&per_page=50&page="+Integer.toString(pagenumber);
            response= given().when().get(url);
            jsonObject = new JSONObject(response.getBody().print());
            jsonArr = jsonObject.getJSONArray("response");

                for(int i=0; i<jsonArr.length(); i++){
                    if(getHd(jsonArr, i).equalsIgnoreCase("true")){
                        hdCounter++;
                    }else{
                        nonHdCounter++;
                    }
                }

            isTrue = jsonObject.getBoolean("more");

            pagenumber++;
       }while (isTrue);

        System.out.println("ctrHDtrue----------------->"+hdCounter);
        System.out.println("ctrHDFalse----------------->"+nonHdCounter);
    }

    public static String getHd(JSONArray jsonArr, int counter) throws JSONException {
        return jsonArr.getJSONObject(counter).getJSONObject("flags").get("hd").toString();
    }

}
