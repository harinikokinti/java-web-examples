package com.harini.employee.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TableColumnTag extends BodyTagSupport {

	private String header;
	private String value;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public int doStartTag() throws JspException {
		TableTag tableTag = (TableTag) findAncestorWithClass(this, TableTag.class);
		tableTag.addHeader(header);
		tableTag.addValue(value);
		return EVAL_BODY_INCLUDE;
	}

}
