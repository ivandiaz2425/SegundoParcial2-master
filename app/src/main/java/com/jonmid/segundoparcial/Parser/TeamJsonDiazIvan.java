package com.jonmid.segundoparcial.Parser;

import com.jonmid.segundoparcial.Model.TeamModelDiazIvan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class TeamJsonDiazIvan {

    public static List<TeamModelDiazIvan> getData(String content) throws JSONException {
        JSONObject jsonObject= new JSONObject(content);
        JSONArray jsonArray = jsonObject.getJSONArray("teams");
        List<TeamModelDiazIvan> List = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject item = jsonArray.getJSONObject(i);

            TeamModelDiazIvan Team = new TeamModelDiazIvan();


            Team.setName(item.getString("name"));

            Team.setCode(item.getString("code"));

            Team.setCrestUrl(item.getString("crestUrl"));

            List.add(Team);        }
        return List;
    }
}
