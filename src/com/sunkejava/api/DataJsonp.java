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

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.sunkejava.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



/**
 * YY����������̨��51AVI����
 * ��ҪJson Jar��
 * @author Administrator
 *
 */
public class DataJsonp {
	public static void main(String[] args) throws Exception {
		JSONArray result22 = GetDate("YY","504525");//JSON������
		//System.out.println(result22);
		JSONArray rest = GetDate("YINYUETAI","833120");
		//System.out.println(rest);
		JSONArray rests = GetDate("51AVI","204960");
		JSONArray restsss= GetDate("LIAN","b&b325");
		System.out.println(restsss);
	}
	
	
	
	public static JSONArray GetDate(String DataType,String ID) throws Exception{
		String urls = null;
		//�����齨���Json�����ŵ�Array����
		JSONArray thisj = new JSONArray();
		JSONArray pthisj = new JSONArray();
		if(DataType.equals("YY")){
			 urls = "http://www.yy.com/u/works/s?yyno="+ID+"&p=1";
			//��Ҫ�׳��쳣
				URL url2 = new URL(urls);
				BufferedReader bufr2 = new BufferedReader(new InputStreamReader(new BufferedInputStream(url2.openStream()),"utf-8"));
				String line2;
				StringBuffer sb2 = new StringBuffer();
				while((line2 = bufr2.readLine())!= null){
					sb2.append(line2);
				}
				bufr2.close();
				//��sb�ַ���ת��Ϊjson����
				JSONObject jsn1 = JSONObject.fromObject(sb2.toString());
				//JSONObject jsonobject2 = JSONObject.fromObject("{\""+"data"+StringUtil.rightString(sb2.toString(),"data"));
				int Sumpage = (int) jsn1.get("pages");
				for(int j=0;j<Sumpage;j++){
					String purls = "http://www.yy.com/u/works/s?yyno="+ID+"&p="+(j+1);
					//��Ҫ�׳��쳣
						URL purl2 = new URL(purls);
						BufferedReader pbufr2 = new BufferedReader(new InputStreamReader(new BufferedInputStream(purl2.openStream()),"utf-8"));
						String pline2;
						StringBuffer psb2 = new StringBuffer();
						while((pline2 = pbufr2.readLine())!= null){
							psb2.append(pline2);
						}
						pbufr2.close();
						//��sb�ַ���ת��Ϊjson����
						JSONObject pjsn1 = JSONObject.fromObject(psb2.toString());
						JSONArray presult2 = pjsn1.getJSONArray("data");
						JSONObject newjsonp = new JSONObject();
						newjsonp.put("song_album_id",Integer.toString(j+1));
						newjsonp.put("song_album",presult2.getJSONObject(0).get("ownername")+"---��"+(j+1)+"ҳ");
						newjsonp.put("song_album1","����YY����");		
				for(int i = 0;i<presult2.size();i++ ){
					if(j==Sumpage){
						System.out.println(presult2.size());
					}
					JSONObject concent = (JSONObject) presult2.get(i);
					//��ȡ��Ҫ�ĵ����ݲ�����µ�json����2
					JSONObject newjson = new JSONObject();
					newjson.put("song_id", Integer.toString(i+1));
					//��ȡ�������Ʋ������µ�Json������
					newjson.put("song_title",concent.get("songname"));
					//��ȡ�������ֲ������µ�Json������
					newjson.put("singer", concent.get("ownername"));
					//��ȡ�������ŵ�ַ�������µ�Json������
					newjson.put("pic", concent.get("snapshoturl"));
					newjson.put("likeCount", concent.get("likeCount"));
					newjson.put("watchCount", concent.get("watchCount"));
					newjson.put("duration", concent.get("duration"));
					newjson.put("resurl",concent.get("resurl"));
					//���齨���json�������ݼ��뵽newarr������
						pthisj.add(newjson);
					}
				newjsonp.put("song_list",pthisj);
				pthisj.clear();
				thisj.add(newjsonp);
				}
		}else if(DataType.equals("YINYUETAI")){
			 urls = "http://www.yinyuetai.com/api/info/get-video-urls?videoId="+ID;
			String purls="http://v.yinyuetai.com/video/"+ID;
			 //��Ҫ�׳��쳣
				URL url2 = new URL(urls);
				BufferedReader bufr2 = new BufferedReader(new InputStreamReader(new BufferedInputStream(url2.openStream()),"utf-8"));
				String line2;
				StringBuffer sb2 = new StringBuffer();
				while((line2 = bufr2.readLine())!= null){
					sb2.append(line2);
				}
				bufr2.close();
				
				URL urlq = new URL(purls);
				BufferedReader bufr3 = new BufferedReader(new InputStreamReader(new BufferedInputStream(urlq.openStream()),"utf-8"));
				String line3;
				StringBuffer sb3 = new StringBuffer();
				while((line3 = bufr3.readLine())!= null){
					sb3.append(line3);
				}
				bufr3.close();
				String context = StringUtil.betweenSting(sb3.toString(),"<title>", "</title>");
				//System.out.println(context);
				//��sb�ַ���ת��Ϊjson����
				JSONObject jsonobject2 = JSONObject.fromObject("{data:["+sb2.toString()+"]}");
				//ȡ����Ҫ������data{}�е�����
				JSONArray result2 = jsonobject2.getJSONArray("data");
				for(int i = 0;i<result2.size();i++ ){
					JSONObject concent = (JSONObject) result2.get(i);
					//��ȡ��Ҫ�ĵ����ݲ�����µ�json����2
					JSONObject newjson = new JSONObject();
					//��ȡ�������Ʋ������µ�Json������
					newjson.put("hdVideoUrl",StringUtil.leftString(concent.get("hdVideoUrl").toString(), "?"));
					//��ȡ�������ֲ������µ�Json������
					newjson.put("hcVideoUrl", StringUtil.leftString(concent.get("hcVideoUrl").toString(), "?"));
					//��ȡ�������ŵ�ַ�������µ�Json������
					newjson.put("heVideoUrl",StringUtil.leftString(concent.get("heVideoUrl").toString(), "?"));
					newjson.put("title",context);
					//���齨���json�������ݼ��뵽newarr������
					thisj.add(newjson);
				}
		}else if(DataType.equals("51AVI")){
			urls = "http://www.51av.org/modules/premium/player/ckplayer/config.php?id="+ID;
			//��ȡString���͵�XML
			InputStream is=downloadXML(urls);
			String outfile=convertStreamToString(is);
			
			//ȡ����Ҫ���ı�
			String VideUrl = StringUtil.betweenSting(outfile, "<file>", "</file>");
			String VideoSize = StringUtil.betweenSting(outfile, "<size>", "</size>");
			String VideoSeconds = StringUtil.betweenSting(outfile, "<seconds>", "</seconds>");
			String VideoText = "{'file':'"+VideUrl+"','size':'"+VideoSize+"','seconds':'"+VideoSeconds+"'}";
/*			System.out.println("��Ӱ��ַ��"+VideUrl);
			System.out.println("��Ӱ��С��"+VideoSize);
			System.out.println("��Ӱʱ����"+VideoSeconds);*/
			thisj.add(VideoText);
	}else if(DataType.equals("LIAN")){
		/**
		 * ��ȡ�ؼ�kֵ
		 * @param name  tvName
		 * @return
		 * @throws IOException
		 */
			String n1Type = StringUtil.leftString(ID, "&");
			String IDS = StringUtil.rightString(ID, "&");
			String results = null;
			String url = "http://h.syasn.com/?n="+IDS;
//			String purls= "http://h.syasn.com/jk/k.php?n="+IDS;
//			URL urlq = new URL(purls);
//			BufferedReader bufr3 = new BufferedReader(new InputStreamReader(new BufferedInputStream(urlq.openStream()),"utf-8"));
//			String line3;
//			StringBuffer sb3 = new StringBuffer();
//			while((line3 = bufr3.readLine())!= null){
//				sb3.append(line3);
//			}
//			bufr3.close();
//			JSONObject objs = JSONObject.fromObject(sb3.toString());
//			String mip = objs.getString("mip");
//			String mik = objs.getString("mik");
//			String min = objs.getString("min");
			  HttpClient client = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
			  client.getHttpConnectionManager().getParams().setConnectionTimeout(15000); //ͨ��������������������ӵĳ�ʱʱ��
			  client.getHttpConnectionManager().getParams().setSoTimeout(60000); //Socket�����ݵĳ�ʱʱ�䣬���ӷ�������ȡ��Ӧ������Ҫ�ȴ���ʱ��
			  client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			  GetMethod method = new GetMethod(url);
			  method.setRequestHeader("Content-Type", "text/html;charset=gbk"); // ��ֹ����
			  method.setRequestHeader("Connection","close");
			  method.setRequestHeader("Referer", "http://www.2ni.tv/"+IDS); // ������·
			  method.setRequestHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:42.0) Gecko/20100101 Firefox/42.0"); 
			  try {
				client.executeMethod(method);
			} catch (HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  	
			  InputStream inputStream = method.getResponseBodyAsStream();  
			  BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));  
			  StringBuffer stringBuffer = new StringBuffer();  
			  String str= "";  
			  while((str = br.readLine()) != null){  
			  stringBuffer .append(str );  
			  }
			  String rightString = StringUtil.rightString(stringBuffer.toString(), "};");
			  String stringk14 = StringUtil.leftString(rightString, "mip");
			  //System.out.println(stringk14);
			  String str14left = stringk14.substring(0,68);
			  //System.out.println(str14left);
			  String str14right = stringk14.substring(68);
			  //System.out.println(str14right);
			  String k4 = StringUtil.betweenSting(str14left, "='", "',");
			  String k1 = StringUtil.betweenSting(str14right, "='", "',");
			  //System.out.println(k4+"-----"+k1);
			  String k3string = StringUtil.rightString(rightString, "mik=");
			  String k3 = StringUtil.betweenSting(k3string, "?'", "':");
			  String result = StringUtil.rightString(stringBuffer.toString(), "mid=");
			  String mid = StringUtil.betweenSting(result, "?(", " '");
			  String k7 = mid.substring(3);
			  String result2 = StringUtil.rightString(stringBuffer.toString(), "mis=");
			  String mis = StringUtil.rightString(result2, "?'");
			  String k6 = mis.substring(0,32);
//			  results="{'k6':'"+k6+"','k7':'5"+k7+"','ks':'"+IDS+"','type':'"+n1Type+"','mip':'"+mip+"','mik':'"+mik+"','min':'"+min+"'}";
			  results = "{'ks':'"+IDS+"','type':'"+n1Type+"','k1':'"+k1+"','k3':'"+k3+"','k4':'"+k4+"','k6':'"+k6+"','k7':'5"+k7+"'}";
			  thisj.add(results);
		
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
