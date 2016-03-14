package com.skn.ham;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.skn.ham.data.model.GasStation;
import com.skn.ham.network.APIRequester;
import com.skn.ham.network.constants.APIKeyStore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private GasStationDBHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new GasStationDBHelper(getApplicationContext());

        JSONObject fields = new JSONObject();

        try {
            fields.put(APIKeyStore.APP_INIT_REQ_OS_GBN, "A");
            fields.put(APIKeyStore.APP_INIT_REQ_UPD_DATE, AppManager.getInstance(this).getAccessTime());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        APIRequester requester = new APIRequester(this);
        JSONObject reqParams = requester.makeRequestParams(null, APIKeyStore.APP_INIT_REQ_ID, fields);

        requester.requestPOST(reqParams, new APIRequester.APICallbackListener() {


            @Override
            public void onBefore() {

            }

            @Override
            public void onSuccess(Object object) {

                if (object != null) {

                    if (object instanceof JSONObject) {

                        Log.i(LOG_TAG, "초기구동 응답 : " + object.toString());
                        JSONObject json = (JSONObject) object;

//                        updateDB(json);
                        updateVersion(json);
                    }
                }

            }

            @Override
            public void onError(Error error) {
                Log.i(LOG_TAG, error.toString());
            }

        });

    }
    private void updateVersion(JSONObject json) {

        try {
            JSONObject fields = json.getJSONObject(APIKeyStore.COMMON_RESP_FIELDS);

            AppManager am = AppManager.getInstance(this);

            String appResourceVersion = fields.getString(APIKeyStore.APP_INIT_RESP_APP_RSC_VERSION);
            String appVersion = fields.getString(APIKeyStore.APP_INIT_RESP_APP_VERSION);
            String updatedDate = fields.getString(APIKeyStore.APP_INIT_RESP_UPD_DATE);

            //버전 저장
            am.setNewVersion(appVersion);

            //데이터 업데이트 시간저장
            am.setAccessTime(updatedDate);

            //앱 버전 체크
            AppManager.VersionCheckResult checkResult = am.checkAppVersion();

            //메이져 업데이트시 (강제업데이트시)
            if (checkResult == AppManager.VersionCheckResult.MAJOR_UPDATE) {

            } else {


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void updateDB(JSONObject json) {

        try {
            JSONObject recordSets = json.getJSONObject(APIKeyStore.COMMON_RESP_RECORD_SETS);

            JSONObject user_arr_shop = recordSets.getJSONObject(APIKeyStore.STATION_LIST_RESP_USER_ARR_SHOP);
            JSONObject arr_shop = recordSets.getJSONObject(APIKeyStore.STATION_LIST_RESP_ARR_SHOP);
            JSONObject arr_except_shop = recordSets.getJSONObject(APIKeyStore.STATION_LIST_RESP_ARR_SHOP_EXCEPT);

            JSONArray stationList = arr_shop.getJSONArray(APIKeyStore.COMMON_RESP_LIST);
            JSONArray stationExceptedList = arr_except_shop.getJSONArray(APIKeyStore.COMMON_RESP_LIST);

            //추가 또는 업데이트될 주유소 리스트
            if (stationList.length() > 0) {

                ArrayList<ContentValues> contentValuesList = new ArrayList<>();

                for (int i = 0; i < stationList.length(); i++) {

                    JSONObject stationJSON = stationList.getJSONObject(i);
                    GasStation station = ModelHelper.getStationFromJSON(stationJSON);

                    if (station != null) {

                        Log.i(LOG_TAG, station.getName() + "," + station.getAddress() + "," + station.getTel() + "이 추가또는 수정됨");
                        ContentValues contentValues = ModelHelper.getContentValuesFromStation(station);
                        contentValuesList.add(contentValues);
                    }
                }

                if (contentValuesList.size() > 0) {

                    ContentValues[] valuesArr = new ContentValues[contentValuesList.size()];
                    contentValuesList.toArray(valuesArr);

                    //주유소 Insert
                    bulkInsert(valuesArr);
                }
            }

            //삭제될 주유소 리스트
            if (stationExceptedList.length() > 0) {

                //주유소 Delete

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public int bulkInsert(ContentValues[] values){
        db = helper.getWritableDatabase();

        int returnCount = 0;

        db.beginTransaction();

        try {

            for (ContentValues value : values) {

                long id = db.insertWithOnConflict(GasStationContract.TABLE_NAME, null, value, SQLiteDatabase.CONFLICT_REPLACE);
                if (id != -1) returnCount++;
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        return returnCount;
    }

    public void insert(String name, String address){
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);

        db.insert(GasStationContract.TABLE_NAME, null, values);
    }

    public void update(String name, String address){
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("address", address);

        String whereClause = "name" + " = ?";
        String[] whereArgs = { name };

        db.update(GasStationContract.TABLE_NAME, values, whereClause, whereArgs);
    }

    public void delete(String name){
        db = helper.getWritableDatabase();

        String whereClause = "name" + " = ?";
        String[] whereArgs = { name };

        db.delete(GasStationContract.TABLE_NAME, whereClause, whereArgs);
    }
    public void select(){
        db = helper.getReadableDatabase();

        Cursor cursor = db.query(GasStationContract.TABLE_NAME, null, null, null, null, null, null);

        while(cursor.moveToNext()){

            String seq = cursor.getString(cursor.getColumnIndex(GasStationContract.COLUMN_SEQ));

            String name = cursor.getString(cursor.getColumnIndex(GasStationContract.COLUMN_NAME));
            String address = cursor.getString(cursor.getColumnIndex(GasStationContract.COLUMN_ADDR));

            Log.i("========", seq+" "+name + " " + address);
        }
    }
}
