package br.com.cursomc.resource.utils;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {

	public static List<Integer> decodeList(String s){
		try {
		return Arrays.asList(s.split(",")).stream()
				.map(x-> Integer.parseInt(x))
				.collect(Collectors.toList());
		}catch (Exception e) {
			List<Integer> list = new ArrayList<>();
			return list;
		}
	}
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s,"UTF-8");
		} catch (Exception e) {
			return "";
		}
	}
}
