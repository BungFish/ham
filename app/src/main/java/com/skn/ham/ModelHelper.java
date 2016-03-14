package com.skn.ham;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.Nullable;

import com.skn.ham.network.constants.APIKeyStore;

import org.json.JSONException;
import org.json.JSONObject;

public class ModelHelper {

    @Nullable
    public static GasStation getStationFromJSON(JSONObject json) {

        try {
            GasStation station = new GasStation();

            String seq = json.getString(APIKeyStore.STATION_LIST_RESP_SEQ);
            String name = json.getString(APIKeyStore.STATION_LIST_RESP_NM);
            String tel = json.getString(APIKeyStore.STATION_LIST_RESP_TEL);
            String address = json.getString(APIKeyStore.STATION_LIST_RESP_ADDR);
            String latitude = json.getString(APIKeyStore.STATION_LIST_RESP_LOC_LAT);
            String longitude = json.getString(APIKeyStore.STATION_LIST_RESP_LOC_LONG);
            String gasPrice = json.getString(APIKeyStore.STATION_LIST_RESP_PRICE_GAS);
            String gasDC = json.getString(APIKeyStore.STATION_LIST_RESP_DISC_GAS);
            String dieselPrice = json.getString(APIKeyStore.STATION_LIST_RESP_PRICE_DIESEL);
            String dieselDC = json.getString(APIKeyStore.STATION_LIST_RESP_DISC_DIESEL);
            String hgasPrice = json.getString(APIKeyStore.STATION_LIST_RESP_PRICE_HGAS);
            String hgasDC = json.getString(APIKeyStore.STATION_LIST_RESP_DISC_HGAS);

            String directYN = json.getString(APIKeyStore.STATION_LIST_RESP_OPT_DIRECT_YN);
            String selfYN = json.getString(APIKeyStore.STATION_LIST_RESP_OPT_SELF_YN);
            String washYN = json.getString(APIKeyStore.STATION_LIST_RESP_OPT_WASH_YN);
            String convstoreYN = json.getString(APIKeyStore.STATION_LIST_RESP_OPT_CONVSTORE_YN);
            String repairYN = json.getString(APIKeyStore.STATION_LIST_RESP_OPT_REPAIR_YN);
            String hgasYN = json.getString(APIKeyStore.STATION_LIST_RESP_OPT_HGAS_YN);


            station.setSeq(Integer.parseInt(seq));
            station.setName(name);
            station.setTel(tel);
            station.setAddress(address);
            station.setLatitude(Double.parseDouble(latitude));
            station.setLongitude(Double.parseDouble(longitude));

            if (gasPrice != null) station.setGasPrice(Integer.parseInt(gasPrice));
            else station.setGasPrice(-1);
            if (gasDC != null) station.setGasDC(Integer.parseInt(gasDC));
            else station.setGasDC(-1);
            if (dieselPrice != null) station.setDieselPrice(Integer.parseInt(dieselPrice));
            else station.setDieselPrice(-1);
            if (dieselDC != null) station.setDieselDC(Integer.parseInt(dieselDC));
            else station.setDieselDC(-1);
            if (hgasPrice != null) station.setHgasPrice(Integer.parseInt(hgasPrice));
            else station.setHgasPrice(-1);
            if (hgasDC != null) station.setHgasDC(Integer.parseInt(hgasDC));
            else station.setHgasDC(-1);

            station.setDirectYN(directYN);
            station.setSelfYN(selfYN);
            station.setWashYN(washYN);
            station.setConvstoreYN(convstoreYN);
            station.setRepairYN(repairYN);
            station.setHgasYN(hgasYN);


            return station;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    // DB에 쓰기위해 GasStation객체를 ContentValues 객체로 변환후 리턴
    public static ContentValues getContentValuesFromStation(GasStation station) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(GasStationContract.COLUMN_SEQ, station.getSeq());
        contentValues.put(GasStationContract.COLUMN_ADDR, station.getAddress());
        contentValues.put(GasStationContract.COLUMN_LOC_LAT, station.getLatitude());
        contentValues.put(GasStationContract.COLUMN_LOC_LONG, station.getLongitude());
        contentValues.put(GasStationContract.COLUMN_NAME, station.getName());
        contentValues.put(GasStationContract.COLUMN_TEL, station.getTel());
        contentValues.put(GasStationContract.COLUMN_PRICE_GAS, station.getGasPrice());
        contentValues.put(GasStationContract.COLUMN_DISC_GAS, station.getGasDC());
        contentValues.put(GasStationContract.COLUMN_PRICE_DIESEL, station.getDieselPrice());
        contentValues.put(GasStationContract.COLUMN_DISC_DIESEL, station.getDieselDC());
        contentValues.put(GasStationContract.COLUMN_PRICE_HGAS, station.getHgasPrice());
        contentValues.put(GasStationContract.COLUMN_DISC_HGAS, station.getHgasDC());
        contentValues.put(GasStationContract.COLUMN_FULL_TEXT, station.getName() + " " + station.getAddress());

        contentValues.put(GasStationContract.COLUMN_OPT_CONVSTORE_YN, station.getConvstoreYN());
        contentValues.put(GasStationContract.COLUMN_OPT_DIRECT_YN, station.getDirectYN());
        contentValues.put(GasStationContract.COLUMN_OPT_HGAS_YN, station.getHgasYN());
        contentValues.put(GasStationContract.COLUMN_OPT_REPAIR_YN, station.getRepairYN());
        contentValues.put(GasStationContract.COLUMN_OPT_SELF_YN, station.getSelfYN());
        contentValues.put(GasStationContract.COLUMN_OPT_WASH_YN, station.getWashYN());
        contentValues.put(GasStationContract.COLUMN_FAVORITE_YN, "N");


        return contentValues;
    }

    // DB에서 읽어온 Cursor 객체를 GasStation객체로 변환후 리턴
    public static GasStation getStationFromCursor(Cursor data) {

        int seq = data.getInt(data.getColumnIndex(GasStationContract.COLUMN_SEQ));
        String name = data.getString(data.getColumnIndex(GasStationContract.COLUMN_NAME));
        String tel = data.getString(data.getColumnIndex(GasStationContract.COLUMN_TEL));
        String address = data.getString(data.getColumnIndex(GasStationContract.COLUMN_ADDR));
        double latitude = data.getDouble(data.getColumnIndex(GasStationContract.COLUMN_LOC_LAT));
        double longitude = data.getDouble(data.getColumnIndex(GasStationContract.COLUMN_LOC_LONG));
        int gasPrice = data.getInt(data.getColumnIndex(GasStationContract.COLUMN_PRICE_GAS));
        int gasDC = data.getInt(data.getColumnIndex(GasStationContract.COLUMN_DISC_GAS));
        int dieselPrice = data.getInt(data.getColumnIndex(GasStationContract.COLUMN_PRICE_DIESEL));
        int dieselDC = data.getInt(data.getColumnIndex(GasStationContract.COLUMN_DISC_DIESEL));
        int hgasPrice = data.getInt(data.getColumnIndex(GasStationContract.COLUMN_PRICE_HGAS));
        int hgasDC = data.getInt(data.getColumnIndex(GasStationContract.COLUMN_DISC_HGAS));
        String directYN = data.getString(data.getColumnIndex(GasStationContract.COLUMN_OPT_DIRECT_YN));
        String selfYN = data.getString(data.getColumnIndex(GasStationContract.COLUMN_OPT_SELF_YN));
        String washYN = data.getString(data.getColumnIndex(GasStationContract.COLUMN_OPT_WASH_YN));
        String convstoreYN = data.getString(data.getColumnIndex(GasStationContract.COLUMN_OPT_CONVSTORE_YN));
        String repairYN = data.getString(data.getColumnIndex(GasStationContract.COLUMN_OPT_REPAIR_YN));
        String hgasYN = data.getString(data.getColumnIndex(GasStationContract.COLUMN_OPT_HGAS_YN));
        String favYN = data.getString(data.getColumnIndex(GasStationContract.COLUMN_FAVORITE_YN));

        GasStation station = new GasStation();
        station.setSeq(seq);
        station.setName(name);
        station.setTel(tel);
        station.setAddress(address);
        station.setLatitude(latitude);
        station.setLongitude(longitude);
        station.setGasPrice(gasPrice);
        station.setGasDC(gasDC);
        station.setDieselPrice(dieselPrice);
        station.setDieselDC(dieselDC);
        station.setHgasPrice(hgasPrice);
        station.setHgasDC(hgasDC);
        station.setDirectYN(directYN);
        station.setSelfYN(selfYN);
        station.setWashYN(washYN);
        station.setConvstoreYN(convstoreYN);
        station.setRepairYN(repairYN);
        station.setHgasYN(hgasYN);
        station.setFavYN(favYN);

        return station;
    }

    // Y,N String을 Boolean으로 변경
    public static boolean convertBooleanFromYN(String yn) {

        if (yn.equals("Y"))
            return true;
        else
            return false;
    }

}
