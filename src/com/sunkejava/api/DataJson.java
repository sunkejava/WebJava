package com.sunkejava.api;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.sunkejava.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



/**
 * YY神曲、音悦台、51AVI解析
 * 需要Json Jar包
 * @author Administrator
 *
 */
public class DataJson {
	public static void main(String[] args) throws Exception {
		JSONArray result22 = GetDate("YY","504525");//JSON及解析
		System.out.println(result22);
		JSONArray result23 = GetDate("YINYUETAI","833120");//Json解析
		System.out.println(result23);
		JSONArray result2 = GetDate("51AVI","699161");//XML解析+取文本
		System.out.println(result2);
	}
	
	
	
	public static JSONArray GetDate(String DataType,String ID) throws Exception{
		String urls = null;
		//创建组建后的Json对象存放的Array数组
		JSONArray thisj = new JSONArray();
		if(DataType == "YY"){
			 urls = "http://www.yy.com/u/works/s?yyno="+ID+"&p=1";
			//需要抛出异常
				URL url2 = new URL(urls);
				BufferedReader bufr2 = new BufferedReader(new InputStreamReader(new BufferedInputStream(url2.openStream()),"utf-8"));
				String line2;
				StringBuffer sb2 = new StringBuffer();
				while((line2 = bufr2.readLine())!= null){
					sb2.append(line2);
				}
				bufr2.close();
				//System.out.println(sb2.toString());
				String maxpage = StringUtil.betweenSting(StringUtil.betweenSting(sb2.toString(), "pages", "data"),":",",");
				//System.out.println("最大页数："+maxpage);
				//将sb字符串转换为json对象
				JSONObject jsn1 = JSONObject.fromObject(sb2.toString());
				//JSONObject jsonobject2 = JSONObject.fromObject("{\""+"data"+StringUtil.rightString(sb2.toString(),"data"));
				int Sumpage = (int) jsn1.get("pages");
				//取的需要的数据data{}中的数据
				JSONArray result2 = jsn1.getJSONArray("data");
				System.out.println(jsn1);
				System.out.println("result2:"+result2);
				for(int i = 0;i<result2.size();i++ ){
					JSONObject concent = (JSONObject) result2.get(i);
					//获取需要的的内容并组成新的json对象2
					JSONObject newjson = new JSONObject();
					//获取神曲名称并加入新的Json对象中
					newjson.put("songname",concent.get("songname"));
					//获取神曲歌手并加入新的Json对象中
					newjson.put("ownername", concent.get("ownername"));
					//获取歌曲播放地址并加入新的Json对象中
					newjson.put("resurl",concent.get("resurl"));
					//将组建后的json对象数据加入到newarr数组中
						thisj.add(newjson);
				}
		}else if(DataType == "YINYUETAI"){
			 urls = "http://www.yinyuetai.com/api/info/get-video-urls?videoId="+ID;
			//需要抛出异常
				URL url2 = new URL(urls);
				BufferedReader bufr2 = new BufferedReader(new InputStreamReader(new BufferedInputStream(url2.openStream()),"utf-8"));
				String line2;
				StringBuffer sb2 = new StringBuffer();
				while((line2 = bufr2.readLine())!= null){
					sb2.append(line2);
				}
				bufr2.close();
//				System.out.println(sb2.toString());
				//将sb字符串转换为json对象
				JSONObject jsonobject2 = JSONObject.fromObject("{data:["+sb2.toString()+"]}");
				//取的需要的数据data{}中的数据
				JSONArray result2 = jsonobject2.getJSONArray("data");
				for(int i = 0;i<result2.size();i++ ){
					JSONObject concent = (JSONObject) result2.get(i);
					//获取需要的的内容并组成新的json对象2
					JSONObject newjson = new JSONObject();
					//获取神曲名称并加入新的Json对象中
					newjson.put("hdVideoUrl",concent.get("hdVideoUrl"));
					//获取神曲歌手并加入新的Json对象中
					newjson.put("hcVideoUrl", concent.get("hcVideoUrl"));
					//获取歌曲播放地址并加入新的Json对象中
					newjson.put("heVideoUrl",concent.get("heVideoUrl"));
					//将组建后的json对象数据加入到newarr数组中
					thisj.add(newjson);
				}
		}else if(DataType == "51AVI"){
			urls = "http://www.51av.us/modules/premium/player/ckplayer/config.php?id="+ID;
			//获取String类型的XML
			InputStream is=downloadXML(urls);
			String outfile=convertStreamToString(is);
			//取出需要的文本
			String VideUrl = StringUtil.betweenSting(outfile, "<file>", "</file>");
			String VideoSize = StringUtil.betweenSting(outfile, "<size>", "</size>");
			String VideoSeconds = StringUtil.betweenSting(outfile, "<seconds>", "</seconds>");
			String VideoText = "file:"+VideUrl+" size:"+VideoSize+" seconds:"+VideoSeconds;
/*			System.out.println("电影地址："+VideUrl);
			System.out.println("电影大小："+VideoSize);
			System.out.println("电影时长："+VideoSeconds);*/
			thisj.add(VideoText);
	} 
		return thisj;

}
	public static InputStream downloadXML(final String urlStr){
		InputStream inStream = null;
					   URL url = null;
					try {
						url = new URL(urlStr);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
					   HttpURLConnection conn = null;
					try {
						conn = (HttpURLConnection) url.openConnection();
						conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)"); 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
					   conn.setConnectTimeout(5 * 1000);  
					  try {
						conn.setRequestMethod("GET");
						conn.connect();
					} catch (Exception e) {
						// TODO Auto-generated catch block
					}  
					  
					   try {
						   inStream= conn.getInputStream();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
	return inStream;  
	}
	public static String convertStreamToString(InputStream is) throws UnsupportedEncodingException {   
		 
		   BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"));   

				StringBuilder sb = new StringBuilder();   



				String line = null;   

				try {   

					while ((line = reader.readLine()) != null) {   

						sb.append(line + "/n");   

					}   

				} catch (IOException e) {   

					e.printStackTrace();   

				} finally {   

					try {   

						is.close();   

					} catch (IOException e) {   

						e.printStackTrace();   

					}   
 
				}   
 
 
 
				return sb.toString();   
 
			}
}
