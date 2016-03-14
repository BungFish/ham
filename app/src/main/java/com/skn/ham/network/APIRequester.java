package com.skn.ham.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.skn.ham.R;
import com.skn.ham.network.constants.APIKeyStore;

import org.json.JSONException;
import org.json.JSONObject;

public class APIRequester {

    private static final String LOG_TAG = APIRequester.class.getSimpleName();

    private Context mContext;

    public APIRequester(Context context) {
        mContext = context;
    }

    public void requestPOST(JSONObject jsonRequestParams, final APICallbackListener callbackListener) {

        callbackListener.onBefore();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, APIKeyStore.ROOT_URL, jsonRequestParams, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                if (response != null) {

                    try {
                        Log.i(LOG_TAG, response.toString());
                        callbackListener.onSuccess(response.getJSONObject(APIKeyStore.COMMON_RESP_DATA_SET));

                    } catch (JSONException e) {
                        e.printStackTrace();
                        callbackListener.onSuccess(null);
                    }
                } else {

                    callbackListener.onSuccess(null);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                String msg = "";
                if (error instanceof TimeoutError)
                    msg = mContext.getString(R.string.err_timeout);
                else if (error instanceof NoConnectionError)
                    msg = mContext.getString(R.string.err_no_connection);
                else if (error instanceof ServerError)
                    msg = mContext.getString(R.string.err_server);
                else if (error instanceof NetworkError)
                    msg = mContext.getString(R.string.err_network);
                else
                    msg = mContext.getString(R.string.err_unexpected);

                Error err = new Error(msg);
                callbackListener.onError(err);
                Log.i(LOG_TAG, "error" + error.getLocalizedMessage());
            }
        });

        RequestQueueManager.getInstance(mContext).getRequestQueue().add(jsonObjectRequest);
    }

    public JSONObject makeRequestParams(String fid, String id, JSONObject fields) {

        JSONObject params = new JSONObject();
        JSONObject transactions = new JSONObject();
        JSONObject attributes = new JSONObject();
        JSONObject dataSet = new JSONObject();

        try {

            if (fid != null && !fid.isEmpty()) {
                transactions.put(APIKeyStore.COMMON_PARAM_ROOT_KEY_TRASACTION, fid);
            }
            if (id != null && !id.isEmpty()) {
                transactions.put(APIKeyStore.COMMON_PARAM_SUB_KEY_OF_TRANSACTION_ID, id);
            }

            attributes.put(APIKeyStore.COMMON_PARAM_SUB_KEY_OF_ATTRIBUTE_FRST_TRNM_CHNL_CD, "HAM");
            attributes.put(APIKeyStore.COMMON_PARAM_SUB_KEY_OF_ATTRIBUTE_SSO_SESN_KEY_RENEW, "N");

            //Todo 엑세스토큰 갱신해야함

//            attributes.put(APIKeyStore.COMMON_PARAM_SUB_KEY_OF_ATTRIBUTE_SSO_SESN_KEY, AppManager.getInstance(mContext).getToken());

            if (fields != null) {

                dataSet.put(APIKeyStore.COMMON_PARAM_SUB_KEY_OF_DATASETS_FIELDS, fields);
            } else {

                dataSet.put(APIKeyStore.COMMON_PARAM_SUB_KEY_OF_DATASETS_FIELDS, new JSONObject());
            }


        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(LOG_TAG, "makeRequestParams: Error making sub objects");
        }


        try {
            params.put(APIKeyStore.COMMON_PARAM_ROOT_KEY_DATASETS, dataSet);
            params.put(APIKeyStore.COMMON_PARAM_ROOT_KEY_TRASACTION, transactions);
            params.put(APIKeyStore.COMMON_PARAM_ROOT_KEY_ATTRIBUTES, attributes);

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(LOG_TAG, "makeRequestParams: Error making root objects");
        }

        return params;
    }

    public interface APICallbackListener {

        public void onBefore();

        public void onSuccess(Object object);

        public void onError(Error error);
    }
}
