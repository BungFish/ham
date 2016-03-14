package com.skn.ham.network.constants;

/**
 * Created by sngjoong on 16. 1. 23..
 */
public class APIKeyStore {

    //Development
    public static final String ROOT_URL = "http://mobilehamdev.sknetworks.co.kr/web/json.jmd";
    //Production
//    public static final String ROOT_URL= "https://mobileham.sknetworks.co.kr/web/json.jmd";

    //공통 요청 객체 Keys
    public static final String COMMON_PARAM_ROOT_KEY_TRASACTION = "transaction";
    public static final String COMMON_PARAM_ROOT_KEY_ATTRIBUTES = "attributes";
    public static final String COMMON_PARAM_ROOT_KEY_DATASETS = "dataSet";

    // 파라미터 서브오브젝트 키정보
    public static final String COMMON_PARAM_SUB_KEY_OF_TRANSACTION_FID = "fid";
    public static final String COMMON_PARAM_SUB_KEY_OF_TRANSACTION_ID = "id";
    public static final String COMMON_PARAM_SUB_KEY_OF_ATTRIBUTE_FRST_TRNM_CHNL_CD = "FRST_TRNM_CHNL_CD";
    public static final String COMMON_PARAM_SUB_KEY_OF_ATTRIBUTE_SSO_SESN_KEY_RENEW = "SSO_SESN_KEY_RENEW";
    public static final String COMMON_PARAM_SUB_KEY_OF_ATTRIBUTE_SSO_SESN_KEY = "SSO_SESN_KEY";
    public static final String COMMON_PARAM_SUB_KEY_OF_DATASETS_FIELDS = "fields";

    //공통 응답 객체 Keys
    public static final String COMMON_RESP_DATA_SET = "dataSet";
    public static final String COMMON_RESP_RECORD_SETS = "recordSets";
    public static final String COMMON_RESP_FIELDS = "fields";
    public static final String COMMON_RESP_LIST = "nc_list";
    public static final String COMMON_RESP_LIST_COUNT = "nc_recordCount";
    public static final String COMMON_RESP_MESSAGE = "message";
    public static final String COMMON_RESP_RESULT = "result";
    public static final String COMMON_RESP_VALUE_RESULT_OK = "OK";
    public static final String COMMON_RESP_VALUE_RESULT_FAIL = "FAIL";
    public static final String COMMON_RESP_ERR_MSG_NAME = "messageName";
    public static final String COMMON_RESP_ERR_MSG_ID = "messageId";

    //앱 초기구동 체크 요청 파라미터 Keys
    public static final String APP_INIT_REQ_ID = "COMAppInitData";
    public static final String APP_INIT_REQ_UPD_DATE = "UPD_DATE";
    public static final String APP_INIT_REQ_OS_GBN = "OS_GBN";

    //앱 초기버전 체크 응답 파리미터 Keys
    public static final String APP_INIT_RESP_APP_VERSION = "APP_VER";
    public static final String APP_INIT_RESP_UPD_DATE = "UPD_DATE";
    public static final String APP_INIT_RESP_APP_RSC_VERSION = "APP_RSC_VER";
    public static final String APP_INIT_RESP_USER_ARR_SHOP = "USER_ARR_SHOP";

    //주유소 리스트 API 요청 파라미터 Keys
    public static final String STATION_LIST_REQ_ID = "MLNSearchOilStList";
    public static final String STATION_LIST_REQ_FID = "FIDMOB1702";
    public static final String STATION_LIST_REQ_UPD_DATE = "UPD_DATE";
    public static final String STATION_LIST_REQ_SEQ = "SEQ";

    //주유소 리스트 API 응답 객체 Keys
    public static final String STATION_LIST_RESP_UPD_DATE = "UPD_DATE";
    public static final String STATION_LIST_RESP_USER_ARR_SHOP = "USER_ARR_SHOP";
    public static final String STATION_LIST_RESP_ARR_SHOP = "ARR_SHOP";
    public static final String STATION_LIST_RESP_ARR_SHOP_EXCEPT = "ARR_SHOP_EXCEPT";

    //주유소 리스트 API 응답 객체 안의 배열 요소 Keys
    public static final String STATION_LIST_RESP_SEQ = "SEQ";
    public static final String STATION_LIST_RESP_NM = "NM";
    public static final String STATION_LIST_RESP_TEL = "TEL";
    public static final String STATION_LIST_RESP_ADDR = "ADDR";
    public static final String STATION_LIST_RESP_LOC_LAT = "LOC_LAT";
    public static final String STATION_LIST_RESP_LOC_LONG = "LOC_LONG";
    public static final String STATION_LIST_RESP_PRICE_GAS = "PRICE_GAS";
    public static final String STATION_LIST_RESP_DISC_GAS = "DISC_GAS";
    public static final String STATION_LIST_RESP_PRICE_DIESEL = "PRICE_DIESEL";
    public static final String STATION_LIST_RESP_DISC_DIESEL = "DISC_DIESEL";
    public static final String STATION_LIST_RESP_PRICE_HGAS = "PRICE_HGAS";
    public static final String STATION_LIST_RESP_DISC_HGAS = "DISC_HGAS";
    public static final String STATION_LIST_RESP_OPT_CONVSTORE_YN = "OPT_CONVSTORE_YN";
    public static final String STATION_LIST_RESP_OPT_DIRECT_YN = "OPT_DIRECT_YN";
    public static final String STATION_LIST_RESP_OPT_HGAS_YN = "OPT_HGAS_YN";
    public static final String STATION_LIST_RESP_OPT_SELF_YN = "OPT_SELF_YN";
    public static final String STATION_LIST_RESP_OPT_WASH_YN = "OPT_WASH_YN";
    public static final String STATION_LIST_RESP_OPT_REPAIR_YN = "OPT_REPAIR_YN";

    //단골 주유소 공통 요청
    public static final String FAV_PUBLIC_REQ_SEQ = "SEQ";

    //단골 주유소 등록 API 요청 파라미터 Keys
    public static final String ADD_FAV_REQ_FID = "FIDMOB1801";
    public static final String ADD_FAV_REQ_ID = "MLNUpdateUserOilSt";

    //단골 주유소 삭제 API 요청 파라미터 Keys
    public static final String REMOVE_FAV_REQ_FID = "FIDMOB1803";
    public static final String REMOVE_FAV_REQ_ID = "MLNDeleteUserOilSt";


    //단골 주유소 리스트 API 요청 파라미터 Keys
    public static final String FAV_LIST_REQ_FID = "FIDMOB1804";
    public static final String FAV_LIST_REQ_ID = "MLNSearchUserOilStList";


    //주소검색 요청 파라미터 Keys
    public static final String ADDR_SEARCH_REQ_FID = "FIDMOB2902";
    public static final String ADDR_SEARCH_REQ_ID = "COMSearchAddrList";
    public static final String ADDR_SEARCH_REQ_KUBUN = "KUBUN";
    public static final String ADDR_SEARCH_REQ_DONG = "DONG";
    public static final String ADDR_SEARCH_REQ_BUNJI = "BUNJI";
    public static final String ADDR_SEARCH_REQ_SI_DO = "SI_DO";
    public static final String ADDR_SEARCH_REQ_GU_GUN = "GU_GUN";
    public static final String ADDR_SEARCH_REQ_DORO = "DORO";
    public static final String ADDR_SEARCH_REQ_BULD_NO = "BULD_NO";

    //주소검색 응답 파라미터 Keys
    public static final String ADDR_SEARCH_RESP_POST = "POST";
    public static final String ADDR_SEARCH_RESP_ADDR = "ADDR";
    public static final String ADDR_SEARCH_RESP_SAN = "SAN";
    public static final String ADDR_SEARCH_RESP_HJD = "HJD";
    public static final String ADDR_SEARCH_RESP_BUNGI_S = "BUNGI_S";
    public static final String ADDR_SEARCH_RESP_BUNGI_E = "BUNGI_E";
    public static final String ADDR_SEARCH_RESP_DORO_NM = "DORO_NM";
    public static final String ADDR_SEARCH_RESP_JIHA = "JIHA";
    public static final String ADDR_SEARCH_RESP_BULD_NO_S = "BUIL_NO_S";
    public static final String ADDR_SEARCH_RESP_BULD_NO_E = "BULD_NO_E";
    public static final String ADDR_SEARCH_RESP_RANGE = "RANGE";

    //공지사항 요청 파라미터 Keys
    public static final String NOTICE_LIST_REQ_FID = "FIDMOB2401";
    public static final String NOTICE_LIST_REQ_ID = "MCYSearchBoardList";
    public static final String NOTICE_LIST_REQ_PAGE = "PAGE";
    public static final String NOTICE_LIST_REQ_PAGE_RECS = "PAGE_RECS";
    public static final String NOTICE_LIST_REQ_CHN = "CHN";

    //공지사항 응답 파라미터 Keys
    public static final String NOTICE_LIST_RESP_ARR_NOTICE = "ARR_NOTICE";
    public static final String NOTICE_LIST_RESP_NC_LIST = "nc_list";
    public static final String NOTICE_LIST_RESP_SEQ = "SEQ";
    public static final String NOTICE_LIST_RESP_TITLE = "TITLE";
    public static final String NOTICE_LIST_RESP_REG_DT = "REG_DT";

    //공지사항 상세 요청 파라미터 Keys
    public static final String NOTICE_DETAIL_REQ_FID = "FIDMOB2402";
    public static final String NOTICE_DETAIL_REQ_ID = "MCYDetailBoard";
    public static final String NOTICE_DETAIL_REQ_SEQ = "SEQ";

    //공지사항 상세 응답 파라미터 Keys
    public static final String NOTICE_DETAIL_RESP_TITLE = "TITLE";
    public static final String NOTICE_DETAIL_RESP_CONTENTS = "CONTENTS";
    public static final String NOTICE_DETAIL_RESP_REG_DT = "REG_DT";

    //시/도, 구/군, 동/면 리스트 요청 파라미터 Keys
    public static final String ADR_LIST_REQ_FID = "FIDMOB2901";
    public static final String ADR_LIST_REQ_ID = "COMSearchZipInfoList";
    public static final String ADR_LIST_REQ_SI_DO = "SI_DO";
    public static final String ADR_LIST_REQ_GU_GUN = "GU_GUN";

    //시/도, 구/군, 동/면 리스트 응답 파라미터 Keys
    public static final String ADR_LIST_RESP_NM = "NM";
    public static final String ADR_LIST_RESP_ARR_SI_DO = "ARR_SI_DO";
    public static final String ADR_LIST_RESP_ARR_GU_GUN = "ARR_GU_GUN";
    public static final String ADR_LIST_RESP_ARR_DONG_MYEON = "ARR_DONG_MYEON";

    //회원가입 응답 파라미터
    public static final String SIGN_UP_RESP_USER_ID = "USER_ID";
    public static final String SIGN_UP_RESP_USER_NAME = "USER_NM";
    public static final String SIGN_UP_RESP_JOIN_DATE_ZAM = "JOIN_DATE_ZAM";
    public static final String SIGN_UP_RESP_JOIN_DATE_HAM = "JOIN_DATE_HAM";
    public static final String SIGN_UP_RESP_PWD_SET_DATE = "PWD_SET_DATE";
    public static final String SIGN_UP_RESP_USER_CI = "USER_CI";
    public static final String SIGN_UP_RESP_CARD_NO = "CARD_NO";
    public static final String SIGN_UP_PWD_SET_YN = "PW_SET_YN";

    //유저정보 요청 파라미터
    public static final String USER_INFO_REQ_FID = "FIDMOB0110";
    public static final String USER_INFO_REQ_ID = "MCMSelectUser";

    //유저정보 응답 파라미터
    public static final String USER_INFO_RESP_ID = "CUST_ID";
    public static final String USER_INFO_RESP_NAME = "USER_NM";
    public static final String USER_INFO_RESP_CELL_PHONE = "CELL_PHONE";
    public static final String USER_INFO_RESP_JOIN_ROUTE = "JOIN_ROUTE";
    public static final String USER_INFO_RESP_LEAVE_ROUTE = "LEAVE_ROUTE";
    public static final String USER_INFO_RESP_CARD_NO = "CARD_NO";
    public static final String USER_INFO_RESP_OIL_GAS_YN = "OIL_GAS_YN";
    public static final String USER_INFO_RESP_OIL_DIESEL_YN = "OIL_DIESEL_YN";
    public static final String USER_INFO_RESP_HGAS_YN = "OIL_HGAS_YN";
    public static final String USER_INFO_RESP_CUST_STATE = "CUST_STATE";
    public static final String USER_INFO_RESP_REG_DATE = "REG_DATE";
    public static final String USER_INFO_RESP_POST = "POST";
    public static final String USER_INFO_RESP_ADDR1 = "ADDR1";
    public static final String USER_INFO_RESP_ADDR2 = "ADDR2";
    public static final String USER_INFO_RESP_JOIN_YN_ZAM = "JOIN_YN_ZAM";
    public static final String USER_INFO_RESP_JOIN_YN_HAM = "JOIN_YN_HAM";
    public static final String USER_INFO_RESP_JOIN_DATE_ZAM = "JOIN_DATE_ZAM";
    public static final String USER_INFO_RESP_JOIN_DATE_HAM = "JOIN_DATE_HAM";
    public static final String USER_INFO_RESP_LEAVE_DATE_ZAM = "LEAVE_DATE_ZAM";
    public static final String USER_INFO_RESP_LEAVE_DATE_HAM = "LEAVE_DATE_HAM";
    public static final String USER_INFO_RESP_SEX_CD = "SEX_CD";
    public static final String USER_INFO_RESP_BIRYMD = "BIRYMD";
    public static final String USER_INFO_RESP_RECEIVE_EMAIL_YN_ZAM = "RECEIVE_EMAIL_YN_ZAM";
    public static final String USER_INFO_RESP_RECEIVE_EMAIL_YN_HAM = "RECEIVE_EMAIL_YN_hAM";
    public static final String USER_INFO_RESP_RECEIVE_SMS_YN_ZAM = "RECEIVE_SMS_YN_ZAM";
    public static final String USER_INFO_RESP_RECEIVE_SMS_YN_HAM = "RECEIVE_SMS_YN_hAM";
    public static final String USER_INFO_RESP_RECEIVE_TM_YN_ZAM = "RECEIVE_TM_YN_ZAM";
    public static final String USER_INFO_RESP_RECEIVE_TM_YN_HAM = "RECEIVE_TM_YN_hAM";

    // 주유 예약 가능 체크 요청
    public static final String RESERVE_VALIDITY_REQ_FID = "FIDMOB0706";
    public static final String RESERVE_VALIDITY_REQ_ID = "MLNSearchOrdOilYN";
    public static final String RESERVE_VALIDITY_RESV_CHANGE = "RESV_CHANGE";

    // 주유 예약 가능 체크 응답
    public static final String RESERVE_VALIDITY_RESP_RESV_YN = "RESV_YN";

    //에러 코드 (인증 관련)
    public static final String ERR_CODE_TIME_OUT_LOGIN = "COME0005";
    public static final String ERR_CODE_NOT_LOGIN = "COME0006";
    public static final String ERR_CODE_AUTO_LOGIN_FAIL = "COME0009";
    public static final String ERR_CODE_OTHER_LOGIN_OCCURED = "COME0010";

    // 유저정보 요청 파라미터
    public static final String LOGOUT_REQ_FID = "FIDMOB0117";
    public static final String LOGOUT_REQ_ID = "MCMLogout";

    // Tmap api 리소스 루트
    public static final String OPEN_API_ROOT_AUTHORITY = "apis.skplanetx.com";
    public static final String TMAP_API_ROOT_PATH = "tmap";

    // Tmap api 리소스 지오코딩
    public static final String TMAP_API_GEO_PATH = "geo";
    public static final String TMAP_API_REV_GEOCODING_PATH = "reversegeocoding";

    //Tmap 좌표계 타입
    public static final String TMAP_COORD_TYPE = "WGS84GEO";

    //Tmap 지오코딩 쿼리 Keys
    public static final String TMAP_GEO_QUERY_LAT = "lat";
    public static final String TMAP_GEO_QUERY_LONG = "lon";
    public static final String TMAP_GEO_QUERY_COORD_TYPE = "coordType";
    public static final String TMAP_QUERY_API_VERSION = "version";

    //Tmap 지오코딩 응답 Keys
    public static final String TMAP_GEO_RESP_ADDR_INFO = "addressInfo";
    public static final String TMAP_GEO_RESP_FULL_ADDR = "fullAddress";

}
