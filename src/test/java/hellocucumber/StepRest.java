package hellocucumber;

import io.cucumber.java.hu.Amikor;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

@Slf4j
public class StepRest {

  @Amikor("GET Rest hívás: {string}, {string}")
  public void i_call_get_endpoint(String url, String endpoint) {
    Request request = new Request.Builder().url(url + endpoint).build();
    OkHttpClient client = new OkHttpClient();
    Call call = client.newCall(request);
    Response response;
    try {
      response = call.execute();
      assert (response.code() == 200);

      String responseData = response.body().string();
      JSONArray Jarray = new JSONArray(responseData);

      for (int i = 0; i < Jarray.length(); i++) {
        JSONObject object = Jarray.getJSONObject(i);
        assert (object.get("email").toString().contains("@"));
        log.info(object.get("name") + " | " + object.get("email"));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
