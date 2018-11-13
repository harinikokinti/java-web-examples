package com.harini.employee.tags;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TableBodyTag extends SimpleTagSupport {

	private String data;
	private String scope;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public void doTag() throws JspException, IOException {

		JspContext jspContext = getJspContext();

		JspWriter out = jspContext.getOut();

		int scopeValue = 1;

		if ("request".equals(scope)) {
			scopeValue = PageContext.REQUEST_SCOPE;

		} else if ("session".equals(scope)) {
			scopeValue = PageContext.SESSION_SCOPE;

		} else if ("application".equals(scope)) {
			scopeValue = PageContext.APPLICATION_SCOPE;
		}

		List<Map<String, String>> employees = (List<Map<String, String>>) jspContext.getAttribute(data, scopeValue);

		if (employees == null) {
			out.print("<tr><td colspan=3> Sorry no data found </td></tr>");
			return;
		}

		StringBuilder builder = new StringBuilder();

		for (Map<String, String> employee : employees) {
			builder.append("<tr>");
			builder.append("<td>").append(employee.get("ID")).append("</td>");
			builder.append("<td>").append(employee.get("FIRST_NAME")).append("</td>");
			builder.append("<td>").append(employee.get("LAST_NAME")).append("</td>");
			builder.append("</tr>");
		}

		out.println(builder.toString());
	}

}
