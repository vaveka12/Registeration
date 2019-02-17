package e.user.registeration;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

class RegisterRequest extends Request<Object> {
    public RegisterRequest(Object userID, Object usercompany, Object useremail, Object username, Object userpassword, Object userphone, Response.Listener<String> responseListener) {
        super();
    }

    @Override
    protected Response<Object> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    protected void deliverResponse(Object response) {

    }
}
