package jdi;

import com.epam.http.response.RestResponse;
import model.user.Message;
import org.junit.Assert;

import static org.junit.Assert.*;

public class JDIAssertedResponse {
    public final RestResponse response;

    public JDIAssertedResponse(RestResponse response) {
        this.response = response;
    }

    //для десериализации json в pojo
    public <T> T as(String jsonPath, Class<T> tClass) {
        return response.getRaResponse().then().extract().body().jsonPath().getObject(jsonPath, tClass);
    }

    //получаем сообщение и статус из json блока info
    public JDIAssertedResponse hasMessage(String expectedMessage) {
        Message message = as("info", Message.class);
        assertEquals(message.getMessage(), expectedMessage);
        return this;
    }

    public JDIAssertedResponse hasStatusCode(int expectedStatus) {
        int actualStatus = response.getStatus().code;
        assertEquals(actualStatus, expectedStatus);
        return this;

    }

}
