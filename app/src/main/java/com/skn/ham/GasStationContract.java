package com.skn.ham;

import android.provider.BaseColumns;

public final class GasStationContract implements BaseColumns {

    //주유소 DB Table Information
    public static final String TABLE_NAME = "station";

    //일련 번호
    public static final String COLUMN_SEQ = "seq";

    //매장 이름
    public static final String COLUMN_NAME = "name";

    //전화번호
    public static final String COLUMN_TEL = "tel";

    //주소
    public static final String COLUMN_ADDR = "addr";

    //위도
    public static final String COLUMN_LOC_LAT = "lat";

    //경도
    public static final String COLUMN_LOC_LONG = "long";

    //휘발유 가격
    public static final String COLUMN_PRICE_GAS = "gas_price";

    //휘발유 할인가격
    public static final String COLUMN_DISC_GAS = "gas_disc";

    //경유 가격
    public static final String COLUMN_PRICE_DIESEL = "diesel_price";

    //경유 할인가격
    public static final String COLUMN_DISC_DIESEL = "diesel_disc";

    //고급휘발유 가격
    public static final String COLUMN_PRICE_HGAS = "hgas_price";

    //고급휘발유 할인 가격
    public static final String COLUMN_DISC_HGAS = "hgas_disc";

    //직영점 여부
    public static final String COLUMN_OPT_DIRECT_YN = "direct_yn";

    //셀프, 일반주유소 여부
    public static final String COLUMN_OPT_SELF_YN = "self_yn";

    //세차 가능 여부
    public static final String COLUMN_OPT_WASH_YN = "wash_yn";

    //편의점 여부
    public static final String COLUMN_OPT_CONVSTORE_YN = "convstore_yn";

    //정비가능 여부
    public static final String COLUMN_OPT_REPAIR_YN = "repair_yn";

    //고급휘발유 여부
    public static final String COLUMN_OPT_HGAS_YN = "hgas_yn";

    //검색을 위한 전체 텍스트
    public static final String COLUMN_FULL_TEXT = "address_full_text";

    //단골 여부
    public static final String COLUMN_FAVORITE_YN = "favorite_yn";


}
