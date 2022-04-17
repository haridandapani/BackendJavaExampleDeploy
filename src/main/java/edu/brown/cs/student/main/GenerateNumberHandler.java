package edu.brown.cs.student.main;

import java.util.Map;

import org.json.JSONObject;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.Route;

public class GenerateNumberHandler implements Route {

	@Override
	public Object handle(Request request, Response response) throws Exception {
		QueryParamsMap mapper = request.queryMap();
		
		int min = Integer.valueOf(mapper.value("min"));
		int max = Integer.valueOf(mapper.value("max"));
		int random = min + (int) (Math.random() * (max - min));
		Map<String, Object> outputMap = ImmutableMap.of("output", random);
		return new Gson().toJson(outputMap);
	}

}
