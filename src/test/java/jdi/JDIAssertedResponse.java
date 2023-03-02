package jdi;

import com.epam.http.response.RestResponse;

public class JDIAssertedResponse {
    public final RestResponse response;

    public JDIAssertedResponse(RestResponse response) {
        this.response = response;
    }
}
