package com.ashokas.userprofileui.INTERFACE;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public interface OnMysqlTableListener {
    void onTableJsonOjectListReceive(ArrayList<JSONObject> tableJsonObjectList, int queryCode);
}
