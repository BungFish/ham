package com.skn.ham.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sngjoong on 16. 2. 19..
 */
public class GasStation implements Parcelable {

    private int seq;
    private String name;
    private String tel;
    private String address;
    private double latitude;
    private double longitude;
    private int gasPrice;
    private int gasDC;
    private int dieselPrice;
    private int dieselDC;
    private int hgasPrice;
    private int hgasDC;
    private String directYN;
    private String selfYN;
    private String washYN;
    private String convstoreYN;
    private String repairYN;
    private String hgasYN;
    private String favYN;

    private double distanceFromCurrent;



    public GasStation() {

    }

    public double getDistanceFromCurrent() {
        return distanceFromCurrent;
    }

    public void setDistanceFromCurrent(double distanceFromCurrent) {
        this.distanceFromCurrent = distanceFromCurrent;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(int gasPrice) {
        this.gasPrice = gasPrice;
    }

    public int getGasDC() {
        return gasDC;
    }

    public void setGasDC(int gasDC) {
        this.gasDC = gasDC;
    }

    public int getDieselPrice() {
        return dieselPrice;
    }

    public void setDieselPrice(int dieselPrice) {
        this.dieselPrice = dieselPrice;
    }

    public int getDieselDC() {
        return dieselDC;
    }

    public void setDieselDC(int dieselDC) {
        this.dieselDC = dieselDC;
    }

    public int getHgasPrice() {
        return hgasPrice;
    }

    public void setHgasPrice(int hgasPrice) {
        this.hgasPrice = hgasPrice;
    }

    public int getHgasDC() {
        return hgasDC;
    }

    public void setHgasDC(int hgasDC) {
        this.hgasDC = hgasDC;
    }

    public String getDirectYN() {
        return directYN;
    }

    public void setDirectYN(String directYN) {
        this.directYN = directYN;
    }

    public String getSelfYN() {
        return selfYN;
    }

    public void setSelfYN(String selfYN) {
        this.selfYN = selfYN;
    }

    public String getWashYN() {
        return washYN;
    }

    public void setWashYN(String washYN) {
        this.washYN = washYN;
    }

    public String getConvstoreYN() {
        return convstoreYN;
    }

    public void setConvstoreYN(String convstoreYN) {
        this.convstoreYN = convstoreYN;
    }

    public String getRepairYN() {
        return repairYN;
    }

    public void setRepairYN(String repairYN) {
        this.repairYN = repairYN;
    }

    public String getHgasYN() {
        return hgasYN;
    }

    public void setHgasYN(String hgasYN) {
        this.hgasYN = hgasYN;
    }

    public String getFavYN() {
        return favYN;
    }

    public void setFavYN(String favYN) {
        this.favYN = favYN;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.seq);
        dest.writeString(this.name);
        dest.writeString(this.tel);
        dest.writeString(this.address);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeInt(this.gasPrice);
        dest.writeInt(this.gasDC);
        dest.writeInt(this.dieselPrice);
        dest.writeInt(this.dieselDC);
        dest.writeInt(this.hgasPrice);
        dest.writeInt(this.hgasDC);
        dest.writeString(this.directYN);
        dest.writeString(this.selfYN);
        dest.writeString(this.washYN);
        dest.writeString(this.convstoreYN);
        dest.writeString(this.repairYN);
        dest.writeString(this.hgasYN);
        dest.writeString(this.favYN);
        dest.writeDouble(this.distanceFromCurrent);
    }

    protected GasStation(Parcel in) {
        this.seq = in.readInt();
        this.name = in.readString();
        this.tel = in.readString();
        this.address = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.gasPrice = in.readInt();
        this.gasDC = in.readInt();
        this.dieselPrice = in.readInt();
        this.dieselDC = in.readInt();
        this.hgasPrice = in.readInt();
        this.hgasDC = in.readInt();
        this.directYN = in.readString();
        this.selfYN = in.readString();
        this.washYN = in.readString();
        this.convstoreYN = in.readString();
        this.repairYN = in.readString();
        this.hgasYN = in.readString();
        this.favYN = in.readString();
        this.distanceFromCurrent = in.readDouble();
    }

    public static final Creator<GasStation> CREATOR = new Creator<GasStation>() {
        public GasStation createFromParcel(Parcel source) {
            return new GasStation(source);
        }

        public GasStation[] newArray(int size) {
            return new GasStation[size];
        }
    };
}
