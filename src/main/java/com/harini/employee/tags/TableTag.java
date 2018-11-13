package com.harini.employee.tags;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TableTag extends BodyTagSupport {

	private String data;
	private String scope;

	private List<String> headers = new ArrayList<>();
	private List<String> values = new ArrayList<>();

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
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doAfterBody() throws JspException {

		try {

			JspWriter out = pageContext.getOut();

			List<Map<String, String>> employees = getAttribute();

			if (employees == null) {
				out.print("<table><tr><td colspan=3> Sorry no data found </td></tr></table>");

				return EVAL_PAGE;
			}

			StringBuilder builder = new StringBuilder();

			builder.append("<table><tr>");

			for (String header : headers) {
				builder.append("<th>").append(header).append("</th>");
			}

			builder.append("</tr><tbody>");

			for (Map<String, String> employee : employees) {
				builder.append("<tr>");
				for (String key : values) {
					builder.append("<td>").append(employee.get(key)).append("</td>");
				}
				builder.append("</tr>");
			}

			builder.append("</tbody></table>");

			out.println(builder.toString());

		} catch (Exception e) {
		}

		return EVAL_PAGE;
	}

	private List<Map<String, String>> getAttribute() {
		int scopeValue = 1;

		if ("request".equals(scope)) {
			scopeValue = PageContext.REQUEST_SCOPE;

		} else if ("session".equals(scope)) {
			scopeValue = PageContext.SESSION_SCOPE;

		} else if ("application".equals(scope)) {
			scopeValue = PageContext.APPLICATION_SCOPE;
		}

		return (List<Map<String, String>>) pageContext.getAttribute(data, scopeValue);
	}

	public void addHeader(String header) {
		this.headers.add(header);
	}

	public void addValue(String value) {
		this.values.add(value);
	}

}
