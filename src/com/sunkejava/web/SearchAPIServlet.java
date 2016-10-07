package com.sunkejava.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunkejava.util.ResponseUtil;
import com.sunkejava.api.DataJsonp;
import com.sunkejava.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ����API������ѯ�ӿ�
 * 
 * @author Administrator
 *
 */
public class SearchAPIServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String searchContext = request.getParameter("searchContext");
		String searchType = request.getParameter("searchtype");
		System.out.println(searchType);
		DataJsonp djs = new DataJsonp();
		request.setAttribute("error", "");
		request.setAttribute("searchContext", searchContext);
		request.setAttribute("searchtype", searchType);
		if (StringUtil.isEmpty(searchContext) || StringUtil.isEmpty(searchType)) {
			request.setAttribute("error", "�������ݲ���Ϊ�գ���");
			request.getRequestDispatcher("searchAPI.jsp").forward(request, response);
			return;
		} else {
			if (searchType.equals("YY")) {
				try {
					JSONArray result22 = djs.GetDate("YY", searchContext);
					if (result22.toString().equals("[]")) {
						request.setAttribute("error", "IDΪ��" + searchContext + "��������δ�ϴ�����");
						request.getRequestDispatcher("searchAPI.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("yyindex.jsp").forward(request, response);
					}
				} catch (Exception e) {
					System.out.println("ERROR");
					request.setAttribute("error", "IDΪ��" + searchContext + "��������δ�ϴ�����");
					request.getRequestDispatcher("searchAPI.jsp").forward(request, response);

					return;
				}

			} else if (searchType.equals("YINYUETAI")) {
				JSONArray result22;
				try {
					result22 = djs.GetDate("YINYUETAI", searchContext);
					System.out.println("YINYEUTAI:" + result22);
					if (result22.toString().equals("[]")) {
						request.setAttribute("error", "��ȷ��IDΪ��" + searchContext + "������̨ID�Ƿ���ȷ��");
						request.getRequestDispatcher("searchAPI.jsp").forward(request, response);
					} else {

						// response.sendRedirect("yinyuePlayer.jsp");
						request.getRequestDispatcher("yinyuePlayer.jsp?a=" + result22.getJSONObject(0).get("hdVideoUrl")
								+ "&b=" + result22.getJSONObject(0).get("hcVideoUrl") + "&c="
								+ result22.getJSONObject(0).get("heVideoUrl") + "&d="
								+ result22.getJSONObject(0).get("title")).forward(request, response);
					}
				} catch (Exception e) {
					System.out.println("ERROR");
					request.setAttribute("error", "��ȷ��IDΪ��" + searchContext + "������̨ID�Ƿ���ȷ��");
					request.getRequestDispatcher("searchAPI.jsp").forward(request, response);
					return;
				}

			} else if (searchType.equals("51AVI")) {
				JSONArray result22;
				try {
					result22 = djs.GetDate("51AVI", searchContext);
					System.out.println("51AVI:" + result22);
					if (result22.toString().equals("[]")) {
						request.setAttribute("error", "��ȷ��51AVI��ƵID��" + searchContext + "�Ƿ���ȷ��");
						request.getRequestDispatcher("searchAPI.jsp").forward(request, response);
					} else {

						System.out.println("file:" + result22.getJSONObject(0).get("file"));
						String e = StringUtil.rightString(result22.getJSONObject(0).get("file").toString(), "e=");
						System.out.println("e=:"+StringUtil.rightString(result22.getJSONObject(0).get("file").toString(), "e="));
						request.getRequestDispatcher("aviPlayer.jsp?a=" + result22.getJSONObject(0).get("file")+"&b=?"+e).forward(request, response);
					}
				} catch (Exception e) {
					System.out.println("ERROR");
					request.setAttribute("error", "��ȷ��51AVI��ƵID��" + searchContext + "�Ƿ���ȷ��");
					request.getRequestDispatcher("searchAPI.jsp").forward(request, response);
					return;
				}

			} else if (searchType.equals("LIAN")) {
				JSONArray result22;
				try {
					result22 = djs.GetDate("LIAN", searchContext);
					System.out.println("LIAN:" + result22);
					if (result22.toString().equals("[]")) {
						request.setAttribute("error", "��ȷ��������ƵID��" + searchContext + "�Ƿ���ȷ��");
						request.getRequestDispatcher("searchAPI.jsp").forward(request, response);
					} else {

						System.out.println("file:" + result22.getJSONObject(0).get("file"));
						request.getRequestDispatcher("lianPlayer.jsp?a=" + result22.getJSONObject(0).get("ks") + "&b="
								+ result22.getJSONObject(0).get("type") + "&c=" + result22.getJSONObject(0).get("k1")
								+ "&d=" + result22.getJSONObject(0).get("k3") + "&e="
								+ result22.getJSONObject(0).get("k4")+ "&f=" + result22.getJSONObject(0).get("k6")+ "&g=" + result22.getJSONObject(0).get("k7")).forward(request, response);
					}
				} catch (Exception e) {
					System.out.println("ERROR");
					request.setAttribute("error", "��ȷ��������ƵID��" + searchContext + "�Ƿ���ȷ��");
					request.getRequestDispatcher("searchAPI.jsp").forward(request, response);
					return;
				}
			}
		}
	}

}
